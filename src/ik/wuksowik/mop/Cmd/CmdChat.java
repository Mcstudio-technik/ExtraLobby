package ik.wuksowik.mop.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.ChatUtil;
import ik.wuksowik.mop.utils.Titlesend;

public class CmdChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender send, Command cmd, String arg, String[] args) {
			String perm = "extralobby.chat";
		    if (!send.hasPermission(perm)) {
		    	send.sendMessage(ConfigAPI.sendMessageNoPermission());
		      return false;
		    } 
		    if (args.length == 0) {
		    	return ChatUtil.sendMsgS(send, ConfigAPI.sendWithConfig("usageChat"));
		    }
		        switch (args[0].toLowerCase()) {
		          case "on":
		        	  if (ConfigAPI.sendWithConfigBoolean("chatstatus") == true) {
		        		  send.sendMessage(ChatUtil.colorPlaceHolder((Player)send, "&8>> &cChat is now enabled!"));
		        		  break;
		        	  }
				      Main.getInst().getConfig().set("chatstatus", true);
				      Main.getInst().saveConfig();
				      Bukkit.getOnlinePlayers().forEach(all -> Titlesend.sendTitle(all, ConfigAPI.sendWithConfigNoColor("brodcast_title"), ConfigAPI.sendWithConfigNoColor("chaton"), 10, 20, 10));
		            break;
		          case "off":
		        	  if (ConfigAPI.sendWithConfigBoolean("chatstatus") == false) {
		        		  send.sendMessage(ChatUtil.colorPlaceHolder((Player)send, "&8>> &cChat is now disabled!"));
		        		  break;
		        	  }
		        	  Main.getInst().getConfig().set("chatstatus", false);
		        	  Main.getInst().saveConfig();
					  Bukkit.getOnlinePlayers().forEach(all -> Titlesend.sendTitle(all, ConfigAPI.sendWithConfigNoColor("brodcast_title"), ConfigAPI.sendWithConfigNoColor("chatoff"), 10, 20, 10));
		            break;
		          case "clear":
				      Bukkit.getOnlinePlayers().forEach(all -> Titlesend.sendTitle(all, ConfigAPI.sendWithConfigNoColor("brodcast_title"), ConfigAPI.sendWithConfigNoColor("chatclear"), 10, 20, 10));
				      for (int i = 0; i < 100; i++) {
				        Bukkit.getOnlinePlayers().forEach(all -> all.sendMessage("")); 
				      }
			        break;
		        } 
		    return true;
		  }
		}
