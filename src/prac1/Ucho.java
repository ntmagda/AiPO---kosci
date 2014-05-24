/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prac1;

import Filtry.Sobel2;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import org.jblas.DoubleMatrix;
import Filtry.Sobel2;
import KolorowanieKosci.Dylacja;
import KolorowanieKosci.Erozja;
import KolorowanieKosci.Otsu;
import Skora.WykrywanieSkory;
import Skora.WykrywanieSkory1;
import Szum.Odszumianie;
import Szum.Szum;
import tools.*;

/**
 * History sample
 *
 * @author Gabriel Ambrosio Archanjo
 *
 */
public class Ucho extends BaseFrame1 {

    public Ucho(String filename) {
        super(filename);
    }

    /**
     * przetwarzanie zdjęcia
     */
    @Override
    protected void process() {
        resultImage = originalImage.clone();
        history.addEntry("Original", resultImage, null);

     
                  ////////////////////////////SZUM////////////////////////////////
       
        tempPlugin = new Odszumianie();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Odszumianie");
        
        tempPlugin = new WykrywanieSkory1();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Wykrywanie Skory");
        
        tempPlugin = new Otsu();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Otsu");
        
        tempPlugin = new Dylacja();
        tempPlugin.process(resultImage, resultImage);
        tempPlugin.process(resultImage, resultImage);
        tempPlugin.process(resultImage, resultImage);
        tempPlugin.process(resultImage, resultImage);
        tempPlugin.process(resultImage, resultImage);
        tempPlugin.process(resultImage, resultImage);
        tempPlugin.process(resultImage, resultImage);
        tempPlugin.process(resultImage, resultImage);
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Dylacja");
        
        tempPlugin = new Erozja();
      //  tempPlugin.process(resultImage, resultImage);
        //tempPlugin.process(resultImage, resultImage);
        //tempPlugin.process(resultImage, resultImage);
        //tempPlugin.process(resultImage, resultImage);
        //tempPlugin.process(resultImage, resultImage);
        //tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Erozja");

     
    
        
        
        
        
        // wyświetlenie wyników działania programu na wykresie
        imagePanelNew.setImage(resultImage);
        
        if(resultImage != null){
            MarvinImageIO.saveImage(resultImage, "./res/uchoresult.png");
	}
    }

    public static void main(String args[]) {
        // nazwa wyświetlanego zdjęcia
        String filename = "./res/ucho1.png"; //"./res/01.jpg";
        Ucho wykonaj = new Ucho(filename);
    }
}