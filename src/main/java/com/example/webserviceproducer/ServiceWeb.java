package com.example.webserviceproducer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceWeb {
   public String nombreCola = "queue.so1.demo";
   public String nombreServicio = "EjemploCola";
   public String serverLocation = "failover:(tcp://165.168.1.16:61616)?timeout=3000";
   //public String serverLocation = "failover:(tcp://localhost:61616)?timeout=3000";


    @PostMapping("/enviarDatos")
    public Data envia(@RequestBody Data data) {
        String message = " {"
                + " \"idPlatformOrigin\":" + data.getIdPlatformOrigin() + ","
                + " \"idCoin\":" + data.getIdCoin() + ","
                + " \"idPlatformDestiny\":" + data.getIdPlatfomDestiny() + ","
                + " \"idProducto\":" + data.getIdProducto() + ","
                + " \"mount\":" + data.getMount() + ","
                + " \"quantity\":" + data.getQuantity() + ","
                + " \"nameClient\":\"" + data.getNameClient()  + "\","
                + " \"idClient\":" + data.getIdClient()
                + "}";
            try {
                QueueUtil.send(nombreCola, true, true, 0, nombreServicio, message, serverLocation);
                System.out.println("[Enviando a servicio de cola con nombre:  " + nombreCola + " ] Valor --> "+ message);
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Error  ----> ");
                e.printStackTrace();
            }
        return data;
    }
}
