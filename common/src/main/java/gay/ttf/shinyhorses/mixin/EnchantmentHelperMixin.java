package gay.ttf.shinyhorses.mixin;

import gay.ttf.shinyhorses.CommonClass;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.world.item.enchantment.EnchantmentHelper")
public class EnchantmentHelperMixin {

	@Inject(method = "getEnchantmentLevel(Lnet/minecraft/core/Holder;Lnet/minecraft/world/entity/LivingEntity;)I",at = @At("HEAD"),cancellable = true)
	private static void checkHorse(Holder<Enchantment> enchantmentIn, LivingEntity entityIn, CallbackInfoReturnable<Integer> cir){
		CommonClass.checkHorseHook(enchantmentIn,entityIn,cir);
	}
}
