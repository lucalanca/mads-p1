package robo.miner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import robo.miner.entities.Diamond;
import robo.miner.entities.Earth;
import robo.miner.entities.Empty;
import robo.miner.entities.Entity;
import robo.miner.entities.Lift;
import robo.miner.entities.Robot;
import robo.miner.entities.Rock;
import robo.miner.entities.Wall;


public class Board {

    int n = 0;
    int m = 0;
    int numdiamantes;
    int step;
    int liftX;
    int liftY;
    Entity entities[][];

    void createFromFile(String filename) {
        try {
            File myfile = new File(filename);
            Scanner sizescan = new Scanner(myfile);
            while (sizescan.hasNextLine()) {
                String line = sizescan.nextLine();
                m++;
                if (n == 0) {
                    n = line.length();
                }
            }
            entities = new Entity[n][m];

            myfile = new File(filename);
            Scanner scanner = new Scanner(myfile);
            int currentM = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                for (int i = 0; i < line.length(); i++) {
                    switch (line.charAt(i)) {
                        case 'R':
                            entities[i][currentM] = new Robot(this, i, currentM);
                            break;

                        case '*':
                            entities[i][currentM] = new Rock(this, i, currentM);
                            break;

                        case 'L':
                            liftX = i;
                            liftY = currentM;
                            entities[i][currentM] = new Lift(this, i, currentM);
                            break;

                        case 'O':
                            entities[i][currentM] = new Lift(this, i, currentM, true); ///TODO
                            break;

                        case '.':
                            entities[i][currentM] = new Earth(this, i, currentM);
                            break;

                        case '#':
                            entities[i][currentM] = new Wall(this, i, currentM);
                            break;

                        case 'x':
                            entities[i][currentM] = new Diamond(this, i, currentM);
                            break;

                        default:
                            entities[i][currentM] = new Empty(this, i, currentM);
                            break;
                    }
                    
                }
                currentM++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String drawMap(){
        String out = "";
        for(int rows = 0; rows < m; rows++){
            for(int cols = 0; cols <n; cols++){
                out += entities[cols][rows];
            }
            out += "\n";
        }
        return out;
    }
    
    public Entity getEntity(int x, int y){
        return entities[x][y];
    }

    public void updateEntities(Entity rock, Entity temp) {
        this.entities[rock.x][rock.y]= rock;
        this.entities[temp.x][temp.y]= temp;
    }
    
    void update(char input) {
        for(int rows = m-1; rows >= 0; rows--){
            for(int cols = 0; cols < n; cols++){
                if(entities[cols][rows] instanceof Robot) {
                    //ijentities[cols][rows].update(input);
                }
                else {
                    entities[cols][rows].update();
                }
            }
        }
    }

    public void diamondFound() {
        this.numdiamantes--;
        
        if(this.numdiamantes == 0) {
            entities[liftX][liftY] = new Lift(this, liftX, liftY, true);
        }
    }
}
