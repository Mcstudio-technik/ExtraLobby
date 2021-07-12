package ik.wuksowik.mop.utils;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class VanishUtils {
	
  private static final Set<Player> vanished = new HashSet<Player>();
  
  public static void Vanish(String b, Player sender) {
	  for (Player p : Bukkit.getOnlinePlayers()) {
		  switch (b.toUpperCase()) {
		  case "HIDE":
	          p.hidePlayer(sender);
	          if (!vanished.remove(sender)) {
	            vanished.add(sender); 
	          }
			  break;
		  case "SHOW":
	          if (vanished.remove(sender)) {
	              vanished.remove(sender); 
	            }
			  break;
		  }
	  }
  }
  
  public static final boolean isVanish(Player p) {
    return vanished.contains(p);
  }
  
}
