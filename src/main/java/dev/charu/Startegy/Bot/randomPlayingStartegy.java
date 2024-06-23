package dev.charu.Startegy.Bot;

import dev.charu.Model.Board;
import dev.charu.Model.boardCell;

import java.util.List;

public class randomPlayingStartegy implements BotPlayinngStartegy{
    @Override
    public boardCell makemove(Board board) {

        List<boardCell>emptyCell=board.getAvailablecell();
        int no= (int) (Math.random() * emptyCell.size());
        return emptyCell.get(no);
    }
}
