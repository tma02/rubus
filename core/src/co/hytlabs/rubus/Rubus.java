package co.hytlabs.rubus;

import co.hytlabs.rubus.graphics.RoomView;
import co.hytlabs.rubus.graphics.TextureFactory;
import co.hytlabs.rubus.logic.Affinity;
import co.hytlabs.rubus.map.Dungeon;
import co.hytlabs.rubus.map.RoomLocation;
import co.hytlabs.rubus.map.Tile;
import co.hytlabs.rubus.map.TileLocation;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import co.hytlabs.rubus.logic.Character;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Rubus extends ApplicationAdapter {

	public static Rubus instance;
	public static final float TEXTURE_SCALE = 3.0f;
	private int windowWidth, windowHeight;
	private SpriteBatch batch;
	private Texture dungeonTexture;
	private TextureRegion[][] dungeonTiles;
	private TextureRegion[][] floorTiles;
	private TextureRegion[][] ceilingTiles;
	private HashMap<List<Tile.Type>, TextureRegion[]> floorTextureMap;
	private HashMap<List<Tile.Type>, TextureRegion[]> ceilingTextureMap;
	private Character character;
	private State state;
	private RoomView roomView;

	public Rubus(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}

	@Override
	public void create() {
		Rubus.instance = this;
		this.batch = new SpriteBatch();
		this.loadAssets();
		this.initLogic();

		this.character.setLocation(new TileLocation((byte) 0, (byte) 0, (byte) 0, (short) 0, (short) 0));
		RoomLocation roomLocation = this.character.getLocation().getRoomLocation();
		this.roomView = new RoomView(0, 0, 0, 0, this.character.getDungeon().getFloors()[roomLocation.getFloor()].getRoom(roomLocation.getX(), roomLocation.getY()));
	}

	public void loadAssets() {
		this.dungeonTexture = new Texture(Gdx.files.internal("core/assets/dungeon.png"));
		this.dungeonTiles = TextureFactory.buildRegions(this.dungeonTexture, 16, 16);
		this.ceilingTiles = this.dungeonTiles.clone();
		for (int i = 0; i < this.ceilingTiles.length; i++) {
			this.ceilingTiles[i] = Arrays.copyOfRange(this.ceilingTiles[i], 1, 4);
		}
		this.floorTiles = this.dungeonTiles.clone();
		for (int i = 0; i < this.floorTiles.length; i++) {
			this.floorTiles[i] = Arrays.copyOfRange(this.floorTiles[i], 7, 10);
		}
		this.ceilingTextureMap = TextureFactory.mapTextures(this.ceilingTiles);
		this.floorTextureMap = TextureFactory.mapTextures(this.floorTiles);
	}

	public void initLogic() {
		this.character = new Character(Character.Profession.WARRIOR, Affinity.FORTITUDE);
		this.character.setDungeon(new Dungeon(Dungeon.Difficulty.NORMAL, (byte) 1));
		//this.state = State.MAIN_MENU;
		this.state = State.GAME;
		this.roomView = null;
	}

	public Character getCharacter() {
		return this.character;
	}

	public TextureRegion[][] getDungeonTiles() {
		return this.dungeonTiles;
	}

	public HashMap<List<Tile.Type>, TextureRegion[]> getFloorTextureMap() {
		return this.floorTextureMap;
	}

	public HashMap<List<Tile.Type>, TextureRegion[]> getCeilingTextureMap() {
		return this.ceilingTextureMap;
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, GL20.GL_NEAREST);
		this.batch.begin();
		switch (this.state) {
			case MAIN_MENU:
				break;
			case GAME:
				if (this.roomView != null) {
					this.roomView.render(this.batch);
				}
				//determine game state
				//draw dungeon and static room elements
				//draw objects and dynamic room elements
				//draw entities
				//draw UI
				//draw overlays
				break;
			case GAME_MENU:
				break;
		}
		//this.batch.draw(this.dungeonTiles[0][7], 0, 0, 128, 128);
		this.batch.end();
	}

	public enum State {
		MAIN_MENU,
		GAME,
		GAME_MENU
	}
}
