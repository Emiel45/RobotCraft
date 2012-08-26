/*******************************************************************************
 * Copyright (c) 2012 Mast3rPlan.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors:
 *     Mast3rPlan
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
