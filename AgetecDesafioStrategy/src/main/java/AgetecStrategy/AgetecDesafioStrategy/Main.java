package AgetecStrategy.AgetecDesafioStrategy;

import AgetecStrategy.AgetecDesafioStrategy.Services.FormatadorService;
import AgetecStrategy.AgetecDesafioStrategy.Strategies.CSVProcessador;
import AgetecStrategy.AgetecDesafioStrategy.Strategies.ImportCSVStrategy;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FormatadorService formatadorService = new FormatadorService();
        ImportCSVStrategy importCSVStrategy = new ImportCSVStrategy(formatadorService);

        CSVProcessador processor = new CSVProcessador();
        processor.setStrategy(importCSVStrategy);

        File csvFile = new File("F:\\ADS\\Projetos\\DestinoOrigemAgetec\\DestinoAgetec\\arquivo.csv");
        processor.processFile(csvFile);
    }
}
