package com.novacore.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * 数学运算查表优化 Mixin。
 * 对应原 MathOptTransformer。
 * 将 Math.sin / Math.cos 替换为预生成的查表实现。
 */
@Mixin(targets = "net.minecraft.util.math.MathHelper")
public abstract class MathOptMixin {

 @Redirect(
  method = "func_76126_a",
  at = @At(
   value = "INVOKE",
   target = "Ljava/lang/Math;sin(F)F"
  )
 )
 private float redirectSin(float value) {
  System.out.println("[NovaCore][Mixin][MathOpt] 使用查表代替 Math.sin");
  return NovaMathHelper.sin(value);
 }

 @Redirect(
  method = "func_76134_b",
  at = @At(
   value = "INVOKE",
   target = "Ljava/lang/Math;cos(F)F"
  )
 )
 private float redirectCos(float value) {
  System.out.println("[NovaCore][Mixin][MathOpt] 使用查表代替 Math.cos");
  return NovaMathHelper.cos(value);
 }
}