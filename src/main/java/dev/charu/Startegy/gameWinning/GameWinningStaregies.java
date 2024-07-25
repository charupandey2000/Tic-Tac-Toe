package dev.charu.Startegy.gameWinning;

import dev.charu.Model.Board;
import dev.charu.Model.Symbol;

public interface GameWinningStaregies {
    public boolean checkWinner(Board board, int i, int j, Symbol symbol);
}
