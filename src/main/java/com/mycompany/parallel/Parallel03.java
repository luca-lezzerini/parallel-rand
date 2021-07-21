/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallel;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author use
 */
public class Parallel03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var exec = Executors.newCachedThreadPool();
        Future<Double> fd = exec.submit(() -> {
            try {
                Thread.sleep(5_000);
            } catch (Exception e) {
            }
            return Math.sqrt(2);
        });

//        while (!fd.isDone()) {
////            System.out.println("Non ha finito! " + LocalTime.now());
//        }
        Double d = 0.0;
        try {
            d = fd.get();
            System.out.println(d);
        } catch (Exception e) {
        }
        Double df = d;
        Future<Double> fd1 = exec.submit(() -> {
            try {
                Thread.sleep(2_000);
            } catch (Exception e) {
            }
            return Math.sqrt(df);
        });
        try {
            System.out.println(fd1.get());
        } catch (Exception e) {
        }
    }

}
