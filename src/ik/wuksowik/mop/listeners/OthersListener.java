package ik.wuksowik.mop.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import ik.wuksowik.mop.Main;

public class OthersListener implements Listener{
	
  @EventHandler(priority = EventPriority.HIGH)
  public void onRain(WeatherChangeEvent e) {
    if (Main.getInst().getConfig().getBoolean("weather.weather_block"))
	   e.setCancelled(true); 
	 }
  
  @EventHandler
  public void onPickUpItems(PlayerPickupItemEvent e) {
	 if (Main.getInst().getConfig().getBoolean("item.OFF-pickupitem"))	
     if (e.getPlayer().isOp()) {
          e.setCancelled(false);
       } else {
         e.setCancelled(true);
       } 
  }
  
     @EventHandler
     public void onEntityExplode(EntityExplodeEvent e) {
	   if (Main.getInst().getConfig().getBoolean("entity.OFF-explode"))		 
	     e.setCancelled(true); 
         e.blockList().clear();
         } 
     
     @EventHandler
     public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
       if (e.isCancelled())
         return; 
       if (Main.getInst().getConfig().getBoolean("player.frame_protect") && 
         e.getRightClicked() instanceof org.bukkit.entity.ItemFrame && 
         Main.getInst().getConfig().getStringList("Enabled_Worlds").contains(e.getPlayer().getWorld().getName()))
         if (e.getPlayer().isOp()) {
           if (e.getPlayer().getGameMode() == GameMode.CREATIVE) {
             e.setCancelled(false);
           } else {
             e.setCancelled(true);
           } 
         } else {
           e.setCancelled(true);
         }  
       }
     
    	  @EventHandler
    	  public void onPlayerUnleashEntity(PlayerUnleashEntityEvent e) {
    	      e.setCancelled(true); 
    	  }
    	  
    	  @EventHandler
    	  public void onSmelt(FurnaceExtractEvent e) {
    	      e.setExpToDrop(0); 
    	  }
    	  
    	  @EventHandler
    	  public void onFish(PlayerFishEvent e) {
    	      e.setCancelled(true);
    	  }
    	  @EventHandler
    	  public void onManipulate(PlayerArmorStandManipulateEvent e) {
    	      e.setCancelled(true);
    	  }
    	  @EventHandler
    	  public void onHang(HangingBreakByEntityEvent e) {
    	      e.setCancelled(true);
    	  }
    	}