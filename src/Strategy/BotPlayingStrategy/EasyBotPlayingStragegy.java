package Strategy.BotPlayingStrategy;

import Models.Board;
import Models.Cell;
import Models.CellStatus;
import Models.Player;

import java.util.List;

public class EasyBotPlayingStragegy implements BotPlayingStrategy {
    @Override
    public Cell takeMove(Board board) {
        for(List<Cell> row: board.getGrid()){
            for(Cell cell : row){
                if(cell.getCellStatus().equals(CellStatus.EMPTY)){
                    return cell;
                }
            }
        }
        return null;
    }
}
