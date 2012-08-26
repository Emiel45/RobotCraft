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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.src.Block;

public class ReflectionHelper {

	public static <T> boolean setFinalField(Class<T> clazz, T instance, String fieldName, Object value) {
		try {
			Field field = Block.class.getField(fieldName);
			field.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			field.set(instance, value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
