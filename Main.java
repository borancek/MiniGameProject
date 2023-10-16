import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //Create an instance of user object
        User user = new User("");
        //List playable mini games
        String[] playableGames = {"Palindrome Checker", "Adjacent Element Checker", "Magic 8-Ball", "Exit Program" };

        Scanner scan = new Scanner(System.in);
        System.out.println("Hello and welcome to this mini-game experience!");
        //Get name of player
        System.out.println("What is your name?");
        String user_name = scan.next();

        //Set user's name
        user.setName(user_name);

        System.out.println("Good to have you here today, " + user.getName());

        //Iterate through the games the user wishes to play, if the user input is 4, exit the program
        int playableGameNumber = 0;
        while (playableGameNumber != 4) {
            System.out.println("Below, you will find a selection of engaging games from which " +
                    "you may make your choice by entering the corresponding game number.");

            //Print out list of the playable games
            int numberOfGames = playableGames.length;
            for (int i = 0; i < numberOfGames; i++) {
                System.out.println((i + 1) + ") " + playableGames[i]);
            }

            System.out.println("Please choose a game to play, or choose number 4 to exit!");
            playableGameNumber = scan.nextInt();

            //Palindrome Game
            if (playableGameNumber == 1) {
                System.out.println("Welcome to the Palindrome checker!");
                System.out.println("Please provide a single word, and I will assess if it " +
                        "exhibits the unique trait of being a palindrome, reading the same way forwards and backwards.");
                System.out.println("Enter a word:");
                String inputString = scan.next();

                //Convert user input to lowercase in order to deal with case sensitivity
                String inputString_lc = inputString.toLowerCase();
                char[] inputStringArray = inputString_lc.toCharArray();

                //Create empty ArrayList of that is going to receive the original word in order
                //and another empty ArrayList that is going to receive the same word but in reverse
                ArrayList<Character> originalWord = new ArrayList<>();
                ArrayList<Character> originalWordReversed = new ArrayList<>();

                //Get length of original word
                int originalWordLength = inputStringArray.length;
                //iterate through each character and add it to the originalWord array list
                for (int i = 0; i < originalWordLength; i++) {
                    originalWord.add(inputStringArray[i]);
                }

                //Loop through each character starting from the last index
                for (int j = originalWordLength - 1; j >= 0; j--) {
                    originalWordReversed.add(inputStringArray[j]);
                }

                if (originalWord.equals(originalWordReversed) == true) {
                    System.out.println("This word is a palindrome!");
                    System.out.println("Thank you for playing!\n");
                } else {
                    System.out.println("This word is not a palindrome!");
                    System.out.println("Thank you for playing!\n");
                }

            }

            //Adjacent Element Checker
            if (playableGameNumber == 2) {
                System.out.println("Welcome to the adjacent element checker!");
                System.out.println("Please input a list of between two and five " +
                        "numbers. I will then identify which adjacent pair, " +
                        "when multiplied together, yields the greatest result.");

                //Create an empty ArrayList that is going to receive the list of numbers that the user inputs
                ArrayList<Integer> inputArray = new ArrayList<>();
                int amountOfNumbers = 0;
                while (amountOfNumbers != 5) {
                    System.out.println("Enter number:");
                    int entered_number = scan.nextInt();
                    inputArray.add(entered_number);
                    amountOfNumbers++;
                }

                System.out.println("Your numbers are: " + inputArray);
                int inputArrayLength = inputArray.size();

                //Initialise two variables that are going to be used as the indexes of comparison
                int x = 0;
                int y = 1;

                int max = -10000;
                int current_value = -10000;


                for (int i = 1; i < inputArrayLength; i++) {
                    //Multiply index 0 with 1, 2 with 3, 4 with 5
                    current_value = inputArray.get(x) * inputArray.get(y);
                    x++;
                    y++;

                    if (current_value > max) {
                        max = current_value;
                    } else {
                        continue;
                    }
                }
                System.out.println("The largest possible number is: " + max);
                System.out.println("Thank you for playing!\n");
            }

            // Magic 8-Ball
            if (playableGameNumber == 3) {
                System.out.println("Welcome to the Magic 8-Ball!");
                System.out.println("The Magic 8-Ball is an oracle of fate. " +
                        "Pose your question, and this program will " +
                        "reveal what it foresees in your future.");
                System.out.println("Ask a question: ");
                scan.nextLine();
                String question = scan.nextLine();

                //Create instance of random object to get random numbers
                Random random = new Random();
                //Set bounds
                int randomNumber = random.nextInt(9) + 1;

                if(randomNumber == 1){
                    System.out.println("Yes - definitely");
                    System.out.println("Thank you for playing!\n");
                } else if(randomNumber == 2){
                    System.out.println("It is decidedly so");
                    System.out.println("Thank you for playing!\n");
                } else if (randomNumber == 3){
                    System.out.println("Without a doubt");
                    System.out.println("Thank you for playing!\n");
                } else if(randomNumber == 4){
                    System.out.println("Reply hazy, try again");
                    System.out.println("Thank you for playing!\n");
                } else if(randomNumber == 5){
                    System.out.println("Ask again later");
                    System.out.println("Thank you for playing!\n");
                } else if(randomNumber == 6){
                    System.out.println("Better not tell you now");
                    System.out.println("Thank you for playing!\n");
                } else if (randomNumber == 7) {
                    System.out.println("My sources say no");
                    System.out.println("Thank you for playing!\n");
                } else if(randomNumber == 8){
                    System.out.println("Outlook not so good");
                    System.out.println("Thank you for playing!\n");
                } else if(randomNumber == 9) {
                    System.out.println("Very doubtful");
                    System.out.println("Thank you for playing!\n");
                } else {
                    System.out.println("Error\n");
                }

            }
        }
        System.exit(0);
        scan.close();
    }
}