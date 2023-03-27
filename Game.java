package tictactoe;

import java.util.Scanner;

public class Game {

  static Board board = new Board();

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Informe o nome do primeiro jogador: ");
    Player playerOne = new Player(input.next(), "X");

    System.out.println("Informe o nome do segundo jogador: ");
    Player playerTwo = new Player(input.next(), "O");

    board.createBoard();

    makeMove(playerOne, 0, 0);
    makeMove(playerTwo, 1, 0);
    makeMove(playerOne, 0, 1);
    makeMove(playerTwo, 2, 1);
    makeMove(playerOne, 0, 2);

    input.close();

  }

  public static void makeMove(Player player, int column, int row) {
    try {
      if (player.getJogadas() == 0) {
        throw new Exception(player.getName() + ", you don't have more moves");
      }

      board.setMove(column, row, player.getShapeChoosed());

      player.setJogadas(player.getJogadas() - 1);
    } catch (Exception e) {
      System.out.println("Something went wrong!");
    }
  }

}
