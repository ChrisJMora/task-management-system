
# Sistema de Gestión de Tareas

Un sistema de gestión de tareas desarrollado en Java que permite crear, listar, actualizar y eliminar tareas a través de una interfaz de consola intuitiva.

## Características

- **Gestión completa de tareas**: Crear, leer, actualizar y eliminar tareas
- **Interfaz de consola amigable**: Navegación por menús intuitiva
- **Validación de datos**: Verificación de entrada del usuario
- **Arquitectura limpia**: Separación de responsabilidades por capas
- **Pruebas unitarias**: Cobertura completa de pruebas

## Tecnologías Utilizadas

- **Java 11+**: Lenguaje de programación principal
- **Maven**: Gestión de dependencias y construcción del proyecto
- **JUnit 5**: Framework de pruebas unitarias
- **Mockito**: Framework para mocking en pruebas
- **Apache Commons Lang**: Utilidades para manipulación de strings
- **Checkstyle**: Análisis estático de código
- **PMD**: Detector de problemas de código
- **JaCoCo**: Cobertura de código

## Requisitos del Sistema

- **Java**: JDK 11 o superior
- **Maven**: 3.6.0 o superior (para desarrollo)
- **Sistema Operativo**: Windows, macOS, Linux

## Instalación

### Opción 1: Descarga desde GitHub Actions (artefacto automático)

Cada vez que se realiza un _pull request_ a la rama `main`, se genera automáticamente un JAR en la sección de artefactos del _workflow_ de GitHub Actions.

1. Ve a la pestaña **Actions** en GitHub.
2. Selecciona el workflow **Deploy JAR** más reciente asociado al _pull request_.
3. Al final de la ejecución encontrarás el artefacto llamado `app-jar`.
4. Descárgalo y ejecútalo con Java (ver sección de ejecución más abajo).



### Opción 2: Usando el JAR ensamblado (recomendado)

1. Asegúrate de haber ejecutado:

   ```bash
   mvn clean package
   ```

2. Ubica el archivo generado con todas las dependencias:

   ```
   target/task-management-system-1.0-SNAPSHOT-jar-with-dependencies.jar
   ```

3. Ejecuta la aplicación:

   ```bash
   java -jar target/task-management-system-1.0-SNAPSHOT-jar-with-dependencies.jar
   ```

> ⚠️ **No uses** `task-management-system-1.0-SNAPSHOT.jar`, ya que no incluye dependencias ni el atributo `Main-Class`.

### Opción 3: Compilación desde el código fuente

1. Clona el repositorio:

   ```bash
   git clone [URL_DEL_REPOSITORIO]
   cd task-management-system
   ```

2. Compila el proyecto:

   ```bash
   mvn clean compile
   ```

3. Genera el JAR con dependencias:

   ```bash
   mvn package
   ```

## Ejecución

### Ejecutar JAR ensamblado (recomendado)

```bash
java -jar target/task-management-system-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### Ejecutar desde Maven (modo desarrollo)

```bash
mvn exec:java -Dexec.mainClass="com.groupone.taskmanagementsystem.MainApp"
```

## Uso

Al ejecutar la aplicación, verás el menú principal:

```
=== SISTEMA DE GESTIÓN DE TAREAS ===

Seleccione una opción:
1. Crear tarea
2. Listar tareas
3. Actualizar tarea
4. Eliminar tarea
5. Salir
> 
```

### Operaciones Disponibles

1. **Crear tarea**: Añade una nueva tarea al sistema
2. **Listar tareas**: Muestra todas las tareas registradas
3. **Actualizar tarea**: Modifica el título de una tarea existente
4. **Eliminar tarea**: Remueve una tarea del sistema
5. **Salir**: Termina la aplicación

### Ejemplo de Uso

```
> 1
Ingrese el nombre de la nueva tarea: Estudiar Java
Tarea creada con éxito.

> 2
Lista de tareas:
[0] Estudiar Java

> 3
Ingrese el índice de la tarea a actualizar: 0
Ingrese el nuevo nombre: Estudiar Java avanzado
Tarea con ID 0 actualizada con éxito.

> 4
Ingrese el índice de la tarea a eliminar: 0
Tarea con ID 0 eliminada correctamente.

> 5
¡Hasta pronto!
```

## 🧪 Pruebas

### Ejecutar todas las pruebas

```bash
mvn test
```

### Generar reporte de cobertura

```bash
mvn jacoco:report
```

### Ejecutar análisis de código

```bash
mvn checkstyle:check
mvn pmd:check
```

### Generar sitio con reportes

```bash
mvn site
```
