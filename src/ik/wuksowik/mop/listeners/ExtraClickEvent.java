package ik.wuksowik.mop.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.utils.ChatUtil;
import ik.wuksowik.mop.utils.ExtraPanel;

public class ExtraClickEvent implements Listener {
	
	@EventHandler
	public void onClickPanel(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		if (e.getView().getTitle().equalsIgnoreCase(ChatUtil.colorPlaceHolder(p, "&2&lExtraPanel"))) {
			e.setCancelled(true);
		      if (e.getSlot() == 2) {
		    	  
		          if (Main.getInst().getConfig().getBoolean("protect_block") == true) {
		            Main.getInst().getConfig().set("protect_block", false);
		            Main.getInst().saveConfig();
		            ExtraPanel.main(p);
		            return;
		          } 
		           Main.getInst().getConfig().set("protect_block", true);
		           Main.getInst().saveConfig();
		           ExtraPanel.main(p);
		        } else if (e.getSlot() == 3) {
		          if (Main.getInst().getConfig().getBoolean("player.Disablepvp") == true) {
		            Main.getInst().getConfig().set("player.Disablepvp", false);
		            ExtraPanel.main(p);
		            Main.getInst().saveConfig();
		            return;
		          } 
		          Main.getInst().getConfig().set("player.Disablepvp", true);
		          Main.getInst().saveConfig();
		          ExtraPanel.main(p);
		        } else if (e.getSlot() == 4) {
		        	if (Main.getInst().getConfig().getBoolean("item.OFF-dropitem") == true) {
		        		Main.getInst().getConfig().set("item.OFF-dropitem", false);
		        		Main.getInst().saveConfig();
		            ExtraPanel.main(p);
		            return;
		          } 
		        	Main.getInst().getConfig().set("item.OFF-dropitem", true);
		        	Main.getInst().saveConfig();
		          ExtraPanel.main(p);
		        } else if (e.getSlot() == 5) {
		        	if (Main.getInst().getConfig().getBoolean("item.OFF-pickupitem") == true) {
		        		Main.getInst().getConfig().set("item.OFF-pickupitem", false);
		        		Main.getInst().saveConfig();
		            ExtraPanel.main(p);
		            return;
		          } 
		        	Main.getInst().getConfig().set("item.OFF-pickupitem", true);
		        	Main.getInst().saveConfig();
		          ExtraPanel.main(p);
		        } else if (e.getSlot() == 6) {
		        	if (Main.getInst().getConfig().getBoolean("item.OFF-moveitem") == true) {
		        		Main.getInst().getConfig().set("item.OFF-moveitem", false);
		        		Main.getInst().saveConfig();
		            ExtraPanel.main(p);
		            return;
		          } 
		        	Main.getInst().getConfig().set("item.OFF-moveitem", true);
		        	Main.getInst().saveConfig();
		        	ExtraPanel.main(p);
		        }
		}
	}
}
