/// niedokonczone!!!

package Podstawowe;

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
public class YCbCr extends MarvinAbstractImagePlugin {

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
        int r, g, b;
        int  Y, Cb, Cr;
        for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                r = ((int) imageIn.getIntComponent0(x, y));
                g = ((int) imageIn.getIntComponent1(x, y));
                b = ((int) imageIn.getIntComponent2(x, y));
	              
                Y  = (int)( 0.299 * r + 0.587 * g + 0.114 * b)+10;
                Cb = (int)(128 - 0.168736 * r - 0.331264 * g + 0.5 * b);
		Cr = (int)( 128 + 0.5 * r - 0.418688 * g - 0.081312 * b);
                r = (int) (Y + 1.402*(Cr-128));
                g = (int) (Y - 0.34414 * (Cb - 128) - 0.71414 * (Cr - 128));
                b = (int) (Y + 1.772 * (Cb - 128));
                
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
}