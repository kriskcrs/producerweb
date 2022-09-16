package com.example.prueba;


import org.springframework.web.bind.annotation.*;

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


    @GET
    @GetMapping("/datosPersona")
    @Produces(MediaType.APPLICATION_JSON)
    public persona getDatosPersona() {
        persona persona = new persona();
        persona.setId(1);
        persona.setNombre("Cristian");
        persona.setEdad(31);
        return persona;
    }


    @PostMapping("/enviarDatos")
    public persona DatosPersona(@RequestBody persona persona) {

        System.out.println("cantidad" + persona.getCantidad());
        int conta = persona.getCantidad();
        while (conta != 0) {
            String message = " {"
                    + " \"id\":" + persona.getId() + ","
                    + " \"nombre\":\"" + persona.getNombre() + "\","
                    + " \"edad\":" + persona.getEdad()
                    + "}";
            conta--;
            try {
                QueueUtil.send(nombreCola, true, true, 0, nombreServicio, message, serverLocation);

                System.out.println("Enviando mensaje...." + persona.getNombre());
                System.out.println(message);
                Thread.sleep(10);

            } catch (Exception e) {
                System.out.println("Error....");
                e.printStackTrace();
            }
        }
        return persona;
    }


}
