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
public class Szachownica extends MarvinAbstractImagePlugin {

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
        int szerokosc = imageIn.getWidth();
        int wysokosc = imageIn.getHeight();
        int szerokoscPola = (int)szerokosc/10;
         for (int x = 0; x < szerokosc; x++) {
             for (int y = 0; y < wysokosc; y++) {
               
              if((((y/50)+(x/50))%2==0))
               {
                   imageOut.setIntColor(x, y, 255, 255, 255);
               }
              else 
              {
                   imageOut.setIntColor(x, y, 0, 0, 0);
              }
             
             }
         }
    }
}