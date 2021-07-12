package ik.wuksowik.mop.Cmd;

import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.ChatUtil;
import ik.wuksowik.mop.utils.Titlesend;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdBroadcast implements CommandExecutor {
	  
	@SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
    	String perm = "extralobby.bc";
        if (!sender.hasPermission(perm)) {
        	sender.sendMessage(ConfigAPI.sendMessageNoPermission());
            return true;
        }
	    if (args.length == 0) {
	    	return ChatUtil.sendMsgS(sender, ConfigAPI.sendWithConfig("usageBC"));
	    }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; i++)
          sb.append(args[i]).append(" "); 
          String message = sb.toString();
	        switch (args[0].toLowerCase()) {
	          case "chat":
	        	  Bukkit.broadcastMessage(ConfigAPI.sendWithConfig("brodcast_chat") + ChatUtil.color(message));
	            break;
	          case "title":
	        	  Bukkit.getOnlinePlayers().forEach(pieski -> pieski.sendTitle(ConfigAPI.sendWithConfigNoColor("brodcast_title"), message));
	            break;
	          case "subtitle":
	        	  Bukkit.getOnlinePlayers().forEach(kasztany -> kasztany.sendTitle("", message));
		        break;
	        } 
		return false;
	}
}