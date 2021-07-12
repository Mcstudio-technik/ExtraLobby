package ik.wuksowik.mop.utils;

import java.lang.reflect.Constructor;
import org.bukkit.entity.Player;

public class Titlesend{
	
	  public static final void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
		    try {
		      if (title != null) {
		    	  title = ChatUtil.colorPlaceHolder(player, title);
		        Object e = Refrection.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get((Object)null);
		        Object chatTitle = Refrection.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + title + "\"}" });
		        Constructor<?> subtitleConstructor = Refrection.getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { Refrection.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], Refrection.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
		        Object titlePacket = subtitleConstructor.newInstance(new Object[] { e, chatTitle, fadeIn, stay, fadeOut });
		        Refrection.sendPacket(player, titlePacket);
		        subtitleConstructor = Refrection.getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { Refrection.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], Refrection.getNMSClass("IChatBaseComponent") });
		        titlePacket = subtitleConstructor.newInstance(new Object[] { e, chatTitle });
		        Refrection.sendPacket(player, titlePacket);
		      } 
		      if (subtitle != null) {
		    	  subtitle = ChatUtil.colorPlaceHolder(player, subtitle);
		        Object e = Refrection.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get((Object)null);
		        Object chatSubtitle = Refrection.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + title + "\"}" });
		        Constructor<?> subtitleConstructor = Refrection.getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { Refrection.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], Refrection.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
		        Object subtitlePacket = subtitleConstructor.newInstance(new Object[] { e, chatSubtitle, fadeIn, stay, fadeOut });
		        Refrection.sendPacket(player, subtitlePacket);
		        e = Refrection.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get((Object)null);
		        chatSubtitle = Refrection.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + subtitle + "\"}" });
		        subtitleConstructor = Refrection.getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { Refrection.getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], Refrection.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
		        subtitlePacket = subtitleConstructor.newInstance(new Object[] { e, chatSubtitle, fadeIn, stay, fadeOut });
		        Refrection.sendPacket(player, subtitlePacket);
		      } 
		    } catch (Exception s) {
		    	for (int c = 0; c < 10; c++) { 
		      System.err.println("Error with send Title!");
		    	}
		    } 
	  }
}