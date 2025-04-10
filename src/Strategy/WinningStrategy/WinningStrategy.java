package Strategy.WinningStrategy;

import Models.Board;
import Models.Cell;

public interface WinningStrategy {
    public boolean checkWinner(Cell cell, Board board);
}
