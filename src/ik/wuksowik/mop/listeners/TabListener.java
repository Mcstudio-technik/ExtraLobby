package ik.wuksowik.mop.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.HeaderFoter;

public class TabListener implements Listener{
	
	  @EventHandler(priority = EventPriority.HIGH)
	  public void onTabJoin(PlayerJoinEvent e) {
	    if (ConfigAPI.sendWithConfigBoolean("Tablist.enabled")) {
	      String h = Main.getInst().getConfig().getString("Tablist.Header");
	      String f = Main.getInst().getConfig().getString("Tablist.Footer");
	      HeaderFoter.sendHeaderFooter(e.getPlayer(), h, f);
	    } 
	  }
	}