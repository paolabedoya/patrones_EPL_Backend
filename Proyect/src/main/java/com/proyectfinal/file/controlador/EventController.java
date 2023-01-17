package com.proyectfinal.file.controlador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Controller
public class EventController {

    @Value("${rutaSentencias}")
    private String rutaSentencias;

    @GetMapping("/evento")
    public String leerSentencia() {
        String s = null;
        try(FileReader fr = new FileReader(rutaSentencias+"Sentences.txt");
            BufferedReader br = new BufferedReader(fr)

        ){while ((s = br.readLine()) != null){
            if(s.startsWith("@Name")){
            System.out.println(s);
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "evento2";
    }

}
