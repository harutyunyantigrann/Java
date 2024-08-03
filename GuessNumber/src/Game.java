import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Game {
    public Game(){
        System.out.println("Choose any action \n1) Start the game.\n2) My stats.\n3) Reset my stats.\n4) Settings.\n5) Exit.");
        System.out.println("Enter the number: ");
        switch (scanner.nextInt()){
            case 1:
                Start();
                ;
            case 2:
                Stats();
                break;
            case 3:
                Reset();
                Choose();
            case 4:
                Settings();
                Choose();
            case 5:
                System.exit(1);

            default:
                System.out.println("You entered wrong number, please try again.");
                Choose();
        }
    }
    private static int Wins = 0;
    private int randrang = 11;
    private static int Loss = 0;
    private Random random = new Random();
    private int Number;
    private Scanner scanner = new Scanner(System.in);
    private int yourvariant = -1;
    private int trynumber = 0;
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private void Reset(){
        System.out.println("Are you sure that you want reset your stats?");
        System.out.println("Please, enter 0 for No and any other integer for Yes.");
        if(scanner.nextInt() != 0){
            Wins = 0;
            Loss = 0;
            System.out.println("You successfully reset your stats.");
            Choose();
        } else{
            System.out.println("You cancel stats reset.");
            Choose();
        }
    }
    private void Changerange(){
        System.out.println("Set range : 1) 0-5, 2) 0-10, 3) 0-20.");
        switch (scanner.nextInt()){
            case 1:
                randrang = 6;
                System.out.println("Changes successfully saved.");
                break;
            case 2:
                randrang = 11;
                System.out.println("Changes successfully saved.");
                break;
            case 3:
                randrang = 21;
                System.out.println("Changes successfully saved.");
                break;
            default:
                System.out.println("You entered wrong number, please try again.");
                Changerange();
        }
    }
    private void checkrang(int number){
        if(number < 0 || number > randrang-1){
            while(number < 0 || number > randrang-1){
                System.out.println("You entered number out of range, please try enter number again:");
                number = scanner.nextInt();
            }
        } else {
            yourvariant = number;
        }
    }
    private void Settings(){
        System.out.println("Enter your option.");
        System.out.println("1) Change range.\n 2) Change game mode.");
        switch (scanner.nextInt()){
            case 1:
                Changerange();
                break;
            case 2:
                Changemode();
                break;
            default:
                System.out.println("You entered wrong number, please try again.");
                Settings();
        }
    }
    boolean Lightmode = false;
    private void Changemode(){
        System.out.println("1) Hard mode.\n2) Light mode.");
        System.out.println("Enter you option:");
        switch (scanner.nextInt()){
            case 1:
                Lightmode = false;
                break;
            case 2:
                Lightmode = true;
                break;
            default:
                System.out.println("You entered wrong number, please try again.");
                Changemode();
        }
    }
    private void Lightmode(int number){
        if(number-1 == Number || number+1 == Number){
            System.out.println("VERY HOT!!!");
        } else if(number-2 == Number || number+2 == Number){
            System.out.println("HOT!!");
        } else {
            System.out.println("COLD!");
        }
    }
    private void Choose(){
        System.out.println("Enter any symbol to return main");
        scanner.next();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Choose any action \n1) Start the game.\n2) My stats.\n3) Reset my stats.\n4) Settings.\n5) Exit.");
        System.out.println("Enter the number: ");
        switch (scanner.nextInt()){
            case 1:
                Start();
                ;
            case 2:
                Stats();
                break;
            case 3:
                Reset();
                Choose();
            case 4:
                Settings();
                Choose();
            case 5:
                System.exit(1);

            default:
                System.out.println("You entered wrong number, please try again.");
                Choose();
        }
    }
    private void Stats(){
        System.out.println("In our game you win " + ANSI_GREEN + Wins + ANSI_RESET + " games and loss " + ANSI_RED + Loss + ANSI_RESET + " games.");
        Choose();
    }
    private void Start(){
        yourvariant = -1;
        trynumber = 0;
        Number =  random.nextInt(randrang);
        while(true){
            if(trynumber == 3){
                System.out.println(ANSI_RED + "You can`t guess the number, you loss.\nI guess the number: " + Number + ANSI_RESET);
                Loss++;
                Choose();
            }

            if(trynumber==0){
                System.out.println("Guess the number in range 1:"+ (randrang-1) + "\nEnter your option after this line.");
                yourvariant = scanner.nextInt();
                checkrang(yourvariant);

            } else {

                System.out.println("You enter wrong number. \n You have " + ANSI_RED + (3-trynumber) + ANSI_RESET +  " attempt(s)."  + "\nEnter your option after this line.");
                yourvariant = scanner.nextInt();
                checkrang(yourvariant);

            }


            if(yourvariant == Number){
                System.out.println(ANSI_GREEN + "You guess the number and win the game! \nI guess the number: " + Number + ANSI_RESET);
                Wins++;
                Choose();
            } else {
                if(Lightmode){
                    Lightmode(yourvariant);
                }
                trynumber++;
            }
        }


    }
}

