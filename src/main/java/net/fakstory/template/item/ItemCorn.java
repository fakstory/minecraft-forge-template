package net.fakstory.template.item;

import net.fakstory.template.TemplateMod;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemCorn extends ItemFood {

	public ItemCorn() {
		super(3, 0.6f, false);
		setUnlocalizedName("corn");
		setRegistryName("corn");
		setCreativeTab(TemplateMod.creativeTab);
	}

	public void registerItemModel() {
		TemplateMod.proxy.registerItemRenderer(this, 0, "corn");
	}

	public void initOreDict() {
		OreDictionary.registerOre("cropCorn", this);
	}

}
