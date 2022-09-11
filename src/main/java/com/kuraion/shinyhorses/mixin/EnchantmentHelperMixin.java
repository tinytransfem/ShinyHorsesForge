package com.kuraion.shinyhorses.mixin;

import com.kuraion.shinyhorses.ShinyHorsesMod;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.world.item.enchantment.EnchantmentHelper")
public class EnchantmentHelperMixin {

	@Inject(method = "getEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/entity/LivingEntity;)I",at = @At("HEAD"),cancellable = true)
	private static void checkHorse(Enchantment enchantmentIn, LivingEntity entityIn, CallbackInfoReturnable<Integer> cir){
		ShinyHorsesMod.checkHorseHook(enchantmentIn,entityIn,cir);
	}
}
