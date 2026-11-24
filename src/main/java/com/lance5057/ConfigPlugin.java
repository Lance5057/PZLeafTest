package com.lance5057;

import java.util.List;
import java.util.Set;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public class ConfigPlugin implements IMixinConfigPlugin {

	@Override
	public void onLoad(String mixinPackage) {

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
				ExampleMod.LOGGER.println("DictionaryData:itemIdToInfoMap patched");
			}
			if (f.name.equals("entityIdToInfoMap")) {
				f.desc = "Ljava/util/Map;";
				f.signature = "Ljava/util/Map<Ljava/lang/Integer;Lzombie.world/EntityInfo;>;";
				ExampleMod.LOGGER.println("DictionaryData:entityIdToInfoMap patched");
			}
		}

		for (MethodNode m : targetClass.methods) {
			if (m.name.equals("getItemInfoFromID") && m.desc.equals("(S)Lzombie/world/ItemInfo;")) {
				m.desc = "(I)Lzombie/world/ItemInfo;";
				ExampleMod.LOGGER.println("DictionaryData:getItemInfoFromID return type patched");
			}
		}
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		// TODO Auto-generated method stub

	}

}
