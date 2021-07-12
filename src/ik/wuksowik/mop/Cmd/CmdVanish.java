package ik.wuksowik.mop.Cmd;

import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.ChatUtil;
import ik.wuksowik.mop.utils.VanishUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdVanish implements CommandExecutor {
  @Override 
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (!(sender instanceof Player)) {
		sender.sendMessage("§cThis command is not for console!");
		return false;
	}
	String perm = "extralobby.vanish";
	if (!sender.hasPermission(perm)) {
		sender.sendMessage(ConfigAPI.sendMessageNoPermission());
	  return false;
	}
    if (args.length == 0) {
    	return ChatUtil.sendMsgS(sender, ConfigAPI.sendWithConfig("usageVANISH"));
    }
	Player p = (Player)sender;
        switch (args[0].toLowerCase()) {
          case "on":
            VanishUtils.Vanish("hide", p);
            sender.sendMessage(ConfigAPI.sendWithConfig("vanish_poof"));
           break;
          case "off":
            VanishUtils.Vanish("show", p);
            sender.sendMessage(ConfigAPI.sendWithConfig("vanish"));
            break;
        } 
        sender.sendMessage(ConfigAPI.sendWithConfig("usageVANISH"));
        return false;
    } 
}