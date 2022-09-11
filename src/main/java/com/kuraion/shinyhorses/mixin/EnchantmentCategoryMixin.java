package com.kuraion.shinyhorses.mixin;

import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net.minecraft.world.item.enchantment.EnchantmentCategory$1",//ARMOR
				"net.minecraft.world.item.enchantment.EnchantmentCategory$2",//ARMOR_FEET
				"net.minecraft.world.item.enchantment.EnchantmentCategory$3",//ARMOR_LEGS
				"net.minecraft.world.item.enchantment.EnchantmentCategory$4",//ARMOR_CHEST
				"net.minecraft.world.item.enchantment.EnchantmentCategory$5",//ARMOR_HEAD
})
public class EnchantmentCategoryMixin {

	@Inject(method = "canEnchant(Lnet/minecraft/world/item/Item;)Z",at = @At("RETURN"),cancellable = true)
	private void enchantHorseArmor(Item itemIn, CallbackInfoReturnable<Boolean> cir){
		if (cir.getReturnValue())return;
		if (itemIn instanceof HorseArmorItem)cir.setReturnValue(true);
	}
}
