package dev.charu.Model;

import dev.charu.Exceptions.InvalidMoveException;
import dev.charu.Exceptions.InvalidPlayerException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player>players=new ArrayList<>();
    private gameStatus gameStatus;

    private int nextPlayer;

    public static builder getbuilder(){
        return new builder();
    }


    public static class builder{
        Game game;

        public builder(){
            this.game=new Game();
        }

        public builder withsize(int size){
            this.game.board=new Board(size);
            return this;
        }
        public builder withplayer(Player player){
            this.game.players.add(player);
            return this;
        }


        public Game build() throws InvalidPlayerException{
            boolean valid=validate();
            if(valid==false){
                throw new InvalidPlayerException("Condition not satisfy");
            }

            Game game=new Game();
            game.players=this.game.players;
            game.board=this.game.board;
            game.gameStatus= dev.charu.Model.gameStatus.IN_PROGRESS;
            return game;

        }

        private boolean validate(){
            List<Player>players1=game.players;
            if(players1.size()!=2){
                return false;
            }
            Set<Symbol>symbolSet=new HashSet<>();
            for(int i=0;i<players1.size();i++){
                Symbol s=players1.get(i).getSymbol();
                symbolSet.add(s);
            }
            if(symbolSet.size()!=players1.size()){
                return false;
            }
            return true;
        }

    }

//    public Game Create(int size,List<Player>playersList){
//        Game game=Game.getbuilder().withsize(size).withplayer(playersList.get(0)).withplayer(playersList.get(1)).build();
//        return game;
//    }

    public void start(){
        gameStatus= dev.charu.Model.gameStatus.IN_PROGRESS;
        nextPlayer= (int) (Math.random()*2);

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public dev.charu.Model.gameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(dev.charu.Model.gameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(int nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public void makeMove(){
        Player player=players.get(nextPlayer);
        boardCell boardCell=player.makeMove(board);
        boolean valid=vaidatemove(boardCell);
        if(!valid){
            throw new InvalidMoveException("this move is not valid");
        }


        board.update(boardCell);

        nextPlayer=(nextPlayer+1)%2;
        board.displayBoard();

    }
    public boolean vaidatemove(boardCell boardCell){
        boardCell boardCell1=board.getBoard().get(boardCell.getRow()).get(boardCell.getCol());
        return boardCell1.getPlayer() == null;
    }



    public void displayboard(){
        board.displayBoard();
    }




}
