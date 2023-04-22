Prerequisites

Install on you machine mingw32 and mingw64 and a suitable JDK.

Setting up the environment, Configure the project

Project->Properties->C/C++ Build->Environment
JDK_HOME where yout JDK is installed
For x86    build :  add mingw32/bin to the path 
For x86_64 build :  add mingw64/bin to the path


Building

Run clean and build foreach plattform and coppy the resulting dll
to the plugin:

de.wisag.automation.micas.workbench.licmgr
	x86    to os/win32/x86/hwid.dll
	x86_64 to os/win32/x86_64/hwid.dll

Look at de.wisag.automation.micas.workbench.licmgrMETA-INF/MANIFEST.MF



