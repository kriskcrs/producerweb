# producerweb

servicio que recibe un post por el puerto 4040

la ruta /service/enviarDatos

Este servicio escribe a la cola de un activemq


Documentacion


servicio producer
ip 165.168.1.15:4040   --> recibe post

servicio de colas 
ip 165.168.1.16:61616  --> para consumo de colas
ip 165.168.1.16:8161   --> para ver la web

servicio consumer
ip 165.168.1.17:4041  --> lee cola del servidor de colas y lanza el post a ngnix

servicio final ngnix
ip 165.168.1.18:80   --> balanceador 

servicios que responden los post y get que envia ngnix

ip 165.168.1.19:4042    --> recibe post y muestra get en la web

ip 165.168.1.20:4042	--> recibe post y muestra get en la web

ip 165.168.1.21:4042	--> recibe post y muestra get en la web

-------------------------------------------------------------------

crea imagenes

docker build -t 'consumer':v1 .
docker build -t 'producer':v1 .
docker build -t 'serviceget':v1 .


-------------------------------------------------------------------

-- crea segmento --


docker network create --driver=bridge --subnet=165.168.0.0/16 netlb


-------------------------------------------------------------------


-- deployment ---

docker run --network=netlb --ip=165.168.1.15 -p 4040:4040  producer:v1

docker run --network=netlb --ip=165.168.1.16 -p 8161:8161 -p 61616:61616  webcenter/activemq:latest

docker run --network=netlb --ip=165.168.1.17   consumer:v1

docker run -it --network=netlb --ip=165.168.1.18 -p 80:80 -v /Users/cristiancaceres/Desktop/nginx.conf:/etc/nginx/nginx.conf nginx:latest

docker run --network=netlb --ip=165.168.1.19 -p 4042:4042 -it serviceget:v1

docker run --network=netlb --ip=165.168.1.20 -p 4043:4042 -it serviceget:v1

docker run --network=netlb --ip=165.168.1.21 -p 4044:4042 -it serviceget:v1



-------------------------------------------------------------------

--- pruebas ---

post
http://165.168.1.18:80/service/enviarDatos
{
    "idPlatformOrigin":1,
    "idCoin": 1,
    "idPlatformDestiny":1,
    "idProducto":1,
    "mount": 10,
    "quantity": 1,
    "nameClient": "cristian",
    "idClient": 1 
}



get 
http://165.168.1.17:80/service/ver

