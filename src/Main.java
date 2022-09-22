import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> botPositions = new ArrayList<>();

    public static void main(String[] args) {

        // Game board create for Tic Tac Toe by using 2D Array.
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};


        Scanner input = new Scanner(System.in);

        // Define symbol for each
        System.out.println("Your symbol- 'X'\nComputer symbol- 'O'");

        System.out.println();

        // Choosing game level . it's can be easy or hard. There are only two game Level I create for this project.
        System.out.println("Choose game level\n" +
                "1.Easy\n" +
                "2.Hard");

        System.out.print("Your Choose: ");
        int level = input.nextInt();

        while (level > 2 || level < 1) {
            System.out.println("Invalid Input!");
            System.out.print("Your Choose: ");
            level = input.nextInt();
        }

        // Hard level means here intermediate level, not an impossible level.
        if (level == 1) {
            System.out.println("\nEasy! Best of luck");
        } else {
            System.out.println("\nHard! Best of luck.");
        }
        System.out.println();


        // Here's empty game board will be shown before any placement by player. printGameBoard method created for print game board each time.
        printGameBoard(gameBoard);

        // The loop here will be running until we cannot find any winner or draw the match.
        while(true) {

            // Player placement taken . If that position already taken then again while loop will take the correct one.
            System.out.print("Enter your placement (1-9): ");
            int playerPos = input.nextInt();
            while (playerPositions.contains(playerPos) || botPositions.contains(playerPos) || playerPos > 9) {
                System.out.println("Position taken! Enter a correct position.");
                System.out.print("Enter your placement (1-9): ");
                playerPos = input.nextInt();
            }

            // After take the correct position , send it 'placePiece' method with player position previous game board and user name.
            placePiece(gameBoard, playerPos, "player");

            // After each placement , it check that who is winner or for draw match by 'checkWinner' Method.
            String result = checkWinner();
            if (result.length() > 0) {
                printGameBoard(gameBoard);
                System.out.println("\n" + result);
                break;
                // If find any result (win/ loss/ draw) , then immediately break the while loop and end the match after print the result.
            }

            // Now it's bot turn. It choose randomly a number between (1-9).
            Random rand = new Random();
            int botPos = rand.nextInt(9) + 1;

            // If the place is already taken. Then take another random number.
            while (playerPositions.contains(botPos) || botPositions.contains(botPos)) {
                botPos = rand.nextInt(9) + 1;
            }


            // Only for hard level !! If the player chooses level 2.
            if(level == 2) {

                // Here, bot will be check that for which position placement it (bot) can win.
                if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == ' ') {
                    botPos = 3;
                } else if (gameBoard[0][0] == 'O' && gameBoard[0][2] == ' ' && gameBoard[0][4] == 'O') {
                    botPos = 2;
                } else if (gameBoard[0][0] == ' ' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
                    botPos = 1;
                } else if (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == ' ') {
                    botPos = 6;
                } else if (gameBoard[2][0] == 'O' && gameBoard[2][2] == ' ' && gameBoard[2][4] == 'O') {
                    botPos = 5;
                } else if (gameBoard[2][0] == ' ' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
                    botPos = 4;
                } else if (gameBoard[4][0] == 'O' && gameBoard[4][2] == 'O' && gameBoard[4][4] == ' ') {
                    botPos = 9;
                } else if (gameBoard[4][0] == 'O' && gameBoard[4][2] == ' ' && gameBoard[4][4] == 'O') {
                    botPos = 8;
                } else if (gameBoard[4][0] == ' ' && gameBoard[4][2] == 'O' && gameBoard[4][4] == 'O') {
                    botPos = 7;
                } else if (gameBoard[0][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][4] == ' ') {
                    botPos = 9;
                } else if (gameBoard[0][0] == 'O' && gameBoard[2][2] == ' ' && gameBoard[4][4] == 'O') {
                    botPos = 5;
                } else if (gameBoard[0][0] == ' ' && gameBoard[2][2] == 'O' && gameBoard[4][4] == 'O') {
                    botPos = 1;
                } else if (gameBoard[0][4] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][0] == ' ') {
                    botPos = 7;
                } else if (gameBoard[0][4] == 'O' && gameBoard[2][2] == ' ' && gameBoard[4][0] == 'O') {
                    botPos = 5;
                } else if (gameBoard[0][4] == ' ' && gameBoard[2][2] == 'O' && gameBoard[4][0] == 'O') {
                    botPos = 3;
                } else if (gameBoard[0][0] == 'O' && gameBoard[2][0] == 'O' && gameBoard[4][0] == ' ') {
                    botPos = 7;
                } else if (gameBoard[0][0] == 'O' && gameBoard[2][0] == ' ' && gameBoard[4][0] == 'O') {
                    botPos = 4;
                } else if (gameBoard[0][0] == ' ' && gameBoard[2][0] == 'O' && gameBoard[4][0] == 'O') {
                    botPos = 1;
                } else if (gameBoard[0][2] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][2] == ' ') {
                    botPos = 8;
                } else if (gameBoard[0][2] == 'O' && gameBoard[2][2] == ' ' && gameBoard[4][2] == 'O') {
                    botPos = 5;
                } else if (gameBoard[0][2] == ' ' && gameBoard[2][2] == 'O' && gameBoard[4][2] == 'O') {
                    botPos = 2;
                } else if (gameBoard[0][4] == 'O' && gameBoard[2][4] == 'O' && gameBoard[4][4] == ' ') {
                    botPos = 9;
                } else if (gameBoard[0][4] == 'O' && gameBoard[2][4] == ' ' && gameBoard[4][4] == 'O') {
                    botPos = 6;
                } else if (gameBoard[0][4] == ' ' && gameBoard[2][4] == 'O' && gameBoard[4][4] == 'O') {
                    botPos = 3;
                }

                // If the bot cannot find any way to win, it will be a defence against player win placement.

                else if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == ' ') {
                    botPos = 3;
                } else if (gameBoard[0][0] == 'X' && gameBoard[0][2] == ' ' && gameBoard[0][4] == 'X') {
                    botPos = 2;
                } else if (gameBoard[0][0] == ' ' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
                    botPos = 1;
                } else if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == ' ') {
                    botPos = 6;
                } else if (gameBoard[2][0] == 'X' && gameBoard[2][2] == ' ' && gameBoard[2][4] == 'X') {
                    botPos = 5;
                } else if (gameBoard[2][0] == ' ' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
                    botPos = 4;
                } else if (gameBoard[4][0] == 'X' && gameBoard[4][2] == 'X' && gameBoard[4][4] == ' ') {
                    botPos = 9;
                } else if (gameBoard[4][0] == 'X' && gameBoard[4][2] == ' ' && gameBoard[4][4] == 'X') {
                    botPos = 8;
                } else if (gameBoard[4][0] == ' ' && gameBoard[4][2] == 'X' && gameBoard[4][4] == 'X') {
                    botPos = 7;
                } else if (gameBoard[0][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][4] == ' ') {
                    botPos = 9;
                } else if (gameBoard[0][0] == 'X' && gameBoard[2][2] == ' ' && gameBoard[4][4] == 'X') {
                    botPos = 5;
                } else if (gameBoard[0][0] == ' ' && gameBoard[2][2] == 'X' && gameBoard[4][4] == 'X') {
                    botPos = 1;
                } else if (gameBoard[0][4] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][0] == ' ') {
                    botPos = 7;
                } else if (gameBoard[0][4] == 'X' && gameBoard[2][2] == ' ' && gameBoard[4][0] == 'X') {
                    botPos = 5;
                } else if (gameBoard[0][4] == ' ' && gameBoard[2][2] == 'X' && gameBoard[4][0] == 'X') {
                    botPos = 3;
                } else if (gameBoard[0][0] == 'X' && gameBoard[2][0] == 'X' && gameBoard[4][0] == ' ') {
                    botPos = 7;
                } else if (gameBoard[0][0] == 'X' && gameBoard[2][0] == ' ' && gameBoard[4][0] == 'X') {
                    botPos = 4;
                } else if (gameBoard[0][0] == ' ' && gameBoard[2][0] == 'X' && gameBoard[4][0] == 'X') {
                    botPos = 1;
                } else if (gameBoard[0][2] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][2] == ' ') {
                    botPos = 8;
                } else if (gameBoard[0][2] == 'X' && gameBoard[2][2] == ' ' && gameBoard[4][2] == 'X') {
                    botPos = 5;
                } else if (gameBoard[0][2] == ' ' && gameBoard[2][2] == 'X' && gameBoard[4][2] == 'X') {
                    botPos = 2;
                } else if (gameBoard[0][4] == 'X' && gameBoard[2][4] == 'X' && gameBoard[4][4] == ' ') {
                    botPos = 9;
                } else if (gameBoard[0][4] == 'X' && gameBoard[2][4] == ' ' && gameBoard[4][4] == 'X') {
                    botPos = 6;
                } else if (gameBoard[0][4] == ' ' && gameBoard[2][4] == 'X' && gameBoard[4][4] == 'X') {
                    botPos = 3;
                }
            }


            // Same for bot placement like player placement storing.
            placePiece(gameBoard, botPos, "bot");

            // Print game board
            printGameBoard(gameBoard);

            // Check result , If find any solution then here the end for this match.
            result = checkWinner();

            if (result.length() > 0) {
                System.out.println("\n" + result);
                break;
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        // 'printGameBoard' method is only for print current game board with all placement user symbol.
        for(char[] row : gameBoard) {
            // its takes one by one row and print the row's each elements.
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        // This method for place the position in game board for user(player/bot) placement.
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(pos);

        }else if(user.equals("bot")){
            symbol = 'O';
            botPositions.add(pos);
        }

        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner() {

        // 'checkWinner' method is check for which situation a user can win.
        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> botRow = Arrays.asList(7,8,9);

        List<Integer> leftCol = Arrays.asList(1,4,7);
        List<Integer> midCol = Arrays.asList(2,5,8);
        List<Integer> rightCol = Arrays.asList(3,6,9);

        List<Integer> crossLeftRight = Arrays.asList(1,5,9);
        List<Integer> crossRightLeft = Arrays.asList(3,5,7);

        // winning is create as ArrayList , it is created with all the winning condition.
        List<List<Integer>> winning = new ArrayList<>();

        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);

        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);

        winning.add(crossLeftRight);
        winning.add(crossRightLeft);


        // if any user position contains any winning condition. then he is winner. Or the match is draw.
        for(List<Integer> w: winning) {
            if(playerPositions.containsAll(w)) {
                return "Congratulations you won! :)";
            } else if (botPositions.containsAll(w)) {
                return "Bot wins! You loss :(";
            } else if (playerPositions.size() + botPositions.size() == 9) {
                return "Draw!";
            }
        }
        return "";
    }
}