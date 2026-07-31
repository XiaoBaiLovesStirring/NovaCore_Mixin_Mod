package com.novacore;

import net.minecraftforge.fml.common.Mod;

/**
 * NovaCore 的 Mod Container。
 * 让 Forge 把这个 CoreMod 也当作普通 Mod 加载（可选）。
 */
@Mod(
 modid = NovaCoreContainer.MODID,
 name = NovaCoreContainer.NAME,
 version = NovaCoreContainer.VERSION,
 acceptableRemoteVersions = "*"
)
public class NovaCoreContainer {
 public static final String MODID = "novacore";
 public static final String NAME = "NovaCore (Mixin)";
 public static final String VERSION = "1.0-mixin";

 public NovaCoreContainer() {
  System.out.println("[NovaCore] NovaCoreContainer 初始化完成");
 }
}