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

import java.util.Random;

import net.brokenpineapple.robotcraft.util.MinMax;
import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreWorldGenerator implements IWorldGenerator {

	private OreType type;
	private int blockID;
	
	private MinMax veinCount;
	private MinMax veinSize;
	private MinMax veinAltitude;
	
	public OreWorldGenerator(OreType type) {
		this.type = type;
		this.blockID = type.getID();
		
		this.veinCount = type.getVeinCount();
		this.veinSize = type.getVeinSize();
		this.veinAltitude = type.getVeinAltitude();
	}
	
	public boolean canGenerate(World world, int x, int y, int z) {
		boolean canGenerate = false;
		for(int i = 0; i < 6; i++) {
			int xPos = x;
			int yPos = y;
			int zPos = z;
			
			switch(i) {
				case 0: xPos--; break;
				case 1: yPos--; break;
				case 2: zPos--; break;
				case 3: xPos++; break;
				case 4: yPos++; break;
				case 5: zPos++; break;
			}
			
			int blockID = world.getBlockId(xPos, yPos, zPos);
			if(blockID == Block.stone.blockID /*|| blockID == this.blockID*/) {
				canGenerate = true;
			}
		}
		return canGenerate;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int count = veinCount.pick(random);
		for(int vein = 0; vein < count; vein++) {
			int altitude = veinAltitude.pick(random);
			int size = veinSize.pick(random);

			int xPos = chunkX * 16 + random.nextInt(16);
			int zPos = chunkZ * 16 + random.nextInt(16);
			int yPos = altitude;
			//System.out.println("Spawning vein of " + size + " blocks @ {" + xPos + ", " + yPos + ", " + zPos + "}");
			
			for(int i = 0; i < size; i++) {
				if(random.nextInt(size / 2) == 0) {
					for(int a = 0; a < size * 2; a++) {
						switch(random.nextInt(6)) {
							case 0: xPos--; break;
							case 1: yPos--; break;
							case 2: zPos--; break;
							case 3: xPos++; break;
							case 4: yPos++; break;
							case 5: zPos++; break;
						}
					}
					continue;
				}
				
				if(canGenerate(world, xPos, yPos, zPos)) {
					world.setBlock(xPos, yPos, zPos, blockID);
				}

				switch(random.nextInt(6)) {
					case 0: xPos--; break;
					case 1: yPos--; break;
					case 2: zPos--; break;
					case 3: xPos++; break;
					case 4: yPos++; break;
					case 5: zPos++; break;
				}
			}
		}
	}

}
