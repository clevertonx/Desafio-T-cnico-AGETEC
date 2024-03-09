package AgetecStrategy.AgetecDesafioStrategy.Strategies;

import AgetecStrategy.AgetecDesafioStrategy.Models.Condutor;
import AgetecStrategy.AgetecDesafioStrategy.Services.FormatadorService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class ImportCSVStrategy implements CSVProcessamentoStrategy {

    private final FormatadorService formatadorService;

    public ImportCSVStrategy(FormatadorService formatadorService) {
        this.formatadorService = formatadorService;
    }

    @Override
    public void process(File file) {
        String pastaFonte = "F:\\ADS\\Projetos\\DestinoOrigemAgetec\\OrigemDetran";
        String pastaDestino = "F:\\ADS\\Projetos\\DestinoOrigemAgetec\\DestinoAgetec";

        File[] arquivos = new File(pastaFonte).listFiles();
        List<Condutor> condutores = new ArrayList<>();

        if (arquivos != null) {
            for (File csvFile : arquivos) {
                if (csvFile.isFile() && csvFile.getName().endsWith(".csv")) {
                    try {
                        Path sourcePath = Paths.get(csvFile.getAbsolutePath());
                        Path destinationPath = Paths.get(pastaDestino + File.separator + csvFile.getName());

                        if (Files.exists(destinationPath)) {
                            System.err.println("Erro: O arquivo " + csvFile.getName() + " já existe na pasta de destino.");
                            continue;
                        }

                        Files.copy(sourcePath, destinationPath);

                        BufferedReader leitor = new BufferedReader(new FileReader(csvFile));
                        String line;
                        while ((line = leitor.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 3) {
                                String nome = parts[0].trim();
                                String cpf = parts[1].trim();
                                String placaVeiculo = parts[2].trim();

                                Condutor condutor = new Condutor(nome, cpf, placaVeiculo);
                                condutores.add(condutor);
                            }
                        }
                        leitor.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (Condutor condutor : condutores) {
            String nomeFormatado = formatadorService.formatarNome(condutor.getNome());
            String cpfFormatado = formatadorService.formatarCPF(condutor.getCpf());
            System.out.println("Nome: " + nomeFormatado);
            System.out.println("CPF: " + cpfFormatado);
        }
    }
}
