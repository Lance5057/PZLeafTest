package com.lance5057.mixin.accessors;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import zombie.world.DictionaryData;
import zombie.world.EntityInfo;
import zombie.world.ItemInfo;

@Mixin({DictionaryData.class})
public interface DictionaryDataAccessor {
	@Accessor("itemIdToInfoMap")
	public Map<Integer, ItemInfo> getItemIdToInfoMap();
	
	@Accessor("entityIdToInfoMap")
	public Map<Integer, EntityInfo> getEntityIdToInfoMap();
}
