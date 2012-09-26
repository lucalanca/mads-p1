/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robo.miner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pontes
 */
public class Board {
    int n;
    int m;
    int numdiamantes;
    int step;
    
    void createFromFile(String filename){
        try {
            Scanner scanner =  new Scanner(new File(filename));
            while (scanner.hasNextLine()){
              //process each line in some way
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
