package ik.wuksowik.mop.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ik.wuksowik.mop.Main;

public class Update1 {
	
	public static final void startTab(int g) {
		Bukkit.getScheduler().runTaskTimer(Main.getInst(), () -> run(), 0L, g);
	}
	
	  private static final void run() {
		    for (Player onl : Bukkit.getOnlinePlayers()) {
		      if (Main.getInst().getConfig().getBoolean("Tablist.enabled")) {
		        String jp = Main.getInst().getConfig().getString("Tablist.Header");
		        jp = ChatUtil.colorPlaceHolder(onl, jp);
		        String krowa = Main.getInst().getConfig().getString("Tablist.Footer");
		        krowa = ChatUtil.colorPlaceHolder(onl, krowa);
		        HeaderFoter.sendHeaderFooter(onl, jp, krowa);
		      } 
		    } 
		  }
	}