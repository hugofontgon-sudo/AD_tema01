package com.hugofont.tema4gradle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio8 {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Debes pasar un archivo");
            return;
        }

        String archivo = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}