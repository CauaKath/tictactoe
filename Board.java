package tictactoe;

public class Board {
  Board() {
    this.squares = new Square[3][3];
  }

  private Square[][] squares;

  public Square[][] getSquares() {
    return squares;
  }

  public void setSquares(Square[][] squares) {
    this.squares = squares;
  }

  public void createBoard() {
    try {
      String[] columns = { "A", "B", "C" };
      String[] rows = { "1", "2", "3" };

      for (int i = 0; i < rows.length; i++) {
        for (int j = 0; j < columns.length; j++) {
          Square square = new Square(columns[j], rows[i]);

          this.squares[i][j] = square;
        }
      }
    } catch (Exception e) {
      System.out.println("We found a problem creating the board!" + e);
    }
  }

  public void showBoard() {
    try {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          System.out.print(j != 2 ? this.squares[i][j].getShape() + " | " : this.squares[i][j].getShape() + "\n");
        }
        System.out.print(i != 2 ? "----------\n" : "");
      }
    } catch (Exception e) {
      System.out.println("We found a problem showing the board!" + e);
    }
  }

  public void setMove(int column, int row, String shape) {
    try {
      Square newSquare = this.squares[column][row];

      if (newSquare.isFilled()) {
        System.out.println("This space is already filled!");
        return;
      }

      newSquare.setFilled(true);
      newSquare.setShape(shape);

      this.squares[column][row] = newSquare;

      this.showBoard();

      int win = this.checkBoard();

      if (win == 1)
        System.out.println("\nO jogador 1 ganhou");
      if (win == -1)
        System.out.println("\nO jogador 2 ganhou");
    } catch (Exception e) {
      System.out.println("We found a problem showing the board!" + e);
    }
  }

  private int checkBoard() {
    if (this.checkRows() == 1)
      return 1;
    if (this.checkColumns() == 1)
      return 1;
    if (this.checkDiagonals() == 1)
      return 1;

    if (this.checkRows() == -1)
      return -1;
    if (this.checkColumns() == -1)
      return -1;
    if (this.checkDiagonals() == -1)
      return -1;

    return 0;
  }

  private int checkRows() {
    for (int row = 0; row < 3; row++) {
      if ((this.squares[row][0].getShape() == "O" && this.squares[row][1].getShape() == "O"
          && this.squares[row][2].getShape() == "O"))
        return -1;
      if ((this.squares[row][0].getShape() == "X" && this.squares[row][1].getShape() == "X"
          && this.squares[row][2].getShape() == "X"))
        return 1;
    }

    return 0;
  }

  private int checkColumns() {
    for (int column = 0; column < 3; column++) {
      if ((this.squares[0][column].getShape() == "O" && this.squares[1][column].getShape() == "O"
          && this.squares[2][column].getShape() == "O"))
        return -1;
      if ((this.squares[0][column].getShape() == "X" && this.squares[1][column].getShape() == "X"
          && this.squares[2][column].getShape() == "X"))
        return 1;
    }

    return 0;
  }

  private int checkDiagonals() {
    if ((this.squares[0][0].getShape() == "O" && this.squares[1][1].getShape() == "O"
        && this.squares[2][2].getShape() == "O"))
      return -1;
    if ((this.squares[0][0].getShape() == "X" && this.squares[1][1].getShape() == "X"
        && this.squares[2][2].getShape() == "X"))
      return 1;
    if ((this.squares[0][2].getShape() == "O" && this.squares[1][1].getShape() == "O"
        && this.squares[2][0].getShape() == "O"))
      return -1;
    if ((this.squares[0][2].getShape() == "X" && this.squares[1][1].getShape() == "X"
        && this.squares[2][0].getShape() == "X"))
      return 1;

    return 0;
  }
}
