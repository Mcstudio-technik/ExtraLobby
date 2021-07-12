package ik.wuksowik.mop.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import ik.wuksowik.mop.Main;

public class ItemMoveDropCancelListener implements Listener {   
	  @EventHandler
	  public void onDrop(PlayerDropItemEvent e) {
		if (Main.getInst().getConfig().getBoolean("item.OFF-dropitem")) {
         e.setCancelled(true);
	    } 	  	  
	  }
	  
	  @EventHandler
	  public void onMoveItem(InventoryMoveItemEvent e) {
			if (Main.getInst().getConfig().getBoolean("item.OFF-moveitem")) {
	        e.setCancelled(true); 
			  }
		    }
	  
	  @EventHandler
	  public void onItemMove(InventoryDragEvent e) {
		if (Main.getInst().getConfig().getBoolean("item.OFF-moveitem")) {
		 e.setCancelled(true); 
	    }
	  }
	  
		@EventHandler
		public void onInvClick(InventoryClickEvent e) {
			if (Main.getInst().getConfig().getBoolean("item.OFF-moveitem")) {
				e.setCancelled(true);
			}
		}
	  }