



package Histogramy;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import java.math.*;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class HistogramEqualization extends MarvinAbstractImagePlugin {

    
    Integer[] MaxMin = new Integer[5];
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
    @Override
    public void process(
            MarvinImage imageIn,
            MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
        
        int l_arrRed[] = new int[256];
        int l_arrGreen[] = new int[256];
        int l_arrBlue[] = new int[256];
        for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                l_arrRed[imageIn.getIntComponent0(x, y)]++; // zlicza piksele w jednym kolorze
                l_arrGreen[imageIn.getIntComponent1(x, y)]++;
                l_arrBlue[imageIn.getIntComponent2(x, y)]++;
            }
        }
            double w=imageIn.getWidth()*imageIn.getHeight();
        
        double[] DRed= new double[256];        
        for( int i =0; i < 256; i++)
        {
            int zmienna=l_arrRed[0];
            for( int k=0; k <i+1; k++)
            {
                zmienna+=l_arrRed[k];
            }
            System.out.println(zmienna);
        
            DRed[i] = zmienna/w;
        }
        
        double[] DGreen= new double[256];        
        for( int i =0; i < 256; i++)
        {
            int zmienna=l_arrRed[0];
            for( int k=0; k <i+1; k++)
            {
                zmienna+=l_arrRed[k];
            }
            DGreen[i] = zmienna/w;
        }
        
        double[] DBlue= new double [256];        
        for( int i =0; i < 256; i++)
        {
            int zmienna=l_arrRed[0];
            for( int k=0; k <i+1; k++)
            {
                zmienna+=l_arrRed[k];
            }
            DBlue[i] = zmienna/w;
        }
        
        
        int n = 0;
        while(DRed[n]<=0)
        {
            n=n+1;
        }
        double minDRed = DRed[n];
        
         int k = 0;
        while(DBlue[k]<=0)
        {
            k=k+1;
        }
        double minDBlue = DBlue[k];
        
         int j = 0;
        while(DGreen[j]<=0)
        {
            j=j+1;
        }
        double minDGreen = DGreen[j];
        
        
        int[] lutR = new int[256];
        int[] lutG = new int[256];
        int[] lutB = new int[256];
        for(int i = 0 ;i<256;++i){
            lutR[i]=(int) Math.floor(((DRed[i]-minDRed)/(1-minDRed))*255);
            lutG[i]=(int) Math.floor(((DGreen[i]-minDGreen)/(1-minDGreen))*255);
            lutB[i]=(int) Math.floor(((DBlue[i]-minDBlue)/(1-minDBlue))*255);
     
        }  
        int r, g, b;
        for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                r = lutR[imageIn.getIntComponent0(x,y)];
                g = lutG[imageIn.getIntComponent1(x,y)];
                b = lutB[imageIn.getIntComponent2(x,y)];
            imageOut.setIntColor(x, y, r, g, b);
            }
        }
        }
}