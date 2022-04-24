/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEX1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Christina Thomas
 *         Coded in BlueJ and transferred it over to NetBeans
 */

public class GameDriver {

    public static void playerVai() {
        AI AI1 = new AI("R2-D2");
        Game StickGame = new Game();
        Player Player1 = new Player("Player 1");
        int input = StickGame.getSticksInput();
        ArrayList<ArrayList> moves = AI1.makeList(input);
        while (StickGame.getSticks() > 1) {
            int p1Move = Player1.getMoveInput();
            StickGame.setNumberOfSticks(Player1.makeMove(p1Move, StickGame.getSticks()));
            if (StickGame.getSticks() <= 1) {
                System.exit(0);
            } else {
                int AiMove = AI1.chooseMove(moves, StickGame.getSticks());
                StickGame.setNumberOfSticks(AI1.makeMove(AiMove, StickGame.getSticks()));

            }
            
        }

    }

    public static void playerVplayer() {
        Game StickGame = new Game();

        Player Player1 = new Player("Player 1");
        Player Player2 = new Player("Player 2");
        StickGame.getSticksInput();

        while (StickGame.getSticks() > 1) {
            int p1Move = Player1.getMoveInput();
            StickGame.setNumberOfSticks(Player1.makeMove(p1Move, StickGame.getSticks()));
            if (StickGame.getSticks() <= 1) {
                System.exit(0);
            } else {
                int p2Move = Player2.getMoveInput();
                StickGame.setNumberOfSticks(Player2.makeMove(p2Move, StickGame.getSticks()));
            }
        }

    }

    public static void AiVai() {
        AI AI1 = new AI("BB-8");
        Game StickGame = new Game();
        AI AI2 = new AI("R2-D2");
        int input = StickGame.getSticksInput();
        ArrayList<ArrayList> moves = AI1.makeList(input);

        while (StickGame.getSticks() > 1) {
            int AMove = AI2.chooseMove(moves, StickGame.getSticks());
            StickGame.setNumberOfSticks(AI2.makeMove(AMove, StickGame.getSticks()));
            if (StickGame.getSticks() <= 1) {
                wait(5000);
                System.exit(0);
            } else {
                wait(5000);
                int AiMove = AI1.chooseMove(moves, StickGame.getSticks());
                StickGame.setNumberOfSticks(AI1.makeMove(AiMove, StickGame.getSticks()));
            }
            
        }

    }

    //when start is called, separate method
    public static void start() {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter 'Quit' to Quit");
            System.out.println("Please enter the selection of what you would like to play:");
            System.out.println("1 - Player vs. Player game");
            System.out.println("2 - Player vs. AI");
            System.out.println("3 - AI the AI");
            String selection = in.next();
            switch (selection) {
                case "1": {
                    playerVplayer();
                    break;
                }
                case "2": {
                    playerVai();
                    break;
                }
                case "3": {
                    AiVai();
                    break;
                }
                case "Quit": {
                    System.exit(0);
                }
                case "quit": {
                    System.exit(0);
                }
                default: {
                    System.out.println("You trying to break this game? Try again");
                    start();
                }
            }
        }
    }


    // to call method wait anywhere
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    //start here
    public static void main(String[] args) {
        start();
    }
}
