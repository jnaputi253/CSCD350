/**
 * Created by jnaputi253 on 3/30/16.
 */

import java.util.*;
import java.io.*;

public class Test {
    static int currentRow = 1;

    public static void main(String[] args) {
        if(args.length > 0) {
            int rowLength = 0;
            int columnLength = 0;
            String[][] gameBoard = null;

            try {
                Scanner kb = new Scanner(new File(args[0]));

                while(kb.hasNextLine()) {
                    if(kb.hasNextInt()) {
                        rowLength = kb.nextInt();
                        columnLength = kb.nextInt();

                        if(rowLength == 0 || columnLength == 0) {
                            break;
                        }

                    } else {
                        gameBoard = new String[rowLength + 2][columnLength + 2];
                        insertInitialPieces(gameBoard);
                        while(kb.hasNext() && !kb.hasNextInt()) {
                            String line = kb.next();
                            String[] items = line.split("");
                            loadData(gameBoard, items);
                        }

                        convertData(gameBoard);
                        printInfo(gameBoard);
                        space();
                        gameBoard = null;
                    }
                }
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void insertInitialPieces(String[][] gameBoard) {
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ".";
            }
        }
    }

    private static void printInfo(String[][] gameBoard) {
        for(int i = 1; i < gameBoard.length - 1; i++) {
            for(int j = 1; j < gameBoard[i].length - 1; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    private static void loadData(String[][] gameBoard, String[] data) {
        for(int i = 1; i < gameBoard.length - 1; i++) {
            gameBoard[currentRow][i] = data[i - 1];
        }

        currentRow++;
    }

    private static void convertData(String[][] gameBoard) {
        int mineCount = 0;

        for(int i = 1; i < gameBoard.length - 1; i++) {
            for(int j = 1; j < gameBoard[i].length - 1; j++) {
                if(gameBoard[i][j].equals("*")) {
                    continue;
                } else if(gameBoard[i][j].equals(".")) {
                    if(gameBoard[i - 1][j].equals("*")) {
                        mineCount++;
                    }

                    if(gameBoard[i + 1][j].equals("*")) {
                        mineCount++;
                    }

                    if(gameBoard[i][j + 1].equals("*")) {
                        mineCount++;
                    }

                    if(gameBoard[i][j - 1].equals("*")) {
                        mineCount++;
                    }

                    if(gameBoard[i - 1][j - 1].equals("*")) {
                        mineCount++;
                    }

                    if(gameBoard[i + 1][j - 1].equals("*")) {
                        mineCount++;
                    }

                    if(gameBoard[i - 1][j + 1].equals("*")) {
                        mineCount++;
                    }

                    if(gameBoard[i + 1][j + 1].equals("*")) {
                        mineCount++;
                    }

                    gameBoard[i][j] = String.valueOf(mineCount);
                    mineCount = 0;
                }
            }
        }
    }

    private static void space() {
        System.out.println();
    }
}
