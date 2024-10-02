# Taco Shop JPA

Este repositorio contiene un proyecto de Spring Boot para una aplicación de una tienda de tacos, utilizando JPA para las interacciones con la base de datos.

## Estructura del Proyecto

- **src/main/java**: Contiene el código principal de la aplicación.
  - **com/taco/shop**: Paquete raíz de la aplicación.
    - **controller**: Controladores REST.
    - **model**: Clases de entidad que representan las tablas de la base de datos.
    - **repository**: Repositorios de Spring Data JPA.
    - **service**: Interfaces e implementaciones de la capa de servicio.
    - **TacoShopApplication.java**: Clase principal de la aplicación Spring Boot.

- **src/main/resources**: Contiene las propiedades de la aplicación y otros archivos de recursos.
  - **application.properties**: Configuración de la aplicación.

## Comenzando

1. Clonar el repositorio:
    ```sh
    git clone https://github.com/EBDev81/taco-shop-jpa.git
    cd taco-shop-jpa
    ```

2. Construir el proyecto:
    ```sh
    ./mvnw clean install
    ```

3. Ejecutar la aplicación:
    ```sh
    ./mvnw spring-boot:run
    ```

## Dependencias

- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- H2 Database
- Lombok

## Características

- API RESTful para gestionar pedidos de tacos
- Integración con JPA para operaciones de base de datos
- Base de datos en memoria H2 para desarrollo y pruebas

## Contacto

Para más información, contacta al propietario del repositorio.

## Uso

La aplicación proporciona una API RESTful para gestionar pedidos de tacos. Para interactuar con la API, puedes utilizar herramientas como `curl`, Postman, o cualquier cliente HTTP.

## Uso

La aplicación proporciona una API RESTful para gestionar pedidos de tacos. Para interactuar con la API, puedes utilizar herramientas como Postman.

### Ejemplos de Uso

1. **Crear un nuevo pedido de tacos**:
    - Método: POST
    - URL: `http://localhost:8080/orders`
    - Encabezados:
        - `Content-Type: application/json`
    - Cuerpo:
        ```json
        {
            "tacoName": "Carnitas",
            "quantity": 3,
            "customerName": "John Doe",
            "address": "123 Taco St",
            "phoneNumber": "555-1234"
        }
        ```

2. **Obtener todos los pedidos**:
    - Método: GET
    - URL: `http://localhost:8080/orders`

3. **Obtener un pedido por ID**:
    - Método: GET
    - URL: `http://localhost:8080/orders/{id}`

4. **Actualizar un pedido existente**:
    - Método: PUT
    - URL: `http://localhost:8080/orders/{id}`
    - Encabezados:
        - `Content-Type: application/json`
    - Cuerpo:
        ```json
        {
            "tacoName": "Carnitas",
            "quantity": 5,
            "customerName": "John Doe",
            "address": "123 Taco St",
            "phoneNumber": "555-1234"
        }
        ```

5. **Eliminar un pedido**:
    - Método: DELETE
    - URL: `http://localhost:8080/orders/{id}`
