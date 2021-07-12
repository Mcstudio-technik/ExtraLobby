package ik.wuksowik.mop.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;

public class PlayerCommandPreprocessListner implements Listener {
	
	@EventHandler
	  public void onCommandUnknown(PlayerCommandPreprocessEvent e) {
	    if (!e.isCancelled()) {
	    if (Main.getInst().getConfig().getBoolean("command_disable.enable") && 
	      !e.getPlayer().hasPermission("extralobby.commandblocker") && 
	     (Main.getInst().getConfig().getStringList("command_disable.list") != null)) {
	    	
	      for (String commands : Main.getInst().getConfig().getStringList("command_disable.list")) {
	    	  
	        if (e.getMessage().contains(" ")) {
	          if (e.getMessage().split(" ")[0].equalsIgnoreCase(commands)) {
	            e.setCancelled(true);
	            e.getPlayer().sendMessage(ConfigAPI.sendWithConfig("blockcommand"));
	            break;
	          } 
	          continue;
	        } 
	        if (e.getMessage().equalsIgnoreCase(commands)) {
	          e.setCancelled(true);
	          e.getPlayer().sendMessage(ConfigAPI.sendWithConfig("blockcommand"));
	          break;
	         } 
	       }
	     }  
	   }
	 return;
   }
}