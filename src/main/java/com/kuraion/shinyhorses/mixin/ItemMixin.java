package com.kuraion.shinyhorses.mixin;

import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
	@Inject(at = @At("HEAD"), method = "getEnchantmentValue",cancellable = true)
	private void init(CallbackInfoReturnable<Integer> cir) {
		if ((Object)this instanceof HorseArmorItem)cir.setReturnValue(1);
	}

	@Inject(at = @At("HEAD"), method = "isEnchantable",cancellable = true)
	private void init(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		if ((Object)this instanceof HorseArmorItem)cir.setReturnValue(true);
	}
}
