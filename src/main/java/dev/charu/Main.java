package dev.charu;

import dev.charu.Model.*;
import dev.charu.Startegy.Bot.randomPlayingStartegy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Game newgame=Game.getbuilder().withplayer(new humanPlayer("charu","charupandey2000",Symbol.X)).withplayer(new botPlayer(Symbol.O,new randomPlayingStartegy())).withsize(3).build();

       while(newgame.getGameStatus()== gameStatus.IN_PROGRESS){
           newgame.makeMove();
           System.out.println("next player");
       }
    }
}