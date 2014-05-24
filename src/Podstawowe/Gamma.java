package Podstawowe;

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
public class Gamma extends MarvinAbstractImagePlugin {

    
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
        
       double wsp = (double) getAttribute("wspolczynnik");
        int r, g, b;
        for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                r = (int)(255 *(Math.pow(( imageIn.getIntComponent0(x, y)/255.0),(wsp))));
                g = (int)(255 *(Math.pow((imageIn.getIntComponent1(x, y)/255.0),(wsp))));
                b = (int)(255 * (Math.pow((imageIn.getIntComponent2(x, y)/255.0),(wsp))));
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
}