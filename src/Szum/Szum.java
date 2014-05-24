package Szum;


import java.util.Random;
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
public class Szum extends MarvinAbstractImagePlugin {

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
        
        double procent = (double)getAttribute("procent");
        int liczbaPixeli = imageIn.getWidth()*imageIn.getHeight();
        int szum = (int)(procent*liczbaPixeli)/100;
        Random randx = new Random();
        Random randy = new Random();
        Random bool = new Random();
        
        for ( int i =0 ; i <szum;i++){
                int xx = randx.nextInt(imageIn.getWidth());
                int yy = randy.nextInt(imageIn.getHeight());
                int kolor = bool.nextInt(2);
               // if(kolor==1){
                //    imageOut.setIntColor(xx, yy, 0, 0, 0);
                //}
                //else{
                    imageOut.setIntColor(xx,yy,255,255,255);
                //}
                      
        }
                
            }
        }