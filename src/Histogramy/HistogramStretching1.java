



package Histogramy;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class HistogramStretching1 extends MarvinAbstractImagePlugin {

    
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
    public void process( MarvinImage imageIn, MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
        
       MaxMin = (Integer[]) getAttribute("MaxMin");
       int minimumRed = MaxMin[3];
       int minimumGreen = MaxMin[4];
       int minimumBlue = MaxMin[5];
       int maximumRed = MaxMin[0];
       int maximumGreen = MaxMin[1];
       int maximumBlue = MaxMin[2];
        int[] lutR = new int[256];
        int[] lutG = new int[256];
        int[] lutB = new int[256];
        for(int i = 0 ;i<256;++i){
            lutR[i]=(255*((int)i-minimumRed))/(maximumRed-minimumRed);
            lutG[i]=(255*((int)i-minimumGreen))/(maximumGreen-minimumGreen);
            lutB[i]=(255*((int)i-minimumBlue))/(maximumBlue-minimumBlue);
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