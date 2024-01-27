//////////////////////////////////////////////////////////////////////


import java.util.Random;
import java.util.Scanner;


//////////////////////////////////////////////////////////////////////


abstract class number_generator
{
    //Random Class
    static Random rand = new Random();

    //Creates a random number between 0 - 100 from the Random Class
    static int rand_int = rand.nextInt(100);
}


//////////////////////////////////////////////////////////////////////


class main extends number_generator
{
    public static void game(String args[])
    {
        //Scanner Class
        //Could never figure out how to get rid of the "Resource Leak" problem
        Scanner scan = new Scanner(System.in);

        //Limits the program to 5 guesses
        int attempts = 5;
        int i, guess;

        //Prints the message for the start of the program
        System.out.println("A random number between 1-100 has been selected.");
        System.out.println("Please try to guess the correct number.");
        System.out.println("You have 5 attempts...");
        

        //Found this interesting sequence online and thought I'd try it out
        for (i = 0; i < attempts; i++)
        {
            System.out.println("");
            System.out.println("Guess the number: ");

            //I noticed this being used for int inputs in several different
            //examples online
            guess = scan.nextInt();
            
            if (rand_int == guess)
            {
                System.out.println("You are correct! Congratulations!");
                break;
            }

            //I noticed that the limited attempts were not working until I
            //added in that extra stuff on the end (&& i != attempts - 1).
            //That REALLY threw me for a loop, but after some research, it
            //actually made tons of sense.
            else if (rand_int > guess && i != attempts - 1)
            {
                System.out.println("");
                System.out.println("Higher!");
            }

            else if (rand_int < guess && i != attempts - 1)
            {
                System.out.println("");
                System.out.println("Lower!");
            }
        }

        //Also needed help for this portion. Kept putting it into the wrong
        //part of the code until I was corrected...
        if (i == attempts)
        {
            System.out.println("");
            System.out.println
            ("You are all out of attempts! "
            + "The correct number was " + rand_int);
        }
    }

    //This portion of the code executes the code.
    //I also could not figure out this 'problem' either, but the code works
    //anyway, so it isn't of any harm... Right?...
    public static void main(String arg[])
    {
        //Found this neat trick online that flushes the console when it starts
        //up! Now it looks a lot more professional!
        System.out.print("\033[H\033[2J");
        System.out.flush();
        game(arg);
    }
}