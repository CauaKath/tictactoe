package tictactoe;

import java.util.Scanner;

public class Game {

  static Board board = new Board();
  static Boolean isPlayerOneNextPlayer = true;

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("\nInforme o nome do primeiro jogador: ");
    Player playerOne = new Player(input.next(), "X");

    System.out.println("\nInforme o nome do segundo jogador: ");
    Player playerTwo = new Player(input.next(), "O");

    board.createBoard();

    board.showBoard();

    while (true) {
      if (isPlayerOneNextPlayer) {
        System.out.println("\n" + playerOne.getName() + " is playing with shape: " + playerOne.getShapeChoosed());
      } else {
        System.out.println("\n" + playerTwo.getName() + " is playing with shape: " + playerTwo.getShapeChoosed());
      }

      int columnIndex = 0;
      int rowIndex = 0;

      System.out.println("\nIn what column do you want to play?");
      String column = input.next();

      for (int i = 0; i < board.getColumns().length; i++) {
        if (board.getColumns()[i].equals(column)) {
          columnIndex = i;
          break;
        }
      }

      System.out.println("\nIn what row do you want to play?");
      String row = input.next();

      for (int i = 0; i < board.getRows().length; i++) {
        if (board.getRows()[i].equals(row)) {
          rowIndex = i;
          break;
        }
      }

      if (isPlayerOneNextPlayer) {
        makeMove(playerOne, columnIndex, rowIndex);
      } else {
        makeMove(playerTwo, columnIndex, rowIndex);
      }

      if (playerOne.getMoves() == 0) {
        System.out.println("\nDraw!!");
        break;
      }

      int win = board.checkBoard();

      if (win == 1) {
        System.out.println("\nO jogador " + playerOne.getName() + " ganhou");
        break;
      }

      if (win == -1) {
        System.out.println("\nO jogador " + playerTwo.getName() + " ganhou");
        break;
      }
    }

    input.close();

  }

  private static void makeMove(Player player, int column, int row) {
    try {
      if (player.getMoves() == 0) {
        throw new Exception(player.getName() + ", you don't have more moves");
      }

      Boolean hasPlayed = board.setMove(column, row, player.getShapeChoosed());

      if (hasPlayed) {
        isPlayerOneNextPlayer = !isPlayerOneNextPlayer;
        player.setMoves(player.getMoves() - 1);
      }
    } catch (Exception e) {
      System.out.println("Something went wrong!");
    }
  }

}
