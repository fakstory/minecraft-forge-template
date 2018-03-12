package net.fakstory.template.item.tool;

import net.fakstory.template.TemplateMod;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe {

	private String name;

	public ItemPickaxe(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	public void registerItemModel() {
		TemplateMod.proxy.registerItemRenderer(this, 0, name);
	}

}
