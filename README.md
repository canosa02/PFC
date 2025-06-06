# PorkiGames
Por Jorge Álvarez Canosa

## Project Description
**PorkiGames** es una aplicación desarrollada con **Spring Boot** que proporciona una **API REST** para la gestión de reseñas de videojuegos. La plataforma permite a los usuarios:

- 🔍 Navegar y buscar juegos por título y género  
- 📄 Ver detalles del juego: descripción, desarrollador, fecha de lanzamiento y puntuación  
- 📝 Leer y escribir reseñas de juegos  
- ⭐ Valorar juegos  
- 🎮 Gestionar géneros de videojuegos  

### Technical Stack
- **Backend**: Java con Spring Boot
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **API Documentation**: SpringDoc OpenAPI (Swagger)

### Key Features
- Endpoints RESTful para operaciones CRUD  
- Paginación para una recuperación eficiente de datos  
- Validación de datos y manejo de errores  
- Patrón DTO para la transferencia de datos  
- MapStruct para el mapeo de objetos  
- JPA/Hibernate para operaciones sobre la base de datos  

### Database Schema
La aplicación maneja las siguientes entidades principales:

- **Usuarios**: Almacena información de los usuarios  
- **Juegos**: Almacena información de los videojuegos  
- **Géneros**: Gestiona los géneros disponibles  
- **Reseñas**: Almacena reseñas y puntuaciones de los usuarios  
- **Generos_en_Juegos**: Relación muchos-a-muchos entre juegos y géneros

## Installation Guide
### IntelliJ IDEA
#### 📥 Prerequisites

- Java JDK 17 o superior  
  👉 Descarga desde: [Oracle Java Downloads](https://www.oracle.com/java/technologies/downloads/)

---
#### 1. **Descargar IntelliJ IDEA**  
   [https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download)

#### 2. **Seleccionar la Edición Community**  
   Haz clic en el botón de descarga correspondiente.

#### 3. **Instalar IntelliJ**  
   Ejecuta el instalador y sigue las instrucciones.

#### 4. **Abrir el proyecto**  
   Abre IntelliJ, selecciona el proyecto y espera a que cargue las dependencias Maven.

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

##### 6. Instalación de Linux Distribution
1. Abre Microsoft Store
2. Busca "Ubuntu"
3. Selecciona tu versión de Ubuntu predilecta
4. Clicka "Get" para instalarlo

##### 7. Verifica la instalación
Después de instalar la distribución:
1. Ábrela desde el menú Start
2. Crea un nombre de usuario y contraseña
3. Verifica WSL 2 está funcionando:
```powershell
wsl --list --verbose
Deberías ver tu distribución con la versión 2.
```

#### Troubleshooting Common Issues
- **Virtual Machine Platform Error**: Asgurate de que la virtualización está activada en la BIOS
- **Error 0x80370102**: Esto indica que la virtualización está deshabilitada

#### Descarga de Podman
##### 1. Descarga Podman:
Visita [https://podman.io](https://podman.io) y descarga el instalador de Windows

##### 2. Instalación de Podman:
Ejecuta el instalador descargado y sigue los pasos del asistente de instalación.

##### 3. Configuración de PostgreSQL
1. Ve a la sección **Images** en Podman Desktop  
2. Haz clic en **Pull an image**  
3. Busca **postgres**  
4. Descarga la imagen oficial de PostgreSQL  
5. Crea un nuevo contenedor desde la imagen usando el botón de reproducción

### Configuración de la Base de Datos
Después de instalar PostgreSQL a través de Podman:

1. El esquema de la base de datos se creará automáticamente en la primera ejecución  
2. Las credenciales por defecto están en el archivo `application.properties`  
3. Se pueden cargar datos de ejemplo usando los scripts SQL proporcionados  
