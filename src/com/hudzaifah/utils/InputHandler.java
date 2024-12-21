package com.hudzaifah.utils;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    //Input Number atau input string
    public Integer getInt(String prompt){
        System.out.print(prompt);
        //lakukan validasi input harus berupa angka
        while (!scanner.hasNextInt()){
            System.out.println("input harus berupa angka ( – ⌓ – )");
            scanner.nextLine();
            System.out.println(prompt);
        }
        Integer result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public String getString(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
