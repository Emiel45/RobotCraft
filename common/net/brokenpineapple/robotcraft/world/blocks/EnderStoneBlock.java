package net.brokenpineapple.robotcraft.world.blocks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import net.brokenpineapple.robotcraft.RobotCraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class EnderStoneBlock extends OverrideBlock {
	
	public EnderStoneBlock() {
		super(3801, Block.whiteStone);
		super.setHardness(3.0F);
		super.setResistance(15.0F);
		super.setStepSound(soundStoneFootstep);
		super.setBlockName("whiteStone");
		super.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> droppedItems = super.getBlockDropped(world, x, y, z, metadata, fortune);

		if(fortune > 0) {
			System.out.println("1 out of " + (16 * 3 / fortune));
			if(world.rand.nextInt(16 * 3 / fortune) == 0) {
				droppedItems.add(new ItemStack(RobotCraft.enderDustItem));
			}
		}
		
		return droppedItems;
	}	
	
}
