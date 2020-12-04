# 2020-vi-no-group-22

### Link al diagrama de clases:
    
https://app.lucidchart.com/lucidchart/a3beaf32-795c-4378-9de1-49b2e16ea657/edit?page=0_0#?folder_id=home&browser=icon

### Link al diagrama entidad relación:

https://lucid.app/invitations/accept/ba1427d0-a21d-4c12-aba7-d4b5c682f9d8

<br>

Cambiar en persistence.xml la pass para la database MySQL local.

Crear schema con:

    CREATE SCHEMA `2020-vi-no-group-22`;
    
Dropear schema con:

    DROP DATABASE `2020-vi-no-group-22`;
    

Correr el test 'TestInsercionDatos' para crear un set de datos de prueba en la DB.
Se insertan datos con cada ejecución del test, si duplicas datos corriendo el test varias veces, lo mejor seria dropear
el schema y crearlo de nuevo para volver a algo consistente.

### Diagrama de arquitectura:

![Alt text](https://github.com/dds-utn/2020-vi-no-group-22/blob/master/assets/Diagrama_arquitectura.jpg)

### Link a la app:

https://tp-dds-g22.herokuapp.com/