package tictactoe;

import java.util.Scanner;

public class TicTacToeApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Allow for continuous games
        boolean doYouWantToPLay = true;

        while (doYouWantToPLay) {
            //Setup tokens and AI
            System.out.print("Welcome to Tic Tac Toe! You are about to go against "
                    + "the master of Tic tac Toe. Are you ready? I hope so! \n "
                    + "BUT FIRST, you must pickwhat character you want to be and which character I will be");
            System.out.println();
            System.out.println("Enter a single character that will represent you on the board");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a single character that will represent your opponent on the board");
            char opponentToken = sc.next().charAt(0);

            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();

            //Setup the game
            System.out.println();
            System.out.println("Now we can start the game. To play, enter a number and your token shall be put "
                    + "in its place.\nThe numbers go from 1-9, left to right. We shall see who will win this round.");
            TicTacToe.printIndexBoard();
            System.out.println();

            //Let's play
            while (game.gameOver().equals("notOver")) {
                if (game.currentMarker == game.userMarker) {
                    //User turn
                    System.out.println("it's your turn! Enter a spot for your token");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println("Try again. " + spot + " is invalid. This spot is already taken "
                                + " or it is out of range");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");
                } else {
                    //AI's turn                
                    System.out.println("It's my turn!");
                    //AI picks a spot
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);

                    System.out.println("I picked " + aiSpot + "!");
                }
                //Print refreshed board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            //set upa  new game... or not
            System.out.println("Do you want ti play again? "
                    + "Enter Y if you do. "
                    + "Enter anything else if you are tired of me.");
            char response = sc.next().charAt(0);
            doYouWantToPLay = (response == 'Y' || response == 'y');
        }
    }

}
