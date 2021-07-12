package ik.wuksowik.mop.Cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.TpSpawn;

public class CmdTpSpawn implements CommandExecutor {
	
	  @Override
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    if (!(sender instanceof Player)) {
		        sender.sendMessage("§cThis command is no for console!");
		      return false;
		    }
	      Player p = (Player)sender;
	      String perm = "extralobby.spawn";
	        if (p.hasPermission(perm)) {
			       TpSpawn.run(p);
			       p.sendMessage(ConfigAPI.sendWithConfig("tpspawn"));
	        } else {
	        	p.sendMessage(ConfigAPI.sendMessageNoPermission());
	        } 
			return false;
}
}