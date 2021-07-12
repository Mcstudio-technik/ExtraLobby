package ik.wuksowik.mop.listeners;

import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.utils.ChatUtil;
import ik.wuksowik.mop.utils.Titlesend;
import ik.wuksowik.mop.utils.TpSpawn;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
	
  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
	int level = Main.getInst().getConfig().getInt("PlayerLevelonJoin");
    Player p = e.getPlayer();
    p.setHealth(20);
    p.setFoodLevel(20);
    p.setLevel(level);
    p.setAllowFlight(false);
    p.setFlying(false);
    p.setFireTicks(0);
    p.setGameMode(GameMode.ADVENTURE);
     if (Main.getInst().getConfig().getBoolean("ClearChat-OnJoin")) {
		for (int i = 0; i < 100; i++) {
		p.sendMessage("");
    }  
    if (Main.getInst().getConfig().getBoolean("JoinMSG.enable")) {
        for (final String msg : Main.getInst().getConfig().getStringList("JoinMSG.messages"))
        	p.sendMessage(ChatUtil.colorPlaceHolder(p, msg).replace("{player}", p.getName()));
            }
        	String ka1 = Main.getInst().getConfig().getString("JoinMSG.subtitle").replace("{player}", p.getName());
        	String ka = Main.getInst().getConfig().getString("JoinMSG.title").replace("{player}", p.getName());
        	if (Main.getInst().getConfig().getBoolean("JoinMSG.enabledtitle")) {
            Titlesend.sendTitle(p, ChatUtil.colorPlaceHolder(p, ka), ChatUtil.colorPlaceHolder(p, ka1), 5, 60, 5);
        	}
       if (Main.getInst().getConfig().getBoolean("TpSpawnOnJoin")) {
         TpSpawn.run(p);
         }
       }
    }

}