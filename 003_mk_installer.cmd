@echo off
echo deleting out directory
rd /q /s .\out

pushd "%~dp0"

mkdir "%~dp0out"

:: Erst Lzenzmanager bauen
mkdir "%~dp0out\licmgr"
mkdir "%~dp0out\licmgr\dist"

set LOG="%~dp0out\installer-build.log"
:: Output vom Maven build kopieren
echo sync licensmanager build
robocopy "%~dp0repositories\de.wisag.automation.micas.workbench.ide.product\target\products\de.wisag.automation.micas.workbench.licmgr.app\win32\win32\x86_64" ^
	"%~dp0out\licmgr\dist" /MIR >>"%LOG%

:: Installer Daten kopieren	
echo sync licensmanager installer
robocopy "%~dp0repositories\de.wisag.automation.micas.workbench.ide.product\installer\licmanager" "%~dp0out\licmgr" /E >>"%LOG%"
echo create licensmanager releasenotes
"%~dp0tools\o2pdf\1.7\officetopdf.exe" "%~dp0docuware\de.wisag.automation.micas.docuware\releasenotes\licmgr-releasenotes.docx" ^
	"%~dp0out\licmgr\dist\releasenotes.pdf"

	:: Aus Productfile Versionsangabe extrahieren
echo write version file
xidel -s "%~dp0repositories\de.wisag.automation.micas.workbench.ide.product\licmanager.product" ^
  -e '/product/@version' --output-format adhoc > "%~dp0out\licmgr\installer_version.txt"

:: read version from file
set /p LMGR_VERSION=<"%~dp0out\licmgr\installer_version.txt"
cd "%~dp0out\licmgr"
cd "%~dp0out\licmgr\dist"
copy /Y "%~dp0out\licmgr\images\app.ico" "%~dp0out\licmgr\dist\"
:: exe Datei mit icon versehen
rcedit licmanager.exe --set-icon app.ico
7z a ..\..\licmanager-%LMGR_VERSION%.7z .
cd "%~dp0out\licmgr"
:: Batch Datei für wix toolset aufrufen
echo Building Licensemanager installer
call .\build-installer.cmd >>"%LOG%"
popd


mkdir "%~dp0out\micas-workbench"
mkdir "%~dp0out\micas-workbench\dist"
echo sync workbench build
robocopy "%~dp0repositories\de.wisag.automation.micas.workbench.ide.product\target\products\de.wisag.automation.micas.workbench.product\win32\win32\x86_64" ^
	"%~dp0out\micas-workbench\dist" /MIR >>"%LOG%"

echo sync workbench build
robocopy "%~dp0repositories\de.wisag.automation.micas.workbench.ide.product\installer\micas-workbench" ^
	"%~dp0out\micas-workbench" /E >>"%LOG%"
"%~dp0tools\o2pdf\1.3\officetopdf.exe" "%~dp0docuware\de.wisag.automation.micas.docuware\releasenotes\workbench-releasenotes.docx" "%~dp0out\licmgr\dist\releasenotes.pdf"
pushd "%~dp0"
xidel -s "%~dp0repositories\de.wisag.automation.micas.workbench.ide.product\micas-workbench.product" ^
  -e '/product/@version' --output-format adhoc > "%~dp0out\micas-workbench\installer_version.txt"

set /p WCWB_VERSION=<"%~dp0out\micas-workbench\installer_version.txt"
cd "%~dp0out\micas-workbench\dist"
copy /Y "%~dp0out\micas-workbench\images\app.ico" "%~dp0out\micas-workbench\dist\"
rcedit micas-workbench.exe --set-icon app.ico
7z a ..\..\micas-workbench-%WCWB_VERSION%.7z .

cd "%~dp0out\micas-workbench"
echo Building Workbench installer
call .\build-installer.cmd >>"%LOG%"
popd

echo copy licmgr msi
copy  "%~dp0out\licmgr\*.msi" "%~dp0out\" >nul
echo Build result :

echo copy workbench msi
copy  "%~dp0out\micas-workbench\*.msi" "%~dp0out\" >nul

echo Licensemanager Installer :
dir /S /B .\out\licmanager-*.msi
echo Workbench Installer :
dir /S /B .\out\micas-workbench*.msi

rd /q /s "%~dp0out\micas-workbench"
rd /q /s "%~dp0out\licmgr"