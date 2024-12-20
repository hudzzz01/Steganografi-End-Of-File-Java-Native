package com.hudzaifah.service;

import com.hudzaifah.exception.InvalidReadImageException;
import com.hudzaifah.utils.IOimage;

import java.io.File;
import java.nio.file.Path;

public class SteganoService {
    IOimage iOimage = new IOimage();

    public Integer[] stegano(String message, File inputImage){
        String output = "OutputImage/" + inputImage.getName();
        Path outputPath = Path.of(output);
        File outputImage = outputPath.toFile();
        byte [] imageByte = null;
        try {
            imageByte = getImageByte(inputImage);
        } catch (InvalidReadImageException e) {
            System.out.println(e.getMessage());
            return new Integer[]{0,0};
        }
        byte [] messageByte = getMessageByte(message);
        byte [] newData = combineByte(imageByte, messageByte);
        if(writeByteToFile(newData, outputImage)) return new Integer[]{1, messageByte.length};
        return new Integer[]{0,0};
    }

    byte [] getImageByte(File file) throws InvalidReadImageException {
        byte [] data = iOimage.readImage(file);
        if(data == null || data.length == 0){
            throw new InvalidReadImageException();
        }
        return iOimage.readImage(file);
    }

    byte [] getMessageByte(String message){
        return message.getBytes();

    }

    byte [] combineByte(byte [] imageByte, byte [] messageByte){
        byte [] newData = new byte[imageByte.length + messageByte.length];
        System.arraycopy(imageByte, 0, newData, 0, imageByte.length);
        System.arraycopy(messageByte, 0, newData, imageByte.length, messageByte.length);
        return newData;
    }

    Boolean writeByteToFile(byte [] data, File file){
        iOimage.writeImage(data,file);
        return file.exists();
    }

}
