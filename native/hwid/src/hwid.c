/*
 * hwid.c
 *
 *  Created on: 17.02.2012
 *      Author: krauter
 */

#include <stdio.h>
#include <windows.h>
#include <Shlwapi.h>
#include "cpuid.h"

unsigned long GetSysVolumeSerial()
{
	TCHAR directoryBuffer[MAX_PATH] = TEXT("");
	// get the windows directory
	if (GetWindowsDirectory(directoryBuffer, MAX_PATH))
	{
		DWORD dwVolSerial;
		// only use the root directory part
		LPSTR rootPath = PathBuildRoot(directoryBuffer,
				PathGetDriveNumber(directoryBuffer));
		BOOL bIsRetrieved = GetVolumeInformation(rootPath, NULL, 0,
				&dwVolSerial, NULL, NULL, NULL, 0);
		if (bIsRetrieved)
		{
			return dwVolSerial;
		}
		return 0;
	}
	return 0;
}

int GetCpuId(unsigned int info, unsigned int *eax, unsigned int *ebx,
		unsigned int *ecx, unsigned int *edx)
{
	return cpuid(info, eax, ebx, ecx, edx);
}

