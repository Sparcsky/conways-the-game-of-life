package ph.parcs.gol;

public class CellFactory {

    public static Cell[][] create(int col, int row) {
        Cell[][] cells = new Cell[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                cells[i][j] = new Cell(0, j, i);
            }
        }
        return cells;
    }

}
