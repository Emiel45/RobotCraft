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