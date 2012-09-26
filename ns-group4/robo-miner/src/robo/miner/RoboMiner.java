package robo.miner;

public class RoboMiner {
    
    public static void main(String[] args) {
        Board b = new Board();
        b.createFromFile("files/example1.map");
        b.drawMap();
        
        //2 iteração
        while(true) {
            //wait 1s... if input read break
            //updateboard(input)
            //drawboard
            
        }
        
    }
}
