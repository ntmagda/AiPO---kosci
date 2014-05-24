package Podstawowe;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;

public class MultiThresholding extends MarvinAbstractImagePlugin {

    private Integer[] threshold = new Integer[4];

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
            boolean previewMode
    ) {
        threshold = (Integer[]) getAttribute("threshold");
        for (int y = 0; y < imageIn.getHeight(); y++) {
            for (int x = 0; x < imageIn.getWidth(); x++) {

                if (imageIn.getIntComponent0(x, y) < threshold[0]) {
                    imageOut.setIntColor(x, y, imageIn.getAlphaComponent(x, y), 0, 0, 0);
                } 
                else if(imageIn.getIntComponent0(x, y) < threshold[1]) {
                    imageOut.setIntColor(x, y, imageIn.getAlphaComponent(x, y), 255, 255, 255);
                }
                else if(imageIn.getIntComponent0(x, y) < threshold[2]){
                    imageOut.setIntColor(x, y, imageIn.getAlphaComponent(x, y), 255, 0, 0);
                }
                else if(imageIn.getIntComponent0(x, y) < threshold[3]){
                    imageOut.setIntColor(x, y, imageIn.getAlphaComponent(x, y), 0, 255, 0);
                }
                else if(imageIn.getIntComponent0(x, y) < threshold[4]){
                    imageOut.setIntColor(x, y, imageIn.getAlphaComponent(x, y), 0, 0, 255);
                }
            }
        }
    }
}