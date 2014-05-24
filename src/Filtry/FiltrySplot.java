package Filtry;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import org.jblas.DoubleMatrix;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class FiltrySplot extends MarvinAbstractImagePlugin {

    static double dzielnik=0;
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
        
        int dimSplotx = (int) getAttribute("dimSplotx");    
        int dimSploty = (int) getAttribute("dimSploty");    
        double[][] splot = (double[][])getAttribute("splot");
        
                 for(int i=0; i < dimSplotx; i++)
                    {
                        for (int j = 0 ; j < dimSploty; j++)
                        {
                           dzielnik+=splot[i][j];
                        }
                    }
     
        
        int[][][] MatrixIn = new int[imageIn.getWidth()][imageIn.getHeight()][];

        for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                int[] RGB = new int[3];
                RGB[0]=(int) imageIn.getIntComponent0(x, y);
                RGB[1]=(int) imageIn.getIntComponent1(x, y);
                RGB[2]=(int) imageIn.getIntComponent2(x, y);
                MatrixIn[x][y] = RGB;
            }
        }
        int[][][] MatrixOut = new int[imageIn.getWidth()][imageIn.getHeight()][3];
        for (int x = (dimSplotx-1)/2; x < imageIn.getWidth()-((dimSplotx-1)/2); x++) {
            for (int y = (dimSploty-1)/2; y < imageIn.getHeight()-((dimSploty-1)/2); y++) {
                
                int[] RGB = new int[3];
                 for( int i =1; i < ((dimSplotx-1)/2)+1;i++)
                  {
                      for( int j = i; j < ((dimSploty-1)/2)+1;j++)
                      {
                          
                 //        RGB[0]=(int)(RGB[0]+(splot[i*(dimSplotx+1)]*MatrixIn[x+i-(dimSplotx-1)/2][y+j-(dimSploty-1)/2]));
                         
                          
                RGB[0]=(int)(RGB[0]+((
                       
                        MatrixIn[x-i][y][0]*splot[((dimSplotx-1)/2)-i][(dimSploty-1)/2]+
                        MatrixIn[x-i][y-j][0]*splot[((dimSplotx-1)/2)-i][((dimSploty-1)/2)-j]+
                        MatrixIn[x-i][y+j][0]*splot[((dimSplotx-1)/2)-i][((dimSploty-1)/2)+j]+
                        MatrixIn[x][y+j][0]*splot[((dimSplotx-1)/2)][((dimSploty-1)/2)+j]+
                        MatrixIn[x][y-j][0]*splot[((dimSplotx-1)/2)][((dimSploty-1)/2)-j]+
                        MatrixIn[x][y][0]*splot[((dimSplotx-1)/2)][(dimSploty-1)/2]+
                        MatrixIn[x+i][y][0]*splot[((dimSplotx-1)/2)+i][(dimSploty-1)/2]+
                        MatrixIn[x+i][y-j][0]*splot[((dimSplotx-1)/2)+i][((dimSploty-1)/2)-j]+
                        MatrixIn[x+i][y+j][0]*splot[((dimSplotx-1)/2)+i][((dimSploty-1)/2)+j])));
                RGB[1]=(int)(RGB[1]+((
                        MatrixIn[x-i][y][1]*splot[((dimSplotx-1)/2)-i][(dimSploty-1)/2]+
                        MatrixIn[x-i][y-j][1]*splot[((dimSplotx-1)/2)-i][((dimSploty-1)/2)-j]+
                        MatrixIn[x-i][y+j][1]*splot[((dimSplotx-1)/2)-i][((dimSploty-1)/2)+j]+
                        MatrixIn[x][y+j][1]*splot[((dimSplotx-1)/2)][((dimSploty-1)/2)+j]+
                        MatrixIn[x][y-j][1]*splot[((dimSplotx-1)/2)][((dimSploty-1)/2)-j]+
                        MatrixIn[x][y][1]*splot[((dimSplotx-1)/2)][(dimSploty-1)/2]+
                        MatrixIn[x+i][y][1]*splot[((dimSplotx-1)/2)+i][(dimSploty-1)/2]+
                        MatrixIn[x+i][y-j][1]*splot[((dimSplotx-1)/2)+i][((dimSploty-1)/2)-j]+
                        MatrixIn[x+i][y+j][1]*splot[((dimSplotx-1)/2)+i][((dimSploty-1)/2)+j])));
               RGB[2] =(int)(RGB[2]+((
                        MatrixIn[x-i][y][2]*splot[((dimSplotx-1)/2)-i][(dimSploty-1)/2]+
                        MatrixIn[x-i][y-j][2]*splot[((dimSplotx-1)/2)-i][((dimSploty-1)/2)-j]+
                        MatrixIn[x-i][y+j][2]*splot[((dimSplotx-1)/2)-i][((dimSploty-1)/2)+j]+
                        MatrixIn[x][y+j][2]*splot[((dimSplotx-1)/2)][((dimSploty-1)/2)+j]+
                        MatrixIn[x][y-j][2]*splot[((dimSplotx-1)/2)][((dimSploty-1)/2)-j]+
                        MatrixIn[x][y][2]*splot[((dimSplotx-1)/2)][(dimSploty-1)/2]+
                        MatrixIn[x+i][y][2]*splot[((dimSplotx-1)/2)+i][(dimSploty-1)/2]+
                        MatrixIn[x+i][y-j][2]*splot[((dimSplotx-1)/2)+i][((dimSploty-1)/2)-j]+
                        MatrixIn[x+i][y+j][2]*splot[((dimSplotx-1)/2)+i][((dimSploty-1)/2)+j])));

                  }
               }
               RGB[0] = (int)(RGB[0]/dzielnik);
               RGB[1] = (int)(RGB[1]/dzielnik);
               RGB[2] = (int)(RGB[2]/dzielnik);
          /*      
                RGB[0]=(int)((
                       
                        MatrixIn[x-1][y][0]*splot[0][1]+
                        MatrixIn[x-1][y-1][0]*splot[0][0]+
                        MatrixIn[x-1][y+1][0]*splot[0][2]+
                        MatrixIn[x][y+1][0]*splot[1][2]+
                        MatrixIn[x][y-1][0]*splot[1][0]+
                        MatrixIn[x][y][0]*splot[1][1]+
                        MatrixIn[x+1][y][0]*splot[2][1]+
                        MatrixIn[x+1][y-1][0]*splot[2][0]+
                        MatrixIn[x+1][y+1][0]*splot[2][2])/(dzielnik));
                RGB[1]=(int)((
                        MatrixIn[x-1][y][1]*splot[0][1]+
                        MatrixIn[x-1][y-1][1]*splot[0][0]+
                        MatrixIn[x-1][y+1][1]*splot[0][2]+
                        MatrixIn[x][y+1][1]*splot[1][2]+
                        MatrixIn[x][y-1][1]*splot[1][0]+
                        MatrixIn[x][y][1]*splot[1][1]+
                        MatrixIn[x+1][y][1]*splot[2][1]+
                        MatrixIn[x+1][y-1][1]*splot[2][0]+
                        MatrixIn[x+1][y+1][1]*splot[2][2])/dzielnik);
               RGB[2]=(int)((
                       MatrixIn[x-1][y][2]*splot[0][1]+
                        MatrixIn[x-1][y-1][2]*splot[0][0]+
                        MatrixIn[x-1][y+1][2]*splot[0][2]+
                        MatrixIn[x][y+1][2]*splot[1][2]+
                        MatrixIn[x][y-1][2]*splot[1][0]+
                        MatrixIn[x][y][2]*splot[1][1]+
                        MatrixIn[x+1][y][2]*splot[2][1]+
                        MatrixIn[x+1][y-1][2]*splot[2][0]+
                        MatrixIn[x+1][y+1][2]*splot[2][2])/dzielnik);
            */        
               MatrixOut[x][y] = RGB;
            }
        }
        

        
        for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                
                imageOut.setIntColor(x, y, (int)MatrixOut[x][y][0], (int)MatrixOut[x][y][1], MatrixOut[x][y][2]);
            }
        }
        
    }
}