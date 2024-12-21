package com.hudzaifah.utils;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler(scanner);
    public Integer menu(){
        System.out.println("Selamat Datang Di program Steganografi By Hudzaifah");
        System.out.println("1. Masukan pesan kedalam gambar");;
        System.out.println("2. Ektrak pesan dari gambar");
        System.out.println("99. Keluar");
        System.out.println("Masukan pilihan kamu : ");
        return inputHandler.getInt("=> ");

    }

    public void hasil(Integer[] result, String namaFile){
        if(result[0] == 1) {
            System.out.println("berhasil menyimpan pesan ke dalam gambar");
            System.out.println("gambar tersimpan di folder OutputImage");
            System.out.println("OutputImage/" + namaFile);
            System.out.println("Panjang pesan yang harus di ingat untuk mengambil pesan tersebut adalah " + result[1]);
            System.out.println("( ˶ˆᗜˆ˵ )");;
        }else{
            System.out.println("gagal menyemapan pesan ke dalam gambar");
        }
        System.out.println("___________________________");
        System.out.println();
    }

    public void hasil(String[] result){
        if(result[0].equals("1")) {
            System.out.println("berhasil mengambil pesan");
            System.out.println("pesan : " + result[1]);
            System.out.println("( ˶ˆᗜˆ˵ )");
        }else{
            System.out.println("gagal mengambil pesan");
        }
        System.out.println("____________________________");
        System.out.println();
    }

    public Integer inputLenghtByteMessage(){
        System.out.println("Masukan panjang byte pesan : ");
        return inputHandler.getInt("=> ");
    }

    public String inputImageName(String inputAtauOutput, Boolean isInput){
        System.out.println("gambar harus memiliki ekstensi .PNG");
        if(isInput){
            System.out.println("Masukan gambar kedalam folder InputImage!!!");
        }else{
            System.out.println("Masukan gambar kedalam folder imageForExtractMessage!!!");

        }
        System.out.println("kemudian masukan nama gambarnya beserta formatnya contoh : gambar.png");
        return inputHandler.getString("Masukan nama gambar" + inputAtauOutput + " : ");
    }

    public String inputMessage(){
        return inputHandler.getString("Masukan pesan : ");
    }
}
