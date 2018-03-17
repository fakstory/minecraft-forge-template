package net.fakstory.template;

import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.fakstory.template.block.ModBlocks;
import net.fakstory.template.client.TemplateTab;
import net.fakstory.template.item.ModItems;
import net.fakstory.template.network.PacketRequestUpdatePedestal;
import net.fakstory.template.network.PacketUpdatePedestal;
import net.fakstory.template.proxy.CommonProxy;
import net.fakstory.template.recipe.ModRecipes;
import net.fakstory.template.world.ModWorldGen;
import net.fakstory.externalNetwork.TcpClient;

@Mod(modid = TemplateMod.modId, name = TemplateMod.name, version = TemplateMod.version)
public class TemplateMod {

	public static final String modId = "template";
	public static final String name = "Template Mod";
	public static final String version = "0.0.1";

	@Mod.Instance(modId)
	public static TemplateMod instance;

	@SidedProxy(serverSide = "net.fakstory.template.proxy.CommonProxy", clientSide = "net.fakstory.template.proxy.ClientProxy")
	public static CommonProxy proxy;

	public static final TemplateTab creativeTab = new TemplateTab();
	public static final Item.ToolMaterial copperToolMaterial = EnumHelper.addToolMaterial("COPPER", 2, 500, 6, 2, 14);
	public static final ItemArmor.ArmorMaterial copperArmorMaterial = EnumHelper.addArmorMaterial("COPPER", modId + ":copper", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static SimpleNetworkWrapper network;
	public static TcpClient tcpClient = new TcpClient();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
		proxy.registerRenderers();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(modId);
		network.registerMessage(new PacketUpdatePedestal.Handler(), PacketUpdatePedestal.class, 0, Side.CLIENT);
		network.registerMessage(new PacketRequestUpdatePedestal.Handler(), PacketRequestUpdatePedestal.class, 1, Side.SERVER);
		tcpClient = new TcpClient();
		tcpClient.send("tata");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		ModRecipes.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@Mod.EventBusSubscriber
	public static class RegsitrationHandler {

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
			ModBlocks.registerItemBlocks(event.getRegistry());
		}

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {

			ModBlocks.register(event.getRegistry());
		}

		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			ModItems.registerModels();
			ModBlocks.registerModels();
		}
	}

}