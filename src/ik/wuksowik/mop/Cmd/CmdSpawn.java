package ik.wuksowik.mop.Cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.SetSpawn;

public class CmdSpawn implements CommandExecutor {
	
	 @Override
	  public boolean onCommand(CommandSender cs, Command cmd, String arg2, String[] args) {
		    if (!(cs instanceof Player)) {
		      cs.sendMessage("§cThis command is no for console!");
		    return false;
		    }
		      Player p = (Player)cs;
		      String perm = "extralobby.setspawn";
		      if (p.hasPermission(perm)) {
		        if (args.length == 0) {
		          SetSpawn.run(p);
		          p.sendMessage(ConfigAPI.sendWithConfig("setspawn"));
		        } else {
		        	p.sendMessage(ConfigAPI.sendWithConfig("usageSpawn"));
		        } 
		      } else {
		    	  p.sendMessage(ConfigAPI.sendMessageNoPermission());
		      } 
		    return true;
		  }
		}