package ik.wuksowik.mop.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import ik.wuksowik.mop.Main;

public class ConsumeListener implements Listener{
	
	
	  @EventHandler
	  public void onPlayerItemConsume(PlayerItemConsumeEvent e) {
		if (Main.getInst().getConfig().getBoolean("player.OFF-ConsumeItem")) {
			e.setCancelled(true);
		}
	  }
	  
	  @EventHandler
	  public void onPlayerBucketFill(PlayerBucketFillEvent e) {
	      e.setCancelled(true); 
	  }
	  
	  @EventHandler
	  public void onBed(PlayerBedEnterEvent e) {
	   if (Main.getInst().getConfig().getBoolean("player.OFF-UseBed")) {
	      e.setCancelled(true); 
	   }
	  }
	}