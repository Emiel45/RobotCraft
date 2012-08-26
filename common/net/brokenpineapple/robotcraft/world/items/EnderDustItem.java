package net.brokenpineapple.robotcraft.world.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class EnderDustItem extends Item {

	public EnderDustItem() {
		super(3701);
		super.setIconIndex(0);
		super.setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		LanguageRegistry.addName(this, "Ender Dust");
	}

	@Override
	public String getTextureFile() {
		return "/net/brokenpineapple/robotcraft/sprites/misc.png";
	}

}
