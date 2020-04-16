
package circles;

import com.sun.prism.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;


public class Circles extends JFrame{

     private BufferedImage buffer;   
    
    public Circles() {
        super("DFGG 17310120");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(2000, 10, 600, 600);
        this.setVisible(true); 
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }
    
    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);        
    }
    
    @Override
    public void paint(java.awt.Graphics g){
        //Punto medio
        puntitcoMedioAJUA(250, 250, 25);
        putPixel(50, 50, Color.RED);
        //Bresenham
       int xc = 50, yc = 70, r2 = 30;              
       circleBres(xc, yc, 20);
       //ELIPSE ESTOY MAMADISIMO 

       elipseMamadisimo(50, 150, 400, 280); 
        
    }
    //Elipse mamadisimo
    public void elipseMamadisimo(float rx, float ry,float xc, float yc){
    float dx, dy, d1, d2, x, y; 
    x = 0; 
    y = ry;
    d1 = (ry * ry) - (rx * rx * ry) + 
                    (0.25f * rx * rx); 
    dx = 2 * ry * ry * x; 
    dy = 2 * rx * rx * y; 
    DecimalFormat df = new DecimalFormat("#,###,##0.00000"); 

    while (dx < dy) 
    { 
        float uno = Float.valueOf(df.format(x + xc));
        int value = (int) uno;
        float dos = Float.valueOf(df.format(y+yc));
        int valueDos = (int) dos; 
        float tres = Float.valueOf(df.format(-x+xc));
        int valueT = (int) tres; 
        float cuatro = Float.valueOf(df.format(-y+yc));
        int valueC = (int) cuatro;         
        putPixel(value, valueDos , Color.RED); 
        putPixel(valueT, valueDos, Color.RED); 
        putPixel(value, valueC, Color.RED); 
        putPixel(valueT,valueC, Color.RED); 
  
    
        if (d1 < 0)  
        { 
            x++; 
            dx = dx + (2 * ry * ry); 
            d1 = d1 + dx + (ry * ry); 
        } 
        else
        { 
            x++; 
            y--; 
            dx = dx + (2 * ry * ry); 
            dy = dy - (2 * rx * rx); 
            d1 = d1 + dx - dy + (ry * ry); 
        } 
    } 
    d2 = ((ry * ry) * ((x + 0.5f) * (x + 0.5f))) 
        + ((rx * rx) * ((y - 1) * (y - 1))) 
        - (rx * rx * ry * ry); 

    while (y >= 0) {   
        float uno = Float.valueOf(df.format(x + xc));
        int value = (int) uno;
        float dos = Float.valueOf(df.format(y+yc));
        int valueDos = (int) dos; 
        float tres = Float.valueOf(df.format(-x+xc));
        int valueT = (int) tres; 
        float cuatro = Float.valueOf(df.format(-y+yc));
        int valueC = (int) cuatro; 
        putPixel(value, valueDos , Color.RED); 
        putPixel(valueT, valueDos, Color.RED); 
        putPixel(value, valueC, Color.RED); 
        putPixel(valueT,valueC, Color.RED); 
  
        if (d2 > 0) { 
            y--; 
            dy = dy - (2 * rx * rx); 
            d2 = d2 + (rx * rx) - dy; 
        } 
        else { 
            y--; 
            x++; 
            dx = dx + (2 * ry * ry); 
            dy = dy - (2 * rx * rx); 
            d2 = d2 + dx - dy + (rx * rx); 
        } 
    } 
}             
    // Punto medio
     public void puntitcoMedioAJUA(int equisCentral,int yeCentral, int r){
         equisCentral = 250;
         yeCentral = 210;          
        int x = r, y = 0; 
        putPixel(x + equisCentral,y + yeCentral,Color.RED); 
        if (r > 0) {               
            putPixel(x + equisCentral,-y + yeCentral,Color.RED);                   
            putPixel(y + equisCentral,x + yeCentral,Color.RED);                    
            putPixel(-y + equisCentral,x + yeCentral,Color.RED); 
        } 
        int P = 1 - r; 
        while (x > y) { 
              
            y++; 

            if (P <= 0) 
                P = P + 2 * y + 1; 

            else { 
                x--; 
                P = P + 2 * y - 2 * x + 1; 
            } 

            if (x < y) 
                break; 

            putPixel(x + equisCentral,y + yeCentral,Color.RED); 
                      
            putPixel(-x + equisCentral,y + yeCentral,Color.RED); 
                      
            putPixel(x + equisCentral,-y + yeCentral,Color.RED); 
                      
            putPixel(-x + equisCentral,-y + yeCentral,Color.RED); 
                     
            if (x != y) { 
                  
                putPixel(y + equisCentral,x + yeCentral,Color.RED); 
                        
                putPixel(-y + equisCentral,x + yeCentral,Color.RED); 
                        
                putPixel(y + equisCentral,-x + yeCentral, Color.RED); 
                        
                putPixel(-y + equisCentral,-x + yeCentral, Color.RED); 
            } 
        } 
    } 
            
    public void drawCircle(int xc, int yc, int x, int y, Color c){ 
    putPixel(xc+x, yc+y, Color.RED); 
    putPixel(xc-x, yc+y, Color.RED); 
    putPixel(xc+x, yc-y, Color.RED); 
    putPixel(xc-x, yc-y, Color.RED); 
    putPixel(xc+y, yc+x, Color.RED); 
    putPixel(xc-y, yc+x, Color.RED); 
    putPixel(xc+y, yc-x, Color.RED); 
    putPixel(xc-y, yc-x, Color.RED); 
} 
    void circleBres(int xc, int yc, int r) 
{ 
    int x = 0, y = r; 
    int d = 3 - 2 * r; 
    drawCircle(xc, yc, x, y, Color.RED); 
    while (y >= x) 
    { 

        x++; 
  

        if (d > 0) 
        { 
            y--;  
            d = d + 4 * (x - y) + 10; 
        } 
        else
            d = d + 4 * x + 6; 
        drawCircle(xc, yc, x, y, Color.RED);         

    } 
} 

    public static void main(String[] args) {
        Circles c = new Circles();
    }
    
}
