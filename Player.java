package tictactoe;

public class Player {
  Player(String name, String shapeChoosed) {
    this.name = name;
    this.shapeChoosed = shapeChoosed;
    this.jogadas = 5;
  }

  private String name;
  private String shapeChoosed;
  private Integer jogadas;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShapeChoosed() {
    return this.shapeChoosed;
  }

  public void setShapeChoosed(String shapeChoosed) {
    this.shapeChoosed = shapeChoosed;
  }

  public Integer getJogadas() {
    return this.jogadas;
  }

  public void setJogadas(Integer jogadas) {
    this.jogadas = jogadas;
  }
}
