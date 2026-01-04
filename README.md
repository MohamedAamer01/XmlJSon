
---

## Exécution

1. Ouvrir le projet dans un IDE Java (IntelliJ, Eclipse, NetBeans,Visual Studio code , etc.)  
2. Compiler le dossier `src`  
3. Lancer les fichiers principaux pour tester :  
   - XML → JSON : `XMLtoJsON.java`  
   - JSON → JSON : `JSONtoXml.java` (exemple)  

---

## Vidéo de démonstration

Vous pouvez visionner la vidéo de démonstration ici :  
[Voir la vidéo sur Google Drive]
(https://drive.google.com/file/d/1QdeMzfYw43_jjT1XXUzG62zscymahpWV/view?usp=drive_link)

---

## Auteurs
https
- Mohamed Aamer  
- Projet réalisé pour [Data Exchange / Semestre 1  / année 2026]

---

## Architecture du projet

Le projet est organisé comme suit :
## Architecture du projet

Le projet est organisé comme suit :

```text
XmlMiniProject1/
├─ src/
│  ├─ app/                 # Classe principale et interface
│  │  └─ MainApp.java
│  └─ converter/           # Classes pour la conversion XML ↔ JSON
│     ├─ JsonToXml.java
│     └─ XmlToJson.java
├─ bin/
├─ legal/                  # Licences et informations légales (JavaFX)
├─ lib/                    # Bibliothèques externes
├─ out/                    # Dossiers de sortie de compilation
└─ README.md               # Description du projet
