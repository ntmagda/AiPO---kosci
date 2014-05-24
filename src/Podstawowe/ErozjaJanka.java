package Podstawowe;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;


public class ErozjaJanka extends MarvinAbstractImagePlugin {

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
        int k,xx,yy;
        int [][] tab = {{0,255,255},{0,0,255},{255,255,255}};
        int [][] temp = new int [3][3];
        int [][] temmp = new int [imageIn.getWidth()][imageIn.getHeight()];
        for (int x = 0; x < imageIn.getWidth(); x++
                ) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                k = (int) imageIn.getIntComponent0(x, y);
               
                    for(int i = 0; i < 3; ++i)
                    for(int j = 0; j < 3; ++j)
                     {
                                xx = x - 1 + i;
                                yy = y - 1 + j;
                                if(xx < 0)
                                    {xx=x;}
                                if(yy < 0)
                                    {yy=y;}
                                if( xx >= imageIn.getWidth() )
                                    {xx=x;}
                                if( yy >= imageIn.getHeight() )
                                    {yy=y;}
                                temp[i][j]=(int) imageIn.getIntComponent0(xx, yy);
                     }
                    
                    for(int i = 0; i < 3; ++i)
                        for(int j = 0; j < 3; ++j)
                            {
                            if(tab[i][j] == temp[i][j]) {k = 0;break;}
                            else  k = 255;
                            }                  
                  
                  temmp[x][y] = k;
            }
          
        }
    for(int x= 0;x<imageIn.getWidth();++x)
        for(int y = 0;y<imageIn.getHeight();++y)
            imageOut.setIntColor(x,y,temmp[x][y],temmp[x][y],temmp[x][y]);
    }
    
}