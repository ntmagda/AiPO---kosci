/*

Obrót - obrót obrazu o kąt r można wykonywać przekształcając współrzędne oryginału lub kopii.
Przy przekształcaniu z oryginału bierzemy piksel P[i,j] i ustalamy współrzędne, pod które powinien on trafić na kopii, jako:

    P_k[cos(r)*i-sin(r)*j,sin(r)*i+cos(r)*j]

Przy przekształcaniu z kopii bierzemy piksel P_k[i,j] i ustalamy współrzędne, z których należy pobrać piksel oryginału, jako:

    P[cos(-r)*i-sin(-r)*j,sin(-r)*i+cos(-r)*j]

Poniżej znajdują się przykłady obrotów, po lewej z oryginału, po prawej z kopii. 
x'=-x
y'=-y
 
 */
package Podstawowe;

import DzialanianaMacierzach.DzialaniaMatrix;
import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import org.jblas.DoubleMatrix;

/**
 * Invert the pixels color.
 *
 *1 @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class Obrot extends MarvinAbstractImagePlugin {

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
                 DzialaniaMatrix dzialanie  = new DzialaniaMatrix();
                DoubleMatrix tablica1[] = dzialanie.returnMatrix(imageIn);
        for (int x = 1; x < imageIn.getWidth(); x++) {
            for (int y = 1; y < imageIn.getHeight(); y++)
            {
                
                r = Math.abs((int)tablica1[0].get(x,y));
                g = Math.abs((int)tablica1[1].get(x,y));
                b = Math.abs((int)tablica1[2].get(x,y));
                imageOut.setIntColor(imageIn.getWidth()-x,y, r,g,b);
            }
        }
    }
}