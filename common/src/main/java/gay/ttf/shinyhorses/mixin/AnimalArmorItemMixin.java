package gay.ttf.shinyhorses.mixin;

import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net.minecraft.world.item.AnimalArmorItem"})
public abstract class AnimalArmorItemMixin {

	@Shadow public abstract AnimalArmorItem.BodyType getBodyType();

	@Inject(method = "isEnchantable(Lnet/minecraft/world/item/ItemStack;)Z",at = @At("RETURN"),cancellable = true)
	private void enchantHorseArmor(ItemStack itemIn, CallbackInfoReturnable<Boolean> cir){
		if (this.getBodyType() == AnimalArmorItem.BodyType.EQUESTRIAN) cir.setReturnValue(true);
	}
}
