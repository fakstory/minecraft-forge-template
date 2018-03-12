package net.fakstory.template.item.tool;

import net.fakstory.template.TemplateMod;

public class ItemSword extends net.minecraft.item.ItemSword {

	private String name;

	public ItemSword(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	public void registerItemModel() {
		TemplateMod.proxy.registerItemRenderer(this, 0, name);
	}

}
