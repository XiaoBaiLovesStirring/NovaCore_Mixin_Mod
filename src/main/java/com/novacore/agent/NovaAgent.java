package com.novacore.agent;

import java.lang.instrument.Instrumentation;

/**
 * Java‑Agent 入口。
 * 通过 -javaagent 启动，负责加载本地 native 库（libnova_native.so / nova_native.dll）。
 */
public class NovaAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("[NovaCore][Agent] 启动 Java‑Agent，参数 = " + agentArgs);
        try {
            System.loadLibrary("nova_native");
            System.out.println("[NovaCore][Agent] 本地库加载成功");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("[NovaCore][Agent] 本地库加载失败: " + e.getMessage());
        }
        // 如需在运行时注册额外的 transformer，可在此处调用 inst.addTransformer(...)
    }

    /** 示例 native 方法，供 Mixin/Mod 调用 */
    public static native void setThreadPriority(int priority);
}
