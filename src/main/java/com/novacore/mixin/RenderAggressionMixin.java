package com.novacore.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 渲染攻击 Mixin（EXTREME 预设）。
 * 对应原 RenderAggressionTransformer。
 * 关闭云、天气、实体阴影等渲染特效，进一步提升帧率。
 */
@Mixin(targets = "net.minecraft.client.renderer.RenderGlobal")
public abstract class RenderAggressionMixin {

 @Inject(method = "func_180443_s", at = @At("HEAD"), cancellable = true)
 private void onRenderClouds(CallbackInfo ci) {
  if (!com.novacore.NovaCoreConfig.renderAggressionEnabled) return;
  System.out.println("[NovaCore][Mixin][RenderAggression] 跳过云层渲染");
  ci.cancel();
 }

 @Inject(method = "func_180440_a", at = @At("HEAD"), cancellable = true)
 private void onRenderWeather(CallbackInfo ci) {
  if (!com.novacore.NovaCoreConfig.renderAggressionEnabled) return;
  System.out.println("[NovaCore][Mixin][RenderAggression] 跳过天气渲染");
  ci.cancel();
 }
}