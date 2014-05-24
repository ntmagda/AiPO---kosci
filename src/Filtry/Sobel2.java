package Filtry;

import KolorowanieKosci.MojCanny;
import Podstawowe.Grad;
import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import java.math.*;
import marvin.io.MarvinImageIO;
import org.jblas.DoubleMatrix;
import tools.BaseFrame1;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
class Sobel12 extends MarvinAbstractImagePlugin {

    @Override
    public void load() {
    }

    @Override
    public MarvinAttributesPanel getAttributesPanel() {
        return null;
    }
    @Override
    public void process(
            MarvinImage imageIn,
            MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
        Grad[][] tablica = new Grad[imageIn.getWidth()][imageIn.getHeight()];  
       // DoubleMatrix tablica = new DoubleMatrix(imageIn.getWidth(),imageIn.getHeight());
        for (int x = 3; x < imageIn.getWidth()-3; x++) {
            for (int y = 3; y < imageIn.getHeight()-3; y++) {
                
                int p0=imageIn.getIntComponent0(x-1, y-1);
                int p1=imageIn.getIntComponent0(x, y-1);
                int p2=imageIn.getIntComponent0(x+1, y-1);
                int p3=imageIn.getIntComponent0(x+1, y);
                int p4=imageIn.getIntComponent0(x+1, y+1);
                int p5=imageIn.getIntComponent0(x, y+1);
                int p6=imageIn.getIntComponent0(x-1, y+1);
                int p7=imageIn.getIntComponent0(x-1, y);
                int xxg = ((p2+2*p3+p4)-(p0+2*p7+p6));
                int yyg = ((p6+2*p5+p4)-(p0+2*p1+p2));
               

                int g = (int) Math.hypot(xxg,yyg);
               
                if(g > 255) g = 255;
                else if(g<0) g = 0;
                imageOut.setIntColor(x, y, g, g, g); 
                
                 if(xxg==0)
                {
                   tablica[x][y] = new Grad(Math.toRadians(90),Math.hypot(xxg,yyg));
                }
                else
                {
                   tablica[x][y] = new Grad(Math.atan2(yyg,xxg),Math.hypot(xxg,yyg));
                }
            }
        }
    }
}

public class Sobel2 extends BaseFrame1 {

    public Sobel2(String filename) {
        super(filename);
    }
    @Override
    protected void process() {
        resultImage = originalImage.clone();
        history.addEntry("Original", resultImage, null);

        resultImage1 = originalImage.clone();
        tempPlugin = new Sobel12();
        tempPlugin.process(resultImage, resultImage1);
        //zaktualizowanie obrazka
        resultImage1.update();
        //dodanie do historii
        addToHistory("Sobel2");
        imagePanelNew.setImage(resultImage1);
        
        if(resultImage1 != null){
            MarvinImageIO.saveImage(resultImage1, "./res/koscsobel.jpg");
	}
        
    }

    public static void main(String args[]) {
        // nazwa wyświetlanego zdjęcia
        String filename = "./res/kosc.jpg"; //"./res/01.jpg";
        Sobel2 wykonaj = new Sobel2(filename);
    }
}







