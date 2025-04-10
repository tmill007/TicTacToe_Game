package Models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellStatus cellStatus;

    public Cell(int i, int j) {
        this.row = i;
        this.col = j;
        this.player = null;
        this.cellStatus = CellStatus.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }


    public void display() {
        if(this.player == null){
            System.out.print("| - |");
        }else{
            System.out.print("| " + this.player.getSymbol().toString() + " |");
        }
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", player=" + player +
                ", cellStatus=" + cellStatus +
                '}';
    }
}
