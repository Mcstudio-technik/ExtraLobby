package ik.wuksowik.mop.utils;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import ik.wuksowik.mop.Main;

public class ExtraPanel {
	
	private static final List<String> BUILD_LORE = Arrays.asList(new String[] { "&8>> &7Click to update status!", "&8>> &7for this option!" });
	private static final List<String> PvP_LORE = Arrays.asList(new String[] { "&8>> &7Click to update status!", "&8>> &7for this option!" });
	private static final List<String> Drop_LORE = Arrays.asList(new String[] { "&8>> &7Click to update status!", "&8>> &7for this option!" });
	private static final List<String> Move_LORE = Arrays.asList(new String[] { "&8>> &7Click to update status!", "&8>> &7for this option!" });
	private static final List<String> PickUp_LORE = Arrays.asList(new String[] { "&8>> &7Click to update status!", "&8>> &7for this option!" });

  public final static InventoryView main(Player p) {
  Inventory inv = Bukkit.createInventory(p, 9, ChatUtil.colorPlaceHolder(p, "&2&lExtraPanel"));
  Items perms = new Items(Material.BOOK).setDisplayName("&2Build and Break {STATUS}".replace("{STATUS}", Main.getInst().getConfig().getBoolean("protect_block") ? ChatUtil.colorPlaceHolder(p,"&c&lOFF &8(&c✖&8)") : ChatUtil.colorPlaceHolder(p,"&a&lON &8(&a&l✔&8)"))).setLore(BUILD_LORE);
  Items prolong = new Items(Material.BOOK).setDisplayName("&cPvP {STATUS}".replace("{STATUS}", Main.getInst().getConfig().getBoolean("player.Disablepvp") ? ChatUtil.colorPlaceHolder(p,"&c&lOFF &8(&c✖&8)") : ChatUtil.colorPlaceHolder(p,"&a&lON &8(&a&l✔&8)"))).setLore(PvP_LORE);
  Items message = new Items(Material.PAPER).setDisplayName("&3Drop-Item {STATUS}".replace("{STATUS}", Main.getInst().getConfig().getBoolean("item.OFF-dropitem") ? ChatUtil.colorPlaceHolder(p,"&c&lOFF &8(&c✖&8)") : ChatUtil.colorPlaceHolder(p,"&a&lON &8(&a&l✔&8)"))).setLore(Drop_LORE); 
  Items enlarge = new Items(Material.BOOK).setDisplayName("&bPickUP-Item {STATUS}".replace("{STATUS}", Main.getInst().getConfig().getBoolean("item.OFF-pickupitem") ? ChatUtil.colorPlaceHolder(p,"&c&lOFF &8(&c✖&8)") : ChatUtil.colorPlaceHolder(p,"&a&lON &8(&a&l✔&8)"))).setLore(PickUp_LORE);
  Items mobs = new Items(Material.BOOK).setDisplayName("&6MoveInventory-Item {STATUS}".replace("{STATUS}", Main.getInst().getConfig().getBoolean("item.OFF-moveitem") ? ChatUtil.colorPlaceHolder(p,"&c&lOFF &8(&c✖&8)") : ChatUtil.colorPlaceHolder(p,"&a&lON &8(&a&l✔&8)"))).setLore(Move_LORE);
  inv.setItem(2, perms.build());
  inv.setItem(3, prolong.build());
  inv.setItem(4, message.build());
  inv.setItem(5, enlarge.build());
  inv.setItem(6, mobs.build());
  return p.openInventory(inv);
  }
 }