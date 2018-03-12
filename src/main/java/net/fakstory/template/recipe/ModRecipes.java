package net.fakstory.template.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.fakstory.template.block.ModBlocks;
import net.fakstory.template.item.ModItems;

public class ModRecipes {

	public static void init() {
//		Ore Dict
		ModBlocks.oreCopper.initOreDict();
		ModItems.ingotCopper.initOreDict();
		ModItems.corn.initOreDict();

//		Smelting
		GameRegistry.addSmelting(ModBlocks.oreCopper, new ItemStack(ModItems.ingotCopper), 0.7f);
	}

}
