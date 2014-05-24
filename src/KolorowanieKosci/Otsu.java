package KolorowanieKosci;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;


public class Otsu extends MarvinAbstractImagePlugin {

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
        
        
      //  int H[] = new int[257];
        int[] H = new int [256];
        for(int x = 0; x < imageIn.getWidth();++x)
            for(int y = 0; y < imageIn.getHeight(); ++y)
                    {
                        H[imageIn.getIntComponent0(x,y)]++;
                    }
        int LP = imageIn.getWidth()*imageIn.getHeight();
        int SU[] = new int [255];
        for ( int i = 0; i < 255; i++)
        {
            SU[i] = H[i]*i;
        }
        int W=0;
        int MAX=0;
        int SUP=0;
        double R;
        int T1=0;
        int T2=0;
        for ( int i =0; i <255; i++)
        {
            W = W+H[i];
            if(W==0) continue;
            int WP = LP-W;               
            if(WP==0) break;
                    SUP = i*H[i];
                    int SG = SUP/W;
                    int SD = (SU[i]-SUP)/WP;
                    R = Math.pow(W*WP*(SG-SD),2);
                
                if(R>=MAX)
                {
                    T1 = i;
                }
                if(R>MAX)
                {
                    T2 = i;
                    MAX=(int)R;
                }
            }
            
            int prog = (int)((T1+T2)/2.5);
         
            for (int x = 0; x < imageIn.getWidth(); x++)
            {
                for (int y = 0; y < imageIn.getHeight(); y++) {
                    int k = (int) imageIn.getIntComponent0(x, y);
                    if(k > prog) k = 255;
                    else k = 0;
                    imageOut.setIntColor(x, y, k, k, k);
                    }
            }
      }
    }