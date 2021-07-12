package ik.wuksowik.mop.listeners;

import org.bukkit.Bukkit;
import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.ChatUtil;

public class BroadCast {
   private static int i = 0;
  
  public final static void BCAUTO() {
	  if (Bukkit.getOnlinePlayers().size() != 0) {
      if (i >= Main.getInst().getConfig().getStringList("automsg.messages").size()) {
          i = 0; 
         }
       String wiad = Main.getInst().getConfig().getStringList("automsg.messages").get(i);
       i+= 1;
       Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(ConfigAPI.sendWithConfig("automsg.prefix") + ChatUtil.colorPlaceHolder(p, wiad)));
       Bukkit.getScheduler().runTaskLater(Main.getInst(), () -> BCAUTO(), Main.getInst().getConfig().getInt("automsg.time") * 20L);
   }
  }
}