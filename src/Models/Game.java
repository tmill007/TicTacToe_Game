package Models;

import Exceptions.InvalidBotCountException;
import Exceptions.PlayerSizeInvalidException;
import Strategy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private int nextPlayerTurn;
    private List<Cell> moves;
    private List<WinningStrategy> winningStrategies;
    private GameStatus gameStatus;

    //Implementing Builder Pattern - uses a private constructor, static getBuilder method and inner static Builder class

    private  Game(int boardDimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(boardDimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.winner = null;
        this.nextPlayerTurn = 0; //uses the index of the player
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) { this.board = board; }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerTurn() {
        return nextPlayerTurn;
    }

    public void setNextPlayerTurn(int nextPlayerTurn) {
        this.nextPlayerTurn = nextPlayerTurn;
    }

    public List<Cell> getMoves() {
        return moves;
    }

    public void setMoves(List<Cell> moves) {
        this.moves = moves;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }


    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    //TODO - implement TAKEMOVE in GAME MODEL
    public void takeMove(Game game) {
        Player currentPlayer = players.get(nextPlayerTurn);
        Cell cell = currentPlayer.takeMove(game.board, currentPlayer);
        //Update Grid and Moves table
        if(cell == null){
            System.out.println("Invalid Move");
            return;
        }
        cell.setPlayer(currentPlayer);
        cell.setCellStatus(CellStatus.FILLED);
        game.moves.add(cell);
        //TODO other
    }

    //STATIC Game Builder Method
    public static GameBuilder getGameBuilder(){
        return new GameBuilder();
    }


    //STATIC Game Builder inner Class
    public static class GameBuilder{
        public int boardDimension;
        public List<Player> players;
        public List<WinningStrategy> winningStrategies;

        public int getBoardDimension() {
            return boardDimension;
        }

        public GameBuilder setBoardDimension(int boardDimension) {
            this.boardDimension = boardDimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        //Game initialization VALIDATIONS
        public void validate() throws InvalidBotCountException, PlayerSizeInvalidException {
            var botCount = 0;
            for(Player p : players){
                if(p.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }
            if(botCount > 1){
                throw new InvalidBotCountException();
            }
            if(players.size() > boardDimension - 1){
                throw new PlayerSizeInvalidException();
            }
        }

        public Game build() throws InvalidBotCountException, PlayerSizeInvalidException {
            validate();
            return new Game(this.boardDimension, this.players, this.winningStrategies);
        }
    }
}
