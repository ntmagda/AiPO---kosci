package KolorowanieKosci;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;


public class CountColors extends MarvinAbstractImagePlugin {

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
            final MarvinImage imageIn,
            final MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
        CopyOnWriteArrayList<Pair> used = new CopyOnWriteArrayList<>();
        ListIterator it = used.listIterator();
        for(int i =0;i<imageIn.getWidth();++i){
            for(int j=0;j<imageIn.getHeight();++j){
                int r = imageIn.getIntComponent0(i, j);
                int g = imageIn.getIntComponent1(i, j);
                int b = imageIn.getIntComponent2(i, j);
                Pair check = new Pair(new Color(r,g,b));
                Pair tmp;
                if(used.contains(check)){
                    while(it.hasNext()){
                        tmp =(Pair) it.next();
                        if(check.equals(tmp)){
                            
                            Pair p =tmp;
                            p.plus();
                        }
                    }
                    it = used.listIterator();
                }else{
                    used.add(check);
                }
                
                
            }
        }
        
        int colorCounter = 0;
        it = used.listIterator();
      
        while(it.hasNext()){
            Pair p = (Pair)it.next();
            if(p.getNumber()>50)
                ++colorCounter;
        }    
        
            
        System.out.print("Liczba Kosci wynosi ");
        System.out.println(colorCounter-1);
    }
}

class Pair{
    Pair(){ counter = 0; }
    Pair(Color a){ c = a; counter=1; }
    
    private Color c;
    private int counter;
    
    public Color getColor(){ return c; }
    public int getNumber(){ return counter; }
    public void setColor(Color a){ c = a; counter = 1; }
    public void plus(){ ++counter; }
    
    @Override
    public boolean equals(Object obj){
        Pair rhs = (Pair)obj;
        return c.equals(rhs.getColor());
    }
    
}
    
    