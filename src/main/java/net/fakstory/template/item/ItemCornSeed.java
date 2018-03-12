package net.fakstory.template.item;

import net.fakstory.template.TemplateMod;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.fakstory.template.block.ModBlocks;

public class ItemCornSeed extends ItemSeeds {

	public ItemCornSeed() {
		super(ModBlocks.cropCorn, Blocks.FARMLAND);
		setUnlocalizedName("corn_seed");
		setRegistryName("corn_seed");

		setCreativeTab(TemplateMod.creativeTab);
	}

	public void registerItemModel() {
		TemplateMod.proxy.registerItemRenderer(this, 0, "corn_seed");
	}

}
