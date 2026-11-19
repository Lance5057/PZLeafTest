package com.lance5057.mixin;

import static com.lance5057.ExampleMod.LOGGER;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import zombie.core.Core;

@Mixin(Core.class)
public class ExampleMixin {
    @Inject(method = "getVersion", at = @At("RETURN"), cancellable = true)
	private void getVersion(CallbackInfoReturnable<String> cir) {
        LOGGER.println("Changing the internal game version.");
        cir.setReturnValue("LanceDev");
    }
}
