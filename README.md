# 2020-vi-no-group-22

### Link al diagrama de clases:
    
https://app.lucidchart.com/documents/edit/1d482532-c44c-40a3-87de-eaebab8260fb/0_0?shared=true

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
