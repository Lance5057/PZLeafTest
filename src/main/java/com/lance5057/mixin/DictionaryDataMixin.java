package com.lance5057.mixin;

import java.util.List;
import java.util.Set;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.lance5057.ExampleMod;

import zombie.world.DictionaryData;
import zombie.world.ItemInfo;

@Mixin(DictionaryData.class)
public class DictionaryDataMixin implements IMixinConfigPlugin {

	@Override
	public void onLoad(String mixinPackage) {
		ExampleMod.LOGGER.println("DictionaryDataMixin loaded!");
	}

	@Override
	public String getRefMapperConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getMixins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		for (FieldNode f : targetClass.fields) {
			if (f.name.equals("itemIdToInfoMap")) {
				f.desc = "Ljava/util/Map;";
				f.signature = "Ljava/util/Map<Ljava/lang/Integer;Lzombie.world/ItemInfo;>;";
				ExampleMod.LOGGER.println("DictionaryData patched");
			}
		}
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		// TODO Auto-generated method stub

	}

	@Inject(method = "getItemInfoFromID", at = @At("RETURN"), cancellable = true)
	protected void getItemInfoFromID(CallbackInfoReturnable<ItemInfo> cir) {
		ExampleMod.LOGGER.println("We don't do that no more. getItemInfoFromID - " + 0);
		cir.setReturnValue(null);
	}

	@Inject(method = "getItemInfoFromType", at = @At("HEAD"))
	protected void getItemInfoFromType(CallbackInfoReturnable<ItemInfo> cir) {
		ExampleMod.LOGGER.println("getItemInfoFromType - ");
	}

}
