package ik.wuksowik.mop.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.TpSpawn;

public class AntyVoid implements Listener{
	
	public void start() {
		checkvoid();
	}
	
	private static final void checkvoid() {
		Bukkit.getOnlinePlayers().stream()
		.filter(c -> c.getLocation().getY() <= Main.getInst().getConfig().getInt("VoidYteleport"))
		.forEach(d -> { d.setFallDistance(0.0F); d.setHealth(20.0D); TpSpawn.run(d);
			d.sendMessage(ConfigAPI.sendWithConfig("AntyVoidMessage"));
		});
		
		Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInst(), () -> checkvoid(), 20L);
	}
	}