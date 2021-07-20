package com.devxschool;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;

public class ReverseImageTest {


    /**
     * 1) loads image that is in resources directory
     * @return originalImage
     */
    public BufferedImage initImage(String location) {
        BufferedImage original;

        try{
            URL url = this.getClass().getClassLoader().getResource(location);
            File file = new File(url.toURI());
            original = ImageIO.read(file);
        }catch(IOException | URISyntaxException e){
            e.printStackTrace();
            throw new NullPointerException("Image not found\n" + e.getMessage());
        }
        return original;
    }

    @Test
    public void flipImageHorizontallyTest() {
        ReverseImage reverseImage = new ReverseImage();
        BufferedImage expected = this.initImage("Expected-DevX-logo.png");

        BufferedImage original = reverseImage.initImage("image/DevX-logo.png");
        BufferedImage actual = reverseImage.flipImageHorizontally(original);

        int width  = actual.getWidth();
        int height = actual.getHeight();

        // Loop over every pixel.
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                assertEquals(actual.getRGB(x, y), expected.getRGB(x, y));
            }
        }

    }

}
