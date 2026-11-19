package com.lance5057.mixin;

import org.spongepowered.asm.mixin.Mixin;

import zombie.world.WorldDictionary;

@Mixin(WorldDictionary.class)
public class WorldDictionaryMixin {
//	@Inject(method = "getItemInfoFromID", at = @At("HEAD"), cancellable = false)
//	private void getItemInfoFromID(CallbackInfo cir, short arg0) {
//		LOGGER.println("getItemInfoFromID - " + arg0);
//	}
}
