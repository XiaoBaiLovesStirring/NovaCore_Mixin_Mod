package my.mod;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraft.client.Minecraft;
import java.util.Collections;
import java.util.Set;

/**
 * Forge 1.12.2 标准的配置 GUI 工厂。
 * 这里直接把 NovaCoreConfig 中的属性包装成 ConfigElement 列表。
 */
public class MyModConfigGuiFactory implements IModGuiFactory {

 @Override
 public void initialize(Minecraft minecraftInstance) {
  // 可以在这里初始化缓存、加载默认配置等
 }

 @Override
 public boolean hasConfigGui() {
  return true;
 }

 @Override
 public GuiScreen createConfigGui(GuiScreen parentScreen) {
  // NovaCoreConfig 已经提供了 getConfigElements() 方法
  return new GuiConfig(
   parentScreen,
   com.novacore.NovaCoreConfig.getConfigElements(),
   "novacore", // Mod ID
   false, false,
   "NovaCore 配置",
   "NovaCore 的高级性能选项"
  );
 }

 @Override
 public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
  // 1.12.2 已经废弃，返回空集合即可
  return Collections.emptySet();
 }
}