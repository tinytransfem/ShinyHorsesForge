package com.kuraion.shinyhorses.mixin;

import com.kuraion.shinyhorses.ShinyHorsesMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.HorseArmorLayer;
import net.minecraft.world.entity.animal.horse.Horse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(HorseArmorLayer.class)
public class HorseArmorLayerMixin {

	@ModifyVariable(method = "render*",at = @At(value = "INVOKE_ASSIGN",target = "Lnet/minecraft/client/renderer/MultiBufferSource;getBuffer(Lnet/minecraft/client/renderer/RenderType;)Lcom/mojang/blaze3d/vertex/VertexConsumer;"))
	private VertexConsumer renderHorseArmorGlint(VertexConsumer old, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Horse entitylivingbaseIn,
												 float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		return ShinyHorsesMod.renderHorseArmorGlintHook(old, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
	}
}
