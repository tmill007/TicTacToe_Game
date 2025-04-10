package Models;


import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Boolean validateInput(int row, int col){
        //TODO - implement validations (if row is in range, col in range etc)
        return true;
    }

    public Cell takeMove(Board board, Player currentPlayer) {
        System.out.println("Player: " + currentPlayer.getName().toUpperCase());
        System.out.println("Select a ROW:");
        int row = scanner.nextInt();
        System.out.println("Select a COLUMN:");
        int col = scanner.nextInt();
        //validating input
        if(!validateInput(row, col)){
            System.out.println("Invalid Input");
            return null;
        }
        return board.getGrid().get(row).get(col);
    }
}
