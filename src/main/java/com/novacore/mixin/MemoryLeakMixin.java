package com.novacore.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 内存泄漏修复 Mixin。
 * 对应原 MemoryLeakTransformer。
 * 这里以注入方式在相关方法入口/出口执行清理逻辑。
 */
@Mixin(targets = "net.minecraft.client.Minecraft")
public abstract class MemoryLeakMixin {

 @Inject(method = "func_99999_displayGuiScreen", at = @At("HEAD"))
 private void onDisplayGuiScreen(CallbackInfo ci) {
  System.out.println("[NovaCore][Mixin][MemoryLeak] 检查并清理内存泄漏缓存…");
  NovaMemoryHelper.cleanupLeakedResources();
 }
}