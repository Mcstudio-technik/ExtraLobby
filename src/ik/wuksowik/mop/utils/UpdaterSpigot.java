package ik.wuksowik.mop.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import ik.wuksowik.mop.Main;

public class UpdaterSpigot  {
	
	public static final void sendUpdate() {
		ConsoleCommandSender d = Bukkit.getConsoleSender();
		String wersja = Main.getInst().getDescription().getVersion();
		  try {
			URL url = new URL("https://api.spigotmc.org/legacy/update.php?resource=83411");
	          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
	          if (wersja.equals(bufferedReader.readLine())) {
	        	    d.sendMessage(" ");
	            	d.sendMessage("§7-------§2 ExtraLobby §7-------");
	            	d.sendMessage(" ");
	            	d.sendMessage("§8>> §aYou are running the lasted version!");
	            	d.sendMessage("§8>> §7Version: §e§l"+wersja);
	                d.sendMessage(" ");
	                d.sendMessage("§7-------§2 ExtraLobby §7-------");
	                d.sendMessage(" ");
	          } else {
	            	d.sendMessage(" ");
	               	d.sendMessage("§7-------§2 ExtraLobby §7-------");
	            	d.sendMessage(" ");
	            	d.sendMessage("§8>> §cNew version of §2ExtraLobby §cis avaliable!");
	            	d.sendMessage("§8>> §7www.spigotmc.org/resources/83411");
	                d.sendMessage(" ");
	                d.sendMessage("§7-------§2 ExtraLobby §7-------");
	                d.sendMessage(" ");
	           }
		    } catch (Exception exception) {
		    	for (int c = 0; c < 12; c++) {
		      System.err.println("Problem with Connect to SpigotAPI");
		    	}
		    } 
	}
}
