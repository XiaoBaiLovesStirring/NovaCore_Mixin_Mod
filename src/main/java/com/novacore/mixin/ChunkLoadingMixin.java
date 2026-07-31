package com.novacore.mixin;

import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * 将 Chunk 加载/写入委托给 NovaChunkIO（多线程 I/O）。
 * 对应原 ChunkLoadingTransformer。
 */
@Mixin(World.class)
public abstract class ChunkLoadingMixin {

 @Redirect(
  method = "func_73041_k",
  at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/World;func_72964_e(II)Lnet/minecraft/world/chunk/Chunk;"
  )
 )
 private Chunk redirectChunkLoad(World world, int x, int z) {
  System.out.println("[NovaCore][Mixin][ChunkLoading] 使用 NovaChunkIO 异步读取 Chunk (" + x + "," + z + ")");
  return NovaChunkIO.loadChunkAsync(world, x, z);
 }
}