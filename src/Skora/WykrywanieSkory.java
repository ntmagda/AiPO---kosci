package Skora;

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
public class WykrywanieSkory extends MarvinAbstractImagePlugin {

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
        for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                r = ((int) imageIn.getIntComponent0(x, y));
                g = ((int) imageIn.getIntComponent1(x, y));
                b = ((int) imageIn.getIntComponent2(x, y));
                
                
                if(r>95&& g>40 && b>20 && (Math.max(Math.max(r,g),b)-Math.min(Math.min(r,g),b))>15 && (Math.abs(r-g))>15 && r>g && r>b)
                {
                    r=b=g=255;
                }
                else
                {
                    r=b=g=0;
                }

                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
}