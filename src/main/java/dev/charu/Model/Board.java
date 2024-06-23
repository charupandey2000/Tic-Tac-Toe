package dev.charu.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<List<boardCell>>board=new ArrayList<>();

    public Board(int size){
        //List<boardCell>list= Collections.nCopies(size,new boardCell());
        //List<List<boardCell>>board=Collections.nCopies(size,list);
        for(int i=0;i<size;i++){
            List<boardCell>boardCells=new ArrayList<>();
            for(int j=0;j<size;j++){
                boardCells.add(new boardCell(i,j));
            }
            board.add(boardCells);
        }

    }

    public List<List<boardCell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<boardCell>> board) {
        this.board = board;
    }

    public void displayBoard(){
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board.size(); ++j) {
                Player player = board.get(i).get(j).getPlayer();

                if (player == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + player.getSymbol() + " | ");
                }
            }
            System.out.print("\n");
        }

    }
    public void update(boardCell boardCell){
       board.get(boardCell.getRow()).get(boardCell.getCol()).setPlayer(boardCell.getPlayer());

    }

    public List<boardCell> getAvailablecell(){
        List<boardCell>ans=new ArrayList<>();
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board.size();j++){
                if(board.get(i).get(j).getPlayer()==null){
                    ans.add(board.get(i).get(j));
                }
            }
        }
        return ans;
    }
}
