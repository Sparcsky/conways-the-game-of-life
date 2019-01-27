package ph.parcs.gol;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameOfLife {

    private Board board;

    public GameOfLife() {
        board = new Board();
    }

    public void setCellState(int x, int y) {
        Cell cell = board.getCell(y, x);
        if (cell.isAlive()) cell.setState(0);
        else cell.setState(1);
    }

    public void update() {
        Board nextBoard = new Board();

        for (int i = 0; i < board.getColumn(); i++) {
            for (int j = 0; j < board.getRow(); j++) {
                Cell currentCell = board.getCell(i, j);
                Cell nextCell = nextBoard.getCell(i, j);

                int neighbors = checkNeighbors(currentCell);

                if (currentCell.isAlive() && (neighbors < 2 || neighbors > 3)) nextCell.setState(0);
                else if (currentCell.isDead() && neighbors == 3) nextCell.setState(1);
                else nextCell.setState(currentCell.getState());
            }
        }
        board = nextBoard;
    }

    private int checkNeighbors(Cell cell) {
        int neighborsCount = 0;
        for (int y = cell.getY() - 1; y <= cell.getY() + 1; y++) {
            for (int x = cell.getX() - 1; x <= cell.getX() + 1; x++) {
                int yChecker = y;
                int xChecker = x;
                if (xChecker == cell.getX() && yChecker == cell.getY()) continue;

                if (xChecker < 0) xChecker = board.getRow() - 1;
                if (xChecker > board.getRow() - 1) xChecker = 0;
                if (yChecker < 0) yChecker = board.getColumn() - 1;
                if (yChecker > board.getColumn() - 1) yChecker = 0;

                Cell neighbor = board.getCell(yChecker, xChecker);
                if (neighbor.isAlive()) neighborsCount++;
            }
        }
        return neighborsCount;
    }

    public void draw(ShapeRenderer renderer) {
        board.display(renderer);
    }
}
