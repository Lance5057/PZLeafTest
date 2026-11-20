package com.lance5057.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.lance5057.ExampleMod;

import zombie.world.ItemInfo;
import zombie.world.WorldDictionary;

@Mixin(WorldDictionary.class)
public class WorldDictionaryMixin {

	@Inject(method = "getItemInfoFromID", at = @At("HEAD"))
	private static void getItemInfoFromID(short arg0, CallbackInfoReturnable<ItemInfo> cir) {
		ExampleMod.LOGGER.println("WorldDictionary$getItemInfoFromID - " + arg0);
	}
}
