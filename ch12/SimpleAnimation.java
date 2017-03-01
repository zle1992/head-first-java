import java.awt.*;
import javax.swing.*;
public class SimpleAnimation {
    int x = 70;
    int y = 70;
    
    public static void main(String [] args){
        SimpleAnimation  gui = new SimpleAnimation();
        gui.go();
    }
    public void go(){
        JFrame frame = new JFrame();
        frame
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(20,50,100,100);
    }
}
