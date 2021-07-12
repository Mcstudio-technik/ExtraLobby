package ik.wuksowik.mop.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.ChatUtil;
import us.myles.ViaVersion.api.Via;

public class CmdViaSupport implements CommandExecutor{
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(Bukkit.getPluginManager().isPluginEnabled("ViaVersion"))) {
			sender.sendMessage(ChatUtil.color("&9If you use this command install plugin &6ViaVersion!"));
			return false;
		}
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatUtil.color("&cThis command is no for console!"));
			return false;		
		}
		Player p = (Player)sender;
	    if (args.length < 1) {
	    	p.sendMessage(ConfigAPI.sendWithConfig("CheckMessageVersion").replace("{VERSION}", String.valueOf(Via.getAPI().getPlayerVersion(sender)).replace("47", "1.8").replace("107", "1,9").replace("110", "1.9.4").replace("210", "1.10").replace("315", "1.11").replace("316", "1.11.x").replace("335", "1.12").replace("338", "1.12.1").replace("340", "1.12.2").replace("393", "1.13").replace("401", "1.13.1").replace("404", "1.13.2").replace("477", "1.14").replace("480", "1.14.1").replace("485", "1.14.2").replace("490", "1.14.3").replace("498", "1.14.4").replace("573", "1.15").replace("575", "1.15.1").replace("578", "1.15.2").replace("735", "1.16").replace("736", "1.16.1").replace("751", "1.16.2").replace("753", "1.16.3").replace("754", "1.16.4 - 1.16.5").replace("755", "1.17.x")));
	        return true;
	      } 
	    String permother = "extralobby.versioncheckother";
	    if (p.hasPermission(permother)) {
	      Player p2 = Bukkit.getPlayer(args[0]);
	      if (p2 == null) {
	        p.sendMessage(ConfigAPI.sendWithConfig("no_player"));
	        return true;
	      } 
	      sender.sendMessage(ConfigAPI.sendWithConfig("CheckMessageVersionOther").replace("{PLAYER}", p2.getName()).replace("{VERSION}", String.valueOf(Via.getAPI().getPlayerVersion(p2)).replace("47", "1.8").replace("107", "1,9").replace("110", "1.9.4").replace("210", "1.10").replace("315", "1.11").replace("316", "1.11.x").replace("335", "1.12").replace("338", "1.12.1").replace("340", "1.12.2").replace("393", "1.13").replace("401", "1.13.1").replace("404", "1.13.2").replace("477", "1.14").replace("480", "1.14.1").replace("485", "1.14.2").replace("490", "1.14.3").replace("498", "1.14.4").replace("573", "1.15").replace("575", "1.15.1").replace("578", "1.15.2").replace("735", "1.16").replace("736", "1.16.1").replace("751", "1.16.2").replace("753", "1.16.3").replace("754", "1.16.4 - 1.16.5").replace("755", "1.17.x")));
	      return false;
	  } else {
		p.sendMessage(ConfigAPI.sendMessageNoPermission());
	}
		return false;	
	}
}
