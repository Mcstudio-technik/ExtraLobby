package ik.wuksowik.mop;

import ik.wuksowik.mop.Cmd.CmdBroadcast;
import ik.wuksowik.mop.Cmd.CmdChat;
import ik.wuksowik.mop.Cmd.CmdExtraPanel;
import ik.wuksowik.mop.Cmd.CmdGamemode;
import ik.wuksowik.mop.Cmd.CmdList;
import ik.wuksowik.mop.Cmd.CmdReload;
import ik.wuksowik.mop.Cmd.CmdRestart;
import ik.wuksowik.mop.Cmd.CmdSpawn;
import ik.wuksowik.mop.Cmd.CmdTpSpawn;
import ik.wuksowik.mop.Cmd.CmdVanish;
import ik.wuksowik.mop.Cmd.CmdViaSupport;
import ik.wuksowik.mop.config.BungeeConfiguration;
import ik.wuksowik.mop.listeners.AntyVoid;
import ik.wuksowik.mop.listeners.BorderClass;
import ik.wuksowik.mop.listeners.BroadCast;
import ik.wuksowik.mop.listeners.ConsumeListener;
import ik.wuksowik.mop.listeners.ExtraClickEvent;
import ik.wuksowik.mop.listeners.GraczListener;
import ik.wuksowik.mop.listeners.HideListener;
import ik.wuksowik.mop.listeners.ItemMoveDropCancelListener;
import ik.wuksowik.mop.listeners.JoinListener;
import ik.wuksowik.mop.listeners.OthersListener;
import ik.wuksowik.mop.listeners.PadListener;
import ik.wuksowik.mop.listeners.PlayerBlockPlace;
import ik.wuksowik.mop.listeners.PlayerCommandPreprocessListner;
import ik.wuksowik.mop.listeners.PlayerJoinFireWork;
import ik.wuksowik.mop.listeners.Prefix;
import ik.wuksowik.mop.listeners.ServerSelector;
import ik.wuksowik.mop.listeners.SignColor;
import ik.wuksowik.mop.listeners.TabListener;
import ik.wuksowik.mop.listeners.UnknownCommand;
import ik.wuksowik.mop.utils.Refrection;
import ik.wuksowik.mop.utils.Update1;
import ik.wuksowik.mop.utils.UpdaterSpigot;
import ik.wuksowik.mop.utils.updatescoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
  private static final String wa = ":( Don't change the plugin name!!";
  
  private static final String war = ":(  Don't change the author's name!!";
  
  public static boolean papiAPI = false;
	  
  AntyVoid h = new AntyVoid();
  
  @Override
  public void onEnable() {
	saveDefaultConfig();
	
	updatetab();
	
    pluginyml();
    
    h.start();
    
    String f = " ";
    ConsoleCommandSender d = Bukkit.getConsoleSender();
    d.sendMessage(f);
    d.sendMessage(f);
    d.sendMessage("§7-------§2 ExtraLobby §7-------");
    d.sendMessage(f);
    d.sendMessage("§e" + getDescription().getDescription());
    d.sendMessage("§8Author: §3" + getDescription().getAuthors());
    d.sendMessage("§8Version: §a" + getDescription().getVersion());
    d.sendMessage("§dSubmit all your suggestions on discord!");
    d.sendMessage(f);
    d.sendMessage("§7-------§2 ExtraLobby §7-------");
    d.sendMessage(f);
    d.sendMessage("§2Loading config: config.yml");
    d.sendMessage("§2Loading config: selector.yml");
    d.sendMessage("§2Loading listeners!");
    d.sendMessage("§2Loading utils!");
    d.sendMessage("§2Loading commands!");
    d.sendMessage(f);
    d.sendMessage("§2Server version: §3" + Refrection.version);
    d.sendMessage(f);
    BungeeConfiguration c = new BungeeConfiguration(this);
    c.createSelectorFile();
    if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
    	d.sendMessage("§a;D §2Succesful connect to plugin §ePlaceHolderAPI!");
        papiAPI = true;
    }
    
    if (getConfig().getBoolean("BungeeCordSupport")) {
    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }
    
    regEvents();
    
    regCommand();
    UpdaterSpigot.sendUpdate();
    if (getConfig().getBoolean("entity.disableMobSpawn")) {
	    for (String s : getConfig().getStringList("Enabled_Worlds")) {
		World world = Bukkit.getWorld(s);
		if (world != null) {
		world.setDifficulty(Difficulty.PEACEFUL);
		world.setGameRuleValue("doMobLoot", "false");
		world.setGameRuleValue("doMobSpawning", "false");
		}
	   }
	}  
	if (getConfig().getBoolean("OptimizedServer")) {
		OptimizeWorld();
	}
	
	if (getConfig().getBoolean("ScoreBoard.enable")) {
	long lng = getConfig().getInt("ScoreBoard.refresh") * 20;
	updatescoreboard.refreshSB(lng);
    }
    if (getConfig().getBoolean("automsg.enable")) {
    BroadCast.BCAUTO();
    }
   }
  
  		private final void regCommand() {
  		    getCommand("gm").setExecutor(new CmdGamemode());
  		    getCommand("chat").setExecutor(new CmdChat());
  		    getCommand("bc").setExecutor(new CmdBroadcast());
  		    getCommand("list").setExecutor(new CmdList());
  		    getCommand("v").setExecutor(new CmdVanish());
  		    getCommand("elreload").setExecutor(new CmdReload());
  		    getCommand("setspawn").setExecutor(new CmdSpawn());
  		    getCommand("spawn").setExecutor(new CmdTpSpawn());	
  		    getCommand("versioncheck").setExecutor(new CmdViaSupport());
  		    getCommand("extrapanel").setExecutor(new CmdExtraPanel());
  		    getCommand("exrestart").setExecutor(new CmdRestart());
  		}
		
		private final void regEvents() {
			PluginManager ta = Bukkit.getPluginManager();
			ta.registerEvents(new JoinListener(), this);
			ta.registerEvents(new SignColor(), this);
			ta.registerEvents(new ExtraClickEvent(), this);
			ta.registerEvents(new PlayerCommandPreprocessListner(), this);
			ta.registerEvents(new PlayerBlockPlace(), this);
			ta.registerEvents(new OthersListener(), this);
			ta.registerEvents(new GraczListener(), this);
			ta.registerEvents(new ItemMoveDropCancelListener(), this);
			ta.registerEvents(new PlayerBlockPlace(), this);
			ta.registerEvents(new ServerSelector(), this);
			ta.registerEvents(new BorderClass(), this);
			ta.registerEvents(new TabListener(), this);
			ta.registerEvents(new PadListener(), this);
			ta.registerEvents(new ConsumeListener(), this);
			ta.registerEvents(new PlayerJoinFireWork(), this);
			ta.registerEvents(new HideListener(this), this);
			ta.registerEvents(new UnknownCommand(), this);
			ta.registerEvents(new Prefix(), this);
			}
		
  
	  @Override
	  public void onDisable() {
		  Bukkit.getScheduler().cancelTasks(this);
		  Bukkit.savePlayers();
		   for (String s : getConfig().getStringList("Enabled_Worlds")) {
		   World world = Bukkit.getWorld(s);
		    if (world != null) {
		     world.save();
			 }
		   }
		   ConsoleCommandSender g = Bukkit.getConsoleSender();
		   String h = " ";
		  g.sendMessage(h);
		  g.sendMessage(h);
		  g.sendMessage("§7-------§2 ExtraLobby §7-------");
		  g.sendMessage(h);
		  g.sendMessage("§e" + getDescription().getDescription());
		  g.sendMessage("§8Author: §3" + getDescription().getAuthors());
		  g.sendMessage("§8Version: §a" + getDescription().getVersion());
		  g.sendMessage("§dSubmit all your suggestions on discord!");
		  g.sendMessage(h);
		  g.sendMessage("§7-------§2 ExtraLobby §7-------");
		  g.sendMessage(h);
		  g.sendMessage(h);
  }
	  
	  private final void OptimizeWorld() {
		    for (String s : getConfig().getStringList("Enabled_Worlds")) {
			World world = Bukkit.getWorld(s);
			if (world != null) {
			world.setAnimalSpawnLimit(0);
			world.setAmbientSpawnLimit(0);
			world.setWeatherDuration(0);
			world.setMonsterSpawnLimit(0);
			world.setWaterAnimalSpawnLimit(0);
			world.setTime(0);
			world.setStorm(false);
			}
	     }
	  }
	  
   private final void pluginyml() {
	    PluginDescriptionFile p = getDescription();
	    if (!p.getName().contains("ExtraLobby")) {
	    	for (byte c = 0; c < 35; c++) {
	  	      getLogger().warning(wa);
	  	    	}
	      getPluginLoader().disablePlugin(this);
	    } 
	    if (!p.getAuthors().contains("wuksowik")) {
	    	for (byte c = 0; c < 35; c++) {
	      getLogger().warning(war);
	    	}
	      getPluginLoader().disablePlugin(this);
	    } 
	  }
  
  public static final Main getInst() {
    return Main.getPlugin(Main.class);
  }
  
    private final void updatetab() {
	    if (getConfig().getInt("Tablist.update") > 0) {
		      int pe = getConfig().getInt("Tablist.update");
		      Update1.startTab(pe);
	    } 
	  }
}