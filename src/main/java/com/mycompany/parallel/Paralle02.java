/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallel;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author use
 */
public class Paralle02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creo un executor service -> 1) cached 2)fixed a 100
        int numero = 10;
        var exec = Executors.newCachedThreadPool();
        Instant i1 = Instant.now();
        for (int i = 0; i < 1_000; i++) {
            numero = 13 - numero;
            int altronumero = numero;
            // lancia un processo che stampa l'orario per 3 secondi con pausa di 1 secondo e poi termina
            //stampare anche il nome del thread
            exec.submit(() -> {
                for (int j = 0; j < altronumero; j++) {
                    String s = Thread.currentThread().getName() + " ";
                    s += LocalTime.now();
                    System.out.println(s);
                    try {
                        Thread.sleep(1_000);
                    } catch (Exception e) {
                    }
                }
            });
            Future<Double> fd = exec.submit(() -> {
                return Math.sqrt(altronumero);
            });
        }
        try {
            exec.shutdown();
            exec.awaitTermination(1L, TimeUnit.DAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Instant i2 = Instant.now();
        Duration d1 = Duration.between(i1, i2);
        System.out.println("Tempo totale " + d1.toMillis());
    }

}
