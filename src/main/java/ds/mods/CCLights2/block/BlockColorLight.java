package ds.mods.CCLights2.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ds.mods.CCLights2.CCLights2;
import ds.mods.CCLights2.block.tileentity.TileEntityColorLight;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockColorLight extends BlockContainer {

	public BlockColorLight(int par1, Material par2Material) {
		super(par2Material);
		this.setBlockName("Light");
		this.setLightLevel(1.0F);
		this.setHardness(0.6F).setStepSound(Block.soundTypeStone);
		this.setCreativeTab(CCLights2.ccltab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.blockIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
       par1IconRegister.registerIcon("CCLights:light");
	}
	@Override
	public int quantityDropped(Random random)
    {
        return 1;
    }

    @Override
	public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileEntityColorLight();
    }
}
