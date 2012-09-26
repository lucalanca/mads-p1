package robo.miner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

    Board actualState = new Board();
    ArrayList<Board> pastStates = new ArrayList<>();
    ArrayList<Board> futureStates = new ArrayList<>();
    static char input = 'W';
    static boolean undo = false;
    static boolean redo = false;
    static boolean gameRunning = true;

    public static void main(String[] args) {
        Game game = new Game();
        Thread t = new Thread(game);
        t.start();
        Scanner scanner = new Scanner(System.in);
        String inputString;
        while (gameRunning) {
            if (scanner.hasNext()) {
                inputString = scanner.next().toUpperCase();
                switch (inputString) {
                    case "UNDO":
                        undo = true;
                        break;
                    case "REDO":
                        redo = true;
                        break;
                    default:
                        input = inputString.charAt(0);
                        break;
                }
            } else {
                input = 'W';
            }
        }
    }

    @Override
    public void run() {
        actualState.createFromFile("files/example6.map");
        System.out.println(actualState.drawMap());


        while (actualState.running) {
            try {
                Thread.sleep(1000);
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
                    actualState.update(input);
                }
                redo = false;
                undo = false;

                System.out.println("input: " + input);
                System.out.println(actualState.drawMap());
                input = 'W';
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        gameRunning = false;
    }
}
