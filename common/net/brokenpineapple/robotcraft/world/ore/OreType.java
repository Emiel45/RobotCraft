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

import net.brokenpineapple.robotcraft.util.MinMax;

public enum OreType {
	COPPER(3601, "copperOre", "Copper Ore", 4.0f, 5.2f, 0, 0, new MinMax(0, 2), new MinMax(16, 64), new MinMax(8, 48)),
	TIN(3602, "tinOre", "Tin Ore", 2.5f, 3.5f, 1, 0, new MinMax(0, 2), new MinMax(16, 64), new MinMax(8, 48)),

	LEAD(3603, "leadOre", "Lead Ore", 5.0f, 8.0f, 2, 0, new MinMax(0, 2), new MinMax(16, 64), new MinMax(8, 48));

	private int id;
	private final String friendlyName;
	private final String name;

	private float hardness;
	private float resistance;

	private final int spriteIndex;
	private final int levels;

	private final MinMax veinCount;
	private final MinMax veinSize;
	private final MinMax veinAltitude;

	private OreBlock block;
	private OreWorldGenerator worldGenerator;

	private OreType(int id, String friendlyName, String name, float hardness, float resistance, int spriteIndex, int levels, MinMax veinCount, MinMax veinSize, MinMax veinAltitude) {
		this.id = id;
		this.friendlyName = friendlyName;
		this.name = name;

		this.hardness = hardness;
		this.resistance = resistance;

		this.spriteIndex = spriteIndex;
		this.levels = levels;

		this.veinCount = veinCount;
		this.veinSize = veinSize;
		this.veinAltitude = veinAltitude;

		this.block = new OreBlock(this);
		this.worldGenerator = new OreWorldGenerator(this);
	}

	public int getID() {
		return id;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public String getName() {
		return name;
	}

	public float getHardness() {
		return hardness;
	}

	public float getResistance() {
		return resistance;
	}

	public int getSpriteIndex() {
		return spriteIndex;
	}

	public int getLevels() {
		return levels;
	}

	public MinMax getVeinCount() {
		return veinCount;
	}

	public MinMax getVeinSize() {
		return veinSize;
	}

	public MinMax getVeinAltitude() {
		return veinAltitude;
	}

	public OreBlock getBlock() {
		return block;
	}

	public OreWorldGenerator getWorldGenerator() {
		return worldGenerator;
	}

}
