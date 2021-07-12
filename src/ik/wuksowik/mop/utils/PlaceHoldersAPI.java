package ik.wuksowik.mop.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ik.wuksowik.mop.Main;
import me.clip.placeholderapi.PlaceholderAPI;

public class PlaceHoldersAPI{
	  
	  public static String setPlaceholders(Player player, String x) {
	    String m = x
	        .replace("{Player}", player.getDisplayName())
	        .replace("{UUID}", String.valueOf(player.getUniqueId())
	        .replace("{World}", String.valueOf(player.getWorld())
	        .replace("{Gamemode}", String.valueOf(player.getGameMode())))
	        .replace("{IP}", String.valueOf(player.getAddress().getAddress()))
	        .replace("{Online}", String.valueOf(Bukkit.getOnlinePlayers().size()))
	        .replace("{MaxPlayers}", String.valueOf(Bukkit.getMaxPlayers())));
		  String wroc = m;
	    if (Main.papiAPI) {
	    	wroc = PlaceholderAPI.setPlaceholders(player, m);
	    }
		return wroc;
	  }
	}