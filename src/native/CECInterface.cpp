/*
 * CECInterface.cpp
 *
 *  Created on: Mar 26, 2017
 *      Author: mattashley
 */

#include <cec.h>
#include <stdlib.h>
#include "cec_LibCEC.h"
#include "handle.h"

JNIEXPORT void JNICALL Java_cec_LibCEC_init
  (JNIEnv * env, jobject obj)
{
	  CEC::libcec_configuration *config = new CEC::libcec_configuration();

	  config->Clear();
	  snprintf(config->strDeviceName, 13, "RaspberryPi");
	  config->clientVersion       = CEC::LIBCEC_VERSION_CURRENT;
	  config->bActivateSource     = 0;

	  config->deviceTypes.Add(CEC::CEC_DEVICE_TYPE_RECORDING_DEVICE);

	  CEC::ICECAdapter* adapter = (CEC::ICECAdapter *) CECInitialise(config);
          adapter->InitVideoStandalone();
	  setHandle(env, obj, adapter);

}

JNIEXPORT jboolean JNICALL Java_cec_LibCEC_open
  (JNIEnv * env, jobject obj, jstring strPort)
{
    CEC::ICECAdapter *adapter = getHandle<CEC::ICECAdapter>(env, obj);
    const char *nativeString = env->GetStringUTFChars(strPort, 0);

    bool result = adapter->Open(nativeString);

    env->ReleaseStringUTFChars(strPort, nativeString);

    return result ? JNI_TRUE : JNI_FALSE;

}

JNIEXPORT jobjectArray JNICALL Java_cec_LibCEC_getAdapters
  (JNIEnv * env, jobject obj)
{
    CEC::ICECAdapter *adapter = getHandle<CEC::ICECAdapter>(env, obj);

    CEC::cec_adapter_descriptor devices[10];
    int8_t iDevicesFound = adapter->DetectAdapters(devices, 10, NULL, true);

    jstring str = NULL;
    jclass strCls = env->FindClass("Ljava/lang/String;");
    jobjectArray strarray = env->NewObjectArray(iDevicesFound,strCls,NULL);
    for(int i=0; i<iDevicesFound; i++)
    {

        str = env->NewStringUTF(devices[i].strComName);
        env->SetObjectArrayElement(strarray,i,str);
        env->DeleteLocalRef(str);

    }

     return strarray;

}

JNIEXPORT jboolean JNICALL Java_cec_LibCEC_powerOnDevice
  (JNIEnv * env, jobject obj, jint address)
{
    CEC::ICECAdapter *adapter = getHandle<CEC::ICECAdapter>(env, obj);
    bool result = adapter->PowerOnDevices((CEC::cec_logical_address)address);

    return result ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cec_LibCEC_powerOnTV
  (JNIEnv * env, jobject obj)
{
    CEC::ICECAdapter *adapter = getHandle<CEC::ICECAdapter>(env, obj);
    /* Calls function with default device address which is TV's address */
    bool result = adapter->PowerOnDevices();

    return result ? JNI_TRUE : JNI_FALSE;

}

JNIEXPORT jintArray JNICALL Java_cec_LibCEC_getActiveDevices
  (JNIEnv * env, jobject obj)
{
    CEC::ICECAdapter *adapter = getHandle<CEC::ICECAdapter>(env, obj);
    CEC::cec_logical_addresses addresses = adapter->GetActiveDevices();

    jintArray jAddresses = env->NewIntArray(sizeof(addresses.addresses));
    env->SetIntArrayRegion(jAddresses, 0, sizeof(addresses.addresses), addresses.addresses);

    return jAddresses;

}

JNIEXPORT jlong JNICALL Java_cec_LibCEC_getDeviceVendorId
  (JNIEnv * env, jobject obj, jint address)
{
    CEC::ICECAdapter *adapter = getHandle<CEC::ICECAdapter>(env, obj);
    return adapter->GetDeviceVendorId((CEC::cec_logical_address)address);

}

JNIEXPORT jint JNICALL Java_cec_LibCEC_getDevicePowerStatus
  (JNIEnv * env, jobject obj, jint address)
{
    CEC::ICECAdapter *adapter = getHandle<CEC::ICECAdapter>(env, obj);
    return adapter->GetDevicePowerStatus((CEC::cec_logical_address)address);

}

JNIEXPORT void JNICALL Java_cec_LibCEC_close
  (JNIEnv *env, jobject obj)
{
    CEC::ICECAdapter *adapter = getHandle<CEC::ICECAdapter>(env, obj);
    adapter->Close();
}

JNIEXPORT void JNICALL Java_cec_LibCEC_dispose
  (JNIEnv *env, jobject obj)
{
    CEC::ICECAdapter *adapter = getHandle<CEC::ICECAdapter>(env, obj);
    delete adapter;
}

