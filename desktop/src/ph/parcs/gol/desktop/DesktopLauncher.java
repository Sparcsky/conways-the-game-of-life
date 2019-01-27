package ph.parcs.gol.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ph.parcs.gol.Main;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Conway's Game of Life";
        config.width  = 1025;
        config.height = 576;
        new LwjglApplication(new Main(), config);
    }
}
