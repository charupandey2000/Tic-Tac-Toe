package dev.charu.Model;

public class boardCell {
    int row;
    int col;
    Player player;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boardCell(){

    }
    public boardCell(int row,int col){
        this.row=row;
        this.col=col;
    }
}
