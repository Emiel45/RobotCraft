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
package net.brokenpineapple.robotcraft;

import java.util.Random;

import net.brokenpineapple.robotcraft.world.blocks.CauldronBlock;
import net.brokenpineapple.robotcraft.world.blocks.EnderStoneBlock;
import net.brokenpineapple.robotcraft.world.items.EnderDustItem;
import net.brokenpineapple.robotcraft.world.items.TheCoreItem;
import net.brokenpineapple.robotcraft.world.ore.OreBlock;
import net.brokenpineapple.robotcraft.world.ore.OreType;
import net.brokenpineapple.robotcraft.world.ore.OreWorldGenerator;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
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

	public static EnderDustItem enderDustItem = new EnderDustItem();
	public static TheCoreItem theCoreItem = new TheCoreItem();

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForgeClient.preloadTexture("/net/brokenpineapple/robotcraft/sprites/ores.png");
		MinecraftForgeClient.preloadTexture("/net/brokenpineapple/robotcraft/sprites/misc.png");
	}

	@Init
	public void init(FMLInitializationEvent event) {
		for (OreType oreType : OreType.values()) {
			GameRegistry.registerBlock(oreType.getBlock());
			GameRegistry.registerWorldGenerator(oreType.getWorldGenerator());
			LanguageRegistry.addName(oreType.getBlock(), oreType.getName());
		}

		/* Register Overrides */
		System.out.println("[RobotCraft] Overriding blocks - Please ignore Item ID conflicts");
		GameRegistry.registerBlock(new EnderStoneBlock());
		GameRegistry.registerBlock(new CauldronBlock());
		System.out.println("[RobotCraft] Done Overriding blocks");
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {

	}

}
