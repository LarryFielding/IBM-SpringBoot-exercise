## ¿Cómo probar el ejercicio?

Después de clonar el repositorio:

* Para probar el ejemplo con la base de datos MySQL:
  1. Cambiar a la rama `prueba_mysql`
  2. Cambiar las credenciales y puerto de su instancia de mysql en el archivo **aplication.yml**:
  ```
  spring:
  datasource:
    url: jdbc:mysql://localhost:3305/countries
    password: root
    username: root
    
  ```
  3. Ejecutar la aplicación Spring.
  
* Para probar el ejemplo con la base de datos MySQL:
  1. Cambiar a la rama `prueba_mongo`
  
Para la prueba con **mysql** o **mongo** se utilizan las mismas urls
  
  * Para ver todos los países por continente: <http://localhost:8080/api/countries/continent/name/{continentName}>
    
    Ejemplo: <http://localhost:8080/api/countries/continent/name/asia>
    
    Como es un método GET se puede probar en cualquier navegador.
  
  * Para insertar un nuevo país:<http://localhost:8080/api/countries/country>
  
    Como es un método POST es necesario utilizar un cliente HTTP, por ejemplo [Postman](https://www.getpostman.com/), y agregar un **Body** de tipo JSON(application/json) como el siguiente:
    ```
    {
      "name": "new country",
      "capital": "new capital",
      "continent": "europe"
    }
    ```
    Esté método regresa el id del nuevo país.
    
  * Para consultar un país en la BD se utiliza la url: <http://localhost:8080/api/countries/country?countryId={id}>
  
    Ejemplo (mysql): <http://localhost:8080/api/countries/country?countryId=186>
  
    Ejemplo (mongo): <http://localhost:8080/api/countries/country?countryId=5d618729d4c407330cf9c3b0>
    
  
