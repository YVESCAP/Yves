# General
Se construyen diferentes piezas de software para la extracción, transformación y carga de datos.
Las piezas que extraen desde el origen los datos para grabarlos en una tabla de trabajo se construyen en Java.
Las piezas que transforman/homologan los datos se construyen en la Base de Datos, especificamente un package y sus respectivos procedimientos. Esto con el fin de llevar
los datos a las tablas finales que conforman nuestro modelo de datos.

# Java
Se ha creado proyecto Java con las clases correspondientes para la carga de los datos provenientes de un archivo .csv y cargando con ellos un modelo de datos
creado en Oracle.
El proyecto se encuentra en la carpeta: Etl_Proceso

# Modelo de Datos
Para el modelamiento de las tablas se usó herramienta Oracle SQL Developer DataModeler, se optó por esta herramienta debido a que ya se había trabajado con ella.
Los objetos creados y la imagen del modelo se encuentran en la carpeta DataModel
