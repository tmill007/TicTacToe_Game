package Strategy.WinningStrategy;

import Models.Board;
import Models.Cell;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    Map<Symbol, Integer> symbolCountMapDiagEven = new HashMap<>();
    Map<Symbol, Integer> symbolCountMapDiagBsize = new HashMap<>();

// 2 HashMaps to store each of the Diagonals -> Map{Symbol, Count}
    //Left Diag will have {0,0 | 1,1 | 2,2}
    //Right Diag will always have a (row + col) that equals (board size - 1). ie {2,0 | 1,1 | 0,2}
// Winning Stategy can be searched in O(1) time

    @Override
    public boolean checkWinner(Cell cell, Board board) {
        int row = cell.getRow();
        int col = cell.getCol();
        Symbol symbol = cell.getPlayer().getSymbol();

        if(row == col){
            if(!symbolCountMapDiagEven.containsKey(symbol)){
                symbolCountMapDiagEven.put(symbol, 0);
            }
            symbolCountMapDiagEven.put(symbol, symbolCountMapDiagEven.get(symbol) + 1);
            if(symbolCountMapDiagEven.get(symbol) == board.getSize()){
                return true;
            }
        } else if (row + col == board.getSize() - 1) {
            if(!symbolCountMapDiagBsize.containsKey(symbol)){
                symbolCountMapDiagBsize.put(symbol, 0);
            }
            symbolCountMapDiagBsize.put(symbol, symbolCountMapDiagBsize.get(symbol) + 1);
            if(symbolCountMapDiagBsize.get(symbol) == board.getSize()){
                return true;
            }
        }
        return false;
    }

}
