package com.hugofont.tema4gradle;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File directory = new File("/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/");

        //Ejercicio 1
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("La carpeta existe y es un directorio");

            //Ejercicio 2
            File[] archivos = directory.listFiles();
            if (archivos != null) {
                System.out.println("Hay archivos");

                for (File archivo : archivos) {
                    System.out.println("Nombre archivo: " + archivo.getName());
                }

                //Ejercicio 3
                System.out.println("\nNombre de la carpeta: " + directory.getName());
                System.out.println("Ruta absoluta: " + directory.getAbsolutePath());

                if (directory.canRead()) {
                    System.out.println("La carpeta " + directory.getName() + " se puede leer");
                } else {
                    System.out.println("La carpeta " + directory.getName() + " no se puede leer");
                }

                if (directory.canWrite()) {
                    System.out.println("La carpeta " + directory.getName() + " se puede escribir");
                } else {
                    System.out.println("La carpeta " + directory.getName() + " no se puede escribir");
                }
            }

        } else {
            System.out.println("La carpeta no existe");
        }

        //Ejericio 4
        File file = new File("/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/directory1/hola.txt");

        System.out.println("\nNombre del archivo: " + file.getName());
        System.out.println("Ruta absoluta: " + file.getAbsolutePath());

        if (file.isHidden()) {
            System.out.println("El archivo " + file.getName() + " está oculto");
        } else {
            System.out.println("El archivo " + file.getName() + " no está oculto");
        }

        if (file.canRead()) {
            System.out.println("El archivo " + file.getName() + " se puede leer");
        } else {
            System.out.println("El archivo " + file.getName() + " no se puede leer");
        }

        if (file.canWrite()) {
            System.out.println("El archivo " + file.getName() + " se puede escribir");
        } else {
            System.out.println("El archivo " + file.getName() + " no se puede escribir");
        }

        //DateTimeFormatter

        System.out.println("El tamaño del archivo son: " + file.length() + " bytes, " + file.length() / 1000 + " KB " + file.length() / 1000000 + " MB");


        // Ejercicio 5
        GestionArchivos gestion = new GestionArchivos();

        System.out.println("\n--- EJERCICIO 5 ---");

        // Crear archivo
        gestion.crearArchivo(
                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/",
                "archivo.txt"
        );

        // Listar directorio
        gestion.listarDirectorio(
                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/"
        );

        // Ver información de un archivo
        gestion.verInfo(
                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/",
                "archivo.txt"
        );


        // Ejercicio 6
        System.out.println("\n--- EJERCICIO 6 ---");

        gestion.leerArchivo(
                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/directory1/",
                "hola.txt"
        );


        // Ejercicio 7
        System.out.println("\n--- EJERCICIO 7 ---");

        gestion.verBinarioHexadecimal(
                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/directory1/",
                "archivo.bin"
        );


        // Ejercicio 9
        System.out.println("\n--- EJERCICIO 9 ---");

        boolean iguales = gestion.compararArchivos(
                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/directory1/",
                "hola.txt",

                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/directory1/directory2/",
                "hola2.txt"
        );

        if (iguales) {
            System.out.println("Los archivos son iguales");
        } else {
            System.out.println("Los archivos son diferentes");
        }


        // Ejercicio 10
        System.out.println("\n--- EJERCICIO 10 ---");

        gestion.concat(
                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/directory1/",
                "hola.txt",

                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/directory1/directory2/",
                "hola2.txt",

                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/",
                "concatenado.txt"
        );



        // Ejercicio 11
        System.out.println("\n--- EJERCICIO 11 ---");

        gestion.concatLines(
                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/directory1/",
                "hola.txt",

                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/directory1/directory2/",
                "hola2.txt",

                "/home/hugfongon-alu-edu-gva-es/Escritorio/2año/AD/tema01/",
                "concatenadoLineas.txt"
        );

    }
}