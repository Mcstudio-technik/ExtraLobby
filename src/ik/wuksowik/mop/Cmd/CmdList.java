package ik.wuksowik.mop.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ik.wuksowik.mop.config.ConfigAPI;

public class CmdList implements CommandExecutor {
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String l , String args[]){
	    String g4 = ConfigAPI.sendWithConfig("listMessage");
	    String perm = "extralobby.list";
        if (sender.hasPermission(perm)) {
            if (args.length == 0) {
                int online = Bukkit.getOnlinePlayers().size();
                sender.sendMessage(g4 + online);
                String s = ConfigAPI.sendWithConfig("PlayersColorOnList");
                for (Player p : Bukkit.getOnlinePlayers()) {
                    String name = p.getName();
                    s = s + name + ", ";
                }
                sender.sendMessage(s);
            } else {
            	sender.sendMessage(ConfigAPI.sendWithConfig("usageLIST"));
            }
          } else {
          	sender.sendMessage(ConfigAPI.sendMessageNoPermission());
          } 
        return false;
    }
}  