package ik.wuksowik.mop.listeners;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import ik.wuksowik.mop.Main;

public class PadListener implements Listener {
	  private Double l1;  
	  
	  private Double l2;
    
	  private List<Player> jumpers = new ArrayList<>();
	  
	        @EventHandler
	        public void onJumpPad(PlayerMoveEvent e) {
	            this.l1 = Main.getInst().getConfig().getDouble("PadJump.launch-power");
	            this.l2 = Main.getInst().getConfig().getDouble("PadJump.launch-power-high");
	        	
	    	    if (Main.getInst().getConfig().getBoolean("PadJump.enable")) {
		    	    Player p = e.getPlayer();
		            Location location = p.getLocation();
	    	       Material k31 = Material.getMaterial(Main.getInst().getConfig().getString("PadJump.material").toUpperCase());
	   	        if (k31 == null)
	   	        	k31 = Material.getMaterial(Main.getInst().getConfig().getString("PadJump.materialold").toUpperCase()); 
	   	        if (e.getPlayer().getLocation().getBlock().getType() == k31) {
	   	         p.setVelocity(location.getDirection().multiply(this.l1).setY(this.l2));
	            this.jumpers.add(e.getPlayer());
	          } 
	        }
	  }
}