package top.yukolin;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class MainmenuScreenshotHelper implements ModInitializer {
	public static final String MOD_ID = "mainmenu-screenshot-helper";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(),
			"version-text.txt");
	public static String VERSION_TEXT = "";

	@Override
	public void onInitialize() {
		try {
			if (CONFIG_FILE.exists()) loadConfig();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void loadConfig() throws IOException {
		VERSION_TEXT = FileUtils.readFileToString(CONFIG_FILE, Charset.defaultCharset());
	}
}