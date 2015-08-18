package ds.mods.CCLights2.converter;

import dan200.computercraft.api.lua.LuaException;

public class ConvertString {
	public static String convert(Object obj) throws LuaException
	{
		if (obj instanceof String)
			return (String) obj;
		else
			throw new LuaException("string expected, got "+obj.getClass().getSimpleName());
	}
}
