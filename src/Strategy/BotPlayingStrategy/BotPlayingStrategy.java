package Strategy.BotPlayingStrategy;

import Models.Board;
import Models.Cell;
import Models.Player;

public interface BotPlayingStrategy {
    public Cell takeMove(Board board);
}
