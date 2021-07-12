package ik.wuksowik.mop.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.ChatUtil;

public class CmdRestart implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		String msg = "extralobby.restart";
		if (!sender.hasPermission(msg)) {
			sender.sendMessage(ConfigAPI.sendMessageNoPermission());
			return false;
		}
		if (Bukkit.getOnlinePlayers().size() < 1) {
			sender.sendMessage("No players online on server!");
			return false;
		}
		if (args.length == 0) {
			return ChatUtil.sendMsgS(sender, ConfigAPI.sendWithConfig("usageRestart"));
		}
		int czas = Integer.valueOf(args[0]);
		sendTimerRestart(czas);
		return false;
	}
	
	@SuppressWarnings("deprecation")
	private static void sendTimerRestart(int czas) {
		if (czas <= 0) {
			Bukkit.shutdown();
		} else {
			String title = ConfigAPI.sendWithConfig("restartTitle").replace("{time}", String.valueOf(czas));
			String subtitle = ConfigAPI.sendWithConfig("restartSubTitle").replace("{time}", String.valueOf(czas));
			if (!ConfigAPI.sendWithConfigBoolean("subtitleEnable")) {
				subtitle = "";			
			}
			if (!ConfigAPI.sendWithConfigBoolean("titleEnable")) {
				title = "";
			}
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.sendTitle(ChatUtil.colorPlaceHolder(all, title), ChatUtil.colorPlaceHolder(all, subtitle));
			}
			Bukkit.getScheduler().runTaskLater(Main.getInst(), () -> sendTimerRestart(czas -1), 21);
		}
	}
	
	

}
