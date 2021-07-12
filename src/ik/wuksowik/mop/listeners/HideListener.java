package ik.wuksowik.mop.listeners;

import ik.wuksowik.mop.utils.ChatUtil;
import ik.wuksowik.mop.utils.CoolDown;
import ik.wuksowik.mop.utils.Items;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import ik.wuksowik.mop.Main;

public class HideListener implements Listener {
	
	  private static Main main;
	  
	  private static List<Action> g = Arrays.asList(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
			  
	  public HideListener(Main Main) {
		 main = Main;
	  }
	  
	  @EventHandler
	  public void onHide(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    String g4 = ChatUtil.colorPlaceHolder(p, main.getConfig().getString("HideMessage"));
	    String g5 = ChatUtil.colorPlaceHolder(p, main.getConfig().getString("ShowMessage"));
	    String Hide = ChatUtil.colorPlaceHolder(p, main.getConfig().getString("ItemHiderNameHidden"));
	    String Show = ChatUtil.colorPlaceHolder(p, main.getConfig().getString("ItemHiderNameShow"));
	    String cool = ChatUtil.colorPlaceHolder(p, main.getConfig().getString("ItemCooldown"));
	    int hideid = main.getConfig().getInt("SubIDHide");
	    int showid = main.getConfig().getInt("SubIDShow");
	    Material materialhide = Material.getMaterial(main.getConfig().getString("MaterialHide"));
	    Material materialshow = Material.getMaterial(main.getConfig().getString("MaterialShow"));
	    Items i2 = (new Items(materialhide, 1, (short)hideid)).setDisplayName(Hide).setLore(main.getConfig().getStringList("ItemHideLore"));
	    Items i3 = (new Items(materialshow, 1, (short)showid)).setDisplayName(Show).setLore(main.getConfig().getStringList("ItemShowLore"));
	    
	    for (Action pdfg: g)
   if (e.getAction() == pdfg && e.getPlayer().getItemInHand().getType() == materialhide &&
		  e.getItem() != null && e.getItem().getItemMeta() != null && e.getItem().getItemMeta().getDisplayName() != null && e.getItem().getItemMeta().getLore() != null) {
	      for (String lorka : main.getConfig().getStringList("ItemHideLore"))
		  if (e.getItem().getItemMeta().getDisplayName().toLowerCase().contains(Hide) && e.getItem().getItemMeta().getLore().contains(ChatUtil.colorPlaceHolder(p, lorka))) {
	       e.setCancelled(true);
		  }
	       if (CoolDown.hasTimer((OfflinePlayer)p, "visibility")) {
	          p.sendMessage(cool.replace("{seconds}", String.valueOf(CoolDown.getRemaining((OfflinePlayer)p, "visibility") / 1000L)));
	         return;
	       }
	       Bukkit.getOnlinePlayers().forEach(a -> p.hidePlayer(a));
	    	    p.sendMessage(g4);
	    	    p.getInventory().setItem(main.getConfig().getInt("HideSlot") - 1, (ItemStack)i3);
	    	    p.updateInventory();
	    	    CoolDown.addTimer((OfflinePlayer)p, "visibility", TimeUnit.SECONDS.toMillis(5L));
	    	    return;
	    	  } 
	    for (Action pdfg: g)
	  if (e.getAction() == pdfg && e.getPlayer().getItemInHand().getType() == materialshow &&
			 e.getItem() != null && e.getItem().getItemMeta() != null && e.getItem().getItemMeta().getDisplayName() != null && e.getItem().getItemMeta().getLore() != null) {
			 for (String lorka4 : main.getConfig().getStringList("ItemShowLore"))
		    if (e.getItem().getItemMeta().getDisplayName().toLowerCase().contains(Show) && e.getItem().getItemMeta().getLore().contains(ChatUtil.colorPlaceHolder(p, lorka4))) {
	    	 e.setCancelled(true);
		    }
		    if (CoolDown.hasTimer((OfflinePlayer)p, "visibility")) {
			 p.sendMessage(cool.replace("{seconds}", String.valueOf(CoolDown.getRemaining((OfflinePlayer)p, "visibility") / 1000L)));
			return;
			}
		    Bukkit.getOnlinePlayers().forEach(s -> p.showPlayer(s));
	    	  p.sendMessage(g5);
	    	  p.getInventory().setItem(main.getConfig().getInt("HideSlot") - 1, (ItemStack)i2);
	    	  p.updateInventory();
	    	  CoolDown.addTimer((OfflinePlayer)p, "visibility", TimeUnit.SECONDS.toMillis(5L));
	    	  return;
	        } 
	    }
	    	  
	    	  @EventHandler
	    	  public void onJoin(PlayerJoinEvent e) {
	    		  if (Main.getInst().getConfig().getBoolean("Givehideitem")) {
	    	    int hideid = main.getConfig().getInt("SubIDHide");
	    	    Player p = e.getPlayer();
	    	    String Hide = ChatUtil.colorPlaceHolder(p, Main.getInst().getConfig().getString("ItemHiderNameHidden"));
	    	    Material materialhide = Material.getMaterial(main.getConfig().getString("MaterialHide"));
	    	    Items i2 = (new Items(materialhide, 1, (short)hideid)).setDisplayName(Hide).setLore(main.getConfig().getStringList("ItemHideLore"));
	    	    p.getInventory().setItem(main.getConfig().getInt("HideSlot") - 1, (ItemStack)i2);
	    	  }
	    	}
	    }