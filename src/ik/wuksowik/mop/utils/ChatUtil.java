package ik.wuksowik.mop.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ik.wuksowik.mop.Main;

public class ChatUtil {
	
  public static boolean sendMsgS(CommandSender sender, String msg) {
	sender.sendMessage(msg.replace("{Player}", sender.getName()));
   return false;
  }
  
  private final static Pattern HEX_PATTERN = Pattern.compile("#[a-fA-F0-9]{6}");

  public final static String color(String message) {
      if (Bukkit.getVersion().contains("1.16")) {
          Matcher matcher = HEX_PATTERN.matcher(message);
          StringBuffer buffer = new StringBuffer();
          while (matcher.find()) {
              matcher.appendReplacement(buffer, net.md_5.bungee.api.ChatColor.valueOf(matcher.group()).toString());
          }
          return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString());
      }
      return ChatColor.translateAlternateColorCodes('&', message);
  }
  
  public final static String colorPlaceHolder(Player p, String message) {
      if (Bukkit.getVersion().contains("1.16")) {
          Matcher matcher = HEX_PATTERN.matcher(message);
          StringBuffer buffer = new StringBuffer();
          while (matcher.find()) {
              matcher.appendReplacement(buffer, net.md_5.bungee.api.ChatColor.valueOf(matcher.group()).toString());
          }
          if (Main.papiAPI) {
          return PlaceHoldersAPI.setPlaceholders(p, matcher.appendTail(buffer).toString());
          } else {
        	  return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString());
          }
      }
      if (Main.papiAPI) {
      return PlaceHoldersAPI.setPlaceholders(p, message);
      } else {
    	  return ChatColor.translateAlternateColorCodes('&', message);
      }
  }
  
}