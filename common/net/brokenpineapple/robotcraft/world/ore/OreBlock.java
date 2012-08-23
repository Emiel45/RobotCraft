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
package net.brokenpineapple.robotcraft.world.ore;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class OreBlock extends Block {
	
	private OreType type;
	
	public OreBlock(OreType type) {
		super(type.getID(), type.getSpriteIndex(), Material.rock);
		super.setBlockName(type.getFriendlyName());
		super.setHardness(type.getHardness());
		super.setResistance(type.getResistance());
		super.setStepSound(soundStoneFootstep);
		super.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public String getTextureFile() {
		return "/net/brokenpineapple/robotcraft/sprites/ores.png";
	}
	
}