package ds.mods.CCLights2.serialize;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import ds.mods.CCLights2.block.tileentity.TileEntityGPU;
import ds.mods.CCLights2.client.ClientProxy;
import ds.mods.CCLights2.gpu.GPU;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GPUSerializer implements ISerializer {

	@Override
	public void write(Object o, ByteArrayDataOutput dat) {
		GPU g = (GPU)o;
		dat.writeInt(g.tile.xCoord);
		dat.writeInt(g.tile.yCoord);
		dat.writeInt(g.tile.zCoord);
		dat.writeInt(g.tile.getWorldObj().provider.dimensionId);
	}

	@Override
	public Object read(ByteArrayDataInput dat) {
		
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		int d = dat.readInt();
		
		World world = ClientProxy.getClientWorld();
		
		TileEntity noncast = world.getTileEntity(x, y, z);
		if (noncast != null)
		{
			TileEntityGPU g = (TileEntityGPU) noncast;
			return g.gpu;
		}
		
		return null;
	}

}
