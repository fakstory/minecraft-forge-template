package net.fakstory.template.item;

import net.fakstory.template.TemplateMod;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.fakstory.template.item.tool.*;

public class ModItems {

	public static ItemOre ingotCopper = new ItemOre("ingot_copper", "ingotCopper");
	public static ItemCorn corn = new ItemCorn();
	public static ItemCornSeed cornSeed = new ItemCornSeed();
	public static ItemSword copperSword = new ItemSword(TemplateMod.copperToolMaterial, "copper_sword");
	public static ItemPickaxe copperPickaxe = new ItemPickaxe(TemplateMod.copperToolMaterial, "copper_pickaxe");
	public static ItemShovel copperShovel = new ItemShovel(TemplateMod.copperToolMaterial, "copper_shovel");
	public static ItemAxe copperAxe = new ItemAxe(TemplateMod.copperToolMaterial, "copper_axe");
	public static ItemHoe copperHoe = new ItemHoe(TemplateMod.copperToolMaterial, "copper_hoe");
	public static ItemArmor copperHelmet = new ItemArmor(TemplateMod.copperArmorMaterial, EntityEquipmentSlot.HEAD, "copper_helmet");
	public static ItemArmor copperChestplate = new ItemArmor(TemplateMod.copperArmorMaterial, EntityEquipmentSlot.CHEST, "copper_chestplate");
	public static ItemArmor copperLeggings = new ItemArmor(TemplateMod.copperArmorMaterial, EntityEquipmentSlot.LEGS, "copper_leggings");
	public static ItemArmor copperBoots = new ItemArmor(TemplateMod.copperArmorMaterial, EntityEquipmentSlot.FEET, "copper_boots");

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				ingotCopper,
				corn,
				cornSeed,
				copperSword,
				copperPickaxe,
				copperShovel,
				copperAxe,
				copperHoe,
				copperHelmet,
				copperChestplate,
				copperLeggings,
				copperBoots
		);
	}

	public static void registerModels() {
		ingotCopper.registerItemModel();
		corn.registerItemModel();
		cornSeed.registerItemModel();
		copperSword.registerItemModel();
		copperPickaxe.registerItemModel();
		copperShovel.registerItemModel();
		copperAxe.registerItemModel();
		copperHoe.registerItemModel();
		copperHelmet.registerItemModel();
		copperChestplate.registerItemModel();
		copperLeggings.registerItemModel();
		copperBoots.registerItemModel();
	}

}
