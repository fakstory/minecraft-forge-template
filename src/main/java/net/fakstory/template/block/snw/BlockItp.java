package net.fakstory.template.block.snw;

import net.fakstory.template.block.BlockTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import org.apache.logging.log4j.Logger;
import net.fakstory.externalNetwork.TcpClient;

import javax.annotation.Nullable;
import net.fakstory.externalNetwork.TcpClient;

public class BlockItp extends BlockTileEntity<BlockItpLogic> {

	private static Logger logger;
	private TcpClient tcpClient;

	public BlockItp() {
		super(Material.ROCK, "BlockItp");
		tcpClient = new TcpClient();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		System.out.println("onBlockActivated");
		if (!world.isRemote) {
			BlockItpLogic tile = getTileEntity(world, pos);
			if (side == EnumFacing.DOWN) {
				tile.decrementCount();
			} else if (side == EnumFacing.UP) {
				tile.incrementCount();
			}
			player.sendMessage(new TextComponentString("Count: " + tile.getCount()));
			this.tcpClient.send(Integer.toString(tile.getCount()));
		}
		return true;
	}

	@Override
	public Class<BlockItpLogic> getTileEntityClass()
	{
		return BlockItpLogic.class;
	}

	@Nullable
	@Override
	public BlockItpLogic createTileEntity(World world, IBlockState state) {
		this.tcpClient.send("Not Created yet!");
		System.out.println("createTileEntity");
		return new BlockItpLogic();
	}
}
