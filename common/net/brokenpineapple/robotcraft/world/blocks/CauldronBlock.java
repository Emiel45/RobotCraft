/*******************************************************************************
 * Copyright (c) 2012 Emiel Tasseel.
 * All rights reserved. This file is part of RobotCraft.
 * 
 * RobotCraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *  
 * RobotCraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  
 * You should have received a copy of the GNU General Public License
 * along with RobotCraft.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package net.brokenpineapple.robotcraft.world.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockCauldron;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.registry.GameRegistry;

public class CauldronBlock extends OverrideBlock {

	private final static Block self = Block.cauldron;

	public CauldronBlock() {
		super(3802, Block.cauldron);
		super.isBlockContainer = true;

		GameRegistry.registerTileEntity(CauldronTileEntity.class, "cauldron");
		RenderingRegistry.registerBlockHandler(new ISimpleBlockRenderingHandler() {

			@Override
			public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
			}

			@Override
			public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
				return renderer.renderBlockCauldron((BlockCauldron) self, x, y, z);
			}

			@Override
			public boolean shouldRender3DInInventory() {
				return false;
			}

			@Override
			public int getRenderId() {
				return 3802;
			}

		});
	}

	public int getRenderType() {
		return 3802;
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new CauldronTileEntity();
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		world.setBlockTileEntity(x, y, z, new CauldronTileEntity());
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int metadata) {
		world.removeBlockTileEntity(x, y, z);
	}

	public int getBlockTextureFromSideAndMetadata(int side, int metaData) {
		return self.getBlockTextureFromSideAndMetadata(side, metaData);
	}

	public void addCollidingBlockToList(World world, int x, int y, int z, AxisAlignedBB bb, List list, Entity entity) {
		self.addCollidingBlockToList(world, x, y, z, bb, list, entity);
	}

	public void setBlockBoundsForItemRender() {
		self.setBlockBoundsForItemRender();
	}

	public boolean isOpaqueCube() {
		return self.isOpaqueCube();
	}

	public boolean renderAsNormalBlock() {
		return self.renderAsNormalBlock();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xhit, float yhit, float zhit) {
		return self.onBlockActivated(world, x, y, z, player, side, xhit, yhit, zhit);
	}

	public void fillWithRain(World world, int x, int y, int z) {
		self.fillWithRain(world, x, y, z);
	}

	public int idDropped(int metadata, Random random, int unused) {
		return self.idDropped(metadata, random, unused);
	}

	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z) {
		return self.idPicked(world, x, y, z);
	}

}
