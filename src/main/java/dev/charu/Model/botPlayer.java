package dev.charu.Model;

import dev.charu.Startegy.Bot.BotPlayinngStartegy;

public class botPlayer extends Player {
    private BotPlayinngStartegy botPlayinngStartegy;

    public botPlayer(Symbol symbol,BotPlayinngStartegy botPlayinngStartegy) {
        super(symbol);
        this.botPlayinngStartegy=botPlayinngStartegy;
    }

    @Override
    public boardCell makeMove(Board board) {
        boardCell boardCell=botPlayinngStartegy.makemove(board);
        boardCell demo=new boardCell(boardCell.getRow(),boardCell.getCol());
        demo.setPlayer(this);
        return demo;
    }
}
