package KolorowanieKosci;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
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
 * 
 * 
 * 
 */


public class Kolorowanie extends MarvinAbstractImagePlugin {   
    
    static int licznikkosci = 0;
    static boolean repeatRed[] = new boolean[255];
    static boolean repeatGreen[] = new boolean[255];
    static boolean repeatBlue[] = new boolean[255];
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

    
    class Point
    {
        private int x;
        private int y; 
        Point(int x,int y)
        {
          this.x = x;
          this.y = y;
                  
        }
        Point()
        {
            x = 0; 
            y = 0;
        }
    
    }
    
    class Color
    {
       int R;
       int G;
       int B;
       
       Color()
       {
           R = 0 ;
           G = 0; 
           B =0 ;
       }
       Color(int r, int b, int g)
       {
           R = r;
           G = g;
           B = b;
       }
       
       int [] getRGB()
       {
           int tablica[] = new int[3];
           tablica[0]=R;
           tablica[1] =G;
           tablica[2]=B;
           return tablica;
       }
       
       
    }
    
    
    
    
    public void floodFill(MarvinImage image, Point node, Color targetColor, Color replacementColor) {
    int width = image.getWidth();
    int height = image.getHeight();
    int[] target = targetColor.getRGB();
    int[] replacement = replacementColor.getRGB();
    if (target != replacement) {
      Deque<Point> queue = new LinkedList<Point>();
      do {
        int x = node.x;
        int y = node.y;
        while (x > 5 && image.getIntComponent0(x - 1, y) == target[0]
                     &&image.getIntComponent1(x - 1, y) == target[1]
                     && image.getIntComponent2(x - 1, y) == target[2]) {
          x--;
        }
        boolean spanUp = false;
        boolean spanDown = false;
        while (x < width-5 && image.getIntComponent0(x, y) == target[0]
                           &&image.getIntComponent1(x , y) == target[1]
                           && image.getIntComponent2(x, y) == target[2]) {
          image.setIntColor(x, y, replacement[0],replacement[1],replacement[2]);
          if (!spanUp && y > 5 && image.getIntComponent0(x, y - 1) == target[0]
                               &&image.getIntComponent1(x, y-1) == target[1]
                               &&image.getIntComponent2(x , y-1) == target[2])
                  
                   {
            queue.add(new Point(x, y - 1));
            spanUp = true;
          } else if (spanUp && y > 5 && image.getIntComponent0(x, y - 1) != target[0]
                                     && image.getIntComponent1(x, y-1)!= target[1]
                                     && image.getIntComponent2(x, y-1) != target[2]) {
            spanUp = false;
          }
          if (!spanDown && y < height - 5 && image.getIntComponent0(x, y + 1) == target[0]
                                          &&image.getIntComponent1(x , y+1) == target[1]
                                          && image.getIntComponent2(x, y+1) == target[2]){
            queue.add(new Point(x, y + 1));
            spanDown = true;
          } else if (spanDown && y < height - 5 && image.getIntComponent0(x, y + 1) != target[0]
                                                &&image.getIntComponent1(x , y+1) != target[1]
                                                && image.getIntComponent2(x, y+1) != target[2]){
            spanDown = false;
          }
          x++;
        }
      } while ((node = queue.pollFirst()) != null);
    }
  }
    
    
    
    Color RandomColor()
    {
        
          Random rand = new Random();
          int losuj;
          losuj = rand.nextInt(8);
          Color wynik = new Color();
                    switch(losuj)
                        {
                            case 0:
                                wynik.R = 255;
                                wynik.G =0;
                                wynik.B =0;
                                break;
                            case 1:
                                wynik.R = 0;
                                wynik.G =255;
                                wynik.B =0;
                                break;
                            case 3:
                                wynik.R = 0;
                                wynik.G =0;
                                wynik.B =255;
                                break;
                            case 4:
                                wynik.R = 255;
                                wynik.G =255;
                                wynik.B =0;
                                break;
                            case 5:
                                wynik.R = 204;
                                wynik.G =0;
                                wynik.B =204;
                                break;
                            case 6:
                                wynik.R = 255;
                                wynik.G =20;
                                wynik.B =147;
                                break;
                            case 7:
                                wynik.R = 0;
                                wynik.G =255;
                                wynik.B =255;
                                break;
                            case 8:
                                wynik.R = 255;
                                wynik.G =215;
                                wynik.B =0;
                                break;
                            case 2:
                                wynik.R = 252;
                                wynik.G =23;
                                wynik.B =90;
                                break;
                        }
                    if(licznikkosci==0)
                    {
                        Color bialy = new Color(255,255,255);
                        licznikkosci++;
                        return bialy;
                        
                    }
                    else{
                    licznikkosci++;
                    return wynik;
                    }
    }
    
void Random1Color(Color wynik)
    {
        
        
          Random randR = new Random();
          Random randG = new Random();
          Random randB = new Random();
          int r = randR.nextInt(255);
          int g = randG.nextInt(255);
          int b = randB.nextInt(255);
          //Color wynik = new Color();
          if(repeatRed[r]||
                  repeatGreen[g]||
                  repeatBlue[b])
          {
              Random1Color(wynik);
          }
          else{
                    wynik.R = r;
                    repeatRed[r]=true;
                    wynik.G =g;
                    repeatGreen[g]=true;
                    wynik.B =b;
                    repeatBlue[b]=true;
                    
                   if(licznikkosci==0)
                    {
                        licznikkosci++;
                        wynik.R=255;
                        wynik.G=255;
                        wynik.B=255;
                        
                    }
                      licznikkosci++;
                }
                    
          }     
    
    
    @Override
    public void process(
            MarvinImage imageIn,
            MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
        
        Color czarny = new Color(0,0,0);
             for ( int y = 6 ; y < imageIn.getHeight()-6;y++){
                 for ( int x = 6 ; x < imageIn.getWidth()-6; x++)
                {
                  
                  if(imageIn.getIntComponent0(x, y)==0 && imageIn.getIntComponent0(x-1, y)==255)
                  {
                      Color rand = new Color();
                     
                      
                       Random1Color(rand);
                   
                        floodFill(imageIn, new Point(x,y),czarny,rand);
                      
                  }
                  }
                      
                  }  
                 }

    
                    
            }
           
           
           
           
  
       