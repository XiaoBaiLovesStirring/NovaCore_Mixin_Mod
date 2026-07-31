package com.novacore.mixin;

import net.minecraft.client.renderer.entity.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * 实体剔除 Mixin。
 * 对应原 EntityCullingTransformer。
 * 在渲染前根据距离判断是否跳过不可见实体的渲染。
 */
@Mixin(RenderManager.class)
public abstract class EntityCullingMixin {

 @Redirect(
  method = "func_188391_a",
  at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/entity/RenderManager;func_188391_a(Lnet/minecraft/entity/Entity;DDDLnet/minecraft/client/renderer/entity/Render;DDD)V"
  )
 )
 private void redirectRenderEntity(
  RenderManager manager,
  net.minecraft.entity.Entity entity,
  double x, double y, double z,
  net.minecraft.client.renderer.entity.Render<?> render,
  float yaw, float partialTicks,
  double p_188391_9_
 ) {
  if (!NovaCullingHelper.shouldRender(entity, manager)) {
   System.out.println("[NovaCore][Mixin][EntityCulling] 跳过不可见实体: " + entity);
   return;
  }
  System.out.println("[NovaCore][Mixin][EntityCulling] 渲染实体: " + entity);
 }
}