RegistroRecetaApp
Este proyecto consiste en una aplicación Android para gestionar el registro de recetas de cocina. Está desarrollado utilizando Kotlin y Jetpack Compose, siguiendo los principios de la arquitectura moderna de Android y aprovechando las bibliotecas más recientes como Coil para la carga de imágenes.

Estructura del Proyecto:
MainActivity.kt:
Es el punto de entrada de la aplicación.
Usa RegistroRecetaAppTheme para aplicar el tema oscuro o claro dinámicamente.
Contiene la interfaz principal que incluye el formulario para agregar recetas y una lista para visualizar las recetas registradas.

Composable Functions:
RecipeApp: Componente principal que maneja el estado de las recetas y muestra tanto el formulario de ingreso como la lista de recetas.
RecipeForm: Un formulario donde los usuarios pueden ingresar los detalles de una nueva receta (nombre, tiempo de preparación, ingredientes, calorías, y URL de la imagen).
RecipeItem: Muestra cada receta en la lista, incluyendo la imagen cargada desde una URL, y un botón para eliminar la receta.

Abrir el proyecto en Android Studio:
Abre Android Studio y selecciona "Open an existing project".
Navega hasta la carpeta del proyecto clonado y ábrelo.
Sincronizar dependencias: Android Studio detectará las dependencias declaradas en el archivo build.gradle. Haz clic en "Sync Now" para sincronizar el proyecto con las bibliotecas necesarias, como Coil y Jetpack Compose.

Ejecutar la aplicación:
Conecta un dispositivo físico o inicia un emulador en Android Studio.
Haz clic en el botón Run o selecciona el menú "Run > Run 'app'".
La aplicación se instalará y ejecutará en el dispositivo/emulador.
