package ph.parcs.gol;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Board {

    private Cell[][] cells;
    private int row;
    private int col;

    public Board() {
        row = Const.WIDTH / Const.TILE_SIZE;
        col = Const.HEIGHT / Const.TILE_SIZE;

        cells = CellFactory.create(col,row);
    }

    public void display(ShapeRenderer renderer) {
        for (int y = 0; y < col; y++) {
            for (int x = 0; x < row; x++) {
                Cell cell = cells[y][x];
                cell.draw(renderer);
            }
        }
    }

    public int getColumn() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Cell getCell(int y, int x) {
        return cells[y][x];
    }

    public Cell[][] getCells() {
        return cells;
    }
}
