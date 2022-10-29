# CountriesApp

La app debe contar con los siguientes componentes:
Campo de búsqueda.
Lista de países.
Visualización de resultados de la búsqueda.
Detalle del país.


Requerimientos básicos
El código puede escribirse en Kotlin o Java.
Cada elemento de la lista debe mostrar los siguientes campos: 
Nombre oficial.
Capital.
Imagen de la bandera.
Al seleccionar cada país debo poder ver más detalle relacionado al país.
Aplicar principios SOLID.


Requerimientos Tecnicos:

● El código debe escribirse en Kotlin.
● Aplicar una arquitectura basada en componentes.
● Utilizar Navigation para navegar entre pantallas.
● Inyectar las dependencias con Koin o Dagger 2.
● Utilizar GitFlow pare el versionamiento del código.
● Uso de corrutinas para el flujo asíncrono.
● Implementar pruebas unitarias.
● Uso de llamadas seguras en kotlin.
● Almacenar localmente los datos para ser consultados cuando no se cuente con internet.
● Al seleccionar cada país debo poder ver con quien limita y traer la información básica de los paises con los que limita.

Responsabilidades de cada capa:
● capa de UI: En esta capa se encuentra la clase CountriesActivity la cual es la encargada de gestionar la vista y hacer la navegación entre el fragment countriesFragment y DetailCountriesFragment, mostrar la lista de paises y sus detalles.
Tambien se tiene el viewModel utilizado para lanzar la corrutina y hacer el llamado en segundo plano de la api, capturar el listado de paises y proporcionarlos en los diferentes fragments que lo utilizan.
● capa domain: En esta capa se tiene el modelo de datos que mapea la respuesta de la api y son utilizados para mostar sus datos, además se encuenta el caso de uso que se encarga de llamar al repositorio que llama los datos de la api.
● capa data:En esta capa se tiene el repository y la interfaz las cuales son utilizadas para hacer el llamado a la api.


Lista de paises llamados desde la api 

![image](https://user-images.githubusercontent.com/93236919/198848403-ebc46237-5191-4b67-9310-8d87010332a6.png)


Detalles del pais

![image](https://user-images.githubusercontent.com/93236919/198850878-d811f442-af0c-49fc-a0a3-b75a6f107de7.png)

Funcionalidad del Buscador

![image](https://user-images.githubusercontent.com/93236919/198848422-2ad396c7-ef62-4f21-b617-ad3656346ce3.png)

Lista de paises llamados desde base de datos

![image](https://user-images.githubusercontent.com/93236919/198850601-bd307699-2978-4d43-ad55-6b9b4b9630e2.png)
