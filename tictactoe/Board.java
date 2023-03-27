package tictactoe;

public class Board {
  Board() {
    this.squares = new Square[3][3];
    this.columns = new String[] { "A", "B", "C" };
    this.rows = new String[] { "1", "2", "3" };
  }

  private Square[][] squares;
  private String[] columns;
  private String[] rows;

  public Square[][] getSquares() {
    return squares;
  }

  public void setSquares(Square[][] squares) {
    this.squares = squares;
  }

  public String[] getColumns() {
    return this.columns;
  }

  public void setColumns(String[] columns) {
    this.columns = columns;
  }

  public String[] getRows() {
    return this.rows;
  }

  public void setRows(String[] rows) {
    this.rows = rows;
  }

  public void createBoard() {
    try {
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
      System.out.println("   " + this.columns[0] + "   " + this.columns[1] + "   " + this.columns[2]);
      for (int i = 0; i < 3; i++) {
        System.out.print(this.rows[i] + "  ");
        for (int j = 0; j < 3; j++) {
          System.out.print(j != 2 ? this.squares[i][j].getShape() + " | " : this.squares[i][j].getShape() + "\n");
        }
        System.out.print(i != 2 ? "  -----------\n" : "");
      }
    } catch (Exception e) {
      System.out.println("We found a problem showing the board!" + e);
    }
  }

  public Boolean setMove(int column, int row, String shape) {
    try {
      Square newSquare = this.squares[row][column];

      if (newSquare.isFilled()) {
        System.out.println("This space is already filled!");
        return false;
      }

      newSquare.setFilled(true);
      newSquare.setShape(shape);

      this.squares[row][column] = newSquare;

      this.showBoard();

      return true;
    } catch (Exception e) {
      System.out.println("We found a problem setting the move!" + e);
      return false;
    }
  }

  public int checkBoard() {
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
