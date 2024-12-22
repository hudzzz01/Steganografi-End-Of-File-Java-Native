package com.hudzaifah.service;

import com.hudzaifah.exception.InvalidReadImageException;
import com.hudzaifah.utils.IOFile;

import java.io.File;
import java.nio.file.Path;

public class SteganoService {
    IOFile IOFile = new IOFile();

    public Integer[] stegano(String message, File inputImage){
        String output = "OutputFile/" + inputImage.getName();
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

    public String[] extrackMessage(File imageForExtractMessage, int messageLength){
        byte [] imageData = null;
        try {
            imageData =  getImageByte(imageForExtractMessage);
        } catch (InvalidReadImageException e) {
            System.out.println(e.getMessage());
            return new String[]{"0", ""};
        }

        int startIndex = imageData.length - messageLength;

        byte[] messageData = extractMessageData(startIndex, messageLength, imageData);

        String message = toStringFromByte(messageData);

        return new String[]{"1", message};
    }

    byte[] extractMessageData(int starIndex, int messageLength, byte[] imageData){
        byte [] messageData = new byte[messageLength];
        for (int i = 0; i < messageLength; i++) {
            messageData[i] = imageData[starIndex + i];
        }
        return messageData;

    }

    String toStringFromByte(byte[] data){
        return new String(data);
    }

    byte [] getImageByte(File file) throws InvalidReadImageException {
        byte [] data = IOFile.readImage(file);
        if(data == null || data.length == 0){
            throw new InvalidReadImageException();
        }
        return IOFile.readImage(file);
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
        IOFile.writeImage(data,file);
        return file.exists();
    }

}
