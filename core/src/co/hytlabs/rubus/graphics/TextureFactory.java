package co.hytlabs.rubus.graphics;

import co.hytlabs.rubus.Rubus;
import co.hytlabs.rubus.map.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: Creates texture regions from a sprite sheet.
 */

public class TextureFactory {

    public static TextureRegion[][] buildRegions(Texture texture, int width, int height, int xOffset, int yOffset) {
        TextureRegion[][] regions = new TextureRegion[256][256];
        int regionsX = texture.getWidth() / width;
        int regionsY = texture.getHeight() / height;
        for (int x = xOffset; x < regionsX; x++) {
            for (int y = yOffset; y < regionsY; y++) {
                regions[x][y] = new TextureRegion(texture, x * width, y * height, width, height);
            }
        }
        return regions;
    }

    public static TextureRegion[][] buildRegions(Texture texture, int width, int height) {
        return TextureFactory.buildRegions(texture, width, height, 0, 0);
    }

    public static HashMap<List<Tile.Type>, TextureRegion[]> mapTextures(TextureRegion[][] textures) {
        HashMap<List<Tile.Type>, TextureRegion[]> textureMap = new HashMap<List<Tile.Type>, TextureRegion[]>();
        textureMap.put(Arrays.asList(new Tile.Type[] {
                Tile.Type.FLOOR, Tile.Type.FLOOR, Tile.Type.FLOOR,
                Tile.Type.FLOOR, Tile.Type.FLOOR,
                Tile.Type.FLOOR, Tile.Type.FLOOR, Tile.Type.FLOOR
        }), new TextureRegion[] {textures[0][0], textures[1][2], textures[2][2], textures[3][2], textures[4][2]/*, textures[5][2], textures[6][2], textures[7][2], textures[8][2]*/});
        textureMap.put(Arrays.asList(new Tile.Type[] {
                Tile.Type.EMPTY, Tile.Type.EMPTY, Tile.Type.EMPTY,
                Tile.Type.EMPTY, Tile.Type.FLOOR,
                Tile.Type.EMPTY, Tile.Type.FLOOR, Tile.Type.FLOOR
        }), new TextureRegion[] {textures[1][0]});
        textureMap.put(Arrays.asList(new Tile.Type[] {
                Tile.Type.EMPTY, Tile.Type.EMPTY, Tile.Type.EMPTY,
                Tile.Type.FLOOR, Tile.Type.EMPTY,
                Tile.Type.FLOOR, Tile.Type.FLOOR, Tile.Type.EMPTY
        }), new TextureRegion[] {textures[2][0]});
        textureMap.put(Arrays.asList(new Tile.Type[] {
                Tile.Type.EMPTY, Tile.Type.FLOOR, Tile.Type.FLOOR,
                Tile.Type.EMPTY, Tile.Type.FLOOR,
                Tile.Type.EMPTY, Tile.Type.EMPTY, Tile.Type.EMPTY
        }), new TextureRegion[] {textures[3][0]});
        textureMap.put(Arrays.asList(new Tile.Type[] {
                Tile.Type.FLOOR, Tile.Type.FLOOR, Tile.Type.EMPTY,
                Tile.Type.FLOOR, Tile.Type.EMPTY,
                Tile.Type.EMPTY, Tile.Type.EMPTY, Tile.Type.EMPTY
        }), new TextureRegion[] {textures[4][0]});
        textureMap.put(Arrays.asList(new Tile.Type[] {
                Tile.Type.EMPTY, Tile.Type.FLOOR, Tile.Type.FLOOR,
                Tile.Type.EMPTY, Tile.Type.FLOOR,
                Tile.Type.EMPTY, Tile.Type.FLOOR, Tile.Type.FLOOR
        }), new TextureRegion[] {textures[5][0], textures[6][0], textures[7][0]});
        textureMap.put(Arrays.asList(new Tile.Type[] {
                Tile.Type.EMPTY, Tile.Type.EMPTY, Tile.Type.EMPTY,
                Tile.Type.FLOOR, Tile.Type.FLOOR,
                Tile.Type.FLOOR, Tile.Type.FLOOR, Tile.Type.FLOOR
        }), new TextureRegion[] {textures[8][0], textures[9][0], textures[10][0]});
        textureMap.put(Arrays.asList(new Tile.Type[] {
                Tile.Type.FLOOR, Tile.Type.FLOOR, Tile.Type.FLOOR,
                Tile.Type.FLOOR, Tile.Type.FLOOR,
                Tile.Type.EMPTY, Tile.Type.EMPTY, Tile.Type.EMPTY
        }), new TextureRegion[] {textures[11][0], textures[12][0], textures[13][0]});
        textureMap.put(Arrays.asList(new Tile.Type[] {
                Tile.Type.FLOOR, Tile.Type.FLOOR, Tile.Type.EMPTY,
                Tile.Type.FLOOR, Tile.Type.EMPTY,
                Tile.Type.FLOOR, Tile.Type.FLOOR, Tile.Type.EMPTY
        }), new TextureRegion[] {textures[14][0], textures[15][0], textures[16][0]});
        return textureMap;
    }

    public static Animation buildAnimation(Texture texture, int width, int height, Animation.Type type, int frames) {
        Animation animation = new Animation(new TextureRegion[] {}, Rubus.ANIMATION_SPEED, type);
        for (int i = 0; i < frames; i++) {
            animation.setFrame(i, new TextureRegion(texture, i * width, type.ordinal() * height, width, height));
        }
        return animation;
    }

    public static HashMap<Animation.Type, Animation> buildAnimations(Texture texture, int width, int height, int frames) {
        HashMap<Animation.Type, Animation> animations = new HashMap<Animation.Type, Animation>();
        for (Animation.Type type : Animation.Type.values()) {
            animations.put(type, TextureFactory.buildAnimation(texture, width, height, type, frames));
        }
        return animations;
    }

}
