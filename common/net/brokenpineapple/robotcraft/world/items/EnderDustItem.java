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
