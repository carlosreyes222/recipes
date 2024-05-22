# Recipe App 🍳

## Descripción del Proyecto

Este proyecto es una aplicación de recetas desarrollada en Android utilizando Jetpack Compose. 
La aplicación permite a los usuarios buscar recetas, ver los detalles de cada receta y obtener información nutricional.
La aplicación se conecta a un API gratis https://api.edamam.com/api/recipes/ de recetas para obtener los datos necesarios.

## Características

- **Búsqueda de Recetas:** Los usuarios pueden buscar recetas utilizando una barra de búsqueda.
- **Listado de Recetas:** Muestra un listado de recetas en una cuadrícula, con imágenes de fondo difuminadas.
- **Detalle de Recetas:** Visualiza el detalle de cada receta, incluyendo ingredientes, calorías, imagen y una opcion para ir al mapa.
- **Mapa:** Integración con Google Maps para mostrar la ubicación de las receta use un random con las ubicaciones de las capitales de América del Sur.
- **Navegación:** Navegación entre diferentes pantallas utilizando Jetpack Navigation.
- 
## Tecnologías Utilizadas

- **Kotlin:** Lenguaje de programación principal.
- **Jetpack Compose:** Para la construcción de interfaces de usuario declarativas.
- **Hilt:** Inyección de dependencias.
- **Retrofit:** Para realizar llamadas HTTP.
- **Coroutines:** Para la gestión de tareas asincrónicas.
- **Mockk:** Librería para realizar tests unitarios con mocks.
- **Jetpack Navigation:** Para la navegación entre pantallas.

## Arquitectura del Proyecto

El proyecto sigue la arquitectura de capas, organizada de la siguiente manera:

- **app:** Contiene la configuración principal de la aplicación.
- **core:** Contiene componentes comunes reutilizables en toda la aplicación.
- **design-system:** Diseño de la aplicación con enfoque Atomic Design.
- **navigation:** Maneja la navegación entre pantallas.
- **network:** Define la configuración de red y el interceptor para colocar la api-key para todas las peticiones.
- **features:** Contiene las características principales divididas por módulos (home, map, recipe-detail).

### Estructura de Directorios

La estructura de directorios del proyecto se encuentra organizada de la forma donde el modulo api contiene la parte publica de la funcionalidad y el modulo impl contiene la implementación de la funcionalidad.


```plaintext
- features
  - home
    - api
    - impl
  - map
    - api
    - impl
  - recipe-detail
    - api
    - impl
