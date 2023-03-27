package tictactoe;

public class Square {
  Square(String column, String row) {
    this.column = column;
    this.row = row;
    this.shape = " ";
    this.filled = false;
  }

  private Boolean filled;
  private String shape;
  private String column;
  private String row;

  public Boolean isFilled() {
    return this.filled;
  }

  public void setFilled(Boolean filled) {
    this.filled = filled;
  }

  public String getShape() {
    return shape;
  }

  public void setShape(String shape) {
    this.shape = shape;
  }

  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public String getRow() {
    return row;
  }

  public void setRow(String row) {
    this.row = row;
  }

}
