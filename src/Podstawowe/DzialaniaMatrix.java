/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DzialanianaMacierzach;
import marvin.gui.MarvinAttributesPanel;
import tools.BaseFrame1;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinAttributes;
import org.jblas.DoubleMatrix;
import java.math.*;
/**
 *
 * @author magda
 */
public class DzialaniaMatrix {

   public void plus (MarvinImage imageIn,
            MarvinImage imageOut, int wartosc)
    {
        int width = imageIn.getWidth();
        int height = imageIn.getHeight();
        int r,g,b;
        DoubleMatrix Red = new DoubleMatrix(width,height);
        DoubleMatrix Green = new DoubleMatrix(width,height);
        DoubleMatrix Blue = new DoubleMatrix(width,height);
        DoubleMatrix TabWartosci = new DoubleMatrix(width,height);
        //DoubleMatrix result = new DoubleMatrix(width,height);
        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                Red.put(x,y,imageIn.getIntComponent0(x, y));
                Green.put(x,y,imageIn.getIntComponent1(x, y));
                Blue.put(x,y,imageIn.getIntComponent2(x, y));           
                TabWartosci.put(x,y,wartosc);
            }
        }
        Red = Red.add(wartosc);
        Green = Green.add(wartosc);
        Blue = Blue.add(wartosc);

        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                r = (int)Red.get(x,y);
                g = (int)Green.get(x,y);
                b = (int)Blue.get(x,y);
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
    
   
    public void minus (MarvinImage imageIn,
            MarvinImage imageOut, int wartosc)
    {
        int width = imageIn.getWidth();
        int height = imageIn.getHeight();
        int r,g,b;
        DoubleMatrix Red = new DoubleMatrix(width,height);
        DoubleMatrix Green = new DoubleMatrix(width,height);
        DoubleMatrix Blue = new DoubleMatrix(width,height);
        DoubleMatrix TabWartosci = new DoubleMatrix(width,height);
        //DoubleMatrix result = new DoubleMatrix(width,height);
        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                Red.put(x,y,imageIn.getIntComponent0(x, y));
                Green.put(x,y,imageIn.getIntComponent1(x, y));
                Blue.put(x,y,imageIn.getIntComponent2(x, y));           
                TabWartosci.put(x,y,wartosc);
            }
        }
        Red = Red.add(-wartosc);
        Green = Green.add(-wartosc);
        Blue = Blue.add(-wartosc);

        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                r = (int)Red.get(x,y);
                g = (int)Green.get(x,y);
                b = (int)Blue.get(x,y);
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
    
    public void pow (MarvinImage imageIn,
            MarvinImage imageOut, int wartosc)
    {
        int width = imageIn.getWidth();
        int height = imageIn.getHeight();
        int r,g,b;
        DoubleMatrix Red = new DoubleMatrix(width,height);
        DoubleMatrix Green = new DoubleMatrix(width,height);
        DoubleMatrix Blue = new DoubleMatrix(width,height);
        DoubleMatrix TabWartosci = new DoubleMatrix(width,height);
        //DoubleMatrix result = new DoubleMatrix(width,height);
        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                Red.put(x,y,imageIn.getIntComponent0(x, y));
                Green.put(x,y,imageIn.getIntComponent1(x, y));
                Blue.put(x,y,imageIn.getIntComponent2(x, y));           
                TabWartosci.put(x,y,wartosc);
            }
        }
        
        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                r = (int)Math.pow(Red.get(x,y),wartosc);
                g = (int)Math.pow(Green.get(x,y),wartosc);
                b = (int)Math.pow(Blue.get(x,y),wartosc);
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
    
    
    public void sqrt (MarvinImage imageIn,
            MarvinImage imageOut, int wartosc)
    {
        int width = imageIn.getWidth();
        int height = imageIn.getHeight();
        int r,g,b;
        DoubleMatrix Red = new DoubleMatrix(width,height);
        DoubleMatrix Green = new DoubleMatrix(width,height);
        DoubleMatrix Blue = new DoubleMatrix(width,height);
        DoubleMatrix TabWartosci = new DoubleMatrix(width,height);
        //DoubleMatrix result = new DoubleMatrix(width,height);
        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                Red.put(x,y,imageIn.getIntComponent0(x, y));
                Green.put(x,y,imageIn.getIntComponent1(x, y));
                Blue.put(x,y,imageIn.getIntComponent2(x, y));           
                TabWartosci.put(x,y,wartosc);
            }
        }
        
        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                r = (int)Math.pow(Red.get(x,y),(1/wartosc));
                g = (int)Math.pow(Green.get(x,y),(1/wartosc));
                b = (int)Math.pow(Blue.get(x,y),(1/wartosc));
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
    
    
        
   
    public void div (MarvinImage imageIn,
            MarvinImage imageOut, int wartosc)
    {
        int width = imageIn.getWidth();
        int height = imageIn.getHeight();
        int r,g,b;
        DoubleMatrix Red = new DoubleMatrix(width,height);
        DoubleMatrix Green = new DoubleMatrix(width,height);
        DoubleMatrix Blue = new DoubleMatrix(width,height);
        DoubleMatrix TabWartosci = new DoubleMatrix(width,height);
        //DoubleMatrix result = new DoubleMatrix(width,height);
        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                Red.put(x,y,imageIn.getIntComponent0(x, y));
                Green.put(x,y,imageIn.getIntComponent1(x, y));
                Blue.put(x,y,imageIn.getIntComponent2(x, y));           
                TabWartosci.put(x,y,wartosc);
            }
        }

        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                r = (int)Red.get(x,y)/wartosc;
                g = (int)Green.get(x,y)/wartosc;
                b = (int)Blue.get(x,y)/wartosc;
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
   
    public void multi (MarvinImage imageIn,
            MarvinImage imageOut, int wartosc)
    {
        int width = imageIn.getWidth();
        int height = imageIn.getHeight();
        int r,g,b;
        DoubleMatrix Red = new DoubleMatrix(width,height);
        DoubleMatrix Green = new DoubleMatrix(width,height);
        DoubleMatrix Blue = new DoubleMatrix(width,height);
        DoubleMatrix TabWartosci = new DoubleMatrix(width,height);
        //DoubleMatrix result = new DoubleMatrix(width,height);
        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                Red.put(x,y,imageIn.getIntComponent0(x, y));
                Green.put(x,y,imageIn.getIntComponent1(x, y));
                Blue.put(x,y,imageIn.getIntComponent2(x, y));           
                TabWartosci.put(x,y,wartosc);
            }
        }

        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                r = (int)Red.get(x,y)*wartosc;
                g = (int)Green.get(x,y)*wartosc;
                b = (int)Blue.get(x,y)*wartosc;
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
        
        
   
    public DoubleMatrix[] returnMatrix (MarvinImage imageIn)
    {
        int width = imageIn.getWidth();
        int height = imageIn.getHeight();
        int r,g,b;
        DoubleMatrix Red = new DoubleMatrix(width,height);
        DoubleMatrix Green = new DoubleMatrix(width,height);
        DoubleMatrix Blue = new DoubleMatrix(width,height);
        for (int x =0 ; x < width; x++)
        {
            for ( int y = 0; y<height; y++)
            {
                Red.put(x,y,imageIn.getIntComponent0(x, y));
                Green.put(x,y,imageIn.getIntComponent1(x, y));
                Blue.put(x,y,imageIn.getIntComponent2(x, y));           
            }
        }

        DoubleMatrix[] tablica = new DoubleMatrix[3];
        tablica[0] = Red;
        tablica[1] = Green;
        tablica[2] = Blue;
        return tablica;
    }
    
    public void DodawanieDwochZdjec(DoubleMatrix[] tablica1, DoubleMatrix[] tablica2, MarvinImage imageOut )
    {
     int r,g,b;
         for (int x =0 ; x < imageOut.getWidth(); x++)
        {
            for ( int y = 0; y<imageOut.getHeight(); y++)
            {
                
                int r1 = Math.abs((int)tablica1[0].get(x,y))&Math.abs((int)tablica2[0].get(x,y));
                int g1 = Math.abs((int)tablica1[1].get(x,y))&Math.abs((int)tablica2[1].get(x,y));
                int b1 = Math.abs((int)tablica1[2].get(x,y))&Math.abs((int)tablica2[2].get(x,y));
                
                r =Math.abs((int)tablica1[0].get(x,y))-r1;
                g =Math.abs((int)tablica1[1].get(x,y))-g1;
                b =Math.abs((int)tablica1[2].get(x,y))-b1;
                
                
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }
    
    
    
    public void OdejmowanieDwochZdjec(DoubleMatrix[] tablica1, DoubleMatrix[] tablica2, MarvinImage imageOut )
    {
     int r,g,b;
         for (int x =0 ; x < imageOut.getWidth(); x++)
        {
            for ( int y = 0; y<imageOut.getHeight(); y++)
            {
                r = Math.abs((int)tablica1[0].get(x,y))-Math.abs((int)tablica2[0].get(x,y));
                g = Math.abs((int)tablica1[1].get(x,y))-Math.abs((int)tablica2[1].get(x,y));
                b = Math.abs((int)tablica1[2].get(x,y))-Math.abs((int)tablica2[2].get(x,y));
                imageOut.setIntColor(x, y, r, g, b);
            }
        }
    }

    
}

