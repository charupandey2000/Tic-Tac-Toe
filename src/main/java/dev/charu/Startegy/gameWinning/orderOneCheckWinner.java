package dev.charu.Startegy.gameWinning;

import dev.charu.Model.Board;
import dev.charu.Model.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class orderOneCheckWinner implements GameWinningStaregies{
    private List<HashMap<Symbol,Integer>>row=new ArrayList<>();
    private List<HashMap<Symbol,Integer>>col=new ArrayList<>();
    private HashMap<Symbol,Integer>digonal=new HashMap<>();
    private HashMap<Symbol,Integer>antidigonal=new HashMap<>();

    public  orderOneCheckWinner(int dim){
        for(int i=0;i<dim;i++){
            row.add(new HashMap<>());
            col.add(new HashMap<>());

        }

    }
    @Override
    public boolean checkWinner(Board board, int i, int j,Symbol symbol) {

        int n=board.getBoard().size();
        if(!row.get(i).containsKey(symbol)){
            row.get(i).put(symbol,0);
        }

        row.get(i).put(symbol,row.get(i).get(symbol)+1);

        if(!col.get(j).containsKey(symbol)){
            col.get(j).put(symbol,0);
        }


        col.get(j).put(symbol,col.get(j).get(symbol)+1);


        if(i==j) {
            if (!digonal.containsKey(symbol)) {
                digonal.put(symbol, 0);
            }

            digonal.put(symbol,digonal.get(symbol)+1);

        }
         if((i+j+1)==n){
            if(!antidigonal.containsKey(symbol)){
                antidigonal.put(symbol,0);
            }
            antidigonal.put(symbol,antidigonal.get(symbol)+1);


        }

        if(row.get(i).get(symbol)==n || col.get(j).get(symbol)==n){
            return true;
        }

        if(i==j && digonal.get(symbol)==n){
            return true;
        }
        if(i+j==n-1 && antidigonal.get(symbol)==n){
            return true;
        }
        return false;
    }
}
