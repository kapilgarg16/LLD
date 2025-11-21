package com.conceptcoding.interviewquestions.snakeNladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("Player-1", 0);
        Player player2 = new Player("Player-2", 0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);

            //roll the dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("Player turn:" + playerTurn.id + " new Position is: " + playerNewPosition);
            //check for winning condition
            if (playerNewPosition >= board.cells.length * board.cells.length - 1) {
                winner = playerTurn;
            }
        }
        System.out.println("\n===> The Winner is:" + winner.id);
    }


    private Player findPlayerTurn() {
        Player playerTurns = playersList.removeFirst();
        playersList.addLast(playerTurns);
        return playerTurns;
    }

    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > board.cells.length * board.cells.length - 1) {
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if (cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "Ladder" : "Snake";
            System.out.println("[+] Jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
