import Controller.GameController;
import Exceptions.InvalidBotCountException;
import Exceptions.PlayerSizeInvalidException;
import Models.*;
import Strategy.WinningStrategy.ColumnWinningStrategy;
import Strategy.WinningStrategy.DiagonalWinningStrategy;
import Strategy.WinningStrategy.RowWinningStrategy;
import Strategy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, PlayerSizeInvalidException {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        //Create new players List
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Tony", new Symbol('X'), PlayerType.HUMAN));
        players.add(new Player(2, "BOT", new Symbol('O'), PlayerType.BOT));

        //Create Winning Strategy List
        List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(),new ColumnWinningStrategy(),
                                                          new DiagonalWinningStrategy());


        Game game1 = gameController.startGame(3, players, winningStrategies);

        gameController.displayBoard(game1);

        while(game1.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            gameController.takeMove(game1);
            gameController.displayBoard(game1);
        }
        if(game1.getGameStatus().equals(GameStatus.SUCCESS)){
            System.out.println("WINNER is: " + game1.getWinner().getName());
        }
        else if(game1.getGameStatus().equals(GameStatus.DRAW)){
            System.out.println("DRAW : Game ended with a draw...");
        }

    }
}
