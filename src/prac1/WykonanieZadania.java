/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prac1;

import Histogramy.Contrast;
import Histogramy.HistogramStretching1;
import Histogramy.SredniaMaxMin;
import Podstawowe.Mask;
import Podstawowe.YCbCr;
import Podstawowe.Gamma;
import marvin.io.MarvinImageIO;
import tools.*;
import Histogramy.*;

/**
 * History sample
 *
 * @author Gabriel Ambrosio Archanjo
 *
 */
public class WykonanieZadania extends BaseFrame1 {

    public WykonanieZadania(String filename) {
        super(filename);
    }

    /**
     * przetwarzanie zdjęcia
     */
    @Override
    protected void process() {
        resultImage = originalImage.clone();
        history.addEntry("Original", resultImage, null);

        Mask maska = new Mask(resultImage);
        ////////////////////////////WYSWIETLANIE HISTOGRAMU///////////////////////
        /*
        tempPlugin = new ColorHistogram();
       // przetworzenie zdjęcia
        tempPlugin.process(resultImage, resultImage);
        */
        

        /////////////////////////////YCbCr////////////////////////////////       
        
        tempPlugin = new YCbCr();
        tempPlugin.process(resultImage, resultImage, maska);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Rozjasnienie Y");
     /*
                ////////////////////////////GREY////////////////////////////////
       /*
        tempPlugin = new Grey();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Grey");
      */
              ////////////////////////////WYSWIETLANIE HISTOGRAMU///////////////////////
        /*
        tempPlugin = new ColorHistogram();
       // przetworzenie zdjęcia
        tempPlugin.process(resultImage, resultImage);
        */
      
         ///////////////////////KOREKCJA GAMMA////////////////////////////
           
        double wspolczynnik =0.1;        
        tempPlugin = new Gamma();
        tempPlugin.setAttribute("wspolczynnik", wspolczynnik);
        tempPlugin.process(resultImage, resultImage);
        resultImage.update();        
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Gamma");
        
          ////////////////////////////WYSWIETLANIE HISTOGRAMU///////////////////////
        // wyswietlam histogram przed rozszerzeniem
        tempPlugin = new ColorHistogram();
       // przetworzenie zdjęcia
        tempPlugin.process(resultImage, resultImage);
         
        ///////////////////////////HISTOGRAM STRETCHING////////////////////////////
        
        SredniaMaxMin temporary = new SredniaMaxMin();
        temporary.process(resultImage);
        
        Integer[] tablica1 = {temporary.maximumRed,temporary.maximumGreen,temporary.maximumBlue, temporary.minimumRed, temporary.minimumGreen, temporary.minimumBlue};
        tempPlugin = new HistogramStretching1();
        tempPlugin.setAttribute("MaxMin", tablica1);
        tempPlugin.process(resultImage, resultImage);
        //temporary.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Histogram Stretching");
       
       ////////////////////////////WYSWIETLANIE HISTOGRAMU///////////////////////
        // wyswietlam histogram po rozszerzeniu
        tempPlugin = new ColorHistogram();
       // przetworzenie zdjęcia
        tempPlugin.process(resultImage, resultImage);
        
      
        ///////////////////////////HISTOGRAM EQUALIZATION////////////////////////////
  /*
        tempPlugin = new HistogramEqualization();
        tempPlugin.process(resultImage, resultImage);
        //temporary.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
         addToHistory("Histogram Equalization");
        */
                ////////////////////////////WYSWIETLANIE HISTOGRAMU///////////////////////
        /*
        tempPlugin = new ColorHistogram();
       // przetworzenie zdjęcia
        tempPlugin.process(resultImage, resultImage);
        */
        //////////////////////////////HSV odczytanie Y-eka///////////////////////////
 /*       
        HSVOdczytY temp = new HSVOdczytY();
        temp.process(resultImage, resultImage);
        int Y = temp.Y;
        //zaktualizowanie obrazka
        //dodanie do historii
        addToHistory("Odczytujemy zmieniona zmienna luminacji");
        resultImage = originalImage.clone();
        
        HSVOdczytY temp1 = new HSVOdczytY();
        temp1.process(resultImage, resultImage);
        temp1.Y=Y;
        //zaktualizowanie obrazka
        //dodanie do historii
        addToHistory("Przekazana i zmieniona zmienna luminacji w obrazie oryginalnym");
   */     
       
        
        
         ///////////////////////CONTRAST////////////////////////////
        
        double wspolczynnik1 =1.5;        
        tempPlugin = new Contrast();
        tempPlugin.setAttribute("wspolczynnik", wspolczynnik1);
        tempPlugin.process(resultImage, resultImage, maska);
        resultImage.update();        
        //zaktualizowanie obrazka
        //dodanie do historii
        addToHistory("Contrast");
         
                 
        // wyświetlenie wyników działania programu na wykresie
        imagePanelNew.setImage(resultImage);
        
        if(resultImage != null){
            MarvinImageIO.saveImage(resultImage, "./res/aaaaaaaaa.png");
	}
        
    }

    public static void main(String args[]) {
        // nazwa wyświetlanego zdjęcia
        String filename = "./res/kobieta.png"; //"./res/01.jpg";
        new WykonanieZadania(filename);
    }
}