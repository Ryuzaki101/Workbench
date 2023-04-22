1. Datei micas-build-tools.7z von 
	https://csus.catuno.de/public/wisag/micas/micas-build-tools.7z 
	herunterladen
    verschieben/umbenennen, entpacken so dass die Datei tools\7z\VERSION\7z.exe existiert.

2. 002_build.cmd aufrufen, dadurch wird workbench und Lizenzmanager gebaut.

3. Versionierung
   Die Versionierung hängt an den .product Dateien :
     repositories/de.wisag.automation.micas.workbench.ide.product/micas-workbench.product
     und
     repositories/de.wisag.automation.micas.workbench.ide.product/licmanager.product
   Einstellungen dort werden auch für die MSI Installer übernommen.
   
          

