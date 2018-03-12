package net.fakstory.template.item.tool;

import net.fakstory.template.TemplateMod;

public class ItemHoe extends net.minecraft.item.ItemHoe {

	private String name;

	public ItemHoe(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	public void registerItemModel() {
		TemplateMod.proxy.registerItemRenderer(this, 0, name);
	}

}
