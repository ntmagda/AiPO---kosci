/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Filtry;

import marvin.io.MarvinImageIO;
import org.jblas.DoubleMatrix;
import tools.*;
import prac1.*;
import DzialanianaMacierzach.*;

/**
 * History sample
 *
 * @author magda
 *
 */
public class Sobel extends BaseFrame1 {

    public Sobel(String filename) {
        super(filename);
    }

    /**
     * przetwarzanie zdjęcia
     */
    @Override
    protected void process() {
        resultImage = originalImage.clone();
        history.addEntry("Original", resultImage, null);

     
        /////////////////////////////FILTRY SPLOTY///////////////////////
        tempPlugin = new FiltrySploty();
        int dimSplotx=3; // wymiar macierzy jądra
        int dimSploty=3;
        
        DoubleMatrix filter = new DoubleMatrix(dimSplotx,dimSploty); 
          filter.fill(0.0);
          filter.put(0,0, -1.0);
          filter.put(0,1, -2.0);
          filter.put(0,2, -1.0);
          filter.put(2,0, 1.0);
          filter.put(2,1, 2.0);
          filter.put(2,2, 1.0);
          
          DzialaniaMatrix dzialanie = new DzialaniaMatrix();// przygotowanie dwoch tablic, potrzebnych do dodania dwoch zdjec do sibeie
          DoubleMatrix[] tablica = new DoubleMatrix[3]; // kazda tablica to tablica dla osobnego kanału, zawiera wartosci dla poszczegolnych pixeli
          DoubleMatrix[] tablica2 = new DoubleMatrix[3]; // jest to tablica ktorej elementami jest tablica DoubleMatrix;

         
     
        tempPlugin.setAttribute("filter", filter); // przesylam filtr
        tempPlugin.process(resultImage,resultImage); // wykonuje sie funkcja z klasy FiltrySploty
        tablica = dzialanie.returnMatrix(resultImage); // po wykonaniu sie funkcji zwraca tablice zmodyfikowanego obrazu
        addToHistory("konwersja pierwsza");
        resultImage = originalImage.clone(); // wszystko od nowa ale z nowym filtrem
        tempPlugin1 = new FiltrySploty();
        DoubleMatrix filter2 = new DoubleMatrix(dimSplotx,dimSploty);
          filter2.fill(0.0);
          filter.put(0,2, -1.0);
          filter.put(1,2, -2.0);
          filter.put(2,2, -1.0);
          filter.put(0,0, 1.0);
          filter.put(1,0, 2.0);
          filter.put(2,0, 1.0);
          
        tempPlugin1.setAttribute("filter", filter2);
        tempPlugin1.process(resultImage,resultImage);
        tablica2 = dzialanie.returnMatrix(resultImage); // tablica dla drugiego zdjecia
        addToHistory("konwersja druga");

        dzialanie.DodawanieDwochZdjec(tablica, tablica2, resultImage); // dodawanie dwoch zdjec do sibeie na podstawie ich tablica, wynik wpisywany do resultImage
        
        imagePanelNew.setImage(resultImage);
        
        if(resultImage != null){
            MarvinImageIO.saveImage(resultImage, "./res/affff.jpg");
	}
        
    }

    public static void main(String args[]) {
        // nazwa wyświetlanego zdjęcia
        String filename = "./res/tucano.jpg"; //"./res/01.jpg";
        Sobel wykonaj = new Sobel(filename);
    }
}