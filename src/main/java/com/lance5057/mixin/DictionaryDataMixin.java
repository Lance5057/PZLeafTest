package com.lance5057.mixin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.lance5057.ExampleMod;
import com.lance5057.mixin.accessors.DictionaryDataAccessor;

import zombie.world.DictionaryData;
import zombie.world.EntityInfo;
import zombie.world.ItemInfo;

@Mixin(DictionaryData.class)
public class DictionaryDataMixin {

	@Shadow
	protected final Map<Integer, ItemInfo> itemIdToInfoMap = new HashMap<>();

	@Shadow
	protected final Map<Integer, EntityInfo> entityIdToInfoMap = new HashMap<>();

	@Inject(method = "getItemInfoFromID", at = @At("RETURN"), cancellable = true)
	protected void getItemInfoFromID(int registeryID, CallbackInfoReturnable<ItemInfo> cir) {
		ExampleMod.LOGGER.println("DictionaryData$getItemInfoFromID - " + registeryID);
		cir.setReturnValue(null);
	}

	@Inject(method = "getItemInfoFromType", at = @At("RETURN"))
	protected void getItemInfoFromType(String fulltype, CallbackInfoReturnable<ItemInfo> cir) {
		ExampleMod.LOGGER.println("DictionaryData$getItemInfoFromType - " + fulltype);
		System.out.println("getItemInfoFromType - " + fulltype);
		cir.setReturnValue(null);
	}

	@Inject(method = "getDictionaryMods", at = @At("HEAD"), cancellable = true)
	protected final void getDictionaryMods(List<String> list, CallbackInfo ci) {
		ExampleMod.LOGGER.println("DictionaryData$getDictionaryMods!");
		list.clear();

		for (Entry<Integer, ItemInfo> entry : itemIdToInfoMap.entrySet()) {
			if (!list.contains(entry.getValue().getModID())) {
				list.add(entry.getValue().getModID());
			}

			if (entry.getValue().getModOverrides() != null) {
				List<String> s = entry.getValue().getModOverrides();

				for (int i = 0; i < s.size(); i++) {
					if (!list.contains(s.get(i))) {
						list.add(s.get(i));
					}
				}
			}
		}

		for (Entry<Integer, EntityInfo> entry : entityIdToInfoMap.entrySet()) {
			if (!list.contains(entry.getValue().getModID())) {
				list.add(entry.getValue().getModID());
			}

			if (entry.getValue().getModOverrides() != null) {
				List<String> s = entry.getValue().getModOverrides();

				for (int i = 0; i < s.size(); i++) {
					if (!list.contains(s.get(i))) {
						list.add(s.get(i));
					}
				}
			}
		}

		ci.cancel();
	}

}
