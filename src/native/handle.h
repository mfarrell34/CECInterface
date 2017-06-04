#ifndef _HANDLE_H_INCLUDED_
#define _HANDLE_H_INCLUDED_

#include "cec_LibCEC.h"

jfieldID getHandleField(JNIEnv *env, jobject obj)
{
    jclass c = env->GetObjectClass(obj);
    // J is the type signature for long:
    return env->GetFieldID(c, "nativeHandle", "J");
}

CECInterface *getInterfaceHandle(JNIEnv *env, jobject obj)
{
    jlong handle = env->GetLongField(obj, getHandleField(env, obj));
    return reinterpret_cast<CECInterface *>(handle);
}


CEC::ICECAdapter *getAdapterHandle(JNIEnv *env, jobject obj)
{
    CECInterface* interfaceHandle = getInterfaceHandle(env, obj);
    return interfaceHandle->get_adapter();
}

void setHandle(JNIEnv *env, jobject obj, CECInterface *interface)
{
    jlong handle = reinterpret_cast<jlong>(interface);
    env->SetLongField(obj, getHandleField(env, obj), handle);
}

#endif
