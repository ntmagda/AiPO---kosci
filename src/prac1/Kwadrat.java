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
import Szum.Odszumianie;
import Szum.Szum;
import tools.*;

/**
 * History sample
 *
 * @author Gabriel Ambrosio Archanjo
 *
 */
public class Kwadrat extends BaseFrame1 {

    public Kwadrat(String filename) {
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

     
    
        // wyświetlenie wyników działania programu na wykresie
        imagePanelNew.setImage(resultImage);
        
        if(resultImage != null){
            MarvinImageIO.saveImage(resultImage, "./res/kwadratodszumiony.png");
	}
    }

    public static void main(String args[]) {
        // nazwa wyświetlanego zdjęcia
        String filename = "./res/kwadrat.png"; //"./res/01.jpg";
        Kwadrat wykonaj = new Kwadrat(filename);
    }
}