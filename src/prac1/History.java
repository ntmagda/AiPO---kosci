/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prac1;

import KolorowanieKosci.Otsu;
import KolorowanieKosci.Dylacja;
import DzialanianaMacierzach.DzialaniaMatrix;
import KolorowanieKosci.MojCanny;
import Filtry.Sobel2;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import org.jblas.DoubleMatrix;
import Filtry.Sobel2;
import Histogramy.Contrast;
import tools.*;
import prac1.*;
import Podstawowe.*;

/**
 * History sample
 *
 * @author Gabriel Ambrosio Archanjo
 *
 */
public class History extends BaseFrame1 {

    public History(String filename) {
        super(filename);
    }

    /**
     * przetwarzanie zdjęcia
     */
    @Override
    protected void process() {
        resultImage = originalImage.clone();
        history.addEntry("Original", resultImage, null);

        ////////////////////////////WYSWIETLANIE HISTOGRAMU///////////////////////
     /*
        tempPlugin = new ColorHistogram();
       // przetworzenie zdjęcia
        tempPlugin.process(resultImage, resultImage);
       */
        
        //////////////////////////////PROGOWANIE///////////////////////////////
        
        /*
        Progowanie tymcz = new Progowanie();
        tymcz.process(resultImage, resultImage);
        tymcz.Thresholding(resultImage, resultImage);
        */
          /////////////////////////////SZACHOWNICA///////////////////////
        /*
        tempPlugin = new Szachownica();
        tempPlugin.process(resultImage,resultImage);
        resultImage.update();
        //dodanie do historii
        addToHistory("HSV");
        
        */
        
        
        //////////////////////////DodawanieDwochZdjec////////////////////
       /*DzialaniaMatrix dzialanie = new DzialaniaMatrix();
       dzialanie.plus(resultImage, resultImage,200);
       dzialanie.minus(resultImage, resultImage,200);
       resultImage.update();
       
        
       DoubleMatrix[] tablica = new DoubleMatrix[3];
       DoubleMatrix[] tablica2 = new DoubleMatrix[3];
         tablica = dzialanie.returnMatrix(resultImage);
         dzialanie.plus(resultImage, resultImage,200);
         tablica2 = dzialanie.returnMatrix(resultImage);
         dzialanie.DodawanieDwochZdjec(tablica, tablica2, resultImage);
         
       

         */ 
         
                  ////////////////////////////SZUM////////////////////////////////
       /*
        tempPlugin = new Szum();
        double procent = 30.0;
        tempPlugin.setAttribute("procent", procent);
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Szum");
        tempPlugin = new Odszumianie();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Odszumianie");

        */
        
        
          ////////////////////////////GREY////////////////////////////////
       

        
        /////////////////////////////FILTRY SPLOTY///////////////////////
        /*
        tempPlugin = new FiltrySploty();
        int dimSplotx =3;
        int dimSploty=3;
        
        DoubleMatrix filter = new DoubleMatrix(dimSplotx,dimSploty);
        for(int i=0; i < dimSplotx; i++)
        {
            for (int j = 0 ; j < dimSploty; j++)
            {
                filter.put(i, j,-1.0);
            }
        }
        filter.put(1,1, 9.0);
        *//*Sobel:
          filter.put(0,0, -1.0);
          filter.put(0,1, -2.0);
          filter.put(0,2, -1.0);
          filter.put(2,0, 1.0);
          filter.put(2,1, 2.0);
          filter.put(2,2, 1.0);
*/
          
////// plaskorzezba/////////
      /*
        filter.put(1,0,0.0);
        filter.put(1,2,0.0);
        filter.put(1,1,1.0);
        filter.put(2,0,1.0);
        filter.put(2,1,1.0);
        filter.put(2,2,1.0);
        */
        ///////////// wyostrzenie/////////
        /*
        filter.put(0,0,0.0);
        filter.put(2,0,0.0);
        filter.put(0,2,0.0);
        filter.put(2,2,0.0);
        filter.put(1,1,5.0);
        */
        
        /*for(int i=0; i < dimSplotx; i++)
        {
            for (int j = 0 ; j < dimSploty; j++)
            {
                System.out.println(filter.get(i, j));
            }
        }*/
        /*
        //splot[((dimSplotx-1)/2)][((dimSploty-1)/2)]=9.0;
        
        splot[1][0]=0;
        splot[1][2]=0;
        splot[1][1]=1;
        splot[2][0]=1;
        splot[2][1]=1;
        
        splot[1][1]=2.0;
        *//*
        tempPlugin.setAttribute("filter", filter);
        tempPlugin.process(resultImage,resultImage);
        addToHistory("ss");
     */
       // DoubleMatrix filter2 = new DoubleMatrix(dimSplotx,dimSploty);
       /*
        for(int i=0; i < dimSplotx; i++)
        {
            for (int j = 0 ; j < dimSploty; j++)
            {
                filter.put(i, j,0.0);
            }
        }
        
          filter.put(2,1, 1.0);
          filter.put(1,2, -1.0);
          
        
        tempPlugin.setAttribute("filter", filter);
        tempPlugin.process(resultImage,resultImage);
        addToHistory("ss");
       */
        /////////////////////////////HSV////////////////////////////////       
        /*
        tempPlugin = new YCbCr();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("HSV");
      
        */
       
        
        ////////////////////////////INVERT////////////////////////////////
      /*
        tempPlugin = new Invert();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Invert");
      
        */
        
                ////////////////////////////DYLACJA////////////////////////////////
        /*DzialaniaMatrix dzialanie = new DzialaniaMatrix();
        DoubleMatrix[] tablica = new DoubleMatrix[3];
        DoubleMatrix[] tablica2 = new DoubleMatrix[3];
      
        tempPlugin = new CannyMisztal();
        tempPlugin.process(resultImage, resultImage);
        resultImage = resultImage.clone();
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("FiltrCanny");
        //tablica = dzialanie.returnMatrix(resultImage);
        /*
      */
        /*
        tempPlugin = new Invert();
        tempPlugin.process(resultImage,resultImage);
        resultImage.update();
        addToHistory("Invert");
        */
        
        
        /*
        tempPlugin = new Dylacja();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Dylacja");      
       
        /*
        tablica2 = dzialanie.returnMatrix(resultImage1);
        dzialanie.OdejmowanieDwochZdjec(tablica, tablica2, resultImage);
        resultImage.update();
        
        */
        
        /*
        
        

        
        
        tempPlugin = new Dylacja();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Dylacja");
        
        tablica2 = dzialanie.returnMatrix(resultImage);
        dzialanie.OdejmowanieDwochZdjec(tablica, tablica2, resultImage);
        resultImage.update();
        
        
        */
        
          
          /*
          
         double wspolczynnik =1.6;        
        tempPlugin = new Contrast();
        tempPlugin.setAttribute("wspolczynnik", wspolczynnik);
        tempPlugin.process(resultImage, resultImage);
        resultImage.update();        
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Contrast"); 
         *//*
        tempPlugin = new CannyMisztal();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("FiltrCanny");
        */
        tempPlugin = new Invert();
        tempPlugin.process(resultImage,resultImage);
        resultImage.update();
        addToHistory("Invert");
           tempPlugin = new Otsu();
        tempPlugin.process(resultImage,resultImage);
        resultImage.update();
        addToHistory("Invert");
        
        /*
        tempPlugin = new Otsu();
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Otsu");      
        
        tempPlugin = new Dylacja();
        tempPlugin.process(resultImage, resultImage);
        tempPlugin.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Dylacja");      
        
         
        

        
        
        ///////////////////////////HISTOGRAM EQUALIZATION////////////////////////////
        /*
        tempPlugin = new HistogramEqualization();
        tempPlugin.process(resultImage, resultImage);
        //temporary.process(resultImage, resultImage);
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Histogram Stretching");
        
        tempPlugin = new ColorHistogram();
       // przetworzenie zdjęcia
        tempPlugin.process(resultImage, resultImage);
       
        */
        
        
        
        ///////////////////////////HISTOGRAM STRETCHING////////////////////////////
       /*
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
        
        tempPlugin = new GrayHistogram();
       // przetworzenie zdjęcia
        tempPlugin.process(resultImage, resultImage);
       */
        ///////////////////////THRESHOLDING/////////////////////////////       
        /*
        Integer[] tablica = new Integer[4];
        Integer[] tablica1 = {50,100,150,200,250};
        
        tempPlugin = new MultiThresholding();
        tempPlugin.setAttribute("threshold", tablica1);
        tempPlugin.process(resultImage, resultImage);
        resultImage.update();
        //dodanie do historii
        addToHistory("Thresholding");
        
        */
        ///////////////////////KOREKCJA GAMMA////////////////////////////
       /*    
        double wspolczynnik =0.5;        
        tempPlugin = new Gamma();
        tempPlugin.setAttribute("wspolczynnik", wspolczynnik);
        tempPlugin.process(resultImage, resultImage);
        resultImage.update();        
        //zaktualizowanie obrazka
        resultImage.update();
        //dodanie do historii
        addToHistory("Gamma");
         
        */
        
         ///////////////////////CONTRAST////////////////////////////
           /*
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
         
        // wyświetlenie wyników działania programu na wykresie
        imagePanelNew.setImage(resultImage);
        
        if(resultImage != null){
            MarvinImageIO.saveImage(resultImage, "./res/KosciNegatyw.jpg");
	}
    }

    public static void main(String args[]) {
        // nazwa wyświetlanego zdjęcia
        String filename = "./res/kosc.jpg"; //"./res/01.jpg";
        History wykonaj = new History(filename);
    }
}