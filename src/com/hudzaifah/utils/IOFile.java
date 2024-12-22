package com.hudzaifah.utils;

import java.io.*;

public class IOFile {
    public byte[] readImage(File file){
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] temp = new byte[1024]; // Buffer sementara
            int bytesRead;

            while ((bytesRead = inputStream.read(temp)) != -1) {
                buffer.write(temp, 0, bytesRead);
            }

            return buffer.toByteArray();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void writeImage(byte[] data,File file){
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
