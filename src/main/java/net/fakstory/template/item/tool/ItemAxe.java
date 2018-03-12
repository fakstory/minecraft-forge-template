package net.fakstory.template.item.tool;

import net.fakstory.template.TemplateMod;

public class ItemAxe extends net.minecraft.item.ItemAxe {

	private String name;

	public ItemAxe(ToolMaterial material, String name) {
		super(material, 8f, -3.1f);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	public void registerItemModel() {
		TemplateMod.proxy.registerItemRenderer(this, 0, name);
	}

}
