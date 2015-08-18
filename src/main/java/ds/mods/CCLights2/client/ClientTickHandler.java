package ds.mods.CCLights2.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import ds.mods.CCLights2.block.tileentity.TileEntityTTrans;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class ClientTickHandler {
	public static TileEntityTTrans tile; //Invoke screenshot when this is here

	@SubscribeEvent
	 public void onRenderTick(TickEvent.RenderTickEvent event) {
		if (tile != null)
		{
			//get minecraft settings
			Minecraft mc = Minecraft.getMinecraft();
			GameSettings gs = mc.gameSettings;
			boolean hideGuiState = gs.hideGUI;
			int thirdPersonState = gs.thirdPersonView;
			//start render instance
			gs.hideGUI = true;
			gs.thirdPersonView = 0;
			mc.entityRenderer.renderWorld(0, 0);
			gs.hideGUI = hideGuiState;
			gs.thirdPersonView = thirdPersonState;
			//most of render we need is done, lets take a picture :DDDDDDDD
			ClientProxy.takeScreenshot(tile);
			//reset tileent so we can use it again.
			tile = null;
		}
	}
}
