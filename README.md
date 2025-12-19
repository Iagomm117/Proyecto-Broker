# Proyecto-Broker
# Introducción
Esta aplicación es un mini broker, el programa permitirá ver un gráfico, crear agentes y generar las operaciones de los propios agentes.
# Dependencias
Las dependencias usadas son las siguientes: JFreeChart - 1.5.6 , JCommon - 1.0.24 y Gson - 2.13.2. 
<img width="586" height="321" alt="image" src="https://github.com/user-attachments/assets/66b5b83c-191e-4bfb-9dec-b024e0049ee7" />
# Versión de java y estructura de paquetes
Este proyecto se realizó en el IDE Apache NetBeans, se usó maven para crear este proyecto y además la versión de OpenJDK 17.
Además de esto la estructura de paquetes es la siguiente:

<img width="359" height="273" alt="image" src="https://github.com/user-attachments/assets/80211dc3-aa2c-4255-8c53-69f1569e85eb" />

Como se aprecia en la imagen esta aplicación tiene 4 paquetes, los cuales son controller,main, model y view.      

En el paquete **controller** tenemos los controladores para cada pestaña de la vista.

En el paquete **main** tenemos la clase que lanza la aplicación.

En el paquete **model** tenemos las clases para guardar y organizar los datos en distintas estructuras.

En el paquete **view** tenemos la vista principal con sus ventanas y el gráfico que se añade.

# Uso de la aplicación.

Para poder usar la aplicación primero tenemos que ejecutarla, al ejecutar la aplicación nos aparece la siguiente venta:

<img width="794" height="480" alt="image" src="https://github.com/user-attachments/assets/52aca1b0-54af-44ba-bfb0-26839f0cc85b" />

En esta imagen se puede apreciar que se inicia el gráfico y que tenemos las 3 pestañas correspondientes.

Si vamos a la pestaña de agentes nos aparecerán 2 campos para rellenar, un botón para crear el agente y también la lista de los agentes.

<img width="794" height="480" alt="image" src="https://github.com/user-attachments/assets/2a90dff7-3b15-48b7-bb15-55622f23e7f7" />

Y por último si vamos a la última pestaña donde podemos crear las operaciones, nos pedirá que seleccionemos un agente y un tipo de operación para poder seleccionar el tipo de operación.

<img width="794" height="480" alt="image" src="https://github.com/user-attachments/assets/3048cfe3-b3c9-49ed-9016-1f976bd35415" />

Al seleccionar un tipo de operación nos aparecerán los siguientes campos:

<img width="794" height="480" alt="image" src="https://github.com/user-attachments/assets/05b2c181-f10f-428a-bc72-fd9616cad66e" />

Ahora si queremos añadir una operación rellenamos los campos y le damos a Guardar.

<img width="790" height="478" alt="image" src="https://github.com/user-attachments/assets/4de1959d-fc77-41ad-b6e4-a4097b25321c" />

Y si queremos crear una operación y ya está creada nos aparecerá el siguiente mensaje, en el caso de compra es este, pero si es de venta cambia el texto.

<img width="790" height="476" alt="image" src="https://github.com/user-attachments/assets/d8048c78-1c4e-4501-af9a-2098df31593d" />



