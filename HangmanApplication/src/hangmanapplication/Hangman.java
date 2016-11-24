package hangmanapplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {
    
    String mysteryWord;
    StringBuilder currentGuess;
    ArrayList<Character> previousGuesses = new ArrayList<>();
    
    int maxTries = 6;
    int currentTry = 0;
    
    ArrayList<String> dictionary = new ArrayList<>();
    private static FileReader fileReader;
    private static BufferedReader bufferedFileReader;
    
    public Hangman() throws IOException {
       try {
        initializeStreams();
        mysteryWord = pickWord();
        currentGuess = initializeCurrentGuess();       
       } catch(IOException e){
           System.out.println("Could not init Hangman() : " + e.toString());
       }
        
    }

    private void initializeStreams() throws IOException {
        try {
            File inFile = new File("dictionary.txt");
            fileReader = new FileReader(inFile);
            bufferedFileReader = new BufferedReader(fileReader);
            String currentLine = bufferedFileReader.readLine();
            while(currentLine != null){
                dictionary.add(currentLine);
                currentLine = bufferedFileReader.readLine(); 
            }
            bufferedFileReader.close();
            fileReader.close();
        } catch(IOException e) {
            System.out.println("Could not init streams: " + e.toString());
        }
        
    }

    private String pickWord() {
        Random rand = new Random();
        int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
        return dictionary.get(wordIndex);
    }

    // _ A _ _ _ _ _ _ 
    private StringBuilder initializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for(int i = 0; i < mysteryWord.length() * 2; i++){
            if (i % 2 == 0){
                current.append('_');
            } else {
                current.append(' ');
            }
        }
        return current;
    }
    
    public String getFormalCurrentGuess(){
        return "Current Guess: " + currentGuess.toString();
    }
    
    public String drawPicture(){
       switch(currentTry){
           case 0: return noPersonDraw();
           case 1: return addHeadDraw();
           case 2: return addBodyDraw();
           case 3: return addOneArmDraw();
           case 4: return addSecondArmDraw();
           case 5: return addOneLegDraw();
           default: return fullPersonDraw();
       } 
    }

    private String noPersonDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|\n" +
                "|\n"+
                "|\n" +
                "|\n" +
                "|\n" +
                "|\n";
    }

    private String addHeadDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|\n"+
                "|\n" +
                "|\n" +
                "|\n" +
                "|\n";
    }

    private String addBodyDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|        |\n"+
                "|        |\n" +
                "|\n" +
                "|\n" +
                "|\n";
    }
    
    private String addOneArmDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \n"+
                "|        |\n" +
                "|\n" +
                "|\n" +
                "|\n";
    }

    private String addSecondArmDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|\n" +
                "|\n" +
                "|\n";
    }

    private String addOneLegDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \n" +
                "|\n" +
                "|\n";
    }

    private String fullPersonDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \\ \n" +
                "|\n" +
                "|\n";
    }

    boolean gameOver() {
        if (didWeWin()){
            System.out.println();
            System.out.println("Congrats! YOu won! You guessed the right word!");
            return true;
        } else if (didWeLose()){
            System.out.println();
            System.out.println("Sorry, you lost. You spent all of your 6 tries."
                    + " The word was " + mysteryWord + ".");
            return true;
        }
        return false;
    }

    boolean playGuess(char guess) {
        boolean isItAGoodGuess = false;
        for (int i = 0; i < mysteryWord.length(); i++) {
            if (mysteryWord.charAt(i) == guess) {
                currentGuess.setCharAt(i * 2, guess);
                isItAGoodGuess = true;
                previousGuesses.add(guess);
            }
        }
        
        if (!isItAGoodGuess) {
            currentTry++;
        }
        return isItAGoodGuess;
    }

    boolean isGuessedAlready(char guess) {
       return previousGuesses.contains(guess);
    }

    private boolean didWeWin() {
        String guess = getCondensedCurrentGuesss();
        return guess.equals(mysteryWord);
    }

    private boolean didWeLose() {
        return currentTry >= maxTries;
    }

    private String getCondensedCurrentGuesss() {
        String guess = currentGuess.toString();
        return guess.replace(" ", "");
    }

    
}
