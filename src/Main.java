import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean done = false;

        do
        {
            int die1 = 0;
            int die2 = 0;
            int sum = 0;
            int point = 0;
            Random rnd = new Random();
            Scanner in = new Scanner(System.in);
            boolean gameOver = false;
            boolean rollPoint = false;
            String again = "";

            do
            {
                //There is an initial roll of 2 dice resulting in a sum of 2 – 12.
                die1 = rnd.nextInt(6) + 1;
                die2 = rnd.nextInt(6) + 1;
                sum = die1 + die2;
                //For each roll show the value for each die and the sum.
                System.out.print("Die 1 is: ", die1, ". Die 2 is: ", die2, ". The sum is: ", sum,".");

                //If the sum is 2, 3 or 12 it is called "craps" or "crapping out" and the game is over with a loss.
                //o	For case i or ii above, indicate that the user either crapped out or won with a natural and then prompt to play again
                if (sum == 2) || (sum == 3) || (sum == 12):
                {
                    System.out.print("You crapped out. Game lost.");
                    gameOver = true;
                }
                //If the sum is 7 or 11 it is called a ‘natural’ and the game is over with a win.
                //o	For case i or ii above, indicate that the user either crapped out or won with a natural and then prompt to play again
                else if (sum == 7) || (sum == 11):
                {
                    System.out.print("You rolled a natural. You win!");
                    gameOver = true;
                }
                //For all other values, the sum becomes ‘the point’ and the user makes subsequent rolls until they either throw a 7 in which case they lose or they make the point sum in which case they win.
                else:
                {
                    point = sum;
                    rollPoint = true;
                    //o	For case iii indicate that the sum is now the point.
                    System.out.print("The point is: ", point, ". You are trying for the point.");

                    do
                    {
                        die1 = rnd.nextInt(6) + 1;
                        die2 = rnd.nextInt(6) + 1;
                        sum = die1 + die2;

                        if (die1 == 7) || (die2 == 7):
                        {
                            // Got a seven and lost   (Prompt user to play again.)
                            System.out.print("Die 1 is: ", die1, ". Die 2 is: ", die2, ". You rolled a 7. Game lost.");
                            gameOver = true;
                            rollPoint = false;
                        }
                        else if (sum == point):
                        {
                            // Made point and won.  (Prompt user to play again.)
                            System.out.print("Die 1 is: ", die1, ". Die 2 is: ", die2, ". The sum is: ", sum,". You made the point. You win!");
                            gameOver = true;
                            rollPoint = false;
                        }
                        else:
                        {
                            //Trying for point
                            System.out.print("Die 1 is: ", die1, ". Die 2 is: ", die2, ". The sum is: ", sum,". You did not make the point. Shoot again.");
                        }
                    }
                    while (rollPoint)
                }
            }
            while(!gameOver);

            //After a win or loss, the next player rolls the die for a new game. In our simulation, the program will simply ask the user if they want to continue to play.
            System.out.print("Do you want to continue playing [Y/N]? ");
            again = in.nextLine();

            if(again.equalsIgnoreCase("N"))
            {
                done = true;
            }
        }
        while(!done);
    }
}