package dev.charu.Model;

import java.util.Scanner;

public class humanPlayer extends Player {
    private String name;
    private String email;

    @Override
    public boardCell makeMove(Board board) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Give row:");
        int row=scanner.nextInt();
        System.out.println("Give col:");
        int col=scanner.nextInt();
        boardCell boardCell=new boardCell(row,col);
        boardCell.setPlayer(this);
        return boardCell;
    }

    public humanPlayer(String name, String email, Symbol symbol) {
        super(symbol);
        this.name = name;
        this.email = email;
    }
}
