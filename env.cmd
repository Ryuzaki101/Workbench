:: This script sets the required environment vaiables
@echo off
set MICAS_BUILDROOT=%~dp0
set JAVA_HOME=%~dp0tools\jdk\1.8.0.91
set M2_HOME=%~dp0tools\mvn\3.3.9
set WIX_HOME=%~dp0tools\wix\3.10.0.0
set SEVENZ_HOME=%~dp0tools\7z\16.02.0.0
set O2PDF_HOME=%~dp0tools\o2pdf\1.3
set RCEDIT_HOME=%~dp0tools\rcedit\0.1.0
set XIDEL_HOME=%~dp0tools\xidel\0.9.4
set PATH=%JAVA_HOME%\bin;%M2_HOME%\bin;%WIX_HOME%\bin;%SEVENZ_HOME%;%O2PDF_HOME%;%RCEDIT_HOME%;%XIDEL_HOME%;%PATH%
