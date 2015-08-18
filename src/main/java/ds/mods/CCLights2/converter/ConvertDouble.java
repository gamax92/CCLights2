package ds.mods.CCLights2.converter;

import dan200.computercraft.api.lua.LuaException;

public class ConvertDouble {
	public static Double convert(Object obj) throws LuaException
	{
		if (obj instanceof Double)
			return (Double) obj;
		else
			throw new LuaException("double expected, got "+obj.getClass().getName());
	}
}
