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
package net.brokenpineapple.robotcraft.util;

import java.util.Random;

public class MinMax {

	private int min, max;
	
	public MinMax(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int getSpan() {
		return max - min;
	}
	
	public int pick(Random random) {
		return this.min + random.nextInt(this.max - this.min + 1);
	}
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
}
