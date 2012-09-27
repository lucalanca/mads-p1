package robo.miner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

    Board actualState = new Board();
    ArrayList<Board> pastStates = new ArrayList<Board>();
    ArrayList<Board> futureStates = new ArrayList<Board>();
    static char input = 'W';
    static boolean undo = false;
    static boolean redo = false;

    public static void main(String[] args) {
        Game game = new Game();
        Thread t = new Thread(game);
        t.start();
        Scanner scanner = new Scanner(System.in);
        String inputString;
        while (true) {
            if (scanner.hasNext()) {
                inputString = scanner.next().toUpperCase();
                if(inputString.equals("UNDO")){
                    undo = true;
                } else if(inputString.equals("REDO")){
                    undo = true;
                } else {
                    input = inputString.charAt(0);
                }
            } else {
                input = 'W';
            }
        }
    }

    @Override
    public void run() {
        actualState.createFromFile("files/example10.map");
        System.out.println(actualState.drawMap());


        while (true) {
            try {
                Thread.sleep(3000);
                if (undo && !redo) {
                    System.out.println("In undo");
                    if (!pastStates.isEmpty()) {
                        futureStates.add(new Board(actualState));
                        actualState = pastStates.remove(pastStates.size() - 1);
                    }
                } else if (redo && !undo) {
                    System.out.println("In redo");
                    if (!futureStates.isEmpty()) {
                        pastStates.add(new Board(actualState));
                        actualState = futureStates.remove(0);
                    }
                } else {
                    if (input == 'U' || input == 'D' || input == 'L' || input == 'R') {
                        System.out.println("clearing future states");
                        futureStates.clear();
                        pastStates.add(new Board(actualState));
                    }
                    System.out.println("updating");
                    actualState.update(input);
                }
                redo = false;
                undo = false;
                //input
                System.out.println("Past state size " + pastStates.size());
                System.out.println("Future state size " + futureStates.size());
                System.out.println(actualState.drawMap());
                System.out.println("input: " + input);
                input = 'W';
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
