package ik.wuksowik.mop.listeners;

import ik.wuksowik.mop.Main;
import ik.wuksowik.mop.config.BungeeConfiguration;
import ik.wuksowik.mop.config.ConfigAPI;
import ik.wuksowik.mop.utils.ChatUtil;
import ik.wuksowik.mop.utils.Items;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ServerSelector implements Listener {
  
  private FileConfiguration bungeeconfig;
  
  private Inventory inv;
  
  public ServerSelector() {
      this.bungeeconfig = BungeeConfiguration.getSelectorConfig();
  }
  
  public Inventory getInventory(Player player) {
    this.inv = Bukkit.createInventory(null, 9 * this.bungeeconfig.getInt("selector.rows"), ChatUtil.colorPlaceHolder(player, this.bungeeconfig.getString("selector.guiname")));
    for (String string : this.bungeeconfig.getConfigurationSection("selector.itemsinselector").getKeys(false)) {
      if (this.bungeeconfig.contains("selector.itemsinselector." + string)) {
        ItemStack item = new ItemStack(Material.valueOf(this.bungeeconfig.getString("selector.itemsinselector." + string + ".material")), this.bungeeconfig.getInt("selector.itemsinselector." + string + ".amount"), (short)this.bungeeconfig.getInt("selector.itemsinselector." + string + ".durability"));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatUtil.colorPlaceHolder(player, this.bungeeconfig.getString("selector.itemsinselector." + string + ".displayname")));
        List<String> lorelist = new ArrayList<>();
        for (String lore : this.bungeeconfig.getStringList("selector.itemsinselector." + string + ".lore"))
          lorelist.add(ChatUtil.colorPlaceHolder(player, lore));
        meta.setLore(lorelist);        
        if (!this.bungeeconfig.getBoolean("selector.showallAttributesonitem")) {
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        }
        item.setItemMeta(meta);
        this.inv.setItem(this.bungeeconfig.getInt("selector.itemsinselector." + string + ".slot"), item);
      } 
    } 
    if (!this.bungeeconfig.getString("selector.fillbackground").equalsIgnoreCase("none")) {
      for (int i = 0; i < inv.getSize(); i++)
        if (this.inv.getItem(i) == null) {
        	this.inv.setItem(i, new Items(Material.valueOf(this.bungeeconfig.getString("selector.fillbackground")), 1, (short)this.bungeeconfig.getInt("selector.id")).setDisplayName(ChatUtil.colorPlaceHolder(player, this.bungeeconfig.getString("selector.name"))));
         }
       }
	return this.inv;
  }
  
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
	    ItemStack itemStack = e.getItem();
	    if (itemStack == null) {
	      return; 
	    }
	    if (!itemStack.getType().equals(Material.valueOf(bungeeconfig.getString("selector.item")))) {
	      return; 
	    }
	    if (!itemStack.hasItemMeta() || itemStack.getItemMeta().getDisplayName().isEmpty()) {
	      return; 
	    }
	    Player c = e.getPlayer();
	    if (!itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.colorPlaceHolder(c, this.bungeeconfig.getString("selector.nameselector")))) {
	      return; 
	    }
	    c.openInventory(getInventory(c));
	  }
  
  
      private final void giveServerSelector(Player player) {
	    if (!this.bungeeconfig.getStringList("World").contains(player.getWorld().getName())) {
	      return; 
	    }
	    if (!this.bungeeconfig.getBoolean("onjoingiveselector")) {
	      return; 
	    }
	    Items c = new Items(Material.valueOf(this.bungeeconfig.getString("selector.item"))).setDisplayName(ChatUtil.colorPlaceHolder(player, this.bungeeconfig.getString("selector.nameselector")
	    		)).setLore(this.bungeeconfig.getStringList("selector.lore"));
	    player.getInventory().setItem(this.bungeeconfig.getInt("selector.slot"), c);
	  }
      
	  @EventHandler
	  public void onPlayerJoin(PlayerJoinEvent e) {
	    if (Main.getInst().getConfig().getBoolean("clear_inventory_onJoin")) {
		 e.getPlayer().getInventory().clear(); 
	    }
	    giveServerSelector(e.getPlayer());
   }
	  
	  @EventHandler
	  public void onPlayerRespawn(PlayerRespawnEvent e) {
	    giveServerSelector(e.getPlayer());
	  }
	  
	  @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatUtil.colorPlaceHolder(player, this.bungeeconfig.getString("selector.guiname")))) {
        	e.setCancelled(true);
          if (e.getCurrentItem() != null) {
	    for (String item : this.bungeeconfig.getConfigurationSection("selector.itemsinselector").getKeys(false)) {
	      if (e.getSlot() == this.bungeeconfig.getInt("selector.itemsinselector." + item + ".slot")) {
	            Material material = Material.getMaterial((this.bungeeconfig.getString("selector.itemsinselector." + item + ".material")));
	            if (e.getCurrentItem().getType().equals(material)) {
	        	    if (this.bungeeconfig.getBoolean("CloseInventoryOnClick")) {
	        	    player.closeInventory();
	        	  }
	          for (String command : this.bungeeconfig.getStringList("selector.itemsinselector." + item + ".commands"))
	              player.performCommand(command); 
	        if (!this.bungeeconfig.getString("selector.itemsinselector." + item + ".bungeeserver").equalsIgnoreCase("none")) {
	          BungeeCord.changeServer(player, this.bungeeconfig.getString("selector.itemsinselector." + item + ".bungeeserver")); 
	          }
	        }
	      }
	    }
	   }
     }
   }
	  
	  @EventHandler
	  public void onInventoryMoveItem(InventoryMoveItemEvent e) {
	    if (ConfigAPI.sendWithConfigBoolean("item.OFF-moveitem")) {
	     if (!e.getSource().getName().equalsIgnoreCase(ChatUtil.colorPlaceHolder((Player)e.getInitiator(), this.bungeeconfig.getString("selector.nameselector")))) {
	      return; 
	     }
	     e.setCancelled(true);
	   }
	  }
	}