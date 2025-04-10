package Models;

import Strategy.BotPlayingStrategy.BotPlayingStategyFactory;
import Strategy.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    //BotPlayingStrategy dependency
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStategyFactory.getBotPlayingStategy(botDifficultyLevel);
    }


    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Cell takeMove(Board board, Player currentPlayer) {
        return botPlayingStrategy.takeMove(board);
    }

}
