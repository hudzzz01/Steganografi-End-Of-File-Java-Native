package com.hudzaifah;

import com.hudzaifah.service.SteganoService;
import com.hudzaifah.utils.IOimage;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("InputImage/tes2.png");
        File inputImage = path.toFile();
        String message = "Hudzaifah assyahid";


        SteganoService steganoService = new SteganoService();
        System.out.println(Arrays.toString(steganoService.stegano(message,inputImage)));



//
//
//        ioimage.writeImage(newData,outputFIle);
//
//        //readstegaimage
//        byte[] data = ioimage.readImage(outputFIle);
//        int indexAwal = data.length - pesanByte.length;
//        int indexAkhir = data.length;
//        System.out.println("-----------");
//
//
//        byte[] pesan2 = new byte[pesanByte.length];
//
//        for (int i = 0; i < pesanByte.length ; i++) {
//            pesan2[i] = data[indexAwal + i];
//        }
//        System.out.println(new String(pesan2));
//
//
//        System.out.println(pesan2.length);

    }
}
