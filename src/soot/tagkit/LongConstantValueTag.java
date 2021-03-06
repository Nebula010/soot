/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 Archie L. Cobbs
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */

package soot.tagkit;

import soot.jimple.LongConstant;

public class LongConstantValueTag extends ConstantValueTag {
	private final long value;

	public LongConstantValueTag(long value) {
		this.value = value;
		this.bytes = new byte[] { (byte) ((value >> 56) & 0xff), (byte) ((value >> 48) & 0xff),
				(byte) ((value >> 40) & 0xff), (byte) ((value >> 32) & 0xff), (byte) ((value >> 24) & 0xff),
				(byte) ((value >> 16) & 0xff), (byte) ((value >> 8) & 0xff), (byte) ((value) & 0xff) };
	}

	public long getLongValue() {
		return value;
	}

	public String toString() {
		return "ConstantValue: " + Long.toString(value);
	}

	@Override
	public LongConstant getConstant() {
		return LongConstant.v(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (value ^ (value >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LongConstantValueTag other = (LongConstantValueTag) obj;
		if (value != other.value)
			return false;
		return true;
	}

}
