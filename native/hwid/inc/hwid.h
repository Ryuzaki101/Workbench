/*
 * hwid.h
 *
 *  Created on: 18.02.2012
 *      Author: krauter
 */

#ifndef HWID_H_
#define HWID_H_

unsigned long GetSysVolumeSerial();
int GetCpuId(unsigned int info, unsigned int *eax, unsigned int *ebx,
		unsigned int *ecx, unsigned int *edx);

#endif /* HWID_H_ */
