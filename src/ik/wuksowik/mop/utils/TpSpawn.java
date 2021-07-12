package ik.wuksowik.mop.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TpSpawn {
	
	  public static final void run(Player p) {
		    Location spawn = new Location(Bukkit.getWorld(SetSpawn.extralobby.getString("Spawn.World")), SetSpawn.extralobby.getDouble("Spawn.X"), 
		    		SetSpawn.extralobby.getDouble("Spawn.Y"), SetSpawn.extralobby.getDouble("Spawn.Z"), (float)SetSpawn.extralobby.getDouble("Spawn.Yaw"), (float)SetSpawn.extralobby.getDouble("Spawn.Pitch"));
		    p.teleport(spawn);
		  }
		}