
package csc223.vn;

import java.util.Scanner; // takes user input for guessing letters in WordGuess
import java.util.Random; // Randomly selects a word in WordGuess

public class WordGuess implements Game {
    private String word;
    private char[] guessedWord;
    private int turns;
    private Scanner scanner;

    public WordGuess() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        int wordLength = random.nextInt(3) + 3;
        StringBuilder randomWord = new StringBuilder();
        for(int i = 0; i < wordLength; i++) {
            randomWord.append(alphabet.charAt(random.nextInt(alphabet.length())));

        }
        word = randomWord.toString();
        guessedWord = new char[word.length()];
        for(int i = 0; i < guessedWord.length; i++) guessedWord[i] = '_';
        turns = word.length() + 3;
        scanner = new Scanner(System.in);
    }
    public void startGame() {
        System.out.println("Please start Word Guess!");
    }
    public void printBoard() {
        System.out.println("Word: " + new String(guessedWord));
    }
    public void takeTurn() {
        System.out.println("Guess a letter: ");
        char guess = scanner.next().charAt(0);
        boolean found = false;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == guess) {
                guessedWord[i] = guess;
                found = true;
            }
        }
        if(!found) System.out.println("Wrong guess");
        turns--;
    }
    public boolean isGameOver() {
        return turns <= 0 || word.equals(new String(guessedWord));
    }
    public void endGame() {
        if(word.equals(new String(guessedWord))) {
            System.out.println("Congratulations, You guessed right");
        } else {
            System.out.println("Game is Over, The Word was: " + word);
        }
    }
    public void playGame() {
        startGame();
        while(!isGameOver()) {
            printBoard();
            takeTurn();
        }
        endGame();
    }
    public static void main(String[] args) {
        WordGuess game = new WordGuess();
        game.playGame();
    }
}