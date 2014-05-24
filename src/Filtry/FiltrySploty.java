package Filtry;

import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import org.jblas.DoubleMatrix;
import java.math.*;
/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class FiltrySploty extends MarvinAbstractImagePlugin {

    @Override
    public void load() {
    }

    @Override
    public MarvinAttributesPanel getAttributesPanel() {
        return null;
    }

    /**
     * Ta funkcja przetwarza zdjęcie jej kod należy zmieniać
     *
     * @param imageIn
     * @param imageOut
     * @param attributesOut
     * @param mask
     * @param previewMode
     */
    
    static double minSumRed=0;
    static double maxSumRed = 0;
    static double minSumGreen=0;
    static double maxSumGreen = 0;
    static double minSumBlue=0;
    static double maxSumBlue = 0;
    @Override
    public void process(
            MarvinImage imageIn,
            MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
        
        

     
        double norm=0;
       
        DoubleMatrix filter = (DoubleMatrix)getAttribute("filter");

        for ( int i = 0; i < filter.getRows();i++)
        {
            for ( int j = 0; j < filter.getColumns();j++)
            {
                norm=norm+Math.abs(filter.get(i, j)); // for normalization 
            }
        }

    
            int marginx = ((filter.getRows()-1)/2);
            int marginy = ((filter.getColumns()-1)/2);

            DoubleMatrix SumRed = new DoubleMatrix(imageIn.getWidth(),imageIn.getHeight());
            DoubleMatrix SumGreen = new DoubleMatrix(imageIn.getWidth(),imageIn.getHeight());
            DoubleMatrix SumBlue = new DoubleMatrix(imageIn.getWidth(),imageIn.getHeight());
            
            for (int x = marginx; x < imageIn.getWidth()-marginx; x++) {
                for (int y = marginy; y < imageIn.getHeight()-marginy; y++) {                
                    for ( int i = x-marginx,k=0 ; k < filter.getRows();i++,k++)
                    {
                        for ( int j = y-marginy, l=0 ; l <filter.getColumns();j++,l++)
                        {
                            SumRed.put(x,y,SumRed.get(x,y)+((filter.get(k, l)*imageIn.getIntComponent0(i, j)))/norm); 
                            SumGreen.put(x,y,SumGreen.get(x,y)+((filter.get(k, l)*imageIn.getIntComponent1(i, j)))/norm);
                            SumBlue.put(x,y,SumBlue.get(x,y)+((filter.get(k, l)*imageIn.getIntComponent2(i, j)))/norm);
                        }
                    }
                }
            }
            
            //poszukiwanie maximow i minimow dla normalizacji
            maxSumRed = SumRed.max();
            minSumRed = SumRed.min();
            maxSumGreen = SumGreen.max();
            minSumGreen = SumGreen.min();
            maxSumBlue = SumBlue.max();
            minSumBlue = SumBlue.min();

            
            System.out.println(maxSumRed);
            System.out.println(minSumRed);
            double oldRangeRed = maxSumRed - minSumRed;
            double oldRangeGreen = maxSumGreen - minSumGreen;
            double oldRangeBlue = maxSumBlue - minSumBlue;
            //System.out.println(oldRangeRed);
            double newRange = 255;
                        
                for (int x = marginx; x < imageIn.getWidth()-marginx; x++) {
                    for (int y = marginy; y < imageIn.getHeight()-marginy; y++) {     
 
                        //normalizacja, wowczas obraz szarawy
                        /*
                        double scaleRed = ((SumRed.get(x,y)-minSumRed)*newRange)/oldRangeRed;
                        SumRed.put(x,y,scaleRed);
                        double scaleGreen = ((SumGreen.get(x,y)-minSumGreen)*newRange)/oldRangeGreen;
                        SumGreen.put(x,y,scaleGreen);
                        double scaleBlue = ((SumBlue.get(x,y)-minSumBlue)*newRange)/oldRangeBlue;
                        SumBlue.put(x,y,scaleBlue);
                       */
                        /*
                        if(SumRed.get(x,y)>255.0) SumRed.put(x,y,255.0);
                        else if(SumRed.get(x,y)<0.0) SumRed.put(x,y,0.0);
                        if(SumGreen.get(x,y)>255.0) SumGreen.put(x,y,255.0);
                        else if(SumGreen.get(x,y)<0.0) SumGreen.put(x,y,0.0);
                        if(SumBlue.get(x,y)>255.0) SumBlue.put(x,y,255.0);
                        else if(SumBlue.get(x,y)<0.0) SumBlue.put(x,y,0.0);
                       */
                        
                        
                        imageOut.setIntColor(x, y, Math.abs((int)(SumRed.get(x,y))), Math.abs((int)(SumGreen.get(x,y))), Math.abs((int)(SumBlue.get(x,y))));
                    }   
                
                }
    }
    

}