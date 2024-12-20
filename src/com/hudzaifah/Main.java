package com.hudzaifah;

import com.hudzaifah.service.SteganoService;
import com.hudzaifah.utils.IOimage;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("InputImage/tes2.png");
        Path pathImageFromExtract = Path.of("imageForExtractMessage/tes2.png");
        File inputImage = path.toFile();
        File extractImage = pathImageFromExtract.toFile();
        String message = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";


        SteganoService steganoService = new SteganoService();
//        System.out.println(Arrays.toString(steganoService.stegano(message,inputImage)));

        System.out.println(Arrays.toString(steganoService.extrackMessage(extractImage, 574)));



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
