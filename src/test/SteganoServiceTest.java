package test;

import com.hudzaifah.service.SteganoService;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SteganoServiceTest {
    SteganoService steganoService = new SteganoService();

    @Test
    void shoutCreateImageAndInsertMessage(){
        String message = "Hudzaifah";
        File inputImage = new File("InputImage/testing2.png");
        Integer[] result = steganoService.stegano(message, inputImage);
        System.out.println(result[0]);
        System.out.println(result[1]);

        assertEquals(1, result[0]);
    }

    @Test
    void shoutNotCreateImageAndInsertMessage(){
        String message = "Hudzaifah";
        File inputImage = new File("InputImage/temp.png");
        Integer[] result = steganoService.stegano(message, inputImage);
        System.out.println(result[0]);
        System.out.println(result[1]);

        assertEquals(0, result[0]);
    }

    @Test
    void shoutExtractMessage(){
        String[] result = steganoService.extrackMessage(new File("imageForExtractMessage/testing2.png"), 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
        assertEquals("Hudzaifah", result[1]);
    }

    @Test
    void shoutNotExtractMessage(){
        String[] result = steganoService.extrackMessage(new File("imageForExtractMessage/testing.png"), 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
        assertEquals("0", result[0]);
    }

}
