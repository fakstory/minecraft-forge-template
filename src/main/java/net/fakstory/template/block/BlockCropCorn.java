package net.fakstory.template.block;

import net.fakstory.template.TemplateMod;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.fakstory.template.item.ModItems;

public class BlockCropCorn extends BlockCrops {

	public BlockCropCorn() {
		setUnlocalizedName("crop_corn");
		setRegistryName("crop_corn");

		setCreativeTab(TemplateMod.creativeTab);
	}

	@Override
	protected Item getSeed() {
		return ModItems.cornSeed;
	}

	@Override
	protected Item getCrop() {
		return ModItems.corn;
	}

}
