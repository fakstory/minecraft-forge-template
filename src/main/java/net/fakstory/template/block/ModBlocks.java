package net.fakstory.template.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.fakstory.template.block.counter.BlockCounter;
import net.fakstory.template.block.pedestal.BlockPedestal;
import net.fakstory.template.block.snw.BlockItp;

public class ModBlocks {

	public static int number_of_itp = 0;
	public static BlockOre oreCopper = new BlockOre("ore_copper", "oreCopper");
	public static BlockCropCorn cropCorn = new BlockCropCorn();
	public static BlockPedestal pedestal = new BlockPedestal();
	public static BlockCounter counter = new BlockCounter();
	public static BlockItp itp = new BlockItp();

	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				oreCopper,
				cropCorn,
				pedestal,
				counter,
				itp
		);

		GameRegistry.registerTileEntity(pedestal.getTileEntityClass(), pedestal.getRegistryName().toString());
		GameRegistry.registerTileEntity(counter.getTileEntityClass(), counter.getRegistryName().toString());
		GameRegistry.registerTileEntity(itp.getTileEntityClass(), itp.getRegistryName().toString());
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				oreCopper.createItemBlock(),
				pedestal.createItemBlock(),
				counter.createItemBlock(),
				itp.createItemBlock()
		);
	}

	public static void registerModels() {
		oreCopper.registerItemModel(Item.getItemFromBlock(oreCopper));
		pedestal.registerItemModel(Item.getItemFromBlock(pedestal));
		counter.registerItemModel(Item.getItemFromBlock(counter));
		itp.registerItemModel(Item.getItemFromBlock(itp));
	}

}
