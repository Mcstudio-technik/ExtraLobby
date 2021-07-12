package ik.wuksowik.mop.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;

public class BorderClass implements Listener{
	
		  @EventHandler(priority = EventPriority.HIGHEST)
		  public static void onMove(PlayerMoveEvent event) {
		    Player player = event.getPlayer();
		    if (Main.getInst().getConfig().getBoolean("Border_Enabled")) {
		    if (event.getTo().getBlockX() > Main.getInst().getConfig().getInt("BorderSize") || event.getTo().getBlockX() < -Main.getInst().getConfig().getInt("BorderSize") || event.getTo().getBlockZ() > Main.getInst().getConfig().getInt("BorderSize") || event.getTo().getBlockZ() < -Main.getInst().getConfig().getInt("BorderSize")) {
		      event.setTo(event.getFrom());
		        player.sendMessage(ConfigAPI.sendWithConfig("Border_Message"));
		      
		    }
		    }
		  }
		  
		  @EventHandler
		  public void onPlayerTeleport(PlayerTeleportEvent e) {
		    Player p = e.getPlayer();
		    if (ConfigAPI.sendWithConfigBoolean("Border_Enabled")) {
		    if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL) && (e.getTo().getX() > Main.getInst().getConfig().getInt("BorderSize") || e.getTo().getX() < -Main.getInst().getConfig().getInt("BorderSize") || e.getTo().getZ() > Main.getInst().getConfig().getInt("BorderSize") || e.getTo().getZ() < -Main.getInst().getConfig().getInt("BorderSize"))) {
		      e.setCancelled(true);
		      p.sendMessage(ConfigAPI.sendWithConfig("Border_Message"));
		      e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_WINGS, 90.0F, 0.90F);
		    } 
		  }
		}
}