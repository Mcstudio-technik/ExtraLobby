package ik.wuksowik.mop.utils;

import java.io.File;
import java.io.IOException;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetSpawn {
	
	  private static final File locs = new File("plugins/ExtraLobby", "Spawn.yml");
	  
	  public static final YamlConfiguration extralobby = YamlConfiguration.loadConfiguration(locs);
	  
	  public static final void run(Player p) {
	    if (!locs.exists())
	      try {
	        locs.createNewFile();
	      } catch (Exception exception) {
	    	  
	      } 
	    Location loc = p.getLocation();
	    extralobby.set("Spawn.X", loc.getX());
	    extralobby.set("Spawn.Y", loc.getY());
	    extralobby.set("Spawn.Z", loc.getZ());
	    extralobby.set("Spawn.Yaw", loc.getYaw());
	    extralobby.set("Spawn.Pitch", loc.getPitch());
	    extralobby.set("Spawn.World", loc.getWorld().getName());
	    try {
	      extralobby.save(locs);
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
	  }
	  
	}