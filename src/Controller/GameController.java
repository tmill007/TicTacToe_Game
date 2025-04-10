package Controller;

import Exceptions.InvalidBotCountException;
import Exceptions.PlayerSizeInvalidException;
import Models.Game;
import Models.Player;
import Strategy.WinningStrategy.WinningStrategy;
import java.util.List;

public class GameController {
    public Game startGame(int boardDimension, List<Player> players, List<WinningStrategy> winningStrategies) throws InvalidBotCountException, PlayerSizeInvalidException {
        return Game.getGameBuilder().setBoardDimension(boardDimension)
                                    .setPlayers(players)
                                    .setWinningStrategies(winningStrategies)
                                    .build();

    }

    public void displayBoard(Game game) {
        game.getBoard().printBoard();
    }


    public void takeMove(Game game) {
        //TODO - implement take move in Game Controller
        game.takeMove(game);
    }
}
