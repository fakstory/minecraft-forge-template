package net.fakstory.template.item;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.fakstory.template.TemplateMod;

public class ItemArmor extends net.minecraft.item.ItemArmor {

	private String name;

	public ItemArmor(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, 0, slot);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	public void registerItemModel() {
		TemplateMod.proxy.registerItemRenderer(this, 0, name);
	}

}
