/**
 * Marvin Project <2007-2009>
 *
Initial version by:
 *
 * Danilo Rosetto Munoz Fabio Andrijauskas Gabriel Ambrosio Archanjo
 *
 * site: http://marvinproject.sourceforge.net
 *
 * GPL Copyright (C) <2007>  *
This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package Histogramy;

import marvin.image.MarvinImage;

/**
 * Color histogram is a representation of the RGB colors distribution.
 *
 * @author Gabriel Ambrsio Archanjo
 * @version 1.0 02/13/2008
 */
public class SredniaMaxMin {
        public int sredniaRed;
        public int sredniaBlue;
        public int sredniaGreen;
        public int minimumRed;
        public int minimumGreen;
        public int minimumBlue;
        public int maximumRed;
        public int maximumGreen;
        public int maximumBlue;
        public int l_arrRed[] = new int[256];
        public int l_arrGreen[] = new int[256];
        public int l_arrBlue[] = new int[256];
        
    public void process(
            MarvinImage a_imageIn) {
        for (int x = 0; x < a_imageIn.getWidth(); x++) {
            for (int y = 0; y < a_imageIn.getHeight(); y++) {
                l_arrRed[a_imageIn.getIntComponent0(x, y)]++; // zlicza piksele w jednym kolorze
                l_arrGreen[a_imageIn.getIntComponent1(x, y)]++;
                l_arrBlue[a_imageIn.getIntComponent2(x, y)]++;
            change();
            }
        }
 }
        
    int srednia(int[] tablica)
    {
        int srednia=0;
        int wszystkiePix=0;
        for(int x =0; x <256; x++)
        {
            srednia+=tablica[x]*x;
            wszystkiePix += tablica[x];
            
        }
        srednia = srednia/wszystkiePix;
        return srednia;
    }
       
    int minimum(int[] tablica)
    {
        //Wyliczanie minimum koloru
        int minimum=0;
        for( int x=0;x<256;x++)
        {
            if(tablica[x]!=0)
                minimum=x;
            if(minimum!=0) break;
        }
        
        return minimum;
    }
        
       
    int maximum(int[] tablica)
    {
        int maximum=0;
        for( int x=0;x<256;x++)
        {
            if(tablica[255-x]!=0)
                maximum=255-x;
            if(maximum!=0) break;
        }
        return maximum;
    }


    void change(){
    sredniaRed = srednia(l_arrRed);
    sredniaBlue = srednia(l_arrBlue);
    sredniaGreen = srednia(l_arrGreen);
    minimumRed = minimum(l_arrRed);
    minimumGreen = minimum(l_arrGreen);
    minimumBlue = minimum(l_arrBlue);
    maximumRed = maximum(l_arrRed);
    maximumGreen = maximum(l_arrGreen);
    maximumBlue = maximum(l_arrBlue);    
    }
    
}