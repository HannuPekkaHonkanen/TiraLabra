package com.mycompany.tiralabra_maven;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Hannu
 */
public class Kuvanlukija {

    public void seeBMPImage(String BMPFileName) throws IOException {
//    public void seeBMPImage(String BMPFileName) {
//        BufferedImage image = ImageIO.read(getClass().getResource(BMPFileName));
        File BMPFile=new File(BMPFileName);
        BufferedImage image = ImageIO.read(BMPFile);

        int[][] array2D = new int[image.getWidth()][image.getHeight()];

        for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
            for (int yPixel = 0; yPixel < image.getHeight(); yPixel++) {
                int color = image.getRGB(xPixel, yPixel);
                if (color == Color.BLACK.getRGB()) {
                    array2D[xPixel][yPixel] = 1;
                }
                if (color == Color.RED.getRGB()) {
                    array2D[xPixel][yPixel] = 2;
                } else {
                    array2D[xPixel][yPixel] = 0; // ?
                }
            }
        }


        for (int yPixel = 0; yPixel < image.getHeight(); yPixel++) {
            for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
                System.out.print(array2D[xPixel][yPixel]);
            }
            System.out.println("");
        }

        Color myBlue = new Color(0, 0, 255); // Color white
        int rgb = myBlue.getRGB();

        try {
//            BufferedImage img = null;
//            try {
//                img = ImageIO.read(new File(BMPFileName));
//            } catch (IOException e) {
//            }



//            for (int i = 0; i < 100; i++) {
//                for (int j = 0; j < 100; j++) {

                    image.setRGB(0, 0, rgb);
//                }
//            }

            // retrieve image
            File outputfile = new File("bitmaps/testikartta006b-16-color-result.bmp");
            ImageIO.write(image, "bmp", outputfile);
        } catch (IOException e) {
        }


    }
}