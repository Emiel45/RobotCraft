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
package net.brokenpineapple.robotcraft;

import java.util.Random;

import net.brokenpineapple.robotcraft.world.ore.OreBlock;
import net.brokenpineapple.robotcraft.world.ore.OreType;
import net.brokenpineapple.robotcraft.world.ore.OreWorldGenerator;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "RobotCraft", version = "1.0")
@NetworkMod()
public class RobotCraft {

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForgeClient.preloadTexture("/net/brokenpineapple/robotcraft/sprites/ores.png");
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		for(OreType oreType : OreType.values()) {
			GameRegistry.registerBlock(oreType.getBlock());
			GameRegistry.registerWorldGenerator(oreType.getWorldGenerator());
			LanguageRegistry.addName(oreType.getBlock(), oreType.getName());
		}
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	
	
}
