/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author use
 */
public class Parallel01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ExecutorService exec = Executors.newSingleThreadExecutor();
//        ExecutorService exec = Executors.newFixedThreadPool(100);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(1_000);
                } catch (Exception e) {
                }
            }
        });
        exec.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(700);
                } catch (Exception e) {
                }
            }
        });
        exec.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(1_200);
                } catch (Exception e) {
                }
            }
        });
        System.out.println("Siamo qui");
    }
    
}
