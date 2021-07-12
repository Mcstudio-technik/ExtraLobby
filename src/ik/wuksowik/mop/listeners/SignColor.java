package ik.wuksowik.mop.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import ik.wuksowik.mop.utils.ChatUtil;

public class SignColor implements Listener{
	    @EventHandler
	    public void onSignCreate(SignChangeEvent e) { 
		  Player p = e.getPlayer();
		    if (p.hasPermission("extralobby.colorsign")) {
		      for (int i = 0; i < e.getLines().length; i++)
		        e.setLine(i, ChatUtil.colorPlaceHolder(p, e.getLine(i)));  
		  }
	  }
}