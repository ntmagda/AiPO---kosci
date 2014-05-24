/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Filtry;


import marvin.io.MarvinImageIO;
import org.jblas.DoubleMatrix;
import tools.*;

/**
 * History sample
 *
 * @author Gabriel Ambrosio Archanjo
 *
 */
public class Plaskorzezba extends BaseFrame1 {

    public Plaskorzezba(String filename) {
        super(filename);
    }

    /**
     * przetwarzanie zdjęcia
     */
    @Override
    protected void process() {
        resultImage = originalImage.clone();
        history.addEntry("Original", resultImage, null);

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
  
        filter.put(1,0,0.0);
        filter.put(1,2,0.0);
        filter.put(1,1,1.0);
        filter.put(2,0,1.0);
        filter.put(2,1,1.0);
        filter.put(2,2,1.0);
        
       
        tempPlugin.setAttribute("filter", filter);
        tempPlugin.process(resultImage,resultImage);
        addToHistory("ss");
     
        imagePanelNew.setImage(resultImage);
        
        if(resultImage != null){
            MarvinImageIO.saveImage(resultImage, "./res/affff.jpg");
	}
        
    }

    public static void main(String args[]) {
        // nazwa wyświetlanego zdjęcia
        String filename = "./res/tucano.jpg"; //"./res/01.jpg";
        Plaskorzezba wykonaj = new Plaskorzezba(filename);
    }
}