package ik.wuksowik.mop.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Refrection {
	
  public static final String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	
  public static final Class<?> getNMSClass(String name) {
    try {
      return Class.forName("net.minecraft.server." + version + "." + name);
    } catch (ClassNotFoundException ex) {
      return null;
    } 
  }
  
  public static final void sendPacket(Player player, Object packet) {
    try {
      Object handle = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
      Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
      playerConnection.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(playerConnection, new Object[] { packet });
    } catch (Exception ex) {
    } 
  }
}