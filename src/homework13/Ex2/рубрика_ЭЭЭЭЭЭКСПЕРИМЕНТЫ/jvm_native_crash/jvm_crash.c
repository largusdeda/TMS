#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>

// Способ 1: Вызов segmentation fault (доступ к нулевому указателю)
JNIEXPORT void JNICALL Java_NativeCrash_crashBySegfault(JNIEnv *env, jobject obj) {
    printf("C: Calling segmentation fault...\n");
    int *ptr = NULL;
    *ptr = 42; // Попытка записи в нулевой адрес -> SIGSEGV
}

// Способ 2: Деление на ноль (обычно SIGFPE)
JNIEXPORT void JNICALL Java_NativeCrash_crashByDivZero(JNIEnv *env, jobject obj) {
    printf("C: Divided by zero...\n");
    int a = 10;
    int b = 0;
    int c = a / b; // Деление на ноль
    printf("Результат: %d\n", c); // Эта строка не выполнится
}

// Способ 3: Вызов abort() - аварийное завершение
JNIEXPORT void JNICALL Java_NativeCrash_crashByAbort(JNIEnv *env, jobject obj) {
    printf("C: Calling abort()...\n");
    abort(); // Посылает сигнал SIGABRT
}

// Способ 4: Переполнение стека (рекурсия)
void recursive_function(int depth) {
    char buffer[1024]; // Занимаем место в стеке
    printf("Depth: %d\n", depth);
    recursive_function(depth + 1); // Бесконечная рекурсия
}

JNIEXPORT void JNICALL Java_NativeCrash_crashByStackOverflow(JNIEnv *env, jobject obj) {
    printf("C: Stack overflow...\n");
    recursive_function(1);
}

// Способ 5: Повреждение стека через memcpy
JNIEXPORT void JNICALL Java_NativeCrash_crashByStackCorruption(JNIEnv *env, jobject obj) {
    printf("C: Stack corruption...\n");
    char buffer[10];
    // Записываем за пределы буфера, повреждая стек
    memcpy(buffer, "This string is definitely longer than 10 bytes and will corrupt the stack", 70);
}

// Способ 6: Вызов illegal instruction
JNIEXPORT void JNICALL Java_NativeCrash_crashByIllegalInstruction(JNIEnv *env, jobject obj) {
    printf("C: Invoke illegal instruction...\n");
    // Функция-указатель на неверный адрес
    void (*illegal_func)() = (void (*)())0x12345678;
    illegal_func(); // Попытка выполнить код по неверному адресу
}
