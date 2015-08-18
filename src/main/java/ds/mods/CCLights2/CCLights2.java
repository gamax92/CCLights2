package ds.mods.CCLights2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import ds.mods.CCLights2.network.PacketHandler;
import ds.mods.CCLights2.network.PacketHandler.PacketMessage;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = "CCLights2", name = "CCLights2", version = "0.4.3", dependencies="required-after:ComputerCraft@[1.7,)", acceptedMinecraftVersions = "1.7.10")
public class CCLights2 {
	@Mod.Instance("CCLights2")
	public static CCLights2 instance;
	
	@SidedProxy(serverSide = "ds.mods.CCLights2.CommonProxy", clientSide = "ds.mods.CCLights2.client.ClientProxy")
	public static CommonProxy proxy;
	
	public static Block gpu,monitor,monitorBig,light,advancedlight,ttrans;
	public static Item ram,tablet;
	public static Logger logger;
	
	public static SimpleNetworkWrapper network = new SimpleNetworkWrapper("CCLights2");
	
	public static CreativeTabs ccltab = new CreativeTabs("CCLights2") {
		@Override
		public ItemStack getIconItemStack() {
			this.getTranslatedTabLabel();
			return new ItemStack(tablet, 1, 0);
		}

		@Override
		public Item getTabIconItem() {
			return tablet;
		}
	};

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));
		logger = event.getModLog();
		
		proxy.registerBlocks();
        
		logger.log(Level.INFO, "STANDING BY");
	}

	@Mod.EventHandler
	public void load(FMLPostInitializationEvent event) {
		proxy.registerRenderInfo();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        network.registerMessage(PacketHandler.class, PacketMessage.class, 0, Side.CLIENT);
        network.registerMessage(PacketHandler.class, PacketMessage.class, 1, Side.SERVER);
	}

	public static void debug(String debugmsg) {
		if (Config.DEBUGS) {
			logger.log(Level.INFO, debugmsg);
		}
	}
}
