package ds.mods.CCLights2;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.world.World;

public class PeripheralProvider implements IPeripheralProvider
{

    @Override
    public IPeripheral getPeripheral(World world, int x, int y, int z, int side)
    {
        if(world.getTileEntity(x, y, z) instanceof IPeripheral)
        {
            return (IPeripheral) world.getTileEntity(x, y, z);
        }

        return null;
    }
}