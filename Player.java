/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEX1;

/**
 *
 * @author C
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Player extends User
{
    public Player(String name){
        super(name);
    }
    
    public boolean win(int sticks)
    {
        boolean didWin = false;
        
        if((sticks == 1) & (sticks != 0) && !(sticks <0))
        {
            didWin = true;
        }
        else if (sticks >= 1)
        {
            didWin = false;
        }
        else
        {
            System.out.println(name + "lost the game~");
        }
        return didWin;
    }
    
    
    public int makeMove(int move, int sticks)
    {
        sticks = sticks - move;
        System.out.println("There are now " + sticks + "sticks left on the board!");
        boolean won = win(sticks);
        if(won == true)
        {
            System.out.println(name + "has won the game!");
            try
            {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e)
            {
            }
            System.exit(0);
        }
        return sticks;
    }
    
    public int getMoveInput()
    {
        Scanner in = new Scanner(System.in);
        System.out.println(name + ": Please enter your move (1-3):\n");
        while(!in.hasNextInt())
        {
            in.next();
            System.out.println("Please enter an integer");
        }
        int input = in.nextInt();
        if(validateMove(input) == true)
        {
            return input;
        }
        else
        {
            System.out.println("Input not within range!");
            return getMoveInput();
        }
    }
    
    public boolean validateMove(int move)
    {
        return move > 0 && move <= 3;
    }
        
}