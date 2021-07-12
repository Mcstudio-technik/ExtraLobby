package ik.wuksowik.mop.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import ik.wuksowik.mop.Main;

public class BungeeCord {
	  
	 public static final void changeServer(Player player, String server) {
	    final ByteArrayDataOutput out = ByteStreams.newDataOutput();
	    out.writeUTF("Connect");
	    out.writeUTF(server);
	    player.sendPluginMessage(Main.getInst(), "BungeeCord", out.toByteArray());
	  }
	}