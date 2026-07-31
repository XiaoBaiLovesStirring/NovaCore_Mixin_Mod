package com.novacore.mixin;

import net.minecraft.client.particle.ParticleManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 粒子限制 Mixin（EXTREME 预设）。
 * 对应原 ParticleLimiterTransformer。
 * 在粒子生成、更新时进行数量与距离裁剪。
 */
@Mixin(ParticleManager.class)
public abstract class ParticleLimiterMixin {

 @Inject(method = "func_78872_a", at = @At("HEAD"))
 private void onSpawnParticle(CallbackInfo ci) {
  if (!com.novacore.NovaCoreConfig.particleLimiterEnabled) return;
  System.out.println("[NovaCore][Mixin][ParticleLimiter] 检查粒子生成上限与距离");
  NovaParticleLimiter.checkAndLimit();
 }

 @Inject(method = "func_78868_a", at = @At("HEAD"))
 private void onUpdateParticles(CallbackInfo ci) {
  if (!com.novacore.NovaCoreConfig.particleLimiterEnabled) return;
  NovaParticleLimiter.reduceLifetimeIfNeeded();
 }
}