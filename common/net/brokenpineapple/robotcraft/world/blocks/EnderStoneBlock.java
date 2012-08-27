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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import net.brokenpineapple.robotcraft.RobotCraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class EnderStoneBlock extends OverrideBlock {
	
	public EnderStoneBlock() {
		super(3801, Block.whiteStone);
		super.setHardness(3.0F);
		super.setResistance(15.0F);
		super.setStepSound(soundStoneFootstep);
		super.setBlockName("whiteStone");
		super.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> droppedItems = super.getBlockDropped(world, x, y, z, metadata, fortune);

		if(fortune > 0) {
			if(world.rand.nextInt(16 * 3 / fortune) == 0) {
				droppedItems.add(new ItemStack(RobotCraft.enderDustItem));
			}
		}
		
		return droppedItems;
	}	
	
}
