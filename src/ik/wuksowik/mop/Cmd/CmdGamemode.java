package ik.wuksowik.mop.Cmd;

import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.ChatUtil;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdGamemode implements CommandExecutor {
	
  @Override	
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  if (!(sender instanceof Player)) {
		  sender.sendMessage("§cThis command is not for console!");
		  return false;
	  }
	    String perm = "extralobby.gm";
	    if (!sender.hasPermission(perm)) {
	    	return ChatUtil.sendMsgS(sender, ConfigAPI.sendMessageNoPermission()); 
	    }
	    if (args.length < 1) {
	        return ChatUtil.sendMsgS(sender, ConfigAPI.sendWithConfig("usageGM")); 
	    }
	    Player p = (Player)sender;
	    GameMode c = GameMode.valueOf(getMode(args[0]));
	      if (c == null) {
	    	  p.sendMessage(ConfigAPI.sendWithConfig("gmNotFound"));
	    	  return false;
	      }
	      if (args.length == 1) {
	        p.setGameMode(c);
	        return ChatUtil.sendMsgS(sender, ConfigAPI.sendWithConfig("setGameMode").replace("{SetGameMode}", String.valueOf(c)));
	      } 
	      if (args.length != 2) {
	        return ChatUtil.sendMsgS(sender, ConfigAPI.sendWithConfig("usageGM")); 
	      }
	      Player o = Bukkit.getPlayer(args[1]);
	      if (o == null) {
	        return ChatUtil.sendMsgS(sender, ConfigAPI.sendWithConfig("no_player")); 
	      }
	      o.setGameMode(c);
	      return ChatUtil.sendMsgS(sender, ConfigAPI.sendWithConfig("setGameModeOther").replace("{Player}", o.getName()).replace("{SetGameMode}", String.valueOf(c)));
  }

	private final String getMode(String args) {
		String game = null;
  		List<String> h = Arrays.asList("0", "1", "2", "3", "survival", "adventure", "spectator", "creative", "c", "s", "a", "spec");
		for (String huj : h)
			if (!args.toLowerCase().equalsIgnoreCase(huj)) {
				return game;
			}
		switch (args.toLowerCase()) {
		case "1":
		case "c":
			game = "CREATIVE";
			break;
		case "0":
		case "s":
			game = "SURVIVAL";
			break;
		case "2":
		case "a":
			game = "ADVENTURE";
			break;
		case "3":
		case "spec":
			game = "SPECTATOR";
			break;
		}   
		return game;
	}
}