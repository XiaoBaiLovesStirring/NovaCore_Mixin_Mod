package com.novacore.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * TickRate 调整 Mixin（EXTREME 预设）。
 * 对应原 TickRateTransformer。
 * 在服务器 tick 开始时根据距离动态调整实体 tick 频率。
 */
@Mixin(targets = "net.minecraft.server.MinecraftServer")
public abstract class TickRateMixin {

 @Inject(method = "func_71217_T", at = @At("HEAD"))
 private void onServerTick(CallbackInfo ci) {
  if (!com.novacore.NovaCoreConfig.tickRateEnabled) return;
  System.out.println("[NovaCore][Mixin][TickRate] 应用动态 tick 间隔策略");
  NovaTickRateHelper.applyTickRatePolicy();
 }
}