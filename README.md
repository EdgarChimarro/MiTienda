# MiTienda
## Una API con las operaciones básicas de listar, crear, actualizary eliminar Clientes

1. Puedes clonar este repositorio localmente utilizando el siguiente comando
  ```
  $ git clone https://github.com/EdgarChimarro/MiTienda/mitienda.git
  ````
2. La aplicacion utiliza H2 como base de datos en memoria [^1].
3. Para importar elproyecto en eclipse seguir los pasos:   
 ```
 File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location
 ```
5. Una vez importado en Eclipse, ejecutar el archivo ```/clientes/src/main/java/com/mitienda/clientes/ClientesApplication.java```
### La aplicacion Spring estará disponible desde el navegador
6. Para obtener la lista de Clientes, escribir la URL  ```http://localhost:8080```  en el navegador
7. Navegar a través del Boton 'Nuevo Cliente' o visitar la url   ```http://localhost:8080/nuevo```
8. [Todo] Desplazarse en la aplicación a través de los botones de ```eliminar``` y ```editar```


[^1]: La base de datos en memoria destruirá los registros al reiniciar la aplicacion.
