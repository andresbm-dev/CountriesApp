# CountriesApp
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

Lista de paises 
![image](https://user-images.githubusercontent.com/93236919/198417700-1d4ab7b1-1847-4ef0-b2a9-7eb7f8efa8f0.png)
Detalles del pais
![image](https://user-images.githubusercontent.com/93236919/198418264-4bd697c8-b052-40f5-aeab-7d886ea0ff66.png)
