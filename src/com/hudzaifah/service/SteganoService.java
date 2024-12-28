package com.hudzaifah.service;

import com.hudzaifah.exception.InvalidReadImageException;
import com.hudzaifah.utils.IOFile;

import java.io.File;
import java.nio.file.Path;

public class SteganoService {
    IOFile IOFile = new IOFile();

    public Integer[] stegano( File inputFileReceptacle, File inputSecretFile){
        String output = "OutputFile/" + inputFileReceptacle.getName();
        Path outputPath = Path.of(output);
        File outputFile = outputPath.toFile();
        byte [] fileReceptacleByte = null;
        try {
            fileReceptacleByte = getImageByte(inputFileReceptacle);
        } catch (InvalidReadImageException e) {
            System.out.println(e.getMessage());
            return new Integer[]{0,0};
        }
        
        //message section
        byte [] fileSecretByte = null;
        try {
            fileSecretByte = getImageByte(inputSecretFile);
        } catch (InvalidReadImageException e) {
            System.out.println(e.getMessage());
            return new Integer[]{0,0};
        }


        byte [] newData = combineByte(fileReceptacleByte, fileSecretByte);
        if(writeByteToFile(newData, outputFile)) return new Integer[]{1, fileSecretByte.length};
        return new Integer[]{0,0};
    }

    public Integer[] extrackMessage(File fileForExtractMessage, int messageLength, String extension){
        byte [] fileData = null;
        try {
            fileData =  getImageByte(fileForExtractMessage);
        } catch (InvalidReadImageException e) {
            System.out.println(e.getMessage());
            return new Integer[]{0,0};
        }

        int startIndex = fileData.length - messageLength;

        byte[] messageDataByte = extractMessageData(startIndex, messageLength, fileData);

        //message section
        String output = "OutputMessage/" + "secretMessage." + extension;
        Path outputPath = Path.of(output);
        File outputFile = outputPath.toFile();
        if(writeByteToFile(messageDataByte, outputFile)) return new Integer[]{1, fileData.length};


        return new Integer[]{0, 0};
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
