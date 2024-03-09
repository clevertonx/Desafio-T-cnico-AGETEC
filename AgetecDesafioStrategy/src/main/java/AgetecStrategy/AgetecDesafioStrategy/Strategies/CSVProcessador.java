package AgetecStrategy.AgetecDesafioStrategy.Strategies;

import java.io.File;

public class CSVProcessador {
    private CSVProcessamentoStrategy strategy;

    public void setStrategy(CSVProcessamentoStrategy strategy) {
        this.strategy = strategy;
    }

    public void processFile(File file) {
        strategy.process(file);
    }
}