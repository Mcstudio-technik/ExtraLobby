package ik.wuksowik.mop.Cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.ExtraPanel;

public class CmdExtraPanel implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cThis command is not for console!");
			return false;
		}
		Player p = (Player)sender;
		String perm = "extralobby.extrapanel";
		if (!p.hasPermission(perm)) {
			p.sendMessage(ConfigAPI.sendMessageNoPermission());
			return false;
		}
		ExtraPanel.main(p);
		return false;
	}
	

}
