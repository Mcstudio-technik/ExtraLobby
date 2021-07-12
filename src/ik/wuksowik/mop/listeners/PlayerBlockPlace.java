package ik.wuksowik.mop.listeners;

import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerBlockPlace implements Listener {
	
  @EventHandler
  public void onPlace(BlockPlaceEvent e) {
    if (ConfigAPI.sendWithConfigBoolean("protect_block") && 
    Main.getInst().getConfig().getString("Enabled_Worlds").contains(e.getBlock().getWorld().getName()) && !e.isCancelled())
      e.setCancelled(true); 
  }
  
  @EventHandler
  public void onBreak(BlockBreakEvent e) {
    if (ConfigAPI.sendWithConfigBoolean("protect_block") && 
    Main.getInst().getConfig().getStringList("Enabled_Worlds").contains(e.getBlock().getWorld().getName()) && !e.isCancelled())
      e.setCancelled(true); 
  } 
  
  @EventHandler
  public void onBlockFire(BlockBurnEvent e) {
    if (ConfigAPI.sendWithConfigBoolean("protect_block") && 
    Main.getInst().getConfig().getStringList("Enabled_Worlds").contains(e.getBlock().getWorld().getName()) && !e.isCancelled())
      e.setCancelled(true); 
  }
  
  @EventHandler
  public void onBlockIgnite(BlockIgniteEvent e) {
    if (ConfigAPI.sendWithConfigBoolean("protect_block") && 
    Main.getInst().getConfig().getStringList("Enabled_Worlds").contains(e.getBlock().getWorld().getName()) && !e.isCancelled())
      e.setCancelled(true); 
  }
}