/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.image.BufferedImage;

/**
 *
 * @author magda
 */
public class ImageProcessing {
        
    BufferedImage image;
    int arrIntColor[];
    int width;
    int height;
    
    ImageProcessing(BufferedImage image)
    {
        
        arrIntColor = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
        width = image.getWidth();
        height = image.getHeight();
    }
   
        public int getAlphaComponent(int x, int y){
		return (arrIntColor[((y*width+x))]& 0xFF000000) >>> 24;
	}
	
	
	public int getIntComponent0(int x, int y){
		return (arrIntColor[((y*width+x))]& 0x00FF0000) >>> 16;
	}

	public int getIntComponent1(int x, int y){
		return (arrIntColor[((y*width+x))]& 0x0000FF00) >>> 8;
	}
	
	public int getIntComponent2(int x, int y){
		return (arrIntColor[((y*width+x))] & 0x000000FF);
	}

	public int getWidth(){
		return(image.getWidth());  	
	}

	
	public int getHeight(){
		return(image.getHeight());  
	}
    
}
