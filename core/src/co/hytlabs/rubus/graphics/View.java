package co.hytlabs.rubus.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: A view of components that will be rendered on the screen.
 */

public abstract class View {

    private int x, y, width, height;
    private boolean ui;

    public View(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.ui = false;
    }

    public boolean isUi() {
        return this.ui;
    }

    public abstract void render(SpriteBatch batch);

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}
