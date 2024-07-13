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

Foro Hub utiliza 4 tipos de HTTP request GET, POST, PUT y DELETE los cuales necesitan ser validados por un  **"token (JWT)"** el cual se obtiene al hacer un login agregando **/login** a la direccion
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

