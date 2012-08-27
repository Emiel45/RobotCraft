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
package net.brokenpineapple.robotcraft.world.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class EnderDustItem extends Item {

	public EnderDustItem() {
		super(3701);
		super.setItemName("enderDust");
		super.setIconIndex(0);
		super.setTabToDisplayOn(CreativeTabs.tabMaterials);

		LanguageRegistry.addName(this, "Ender Dust");
	}

	@Override
	public String getTextureFile() {
		return "/net/brokenpineapple/robotcraft/sprites/misc.png";
	}

}
