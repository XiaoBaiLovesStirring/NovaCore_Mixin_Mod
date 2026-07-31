package com.novacore.mixin;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * 替换 World.checkLightFor 与 World.updateLightByType 为 NovaLightEngine 实现（BFS 光照）。
 * 对应原 LightingTransformer。
 */
@Mixin(World.class)
public abstract class LightingMixin {

 @Redirect(
  method = "func_180500_c",
  at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/World;func_180500_c(Lnet/minecraft/world/EnumSkyBlock;Lnet/minecraft/util/math/BlockPos;)Z"
  )
 )
 private boolean redirectCheckLightFor(World world, EnumSkyBlock sky, BlockPos pos) {
  System.out.println("[NovaCore][Mixin][Lighting] 调用 NovaLightEngine.checkLightFor (BFS)");
  return NovaLightEngine.checkLightFor(world, sky, pos);
 }

 @Redirect(
  method = "func_185463_a",
  at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/World;func_185463_a(Lnet/minecraft/world/EnumSkyBlock;Lnet/minecraft/util/math/BlockPos;)V"
  )
 )
 private void redirectUpdateLightByType(World world, EnumSkyBlock sky, BlockPos pos) {
  System.out.println("[NovaCore][Mixin][Lighting] 调用 NovaLightEngine.updateLightBFS");
  NovaLightEngine.updateLightBFS(world, sky, pos);
 }
}