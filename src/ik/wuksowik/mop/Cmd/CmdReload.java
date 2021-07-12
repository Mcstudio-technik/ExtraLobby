package ik.wuksowik.mop.Cmd;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;

import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.BungeeConfiguration;
import ik.wuksowik.mop.config.ConfigAPI;

public class CmdReload implements CommandExecutor {
	
	  @Override
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  String perm = "extralobby.reload";
	        if (!sender.hasPermission(perm)) {
	        	sender.sendMessage(ConfigAPI.sendMessageNoPermission());
	        	return false;
	        }
		   sender.sendMessage(ConfigAPI.sendWithConfig("reloadconfig"));
	       Main.getInst().reloadConfig();
	       try {
			BungeeConfiguration.save();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return false;
	  }
	  
}