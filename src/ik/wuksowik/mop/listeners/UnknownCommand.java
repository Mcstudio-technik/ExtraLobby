package ik.wuksowik.mop.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;
import ik.wuksowik.mop.config.ConfigAPI;

public class UnknownCommand implements Listener {
	  
	  @EventHandler(priority = EventPriority.HIGHEST)
	  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent o) {
	    if (!o.isCancelled()) {
	      String command = o.getMessage().split(" ")[0];
	      HelpTopic htopic = Bukkit.getHelpMap().getHelpTopic(command);
	      if (htopic == null) {
	    	o.getPlayer().sendMessage(ConfigAPI.sendWithConfig("unknowncommand"));
	        o.setCancelled(true);
	      } 
	    }
	  }
}