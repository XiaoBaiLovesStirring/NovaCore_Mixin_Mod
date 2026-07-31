package my.mod;

import net.minecraftforge.fml.common.Mod;
import com.novacore.NovaCoreConfig;

@Mod(
 modid = MyMod.MODID,
 name = "NovaCore (Mixin 版)",
 version = "1.0-mixin",
 guiFactory = "my.mod.MyModConfigGuiFactory"
)
public class MyMod {
 public static final String MODID = "novacore_mixin";

 public MyMod() {
  System.out.println("[NovaCore] Mixin-Mod 已实例化，当前预设 = " + NovaCoreConfig.preset);
 }
}