package ph.parcs.gol;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Cell {

    private int x;
    private int y;
    private int state;

    private Color color;

    public Cell(int state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public void draw(ShapeRenderer renderer) {
        if (isAlive()) color = Color.WHITE;
        else color = Color.DARK_GRAY;

        renderer.setColor(color);
        renderer.rect(x * Const.TILE_SIZE, y * Const.TILE_SIZE, Const.TILE_SIZE - 1, Const.TILE_SIZE - 1);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isDead() {
        return state == 0;
    }

    public boolean isAlive() {
        return state == 1;
    }

}
