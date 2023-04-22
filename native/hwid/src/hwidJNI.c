/*
 * hwidJNI.c
 *
 *  Created on: 18.02.2012
 *      Author: krauter
 */

#include <jni.h>
#include "hwid.h"

#define CONCATENATE(arg1, arg2)   CONCATENATE1(arg1, arg2)
#define CONCATENATE1(arg1, arg2)  CONCATENATE2(arg1, arg2)
#define CONCATENATE2(arg1, arg2)  arg1 ## arg2
#define MAX_LENGTH 512
#define CLASS de_wisag_automation_micas_workbench_licmgr_internal_hwid_NativeAccess_
#define CLASS_METHOD(name)  CONCATENATE(Java_,CONCATENATE(CLASS,name))

jfieldID GetIntFieldChecked(JNIEnv *env, jclass cls, jclass rtEx, char *name);

JNIEXPORT jlong JNICALL CLASS_METHOD(getSysVolumeSerial)(JNIEnv *env,
		jclass class)
{
	return GetSysVolumeSerial();
}

void cleanUp(JNIEnv *env, jclass iaEx, jclass rtEx, jclass registerClass)
{
    (*env)->DeleteLocalRef(env, iaEx);
    (*env)->DeleteLocalRef(env, rtEx);
    (*env)->DeleteLocalRef(env, registerClass);
}

JNIEXPORT jint JNICALL CLASS_METHOD(getCpuId)(JNIEnv *env, jclass class,
		jint info, jobject reg)
{

	// find exceptions
	jclass iaEx = (*env)->FindClass(env, "java/lang/IllegalArgumentException");

	jclass rtEx = (*env)->FindClass(env, "java/lang/RuntimeException");

	if (reg == NULL)
	{
		(*env)->ThrowNew(env, iaEx, "argument 'reg' must not be null");
	}

	jclass registerClass = (*env)->GetObjectClass(env, reg);

	jfieldID feax = GetIntFieldChecked(env, registerClass, rtEx, "eax");
	/* important: check if an exception was raised */
	if ((*env)->ExceptionCheck(env))
	{
	    cleanUp(env, iaEx, rtEx, registerClass);
		return -10;
	}
	jfieldID febx = GetIntFieldChecked(env, registerClass, rtEx, "ebx");
	if ((*env)->ExceptionCheck(env))
	{
		cleanUp(env, iaEx, rtEx, registerClass);
		return -10;
	}
	jfieldID fecx = GetIntFieldChecked(env, registerClass, rtEx, "ecx");
	if ((*env)->ExceptionCheck(env))
	{
		cleanUp(env, iaEx, rtEx, registerClass);
		return -10;
	}
	jfieldID fedx = GetIntFieldChecked(env, registerClass, rtEx, "edx");

	// copy values
	unsigned int eax0 = (*env)->GetIntField(env, registerClass, feax);
	unsigned int ebx0 = (*env)->GetIntField(env, registerClass, febx);
	unsigned int ecx0 = (*env)->GetIntField(env, registerClass, fecx);
	unsigned int edx0 = (*env)->GetIntField(env, registerClass, fedx);
	// call the function
	int ret = GetCpuId(info, &eax0, &ebx0, &ecx0, &edx0);
	// copy values back
	(*env)->SetIntField(env, reg, feax, eax0);
	(*env)->SetIntField(env, reg, febx, ebx0);
	(*env)->SetIntField(env, reg, fecx, ecx0);
	(*env)->SetIntField(env, reg, fedx, edx0);
	cleanUp(env, iaEx, rtEx, registerClass);
	return ret;
}

jfieldID GetIntFieldChecked(JNIEnv *env, jclass cls, jclass rtEx, char *name)
{
	jfieldID fedx = (*env)->GetFieldID(env, cls, name, "I");
	if (fedx == 0)
	{
		char message[MAX_LENGTH+1];
		message[MAX_LENGTH]=0;
		snprintf(message, MAX_LENGTH,"field %s not found", name);
		(*env)->ThrowNew(env, rtEx, message);
	}
	return fedx;
}

