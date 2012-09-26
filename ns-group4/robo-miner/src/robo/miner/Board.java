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
            Entity entities[][] = new Entity[n][m];

            Scanner scanner = new Scanner(myfile);
            int currentM = 0;

            while (sizescan.hasNextLine()) {
                String line = sizescan.nextLine();

                for (int i = 0; i < line.length(); i++) {
                    switch (line.charAt(i)) {
                        case 'R':
                            entities[i][currentM] = new Robot();
                            break;

                        case '*':
                            entities[i][currentM] = new Rock();
                            break;

                        case 'L':
                            entities[i][currentM] = new Lift();
                            break;

                        case 'O':
                            entities[i][currentM] = new Lift(); ///TODO
                            break;

                        case '.':
                            entities[i][currentM] = new Earth();
                            break;

                        case '#':
                            entities[i][currentM] = new Wall();
                            break;

                        case 'x':
                            entities[i][currentM] = new Diamond();
                            break;

                        default:
                            entities[i][currentM] = new Empty();
                            break;
                    }
                    currentM++;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
