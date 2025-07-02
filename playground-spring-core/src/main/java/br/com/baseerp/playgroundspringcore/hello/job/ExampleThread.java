package br.com.baseerp.playgroundspringcore.hello.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExampleThread {

    // Fixed Delay -> Atraso fixo entre execuções
    // Fixed Rate -> Intervalo fixo entre execuções
    // Cron ->

    @Scheduled(fixedDelay = 1000)
    public void run() {
        System.out.println("Executando...!");
    }
}
