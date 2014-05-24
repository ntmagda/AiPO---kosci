package KolorowanieKosci;

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
public class ZamianaBialyNaCzarny extends MarvinAbstractImagePlugin {

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
                r = (int) imageIn.getIntComponent0(x, y);
                g = (int) imageIn.getIntComponent1(x, y);
                b = (int) imageIn.getIntComponent2(x, y);
                
                if( r ==255 && g ==255 && b == 255)
                {
                    r =0;
                    g=0;
                    b=0;
                }

                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
}