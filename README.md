
# Proyecto Final de Ciclo 
Por Jorge Álvarez Canosa

## Guía de Instalación 
### Intellij
#### 📥 Requisitos Previos

- Tener Java instalado (JDK 17 o superior recomendado).  
  Puedes descargarlo desde: [https://jdk.java.net/]([https://jdk.java.net/](https://www.oracle.com/java/technologies/downloads/))

---
##### 1. Ve al sitio oficial de descarga:  
   [https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download)

##### 2. Debemos movernos hasta la parte inferior de la pestaña y darle click en el botón download de la Community Edition.
   
##### 3. Ejecuta el instalador y sigue los pasos del asistente de instalación

##### 4. Una vez terminada la instalación ya se podría abrir el programa y ver el código

### Podman
#### 📥 Requisitos Previos
- Windows 10 o superior (64 bits)
- Virtualización activada en la BIOS
- WSL 2 instalado (opcional, pero recomendado)

#### Instalación de WSL
##### 1. Habilitar el Subsistema de Windows para Linux

Abre **PowerShell como administrador** y ejecuta:

```powershell
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
```
##### 2. Habilitar la Plataforma de Máquina Virtual
Este paso es esencial para WSL 2. En la misma ventana de PowerShell, ejecuta:

```powershell
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
```
Nota: Si encuentras errores relacionados con la virtualización, asegúrate de que esté habilitada en la BIOS de tu sistema.

##### 3. Reiniciar el Sistema
Reinicia para aplicar los cambios realizados en los pasos anteriores.

##### 4. Descargar e Instalar el Paquete de Actualización del Kernel de Linux
Para descargar el paquete puedes ejecutar el siguiente comando:

```powershell
wsl.exe --install
```
Después de ejecutarlo te pedirá reiniciar nuevamente.

##### 5. Establecer WSL 2 como Versión Predeterminada
Abre PowerShell y ejecuta:

```powershell
wsl --set-default-version 2
```
Esto configurará WSL 2 como la versión predeterminada para futuras instalaciones de distribuciones de Linux.

##### 6. Instalar una Distribución de Linux
Puedes instalar una distribución de Linux desde la Microsoft Store. Por ejemplo, para instalar Ubuntu:

Abre la Microsoft Store.

Busca "Ubuntu" y selecciona la versión deseada.

Haz clic en "Obtener" para instalarla.

##### 7. Verificar la Instalación
Después de instalar la distribución:

Ábrela desde el menú de inicio.

Se te pedirá crear un nombre de usuario y contraseña para la distribución de Linux.

Una vez configurado, puedes verificar que estás utilizando WSL 2 ejecutando:

```powershell
wsl --list --verbose
Deberías ver tu distribución con la versión 2.
```

🛠️ Solución de Problemas Comunes
Error al habilitar la Plataforma de Máquina Virtual: Asegúrate de que la virtualización esté habilitada en la BIOS. Consulta el manual de tu placa base o el sitio web del fabricante para obtener instrucciones específicas.

Error 0x80370102 al iniciar la distribución: Este error indica que la virtualización no está habilitada. Verifica la configuración de la BIOS.

#### Instación de Podman
##### 1. Ve al sitio oficial y descarga el instalador para Windows:
[https://podman.io](https://podman.io)

##### 2. Una vez descargado el archivo debes ejecutarlo y seguir los pasos indicados

##### 3. Creación de images
Debes dirigirte a la parte de images en podman. 
En este apartado puedes añadir todas las imágenes de bases de datos que necesites, en mi caso usaré postgresql.
Debes entrar en la opción pull, escribir postgres y descargar la primera opción

##### 4. Iniciar un container 
A partir de la imagen de postgres crearemos un contenedor dandole al botón de play

