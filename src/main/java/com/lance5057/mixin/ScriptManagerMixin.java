package com.lance5057.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.lance5057.ExampleMod;

import zombie.scripting.ScriptManager;
import zombie.scripting.objects.Item;

@Mixin(ScriptManager.class)
public class ScriptManagerMixin {

	@Inject(method = "FindItem", at = @At("RETURN"), cancellable = true)
	private void FindItem(String name, CallbackInfoReturnable<Item> cir) {
//		ExampleMod.LOGGER.println("ScriptManager$FindItem - I wonder how bad this'll break stuff!");
		cir.setReturnValue(null);
	}
}
