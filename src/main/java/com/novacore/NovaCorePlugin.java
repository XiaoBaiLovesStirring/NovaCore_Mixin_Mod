package com.novacore;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;

/**
 * NovaCore — Minecraft 1.12.2 极致性能引擎 (Mixin + CoreMod 版)
 * Coremod 入口，仅负责让 Mixin 框架加载配置文件。
 * 所有实际逻辑已搬到 com.novacore.mixin 包里的 Mixin 类。
 */
@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.SortingIndex(1001)
public class NovaCorePlugin implements IFMLLoadingPlugin {

 public NovaCorePlugin() {
  System.out.println("[NovaCore] Mixin-CoreMod 启动，加载 Mixin 配置…");
 }

 @Override
 public String[] getASMTransformerClass() {
  // 交给 Mixin，不再需要 ASM Transformer
  return new String[0];
 }

 @Override
 public String getModContainerClass() {
  return "com.novacore.NovaCoreContainer";
 }

 @Override
 public String getSetupClass() {
  return null;
 }

 @Override
 public void injectData(Map<String, Object> data) {
  // 如有需要可读取 FML 环境信息
 }

 @Override
 public String getAccessTransformerClass() {
  // 仍保留 AT，以防需要访问 private 字段
  return "com.novacore.NovaCoreAT";
 }
}