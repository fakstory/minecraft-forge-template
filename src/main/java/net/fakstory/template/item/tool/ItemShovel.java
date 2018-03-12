package net.fakstory.template.item.tool;

import net.fakstory.template.TemplateMod;
import net.minecraft.item.ItemSpade;

public class ItemShovel extends ItemSpade {

	private String name;

	public ItemShovel(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	public void registerItemModel() {
		TemplateMod.proxy.registerItemRenderer(this, 0, name);
	}

}
