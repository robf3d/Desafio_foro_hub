# FORO HUB
<h2>Que es "Foro Hub?</h2>
Foro Hub es un API echa en "JAVA" que nos permite hacer de backend para un foro pudiendo crear, editar, listar y eliminar topicos utilizando una base de datos MYSQL

<h3>Tecnologias empleadas</h3>

- MySql
- Java 17
- Maven
- Spring Boot
- Postman


<h2>Como utilizar Foro Hub</h2>

Foro Hub utiliza 4 tipos de HTTP request GET, POST, PUT y DELETE los cuales necesitan ser validados por un  **"token (JWT)"** el cual se obtiene al hacer un login agregando **/login** a la direccion y utilizando el metodo PUT
```
tu_ip_local/login
```

El formato JSON que devemos utilizar
````
{
    "login":"tu_usuario",
    "clave":"tu_contraseña"
}
````

Al hacer login nuestra api nos retornara un **Token JWT**

![image](https://github.com/user-attachments/assets/2610bb46-a74f-424d-8c19-adeed6f98658)

Este tiene que ser agregado como autorizacion en el header de nuestro **Postman** con el tipo de autorizacion **BEARER TOKEN* para poder realizar cualquier tipo de metodo GET, POST, PUT y DELETE 

![image](https://github.com/user-attachments/assets/aa5ec752-d652-4d74-a7c9-168a59eaedea)

<h2>Metodos</h2>

<h3> - GET</h3>

Para obtener los **Topicos** de nuestro foro podemos utilizar 2 formas de metodo GET, una para listarnos todos los topicos y otra para obtener un topico especifico por **id**

Para listar todos los topicos utilizaremos **/topicos**
````
tu_ip_local/topicos
````

Para obtener un topico espesifico solo agregariamos **/id_de_el_topico**
````
tu_ip_local/topicos/id
````

Ejemplo:

![image](https://github.com/user-attachments/assets/bad35065-3a98-4b4b-84dd-22790a3cebb5)

<h3> - POST</h3>
Para poder agregar un topico en "/topicos" tendremos tendremos que utilizar esta estructura JSON

````
{
    "titulo":"MI_MENSAJE",
    "mensaje":"MI_MENSAJE",
    "fecha":"2024-07-10T10:25",
    "status":"valido",
    "autor": "MI_AUTOR",
    "curso":"MI_CURSO"
}

````

Los campos de **titulo** y **mensaje** no pueden ser iguales a otros topicos ya existentes en nuestra base de datos

Ejemplo:

![image](https://github.com/user-attachments/assets/0cd00c72-52e0-47b3-9f37-79b648a9a172)

<h3> - PUT</h3>
Para poder editar un topico en "/topicos" tendrenmos que agregar el **id** del topico que queremos modificar 

````
tu_ip_local/topicos/id
````

El formato **JSON** que utilizaremos sera igual al metodo **POST** pero excluyendo las partes que no se quieran modificar

Ejemplo:

![image](https://github.com/user-attachments/assets/56ea90ed-ee79-4733-9c72-075b14cef2d4)





