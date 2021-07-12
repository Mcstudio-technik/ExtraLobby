package ik.wuksowik.mop.listeners;

import java.util.Random;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import ik.wuksowik.mop.Main;

public class PlayerJoinFireWork implements Listener{
	
	  private final Color getColor(int paramInt) {
		    Color color = null;
		    if (paramInt == 1)
		      color = Color.AQUA; 
		    if (paramInt == 2)
		      color = Color.BLACK; 
		    if (paramInt == 3)
		      color = Color.BLUE; 
		    if (paramInt == 4)
		      color = Color.FUCHSIA; 
		    if (paramInt == 5)
		      color = Color.GRAY; 
		    if (paramInt == 6)
		      color = Color.GREEN; 
		    if (paramInt == 7)
		      color = Color.LIME; 
		    if (paramInt == 8)
		      color = Color.MAROON; 
		    if (paramInt == 9)
		      color = Color.NAVY; 
		    if (paramInt == 10)
		      color = Color.OLIVE; 
		    if (paramInt == 11)
		      color = Color.ORANGE; 
		    if (paramInt == 12)
		      color = Color.PURPLE; 
		    if (paramInt == 13)
		      color = Color.RED; 
		    if (paramInt == 14)
		      color = Color.SILVER; 
		    if (paramInt == 15)
		      color = Color.TEAL; 
		    if (paramInt == 16)
		      color = Color.WHITE; 
		    if (paramInt == 17)
		      color = Color.YELLOW; 
		    return color;
		  }
	  
	  @EventHandler
	  public void Join(PlayerJoinEvent o) {
	      if (Main.getInst().getConfig().getBoolean("FireWork.enable")) {
	        Firework f = (Firework)o.getPlayer().getWorld().spawnEntity(o.getPlayer().getLocation(), EntityType.FIREWORK);
	        FireworkMeta fm = f.getFireworkMeta();
	        Random r = new Random();
	        int i = r.nextInt(4) + 1;
	        FireworkEffect.Type type = FireworkEffect.Type.BALL;
	        if (i == 1)
	          type = FireworkEffect.Type.BALL; 
	        if (i == 2)
	          type = FireworkEffect.Type.BALL_LARGE; 
	        if (i == 3)
	          type = FireworkEffect.Type.BURST; 
	        if (i == 4)
	          type = FireworkEffect.Type.CREEPER; 
	        if (i == 5)
	          type = FireworkEffect.Type.STAR; 
	        int j = r.nextInt(17) + 1;
	        int k = r.nextInt(17) + 1;
	        Color color1 = getColor(j);
	        Color color2 = getColor(k);
	        FireworkEffect fireworkEffect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(color1).withFade(color2).with(type).trail(r.nextBoolean()).build();
	        fm.addEffect(fireworkEffect);
	        int m = r.nextInt(2) + 1;
	        fm.setPower(m);
	        f.setFireworkMeta(fm);
	      } 
	    } 
	  }