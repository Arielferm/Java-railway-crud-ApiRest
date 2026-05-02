Java REST API – CRUD de Productos Tecnológicos

🔗 https://java-railway-crud-apirest-production-8151.up.railway.app/productos 

API REST desarrollada en Java con Spring Boot, enfocada en la gestión eficiente de productos tecnológicos mediante operaciones CRUD. La aplicación está desplegada en la nube (Railway) y utiliza PostgreSQL como base de datos relacional.

🔹 Características principales:

•	Permite crear, consultar, actualizar y eliminar productos 
•	Arquitectura RESTful clara y escalable 
•	Integración con base de datos PostgreSQL 
•	Deploy productivo en la nube (Railway) 
•	Manejo de requests y responses en formato JSON 

🚀 Tecnologías utilizadas:

Java 17
Spring Boot 3
Spring Data JPA / Hibernate
PostgreSQL
Docker
Railway 

📋 Endpoints disponibles 
(“direcciones” de la API que permiten realizar acciones como ver, crear, editar o eliminar productos según el usuario/app)

MétodoURLDescripciónGET/productosObtener todos los productosGET/productos/{id}Obtener un producto por IDPOST/productosCrear un nuevo productoPUT/productos/{id}Actualizar un productoDELETE/productos/{id}Eliminar un producto

📦 Ejemplo de uso:

Crear un producto (POST)
json{
  "nombre": "Notebook Lenovo",
  "precio": 1500.00
}

Respuesta esperada

json{
  "id": 1,
  "nombre": "Notebook Lenovo",
  "precio": 1500.00
}
