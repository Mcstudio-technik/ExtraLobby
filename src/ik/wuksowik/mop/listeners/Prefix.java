package ik.wuksowik.mop.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;

public class Prefix implements Listener{
	  @EventHandler
	  public void TabPrefix(PlayerJoinEvent e) {
	    if (Main.getInst().getConfig().getBoolean("Tablist.PrefixEnable")) {
	      Player p = e.getPlayer();
	      String Prefix = ConfigAPI.sendWithConfig("Tablist.PrefixOnTab");
	      p.setPlayerListName(Prefix + p.getName());
	  }
}
}