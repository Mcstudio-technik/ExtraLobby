package ik.wuksowik.mop.listeners;

import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.utils.ChatUtil;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import com.google.common.base.Preconditions;

public class ScoreBoard {
		    
	public static final void rejestracjaScoreBoard(Player p) {
		String nazwa = Main.getInst().getConfig().getString("ScoreBoard.prefix");
		String nazwaObjective = "ExtraScoreBoard";
		boolean mozna = Main.getInst().getConfig().getBoolean("ScoreBoard.enable");
		List<String> msg = Main.getInst().getConfig().getStringList("ScoreBoard.messages");
		if (mozna) {
		if (nazwa != null) {
			if (msg != null) {
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective scoreob = sb.registerNewObjective(nazwaObjective, "dummy");
		Preconditions.checkArgument(nazwa.length() < 32, "Prefix is to long!");
		scoreob.setDisplaySlot(DisplaySlot.SIDEBAR);
		scoreob.setDisplayName(ChatUtil.colorPlaceHolder(p, nazwa));
		for (byte c = 0; c < msg.size(); c++) {
			scoreob.getScore(ChatUtil.colorPlaceHolder(p, msg.get(c))).setScore(c);
		}
		p.setScoreboard(sb);
		}
		}
	   }
	}
}
