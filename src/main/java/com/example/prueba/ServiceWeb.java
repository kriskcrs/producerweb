package com.example.prueba;


import org.springframework.web.bind.annotation.*;
import com.example.prueba.It;
import scala.util.parsing.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceWeb {
   public String nombreCola = "queue.so1.demo";
   public String nombreServicio = "EjemploCola";
   public String serverLocation = "failover:(tcp://172.17.0.2:61616)?timeout=3000";
   //public String serverLocation = "failover:(tcp://localhost:61616)?timeout=3000";


    @PostMapping("/enviarDatos")
    public It DatosIt(@RequestBody It it) {

        String message = " {"
                + " \"idPlatformOrigin\":" + it.getIdPlatformOrigin() + ","
                + " \"idCoin\":" + it.getIdCoin() + ","
                + " \"idPlatformDestiny\":" + it.getIdPlatfomDestiny() + ","
                + " \"idProducto\":" + it.getIdProducto() + ","
                + " \"mount\":" + it.getMount() + ","
                + " \"quantity\":" + it.getQuantity() + ","
                + " \"nameClient\":\"" +it.getNameClient()  + "\","
                + " \"idClient\":" + it.getIdClient()
                + "}";

            try {
                QueueUtil.send(nombreCola, true, true, 0, nombreServicio, message, serverLocation);

                System.out.println("Enviando mensaje...." + "");
                System.out.println(message);
                Thread.sleep(10);

            } catch (Exception e) {
                System.out.println("Error....");
                e.printStackTrace();
            }

        return it;
    }


}
