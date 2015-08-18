package ds.mods.CCLights2.converter;

import dan200.computercraft.api.lua.LuaException;

public class ConvertInteger {
	public static Integer convert(Object obj) throws LuaException
	{
		return ConvertDouble.convert(obj).intValue();
	}
}
