/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package KolorowanieKosci;

import DzialanianaMacierzach.DzialaniaMatrix;
import KolorowanieKosci.Otsu;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import org.jblas.DoubleMatrix;
import Filtry.*;
import Histogramy.Contrast;
import Podstawowe.Grey;
import tools.*;
import Podstawowe.*;
import Szum.Odszumianie;
import Podstawowe.ErozjaJanka;
/**
 * History sample
 *
 * @author Gabriel Ambrosio Archanjo
 *
 */
public class Uruchom extends BaseFrame1 {

    public Uruchom(String filename) {
        super(filename);
    }

    /**
     * przetwarzanie zdjęcia
     */
         

    @Override
    protected void process() {
        resultImage = originalImage.clone();
        resultImage1 = originalImage.clone();;
        history.addEntry("Original", resultImage, null);
        DzialaniaMatrix dodawanie = new DzialaniaMatrix();
       /* tempPlugin = new Odszumianie();
        tempPlugin.process(resultImage,resultImage);
        resultImage.update();
        addToHistory("mediana");
        *//*
        double wspolczynnik =1.3;        
        tempPlugin = new Contrast();
        tempPlugin.setAttribute("wspolczynnik", wspolczynnik);
        tempPlugin.process(resultImage, resultImage);
        resultImage.update();        
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Contrast"); 
        */
        DoubleMatrix[] oryginaltab = new DoubleMatrix[3]; 
        oryginaltab = dodawanie.returnMatrix(originalImage);
        //FILTR GAUSSA
        tempPlugin = new FiltrySploty();
        int dimSplotx =5;
        int dimSploty=5;
        
        DoubleMatrix filter = new DoubleMatrix(dimSplotx,dimSploty);
       
          filter.put(0,0, 2.0);
          filter.put(1,0, 4.0);
          filter.put(2,0,5.0);
          filter.put(3,0,4.0);
          filter.put(4,0,2.0);
          
          filter.put(0,1, 4.0);
          filter.put(1,1, 9.0);
          filter.put(2,1,12.0);
          filter.put(3,1,9.0);
          filter.put(4,1,4.0);
          
          filter.put(0,2, 5.0);
          filter.put(1,2, 12.0);
          filter.put(2,2,15.0);
          filter.put(3,2,12.0);
          filter.put(4,2,5.0);
          
          filter.put(0,3, 4.0);
          filter.put(1,3, 9.0);
          filter.put(2,3,12.0);
          filter.put(3,3,9.0);
          filter.put(4,3,4.0);
          
         
          filter.put(0,4,2.0);
          filter.put(1,4,4.0);
          filter.put(2,4,5.0);
          filter.put(3,4,4.0);
          filter.put(4,4,2.0);
                  
        tempPlugin.setAttribute("filter", filter);
        tempPlugin.process(resultImage,resultImage);
        addToHistory("rozmycie Gaussa");
        
        //Odcienie szarosci
        
        tempPlugin = new Grey();
        tempPlugin.process(resultImage, resultImage);
        resultImage.update();
        addToHistory("Grey");
        
                
        tempPlugin = new MojCanny();
        //resultImage1 = originalImage.clone();
        tempPlugin.process(resultImage,resultImage);
        resultImage.update();
        addToHistory("canny");
        
        
      
        DoubleMatrix[] tablica1 = new DoubleMatrix[3]; 
        tablica1 = dodawanie.returnMatrix(resultImage);
        
        
        
        
        /////////////////DYLACJA I OTSU///////////////////////////
        
        resultImage1 = originalImage.clone();
        
        tempPlugin1 = new Invert();
        tempPlugin1.process(resultImage1,resultImage1);
//        addToHistory("Negatyw");
        
        tempPlugin1 = new Otsu();
        tempPlugin1.process(resultImage1,resultImage1);
      //  addToHistory("Otsu");

       MarvinImage imageTmp = resultImage1.clone(); 
        
        tempPlugin1 = new Erozja();
        tempPlugin1.process(imageTmp,resultImage1);
        tempPlugin1.process(imageTmp,resultImage1);
        tempPlugin1.process(imageTmp,resultImage1);
        tempPlugin1.process(imageTmp,resultImage1);
        tempPlugin1.process(imageTmp,resultImage1);
        tempPlugin1.process(imageTmp,resultImage1);
        tempPlugin1.process(imageTmp,resultImage1);
        

        
        
//        addToHistory("Erozja");


        DoubleMatrix[] tablica2 = new DoubleMatrix[3]; 
        tablica2 = dodawanie.returnMatrix(resultImage1);
        
        dodawanie.DodawanieDwochZdjec(tablica1, tablica2, resultImage);
        
        
        tempPlugin1 = new Dylacja();
        tempPlugin1.process(resultImage,resultImage);
        tempPlugin1.process(resultImage,resultImage);
     //   tempPlugin1.process(resultImage,resultImage);
       
        
 
        tempPlugin1 = new Kolorowanie();
        tempPlugin1.process(resultImage, resultImage);
        tempPlugin1 = new ZamianaBialyNaCzarny();
        tempPlugin1.process(resultImage, resultImage);
        DoubleMatrix[] kolorowanietab = new DoubleMatrix[3];
        kolorowanietab = dodawanie.returnMatrix(resultImage);
        
        tempPlugin1 = new CountColors();
        tempPlugin1.process(resultImage, resultImage);
        
       dodawanie.DodawanieDwochZdjec(oryginaltab, kolorowanietab, resultImage);
      
        imagePanelNew.setImage(resultImage);
        
        if(resultImage != null){
            MarvinImageIO.saveImage(resultImage, "./res/aaaakosccanny.jpg");
	}
    }

    public static void main(String args[]) {
        // nazwa wyświetlanego zdjęcia
        String filename = "./res/kosc.jpg"; //"./res/01.jpg";
        Uruchom wykonaj = new Uruchom(filename);
    }
}