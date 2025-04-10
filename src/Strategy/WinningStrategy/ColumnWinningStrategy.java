package Strategy.WinningStrategy;

import Models.Board;
import Models.Cell;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{

    Map<Integer, HashMap<Symbol, Integer>> symbolCountMap = new HashMap<>();

//HashMap to store each Col -> Map{Symbol, Count} : to keep track of the count of each symbol in each Col
// Winning Stategy can be searched in O(1) time
//    |0|->{"x":1, "y":0}
//    |1|->{"x":0, "y":0}
//    |2|->{"x":0, "y":0}


    @Override
    public boolean checkWinner(Cell cell, Board board) {
        int col = cell.getCol();
        Symbol symbol = cell.getPlayer().getSymbol();
        if(!symbolCountMap.containsKey(col)){
            symbolCountMap.put(col, new HashMap<>());
        }
        HashMap<Symbol, Integer> mapValue = symbolCountMap.get(col);
        if(!mapValue.containsKey(symbol)){
            mapValue.put(symbol, 0);
        }
        mapValue.put(symbol, mapValue.get(symbol) + 1);

        return mapValue.get(symbol) == board.getSize();
    }

}
