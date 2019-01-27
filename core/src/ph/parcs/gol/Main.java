package ph.parcs.gol;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Main extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private GameOfLife gol;
    private BitmapFont font;

    private float timeSeconds;
    private float delayTime;

    private boolean play;

    @Override
    public void create() {
        camera = new OrthographicCamera(Const.WIDTH, Const.HEIGHT);
        camera.setToOrtho(true, Const.WIDTH, Const.HEIGHT);

        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        gol = new GameOfLife();
        font = new BitmapFont();
        delayTime = .5f;
    }


    @Override
    public void render() {
        clearScreen();

        shapeRenderer.setProjectionMatrix(camera.combined);

        int mouseX = Gdx.input.getX() / Const.TILE_SIZE;
        int mouseY = Gdx.input.getY() / Const.TILE_SIZE;

        if (Gdx.input.isTouched()) gol.setCellState(mouseX, mouseY);
        if (Gdx.input.isKeyJustPressed(Input.Keys.E)) delayTime += .01f;
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) delayTime -= .01f;
        if (Gdx.input.isKeyJustPressed(Input.Keys.R))    gol = new GameOfLife();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) play = !play;


        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if (play) {
            if (timeSeconds > delayTime) {
                timeSeconds = 0;
                gol.update();
            }
        }

        gol.draw(shapeRenderer);
        shapeRenderer.end();

        batch.begin();
        font.draw(batch,"Speed: " + delayTime,16, Const.HEIGHT - 16);
        font.draw(batch,"Speed: " + delayTime,16, Const.HEIGHT - 16);

        batch.end();
    }


    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
    }
}
