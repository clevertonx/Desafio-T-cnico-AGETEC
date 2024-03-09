package AgetecStrategy.AgetecDesafioStrategy.Services;

import org.springframework.stereotype.Service;

@Service
public class FormatadorService {

    public String formatarNome(String nome) {
        StringBuilder nomeFormatado = new StringBuilder();
        String[] partesNome = nome.split(" ");
        for (String parte : partesNome) {
            if (!parte.isEmpty()) {
                nomeFormatado.append(parte.charAt(0)).append(". ");
            }
        }
        return nomeFormatado.toString().trim();
    }

    public String formatarCPF(String cpf) {
        StringBuilder cpfFormatado = new StringBuilder();
        cpfFormatado.append(cpf.substring(0, 3)).append(".");
        for (int i = 3; i < cpf.length(); i++) {
            if (cpf.charAt(i) != '-') {
                cpfFormatado.append("*");
            } else {
                cpfFormatado.append("-**");
                break;
            }
        }
        return cpfFormatado.toString();
    }
}

