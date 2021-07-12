package ik.wuksowik.mop.utils;

import org.bukkit.Bukkit;
import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.listeners.ScoreBoard;

public class updatescoreboard {
	
	public final static void refreshSB(long czas) {
		Bukkit.getOnlinePlayers().forEach(ludziki -> ScoreBoard.rejestracjaScoreBoard(ludziki));
		Bukkit.getScheduler().runTaskLater(Main.getInst(), () -> refreshSB(czas), czas);
	}
   }