package ik.wuksowik.mop.config;

import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.utils.ChatUtil;

public class ConfigAPI {
	
	public final static String sendMessageNoPermission() {
	  return ChatUtil.color(Main.getInst().getConfig().getString("nopermission"));
	}
	
	public final static String sendWithConfig(String msg) {
		return ChatUtil.color(Main.getInst().getConfig().getString(msg));
	}
	public final static String sendWithConfigNoColor(String msg) {
		return Main.getInst().getConfig().getString(msg);
	}
	
	public final static boolean sendWithConfigBoolean(String msg) {
		return Main.getInst().getConfig().getBoolean(msg);
	}

}
