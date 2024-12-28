package com.hudzaifah;

import com.hudzaifah.service.SteganoService;
import com.hudzaifah.utils.View;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        SteganoService steganoService = new SteganoService();

        int pilihan = 0;
        while (pilihan != 99){
            pilihan = view.menu();
            if (pilihan == 1){
                //stegano
                String inputFileName = view.inputFileName("Input File : ",true);
                String secretFileName = view.inputSecretFileName("input",true);

                Path inputFilePath = Path.of("InputFile/" + inputFileName);
                File inputFile = inputFilePath.toFile();

                Path inputSecretFilePath = Path.of("InputSecretFile/" + secretFileName);
                File inputSecretFile = inputSecretFilePath.toFile();

                Integer[] result = steganoService.stegano(inputFile,inputSecretFile);
                view.hasil(result,inputFile.getName(),"");

            }else if (pilihan == 2){
                //extract
                String inputFileName = view.inputFileName("yang memiliki pesan rahasia : ",false);
                Integer lengthMessage = view.inputLenghtByteMessage();
                Path inputFilePath = Path.of("fileForExtractMessage/" + inputFileName);
                File inputFile = inputFilePath.toFile();

                String outputFileExtension = view.inputExtension();

                Integer[] result = steganoService.extrackMessage(inputFile, lengthMessage,outputFileExtension);
                view.hasil(result,inputFileName,"secret");
            }
        }

        System.exit(0);


    }
}
