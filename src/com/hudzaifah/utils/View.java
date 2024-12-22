package com.hudzaifah.utils;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler(scanner);
    public Integer menu(){
        System.out.println("Selamat Datang Di program Steganografi By Hudzaifah");
        System.out.println("1. Masukan pesan kedalam file");;
        System.out.println("2. Ektrak pesan dari file");
        System.out.println("99. Keluar");
        System.out.println("Masukan pilihan kamu : ");
        return inputHandler.getInt("=> ");

    }

    public void hasil(Integer[] result, String namaFile){
        if(result[0] == 1) {
            System.out.println("berhasil menyimpan pesan ke dalam file");
            System.out.println("gambar tersimpan di folder OutputFile");
            System.out.println("OutputFile/" + namaFile);
            System.out.println("Panjang pesan yang harus di ingat untuk mengambil pesan tersebut adalah " + result[1]);
            System.out.println("( ˶ˆᗜˆ˵ )");;
        }else{
            System.out.println("gagal menyemapan pesan ke dalam File");
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

    public String inputFileName(String inputAtauOutput, Boolean isInput){
        System.out.println("Masukan File beserta extensinya contoh : gambar.png | gambar.jpg | video.mp4 | audio.mp3 | etc");
        if(isInput){
            System.out.println("Masukan gambar kedalam folder InputFile!!!");
        }else{
            System.out.println("Masukan gambar kedalam folder fileForExtractMessage!!!");

        }
        System.out.println("kemudian masukan nama file contoh : gambar.png | video.mp4");
        return inputHandler.getString("Masukan nama file" + inputAtauOutput + " : ");
    }

    public String inputMessage(){
        return inputHandler.getString("Masukan pesan : ");
    }
}
