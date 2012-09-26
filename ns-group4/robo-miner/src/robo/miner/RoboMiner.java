package robo.miner;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RoboMiner {
    
    public static void main(String[] args) {
        Board b = new Board();
        b.createFromFile("files/example1.map");
        System.out.println(b.drawMap());
        
        //2 iteração
        while(true) {
            try {
                Thread.sleep(1000);
                //input
                b.update(); //input here later on
                System.out.println(b.drawMap());
            } catch (InterruptedException ex) {
                Logger.getLogger(RoboMiner.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}
