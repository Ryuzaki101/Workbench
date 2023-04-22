call mvn -DskipTests=true clean package
if errorlevel 1 (
   echo call to maven failed %errorlevel%
   exit /b %errorlevel%
)
call 003_mk_installer.cmd