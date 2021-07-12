package ik.wuksowik.mop.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;

public class GraczListener implements Listener {
	
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e) {
   Player p = e.getPlayer();
	if (p.hasPermission("extralobby.adminprefix")) {
	 e.setFormat(ConfigAPI.sendWithConfig("prefixadmin").replace("{PLAYER}", p.getName()).replace("{MSG}", e.getMessage().replace("%", "151515151515".replace("151515151515", "%%"))));
	} else {
		e.setFormat(ConfigAPI.sendWithConfig("globalchatprefix").replace("{PLAYER}", p.getName()).replace("{MSG}", e.getMessage().replace("%", "151515151515".replace("151515151515", "%%"))));
	}
  }
  
  @EventHandler
  public void ChatManager(AsyncPlayerChatEvent e) {
    Player p = e.getPlayer();
    if (!Main.getInst().getConfig().getBoolean("chatstatus") && !p.hasPermission("extralobby.chatbypass")) {
    	p.sendMessage(ConfigAPI.sendWithConfig("chatmessage"));
      e.setCancelled(true);
    } 
  }
    
  @EventHandler
  public void onFood(FoodLevelChangeEvent e) {
    e.setCancelled(true);
  }
  
  @EventHandler
  public void onDamage(EntityDamageEvent e) {
	if (Main.getInst().getConfig().getBoolean("player.Disablepvp")) {
    e.setCancelled(true);
	}
  }  
  
  @EventHandler
  public void onPlayerDeathDrops(PlayerDeathEvent e) {
	if (Main.getInst().getConfig().getBoolean("player.OFF-ondeaditemdrop")) {
         e.getDrops().clear();
	}
  }
  
  @EventHandler
  public void soilChangeEntity(EntityInteractEvent e) { 
    if (Main.getInst().getConfig().getBoolean("player.farm_protect")) {
      e.setCancelled(true); 
    }
  }
  
  @EventHandler
  public void onDead(PlayerDeathEvent e){
	if (Main.getInst().getConfig().getBoolean("player.OFF-dead-msg")) {	
      if(e.getEntity().getKiller() instanceof Player) {
          e.setDeathMessage(null);
      }
	}
  }
	  @EventHandler
	  public void onQuit(PlayerQuitEvent e) {
	    e.setQuitMessage(null);
	  }
	  
	  @EventHandler
	  public void onJoin(PlayerJoinEvent e) {
	    e.setJoinMessage(null);
	  }
	  
	  @EventHandler
	  public void onVechile(VehicleEnterEvent e) {
	    e.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void onLeafe(LeavesDecayEvent e) {
	    e.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void onP(PlayerPortalEvent e) {
	   if (Main.getInst().getConfig().getBoolean("player.disableportal")) {
	    e.setCancelled(true);
	   }
	 }
	  
	  @EventHandler
	  public void onBottle(ExpBottleEvent d) {
	      d.setExperience(0); 
	  }
	  
	  @EventHandler
	  public void onJoin(PlayerLoginEvent e) {
	    Player p = e.getPlayer();
	    if (!p.hasPermission("extralobby.slotbypass") && Bukkit.getOnlinePlayers().size() >= Main.getInst().getConfig().getInt("MaxSlotOnSever")) {
	      e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, ConfigAPI.sendWithConfig("MessageIfSeverIsFull")); 
	    }
	  }
	}