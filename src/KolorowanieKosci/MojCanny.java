/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KolorowanieKosci;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import org.jblas.DoubleMatrix;



class Grad{
    double kier;
    double wart;
    
    Grad(double kier, double wart)
    {
        this.kier = kier;
        this.wart = wart;
    }
    
    Grad()
    {
        kier = 0 ;
        wart = 0;
    }
}


public class MojCanny extends MarvinAbstractImagePlugin {
    @Override
    public void load() {
    }

    @Override
    public MarvinAttributesPanel getAttributesPanel() {
        return null;
    }
    
      private void edgeTracking(MarvinImage imageIn){
        MarvinImage imageTmp = imageIn.clone();
        for(int x=2; x<imageIn.getWidth()-2; ++x){
            for(int y=2; y<imageIn.getHeight()-2; ++y){
                boolean pixelBlack = true; // should pixel be black ?
                if(imageTmp.getIntComponent0(x,y)!= 255 && imageTmp.getIntComponent0(x,y)!= 0){
                    boolean flag = true;
                    
                    check3:
                    for(int i = x-1,l=0;l<3;++l){
                        for(int j = y-1,k=0 ; k<3 ; ++k){
                            int check = imageTmp.getIntComponent0(i+l,j+k);
                            if(check==255){
                                imageIn.setIntColor(x,y,255,255,255);
                                flag = false;
                                pixelBlack = false;
                                break check3;
                            } 
                        }
                       
                    }
                    
                    if(flag){
                        check5:
                        for(int ii=x-2,ll=0;ll<5;++ll){

                            for(int jj=y-2,kk=0;kk<5;++kk){
                                if(imageTmp.getIntComponent0(ii+ll, jj+kk)==255){
                                    imageIn.setIntColor(x,y,255,255,255);
                                    pixelBlack = false;
                                    break check5;
                                }
                            }
                        }
                    }
                    
                }else{
                    pixelBlack = false;
                }
                if(pixelBlack){
                    imageIn.setIntColor(x,y,0,0,0);
                    
                }
            }
        }
    }
    
    
    public void Sobel(MarvinImage imageIn, MarvinImage imageOut, Grad[][] tablica)
    {
       MarvinImage image = imageIn.clone();
       
         
       // DoubleMatrix tablica = new DoubleMatrix(imageIn.getWidth(),imageIn.getHeight());
        for (int x = 3; x < imageIn.getWidth()-3; x++) {
            for (int y = 3; y < imageIn.getHeight()-3; y++) {
                
                int p0=image.getIntComponent0(x-1, y-1);
                int p1=image.getIntComponent0(x, y-1);
                int p2=image.getIntComponent0(x+1, y-1);
                int p3=image.getIntComponent0(x+1, y);
                int p4=image.getIntComponent0(x+1, y+1);
                int p5=image.getIntComponent0(x, y+1);
                int p6=image.getIntComponent0(x-1, y+1);
                int p7=image.getIntComponent0(x-1, y);
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


    
     void Gradienty(Grad[][] tablica, MarvinImage imageIn, MarvinImage imageOut)
    {
        for (int x = 3; x < imageIn.getWidth()-3; x++) {
            for (int y = 3; y < imageIn.getHeight()-3; y++) {
              double a = (Math.PI)/8;
             if(tablica[x][y].wart>20){
                
                // kolor żółty dla pikseli o kierunku [0,22.5] i dla pikseli od [157.5,180]
                if((tablica[x][y].kier>=-8*a && tablica[x][y].kier<-7*a )||(tablica[x][y].kier>=-a && tablica[x][y].kier<a ||(tablica[x][y].kier>7*a && tablica[x][y].kier<=8*a )))
                {
                   //imageOut.setIntColor(x,y,255, 255, 0);
                   tablica[x][y].kier=0;
                }
                else if((tablica[x][y].kier>=-7*a && tablica[x][y].kier<-5*a )|| (tablica[x][y].kier>=a && tablica[x][y].kier<3*a))
                {
                  // imageOut.setIntColor(x,y,0, 255, 0);
                   tablica[x][y].kier=45;
                }
                else if((tablica[x][y].kier>=-5*a && tablica[x][y].kier<-3*a )||(tablica[x][y].kier>=3*a && tablica[x][y].kier<5*a))
                {
                  //  imageOut.setIntColor(x,y,0, 0, 255);
                   tablica[x][y].kier=90;
                }
                else if((tablica[x][y].kier>=-3*a && tablica[x][y].kier<-a )||(tablica[x][y].kier>=5*a && tablica[x][y].kier<7*a))
                {
                 //   imageOut.setIntColor(x,y,255, 0, 0);
                    tablica[x][y].kier=135;
                }
              }

            }
        }
    }
    
     void kasowanie(MarvinImage imageIn, MarvinImage imageOut, Grad[][] tablica, DoubleMatrix kasowanie)
    {
       //     
       for (int x = 3; x < imageIn.getWidth()-3; x++) {
            for (int y = 3; y < imageIn.getHeight()-3; y++) {
                 
                //kolor zołty 0 stopni
                if(tablica[x][y].kier==0)
                {
                    if(tablica[x][y].wart!=Math.max(tablica[x][y].wart,( Math.max(tablica[x-1][y].wart,tablica[x+1][y].wart))))
                    {
                        kasowanie.put(x,y,1);
                    }
                    else
                    {
                        kasowanie.put(x,y,0);
                    }        
                }
                // kolor zielony 45 stopni
                if(tablica[x][y].kier==135)
                {
                  if(tablica[x][y].wart!=Math.max(tablica[x][y].wart,(Math.max(tablica[x+1][y-1].wart, tablica[x-1][y+1].wart))))
                    {
                        kasowanie.put(x,y,1);
                    }
                    else
                    {
                        kasowanie.put(x,y,0);
                    }        
                }
                
                // kolor niebieski 90 stopni
                if(tablica[x][y].kier==90)
                {
                    if(tablica[x][y].wart!=Math.max(tablica[x][y].wart,(Math.max(tablica[x][y-1].wart,tablica[x][y+1].wart))))
                    {
                        kasowanie.put(x,y,1);
                    }
                    
                    else
                    {
                        kasowanie.put(x,y,0);
                    }        
                }
                
                if(tablica[x][y].kier==45)
                {
                    if(tablica[x][y].wart!=Math.max(tablica[x][y].wart,(Math.max(tablica[x-1][y-1].wart,tablica[x+1][y+1].wart))))
                    {
                        kasowanie.put(x,y,1);
                    }
                    else
                    {
                        kasowanie.put(x,y,0);
                    }        
                }
            }
        }
    }
     
     
     
     public void EdgeTracking(MarvinImage imageIn, MarvinImage imageOut)
     {      for (int x = 2; x < imageIn.getWidth()-2; x++) {
            for (int y = 2; y < imageIn.getHeight()-2; y++) {
                
                    if(imageIn.getIntComponent0(x, y)!=0 && // rozne niz czarny
                       imageIn.getIntComponent0(x, y)!=255) // rozne niz bialy
                    {
                        
                        check1:
                        for( int i = x-1, k = 0; k <3;k++,i++)
                        {
                            for ( int j = y-1,l=0; l <3; l++,j++)
                            {
                            
                                if(imageIn.getIntComponent0(i, j)==255)
                                {
                                    imageOut.setIntColor(x, y, 255,255,255);
                                    break check1;
                                }
                                                                
                                else
                                {
                                    for( int ii = x-2,m=0; m <5;m++,ii++)
                                     {
                                        for ( int jj = y-2,n=0; n <5; n++,jj++)
                                        {
                                            if(imageIn.getIntComponent0(i, j)==255)// czy znajdzie bialy?
                                                
                                                 {
                                                    imageOut.setIntColor(x, y, 255,255,255);
                                                    break check1;
                                                 }
                                                 else
                                            {
                                                imageOut.setIntColor(x,y,0,0,0);
                                            }
                                         }
                                    
                                    
                                      }
                                }
                         }
                  }
             }
        }
     }

     
}
     
    @Override
    public void process(
            MarvinImage imageIn,
            MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
    
    Grad[][] tablica = new Grad[imageIn.getWidth()][imageIn.getHeight()]; 
    for ( int i = 0 ; i < imageIn.getWidth(); i++)
        for ( int j = 0; j < imageIn.getHeight();j++)
        {
            tablica[i][j]= new Grad();
        }
    
    Sobel(imageIn,imageOut, tablica);
    Gradienty(tablica, imageIn,imageOut);
    DoubleMatrix kasowanie = new DoubleMatrix(imageIn.getWidth(), imageIn.getHeight());
    kasowanie(imageIn,imageOut,tablica, kasowanie);
    
      
        for (int x = 2; x < imageIn.getWidth()-2; x++) {
            for (int y = 2; y < imageIn.getHeight()-2; y++) {
                if(!(kasowanie.get(x,y)==0))
                {
                    imageOut.setIntColor(x,y,0,0,0);
                }
                else
                {
                    if(tablica[x][y].wart<20)
                    {
                        imageOut.setIntColor(x,y,0,0,0);
                    }
                    else if(tablica[x][y].wart>45)
                    {
                        imageOut.setIntColor(x, y,255,255,255);
                    }
                    
                }
            }
        }
                 EdgeTracking(imageIn,imageOut);
                 
    }
}