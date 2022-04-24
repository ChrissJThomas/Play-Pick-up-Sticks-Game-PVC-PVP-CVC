/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEX1;

import java.security.SecureRandom;

/**
 *
 * @author C
 */
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AI extends User
{
    public AI(String name)
    {
        super(name);
    }
    
    public ArrayList<ArrayList> makeList(int sticks)
    {
        ArrayList<ArrayList> moves = new ArrayList<ArrayList>();
        int i = 0;
        
        while(i < sticks)
        {
            moves.add(new ArrayList<Integer>());
            i++;
        }
 
        for(ArrayList a : moves)
        {
            a.add(1);
            a.add(2);
            a.add(3);
        }
        return moves;
    }
    
    public int chooseMove(ArrayList<ArrayList> list,int sticks)
    {
        ArrayList<Integer> possible = list.get(sticks -1);
        int choiceIndex = ThreadLocalRandom.current().nextInt(0,possible.size());
        int choice = possible.get(choiceIndex);
       
        
        return choice;
    }
    
    public int makeMove(int move, int sticks) 
    {
        sticks = sticks - move;
        System.out.println(name + " took " + move + " sticks");
        System.out.println("There are now " + sticks + " sticks left on the board.");
        boolean won = win(sticks);
        if(won == true)
        {
            System.out.println(name + " has won the game!");
            try
            {
                TimeUnit.SECONDS.sleep(5);
            }
            catch(Exception e)
            {
                System.exit(0);
            }
            System.exit(0);
        }
        return sticks;
    }
    
    public boolean win(int sticks)
    {
        boolean didWin = false;
        
        if((sticks == 1) && (sticks != 0) && !(sticks < 0))
        {
            didWin = true;
        }
        else if(sticks >= 1)
        {
            didWin = false;
        }
        else
        {
            System.out.println(name + " lost the game!");
        }
        return didWin;
    }
}



























//public class Computer {
//    
//    
//    SecureRandom randomNum = new SecureRandom();
//    int remaining;
//            
//    final int MaxGuesses = 1000000;
//    final int MaxSticks = 100;
//    
//    int block[][] = new int[MaxSticks][MaxGuesses];
//    int numGuess[] = new int [MaxGuesses];
//    int computerpicks[] = new int [MaxSticks];
//    
//    int pick = randomNum.nextInt(numGuess[remaining]);
//    computerpicks[remaining] = block[remaining][pick];
//    return robotpicks[remaining];
//    
//    pickupsticks(); //for computer and player
//}
