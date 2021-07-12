package ik.wuksowik.mop.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import ik.wuksowik.mop.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BungeeConfiguration {

    private static File selectorFile;
    private static FileConfiguration selectorConfig;

    public static FileConfiguration getSelectorConfig() {
        return selectorConfig;
    }
    public static File getSelectorFile() {
        return selectorFile;
    }

    public Main c;

    public BungeeConfiguration(Main c) {
        this.c = c;
    }

    public void createSelectorFile() {
        selectorFile = new File(c.getDataFolder(), "selector.yml");
        if (!selectorFile.exists()) {
            selectorFile.getParentFile().mkdirs();
            c.saveResource("selector.yml", false);
        }

        selectorConfig = new YamlConfiguration();
        try {
            selectorConfig.load(selectorFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    
    public static final void save() throws FileNotFoundException, IOException, InvalidConfigurationException {
    	selectorConfig.load(selectorFile);
    	selectorConfig.save(selectorFile);
    }
}