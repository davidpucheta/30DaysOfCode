/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madlibs;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author davidreyespucheta
 */
public class MadLibs {

    Scanner scanner = new Scanner(System.in);
    String story;
    String name;
    String adjective1;
    String adjective2;
    String noun1;
    String noun2;
    String noun3;
    String adverb;
    String randomNums;
    Random rand = new Random();

    //Getters and setters!!
    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdjective1() {
        return adjective1;
    }

    public void setAdjective1(String adjective1) {
        this.adjective1 = adjective1;
    }

    public String getAdjective2() {
        return adjective2;
    }

    public void setAdjective2(String adjective2) {
        this.adjective2 = adjective2;
    }

    public String getNoun1() {
        return noun1;
    }

    public void setNoun1(String noun1) {
        this.noun1 = noun1;
    }

    public String getNoun2() {
        return noun2;
    }

    public void setNoun2(String noun2) {
        this.noun2 = noun2;
    }

    public String getNoun3() {
        return noun3;
    }

    public void setNoun3(String noun3) {
        this.noun3 = noun3;
    }

    public String getAdverb() {
        return adverb;
    }

    public void setAdverb(String adverb) {
        this.adverb = adverb;
    }

    public String getRandomNums() {
        return randomNums;
    }

    public void setRandomNums() {
        int num = Math.abs(rand.nextInt()) % 100;
        int index = 0;
        int[] numberHolder = new int[3];
        while(index < numberHolder.length){
            numberHolder[index] = num + index;
            index++;
        }
        randomNums = "not "   + numberHolder[0] +
                     ", not " + numberHolder[1] +
                     ", but " + numberHolder[2];
                      
        
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    //print instruction for player
    public void printInstructions() {
        System.out.println("Welcome to the MadLibs game. If you type in "
                + "words, we'll give you a story. Start by typying in a name");
    }

    //get data from player
    public void enterName() {
        System.out.println("Give a name");
        setName(scanner.nextLine());
    }

    public void enterNoun1() {
        System.out.println("Give a noun");
        setNoun1(scanner.nextLine());
    }

    public void enterNoun2() {
        System.out.println("Give another noun");
        setNoun2(scanner.nextLine());
    }

    public void enterNoun3() {
        System.out.println("Give the last noun");
        setNoun3(scanner.nextLine());
    }

    public void enterAdjective1() {
        System.out.println("Give and adjective");
        setAdjective1(scanner.nextLine());
    }

    public void enterAdjective2() {
        System.out.println("Give a second adjective");
        setAdjective2(scanner.nextLine());
    }

    public void enterAdverb() {
        System.out.println("Please Give an adverb");
        setAdverb(scanner.nextLine());
    }

    public void putTogetherTheStory() {
        String story = "Jesse and her best friend " + getName() + " went to Disney World today! "
                + "They saw a " + getNoun1() + " in a show at the Magic Kingdom "
                + "and ate a " + getAdjective1() + " feast for dinner. The next day I "
                + "ran " + getAdverb() + " to meet Mickey mouse in his  " + getNoun2() + ""
                + "and then that night I gazed at the " + getRandomNums() + " "
                + getAdjective2() + " fireworks shooting from the " + getNoun3() + ".";
        setStory(story);
    }

    public void play() {
        enterName();
        enterNoun1();
        enterNoun2();
        enterNoun3();
        enterAdjective1();
        enterAdjective2();
        enterAdverb();
        setRandomNums();
        putTogetherTheStory();
        System.out.println(getStory());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MadLibs game = new MadLibs();
        game.printInstructions();
        game.play();
    }

}
