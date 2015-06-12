package co.hytlabs.rubus.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import co.hytlabs.rubus.Rubus;

public class RubusLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//fwvga
		config.width = 854;
		config.height = 480;
		if (args.length > 0 && args[0].equalsIgnoreCase("vga")) {
			config.width = 640;
		}
		else if (args.length > 0 && args[0].equalsIgnoreCase("wvga")) {
			config.width = 768;
		}
		new LwjglApplication(new Rubus(config.width, config.height), config);
	}
}
