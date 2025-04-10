package Strategy.BotPlayingStrategy;

import Models.BotDifficultyLevel;

public class BotPlayingStategyFactory {
    public static BotPlayingStrategy getBotPlayingStategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStragegy();
        }
        if(botDifficultyLevel.equals(BotDifficultyLevel.HARD)){
            return new HardBotPlayingStragegy();
        }
        return null;
    }
}
