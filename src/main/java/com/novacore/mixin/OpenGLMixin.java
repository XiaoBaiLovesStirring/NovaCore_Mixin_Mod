package com.novacore.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * OpenGL 渲染优化 Mixin。
 * 对应原 OpenGLTransformer。
 * 在渲染批次开始前合并绘制调用，减少状态切换。
 */
@Mixin(targets = "net.minecraft.client.renderer.GlStateManager")
public abstract class OpenGLMixin {

 @Inject(method = "func_179094_E", at = @At("HEAD"))
 private void onPushMatrix(CallbackInfo ci) {
  System.out.println("[NovaCore][Mixin][OpenGL] 优化批次提交，减少状态切换");
  NovaGLHelper.batchBegin();
 }

 @Inject(method = "func_179121_F", at = @At("HEAD"))
 private void onPopMatrix(CallbackInfo ci) {
  NovaGLHelper.batchEnd();
 }
}