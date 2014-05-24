/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Podstawowe;

/**
 *
 * @author magda
 */

import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class Mask extends MarvinImageMask {

    
    public Mask(MarvinImage imageIn){
        
        arrMask = new boolean[imageIn.getWidth()][imageIn.getHeight()]; 
        int prog = 150;
        for (int x = 0; x < imageIn.getWidth(); x++)
        {
            for(int y = 0; y < imageIn.getHeight(); y++) 
            {
                if((imageIn.getIntComponent0(x, y))>prog || (imageIn.getIntComponent1(x, y))>prog ||(imageIn.getIntComponent2(x, y))>prog) 
                {
                            arrMask[x][y] = false;
                }else
                { 
                            arrMask[x][y] = true;
                        
                }
            }
       } 
        
    }
}
