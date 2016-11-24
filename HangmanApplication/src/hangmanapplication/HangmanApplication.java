/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanapplication;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author davidreyespucheta
 */
public class HangmanApplication {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to hangman! I will pick a word and you will try to guess it "
                + "Character by character.\n"
                + "If you guess wrong 6 times, then I win. If you can guess it before then you win.\n"
                + "Are you ready? I hope so because I am");
        System.out.println();
        System.out.println("I have picked my word.\nBelow is a picture, and below "
                + "that is your current guess, which starts off as nothing.\nEvery time you "
                + "guess incorrectly I add a body part to the picture.\nWhen there is a full "
                + "person, you lose");
        
        //allows for multiple games
        boolean doYouWantToPlay = true;
        while(doYouWantToPlay){
            
            //setting up the game
            System.out.println();
            System.out.println("Allright let's play!");
            Hangman game = new Hangman();
                
            do {
                //Draw the things
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                System.out.println(game.mysteryWord);
                System.out.println();
                
                //Get the guess
                System.out.println("Enter a character that you think is in the word: ");
                char guess = (sc.next().toLowerCase()).charAt(0);
                System.out.println();
               
                //check if the char is guessed already
                while (game.isGuessedAlready(guess)){
                    System.out.println("Try again! yuo've already guesed that character");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }
                
                //Play the game
                if (game.playGuess(guess)){
                    System.out.println("Great guess! That character is in the word!");
                } else {
                    System.out.println("Unfortunately that character isn't in the word");
                }
            } 
            while(!game.gameOver()); //KEEP PLAYING UNTIL THE GAME IS OVER!
            
            //play again or no?
            System.out.println();
            System.out.println("Do you want to play another game? Enter Y if you do.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');
            
        }
        
        
        
    }
    
}
