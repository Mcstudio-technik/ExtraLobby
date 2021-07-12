package ik.wuksowik.mop.utils;

import java.lang.reflect.Field;
import org.bukkit.entity.Player;
import com.google.common.base.Strings;

public class HeaderFoter{
	
	  public static void sendHeaderFooter(Player player, String header, String footer) {
		    header = Strings.isNullOrEmpty(header) ? "" : ChatUtil.colorPlaceHolder(player, header);
		    footer = Strings.isNullOrEmpty(footer) ? "" : ChatUtil.colorPlaceHolder(player, footer);
		    try {
		      Field cfield, jfield;
		      Object tabHeader = Refrection.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + header + "\"}" });
		      Object tabFooter = Refrection.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + footer + "\"}" });
		      Object packet = Refrection.getNMSClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[0]).newInstance(new Object[0]);
		      try {
		          cfield = packet.getClass().getDeclaredField("a");
		          jfield = packet.getClass().getDeclaredField("b");
		        } catch (Exception ex) {
		          cfield = packet.getClass().getDeclaredField("header");
		          jfield = packet.getClass().getDeclaredField("footer");
		        } 
		        cfield.setAccessible(true);
		        cfield.set(packet, tabHeader);
		        jfield.setAccessible(true);
		        jfield.set(packet, tabFooter);
		      Refrection.sendPacket(player, packet);
		    } catch (Exception ex) {
		      ex.printStackTrace();
		    } 
		  }
}