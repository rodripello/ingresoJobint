# ingresoJobint

repositorio del challenge para Jobint

Para levantar la aplicacion por docker se corre los siguientes comandos en el directorio donde se encuentra el archivo Dockerfile

se levanta la imagen 

docker build -t nombre imagen  .

para correr el contenedor

docker run -p 8080:8080 -it -d nombre del contenedor

Una vez en la aplicacion se ingresa a la siguiente URL para consumir la aplicacion:

http://localhost:8080/swagger-ui/index.html

Nos pide unas credenciales:
user:jobint
password:jobint

Luego podemos consumir los endpoints en el swagger 

Ejemplo de destino para reservas y hoteles:Rome