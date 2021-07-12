package ik.wuksowik.mop.utils;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items extends ItemStack{
	
	  private ItemMeta meta;
	  		public Items(Material material, int amount, short durability) {
			    setType(material);
			    setAmount(amount);
			    setDurability(durability);
			    this.meta = getItemMeta();
			  }
			  
			  public Items(Material material, int amount) {
			    this(material, amount, (short)0);
			  }
			  
			  public Items(Material material) {
			    this(material, 1, (short)0);
			  }
			  
			  public Items(ItemStack itemStack) {
			    this(itemStack.getType(), itemStack.getAmount(), itemStack.getDurability());
			  }
			  
			  public Items setDisplayName(String displayName) {
				    this.meta.setDisplayName(ChatUtil.color(displayName));
				    return build();
				  }
			  
			  public Items build() {
				    setItemMeta(this.meta);
				    return this;
				  }
			  
			  public Items setLore(List<String> lore) {
				    for (int i = 0; i < lore.size(); i++)
				      lore.set(i, ChatUtil.color(lore.get(i))); 
				    this.meta.setLore(lore);
				    return build();
				  }
			  private List<String> lore;
			  
			  public Items addLore(String lore) {
				    this.lore.add(lore);
				    return this;
				  }
}