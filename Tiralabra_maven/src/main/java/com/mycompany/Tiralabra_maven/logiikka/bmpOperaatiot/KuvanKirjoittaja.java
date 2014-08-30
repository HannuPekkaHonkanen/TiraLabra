package com.mycompany.Tiralabra_maven.logiikka.bmpOperaatiot;

import com.mycompany.Tiralabra_maven.logiikka.Paikka;
import com.mycompany.Tiralabra_maven.logiikka.paikkaPino.OmaPinoAlkionaPaikka;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.Stack;
import javax.imageio.ImageIO;

/**
 * KESKENERÄINEN
 */
public class KuvanKirjoittaja {

    private BufferedImage image;

    public void writeImage(String BMPFileName, int[][] kuvataulukko, OmaPinoAlkionaPaikka kaydytPaikat, OmaPinoAlkionaPaikka reittiPino) {

        File outputfile = new File(BMPFileName.substring(0, BMPFileName.length() - 4) + "tulos.bmp");

        try {
            this.image = ImageIO.read(new File(BMPFileName));
        } catch (IOException e) {
            System.out.println("virhe");
        }

        int color;
        Paikka paikkaK;
        while (!kaydytPaikat.stackIsEmpty()) {
            paikkaK = kaydytPaikat.stackPop();
            color = image.getRGB(paikkaK.i, paikkaK.j);
//            if (paikkaK.aikaKustannus < Integer.MAX_VALUE / 10) {
            if (!(color == Color.BLACK.getRGB() || color == Color.GREEN.getRGB() || color == Color.RED.getRGB())) {
                image.setRGB(paikkaK.i, paikkaK.j, Color.YELLOW.getRGB());
            }
//            try {
//                ImageIO.write(image, "bmp", outputfile);
//                
//            } catch (IOException e) {
//            }
        }


        //        Color myBlue = new Color(0, 0, 255);
//        int blue = myBlue.getRGB();

        Paikka paikkaU;
        while (!reittiPino.stackIsEmpty()) {
            paikkaU = reittiPino.stackPop();
//            System.out.println(paikkaU.i + ", " + paikkaU.j);
//            this.reittiKartta[paikkaU.i][paikkaU.j] = 0;
//                    image.setRGB(paikkaU.i, paikkaU.j, blue);
            image.setRGB(paikkaU.i, paikkaU.j, Color.BLUE.getRGB());
//                    image.setRGB(paikkaU.i, paikkaU.j, Color.YELLOW.getRGB());

        }



        try {
//            outputfile = new File(BMPFileName.substring(0, BMPFileName.length() - 4) + "tulos.bmp");
            ImageIO.write(image, "bmp", outputfile);
        } catch (IOException e) {
        }
    }
}
