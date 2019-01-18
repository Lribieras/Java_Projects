//Fill in your name and student number
//Name: Louis Ribieras
//Student Number: 260631416

// do NOT touch the following import statement
import java.util.Random;
import java.util.*;

public class GuessTheWord {
    
    private static final String[] words = {"perfect", "country", "pumpkin", "special", "freedom", "picture", "husband", 
        "monster", "seventy", "nothing", "sixteen", "morning", "journey", "history", "amazing", "dolphin", "teacher", 
        "forever", "kitchen", "holiday", "welcome", "diamond", "courage", "silence", "someone", "science", "revenge", 
        "harmony", "problem","awesome", "penguin", "youtube", "blanket", "musical", "thirteen", "princess", "assonant", 
        "thousand", "language", "chipotle", "business", "favorite", "elephant", "children", "birthday", "mountain", 
        "football", "kindness", "abdicate", "treasure", "strength", "together", "memories", "darkness", "sandwich", 
        "calendar", "marriage", "building", "function", "squirrel", "tomorrow", "champion", "sentence", "daughter", 
        "hospital", "identical", "chocolate", "beautiful", "happiness", "challenge", "celebrate", "adventure", 
        "important", "consonant", "dangerous", "irregular", "something", "knowledge", "pollution", "wrestling", 
        "pineapple", "adjective", "secretary", "ambulance", "alligator", "congruent", "community", "different", 
        "vegetable", "influence", "structure", "invisible", "wonderful", "nutrition", "crocodile", "education", 
        "beginning", "everything", "basketball", "weathering", "characters", "literature", "perfection", "volleyball", 
        "homecoming", "technology", "maleficent", "watermelon", "appreciate", "relaxation", "abominable", "government", 
        "strawberry", "retirement", "television", "silhouette", "friendship", "loneliness", "punishment", "university", 
        "confidence", "restaurant", "abstinence", "blackboard", "discipline", "helicopter", "generation", "skateboard", 
        "understand", "leadership", "revolution"};  
    
    // this method takes an integer as input and returns a random String from the array above.
    // you can use it, but do NOT modified neither the method NOR the above array. 
    public static String getRandomWord(int seed) {
        Random gen = new Random(seed);
        int randomIndex = gen.nextInt(words.length);
        return words[randomIndex];
    }
    
    //========================
    // Enter your code below
    
    public static void main(String[] args) {

        play(9);
        
    }

    // 2a. Method to check if the guess is valid
    public static Boolean isValidGuess(char guess) {
        return (97 <= guess && guess <= 122);
    }


    // 2b. Method to generate the array of guesses
    public static int[] generateArrayOfGuesses(String secretWord) {

        int wordLength = secretWord.length();
        int[] guessesArray = new int[wordLength];

        for (int i = 0; i < wordLength; i++) {
            guessesArray[i] = 0;
        }

        return guessesArray;
    }


    // 2c.i. Method to check the guess and update the array if needed
    public static Boolean checkAndUpdate(String secretWord, int[] guessesArray, char guess) {

        int goodGuess = 0;
        for (int i = 0; i < secretWord.length(); i++) {

                if (secretWord.charAt(i) == guess) {
                    guessesArray[i] = 1;
                    goodGuess ++;
                }

        }
        if (goodGuess >0){
            return true;
        }
        else {
            return false;
        }

    }

    // 2c.ii. method to return the guesses array
    public static int[] guessArray(String secretWord, int[] guessesArray, char guess) {

        for (int i = 0; i < secretWord.length(); i++) {

            if (secretWord.charAt(i) == guess) {
                guessesArray[i] = 1;
            }

        }

        return guessesArray;

    }



    // 2d. Method to get the String to display
    public static String getWordToDisplay(String secretWord, int[] guessesArray, char guess) {

        String result = "";

        // Loop through the whole secret word
        for (int i = 0; i < secretWord.length(); i++) {

            // If guess is correct, then uppercase letter goes in it's place
            if (secretWord.charAt(i) == guess) {
                result += Character.toUpperCase(guess);
                guessesArray[i] = 1;
            }
            // If it has already been guessed, then put that letter back again
            else if (guessesArray[i] == 1) {
                result += Character.toUpperCase(secretWord.charAt(i));
            }
            // Else if it's not a good guess, then put a '-'
            else {
                result += '-';
            }

        }
        return result;
    }


    // 2e. Method to check if the word has been completely guessed
    public static Boolean isWordGuessed(int[] guessesArray) {

        int sum = 0;

        // Sum all the values inside the guessesArray
        for (int i = 0; i < guessesArray.length; i++) {
            sum += guessesArray[i];
        }

        // Will return true iff the total is equal to length
        return (sum == (guessesArray.length));
    }


    // 2f. Method to simulate a game
    public static void play(int seed) {

        // Create a scanner object
        Scanner scanner = new Scanner(System.in);


        // 1. Generate random secret word
        String secretWord = getRandomWord(seed);


        // 2. Generate corresponding array of guesses
        int[] guessesArray = generateArrayOfGuesses(secretWord);


        // 3. Display message, how many characters, 10 lives, good luck
        int lives = 10;

        System.out.println("\nWelcome to \"Guess the Word!\" \n" + "Your secret word has been generated. " +
                "It has " + secretWord.length() + " characters. You have " + lives + " lives. Good luck!");


        // 4. Let player know how many lives they have and ask for next guess
        // 8. Ask for a new guess until game is over (win / lose)

        while (!(isWordGuessed(guessesArray)) && lives > 0) {

            // As long as the player hasn't guessed the word and still has lives
            System.out.print("\nYou have " + lives + " lives left. Please enter a character: ");

            // 5. Display error message if user inputs String w/ more than one character
            // 6. Display error message if user inputs an invalid character
            String guess = scanner.nextLine();

            // error message if player enters more than one character
            if (guess.length() > 1) {
                System.out.println("You can only enter one single character. Try again!");

            // error message if character is not a lower case letter of the alphabet
            } else if (guess.length() == 1 && !(isValidGuess(guess.charAt(0)))) {
                System.out.println("The character must be a lower case letter of the english alphabet. Try again!");

            // 7. If valid guess: check and update, display word, lose life if necessary
            } else if (guess.length() == 1 && isValidGuess(guess.charAt(0))) {

                int[] guessesArrayGame = guessArray(secretWord, guessesArray, guess.charAt(0));

                    // lose a life if incorrect guess
                    if (secretWord.indexOf(guess.charAt(0)) < 0) {
                        System.out.print("There's no such character. Try again!");
                        lives--;

                    } else if (secretWord.indexOf((guess.charAt(0))) >= 0) {
                        System.out.print("Good job! The secret word contains the character '" + guess + "'");
                    }

                // display word progress
                System.out.print("\n" + getWordToDisplay(secretWord, guessesArrayGame, guess.charAt(0)) + "\n");

            }


            // 9. Win / Lose Message
            if (isWordGuessed(guessesArray)) {
                System.out.println("\nCongratulations you guessed the secret word!");
            } else if (lives == 0) {
                System.out.println("\nYou have no lives left. Better luck next time! The secret word was: \"" + secretWord + "\"");
            }


        //while end
        }

    }


}
