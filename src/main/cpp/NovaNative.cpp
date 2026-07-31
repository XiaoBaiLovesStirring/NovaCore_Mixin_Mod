// NovaNative.cpp
#include <jni.h>
#include <iostream>

#ifdef _WIN32
#define EXPORT __declspec(dllexport)
#else
#define EXPORT __attribute__((visibility("default")))
#endif

extern "C" {

/**
 * 示例：把 Java 调用映射到本地线程优先级设置（仅演示）。
 * 实际实现请根据平台 API（SetThreadPriority / pthread_setschedparam）自行完善。
 */
EXPORT void JNICALL Java_com_novacore_agent_NovaAgent_setThreadPriority(JNIEnv* env, jclass, jint priority) {
    std::cout << "[NovaNative] 设置线程优先级 = " << priority << std::endl;
#ifdef _WIN32
    // SetThreadPriority(GetCurrentThread(), priority);
#else
    // Linux 示例（仅打印，真正实现需要 pthread 库）
    // pthread_setschedparam(pthread_self(), SCHED_RR, &param);
#endif
}

}