package net.fakstory.template;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.fakstory.template.block.pedestal.ContainerPedestal;
import net.fakstory.template.block.pedestal.GuiPedestal;
import net.fakstory.template.block.pedestal.TileEntityPedestal;

public class ModGuiHandler implements IGuiHandler {

	public static final int PEDESTAL = 0;

	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case PEDESTAL:
				return new ContainerPedestal(player.inventory, (TileEntityPedestal)world.getTileEntity(new BlockPos(x, y, z)));
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case PEDESTAL:
				return new GuiPedestal(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
			default:
				return null;
		}
	}

}
