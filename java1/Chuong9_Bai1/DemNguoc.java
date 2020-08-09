/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong9_Bai1;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class DemNguoc {

    public static void main(String[] args) {
//        Thread thr = Thread.currentThread();
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so nguyen: ");
        int a = input.nextInt();

        for (int i = a; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }

    }
}
