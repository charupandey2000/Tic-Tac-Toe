package dev.charu.Model;

public abstract class Player {
  private Symbol symbol;

  public abstract boardCell makeMove(Board board);

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Player(Symbol symbol) {
       this.symbol=symbol;
    }
}
