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
		for (int i = 0; i < 6; i++) {
			int xPos = x;
			int yPos = y;
			int zPos = z;

			switch (i) {
			case 0:
				xPos--;
				break;
			case 1:
				yPos--;
				break;
			case 2:
				zPos--;
				break;
			case 3:
				xPos++;
				break;
			case 4:
				yPos++;
				break;
			case 5:
				zPos++;
				break;
			}

			int blockID = world.getBlockId(xPos, yPos, zPos);
			if (blockID == Block.stone.blockID /* || blockID == this.blockID */) {
				canGenerate = true;
			}
		}
		return canGenerate;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int count = veinCount.pick(random);
		for (int vein = 0; vein < count; vein++) {
			int altitude = veinAltitude.pick(random);
			int size = veinSize.pick(random);

			int xPos = chunkX * 16 + random.nextInt(16);
			int zPos = chunkZ * 16 + random.nextInt(16);
			int yPos = altitude;

			for (int i = 0; i < size; i++) {
				if (random.nextInt(size / 2) == 0) {
					for (int a = 0; a < size * 2; a++) {
						switch (random.nextInt(6)) {
						case 0:
							xPos--;
							break;
						case 1:
							yPos--;
							break;
						case 2:
							zPos--;
							break;
						case 3:
							xPos++;
							break;
						case 4:
							yPos++;
							break;
						case 5:
							zPos++;
							break;
						}
					}
					continue;
				}

				if (canGenerate(world, xPos, yPos, zPos)) {
					world.setBlock(xPos, yPos, zPos, blockID);
				}

				switch (random.nextInt(6)) {
				case 0:
					xPos--;
					break;
				case 1:
					yPos--;
					break;
				case 2:
					zPos--;
					break;
				case 3:
					xPos++;
					break;
				case 4:
					yPos++;
					break;
				case 5:
					zPos++;
					break;
				}
			}
		}
	}

}
