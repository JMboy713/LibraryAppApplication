package com.group.libraryapp;

import java.util.Scanner;

public class Ex5HomeWork {
        public static void main(String[] args) {
            System.out.println("숫자를 입력하세요");
            Scanner scanner = new Scanner(System.in);
            int a=scanner.nextInt();
            int [] arr = new int[a+1];
            for (int i = 0; i < a; i++) {
                double b= Math.random()*a;
                int dice = (int) Math.ceil(b);
                arr[dice] += 1;
            }
            for (int i = 1; i < arr.length; i++) {
                System.out.println(i+"은"+arr[i]+"번 나왔습니다. \n");
            }
        }
}

