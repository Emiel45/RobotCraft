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

import net.brokenpineapple.robotcraft.util.ReflectionHelper;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class OverrideBlock extends Block {

	public OverrideBlock(int blockID, int overrideID, int textureID, Material material) {
		super(blockID, textureID, material);

		if(!ReflectionHelper.setFinalField(Block.class, this, "ca", overrideID))
			if(!ReflectionHelper.setFinalField(Block.class, this, "blockID", overrideID))
				throw new RuntimeException("couldn't force blockID");
		
		blocksList[overrideID] = this;
		opaqueCubeLookup[overrideID] = this.isOpaqueCube();
		lightOpacity[overrideID] = this.isOpaqueCube() ? 255 : 0;
		canBlockGrass[overrideID] = !Material.rock.getCanBlockGrass();

		for (Field field : Block.class.getFields()) {
			if(Modifier.isFinal(field.getModifiers()) && Modifier.isPublic(field.getModifiers()) && field.getType() == Block.class) {
				try {
					Block block = (Block)field.get(null);
					if(block.blockID == overrideID) {
						ReflectionHelper.setFinalField(Block.class, null, field.getName(), this);
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public OverrideBlock(int blockID, Block overrideTarget) {
		this(blockID, overrideTarget.blockID, overrideTarget.blockIndexInTexture, overrideTarget.blockMaterial);
	}

}
