package Filtry;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import java.math.*;
import marvin.io.MarvinImageIO;
import org.jblas.DoubleMatrix;
import tools.BaseFrame1;
import Podstawowe.*;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */




public class SobelCanny extends MarvinAbstractImagePlugin {
    static public Grad[][] tablicaGrad;
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
        
        tablicaGrad= new Grad[imageIn.getWidth()][imageIn.getHeight()];
        
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
                
                if(xxg==0)
                {
                   tablicaGrad[x][y]= new Grad((Math.PI)/2,Math.hypot(xxg,yyg));
                }
                else
                {
                    tablicaGrad[x][y]=new Grad(Math.atan(yyg/xxg),Math.hypot(xxg,yyg));
                }
                
                int g = (int) Math.hypot(xxg,yyg);
                if(g > 255) g = 255;
                else if(g<0) g = 0;
                imageOut.setIntColor(x, y, g, g, g); 
            }
        }
    }
}