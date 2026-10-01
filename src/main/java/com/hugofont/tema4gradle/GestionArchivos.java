package com.hugofont.tema4gradle;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Ejercicio 5
public class GestionArchivos {

    public boolean crearArchivo(String directory, String file) throws IOException {

        File archivo = new File(directory, file);

        return archivo.createNewFile();
    }

    void listarDirectorio(String directory) {

        File directorio = new File(directory);

        File[] archivos = directorio.listFiles();

        if (archivos != null) {

            for (File archivo : archivos) {

                String tipo;

                if (archivo.isDirectory()) {
                    tipo = "d";
                } else {
                    tipo = "f";
                }

                long tamaño = archivo.length();

                String permisos = "";

                if (archivo.canRead()) {
                    permisos += "r";
                }

                if (archivo.canWrite()) {
                    permisos += "w";
                }

                System.out.println(archivo.getName() + " " + tipo + " " + tamaño + " bytes " + permisos);
            }
        }
    }

    void verInfo(String directory, String file) {

        File archivo = new File(directory, file);

        System.out.println("Nombre: " + archivo.getName());
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());

        if (archivo.canRead()) {
            System.out.println("Si se puede leer");
        } else {
            System.out.println("No se puede leer");
        }

        if (archivo.canWrite()) {
            System.out.println("Si se puede escribir");
        } else {
            System.out.println("No se puede escribir");
        }

        System.out.println("Tamaño: " + archivo.length() + " bytes");

        if (archivo.isDirectory()) {
            System.out.println(archivo.getName() + " es un directorio");
        } else {
            System.out.println(archivo.getName() + " es un archivo");
        }
    }

    //Ejercicio 6
    public void leerArchivo(String directory, String file) {

        File archivo = new File(directory, file);

        if (!archivo.exists()) {
            throw new IllegalArgumentException("El archivo no existe");
        }

        try (FileReader reader = new FileReader(archivo);
             BufferedReader leer = new BufferedReader(reader)) {

            String linea;

            while ((linea = leer.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ejercicio 7
    public void verBinarioHexadecimal(String directory, String file) {

        File archivo = new File(directory, file);

        try (FileInputStream input = new FileInputStream(archivo);
             BufferedInputStream leer = new BufferedInputStream(input)) {

            int byteLeido;
            int contador = 0;

            while ((byteLeido = leer.read()) != -1) {

                System.out.printf("%02X ", byteLeido);

                contador++;

                if (contador == 16) {
                    System.out.println();
                    contador = 0;
                }
            }

            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ejercicio 9
    public boolean compararArchivos(
            String directory1,
            String file1,
            String directory2,
            String file2) {

        File archivo1 = new File(directory1, file1);
        File archivo2 = new File(directory2, file2);

        if (archivo1.length() != archivo2.length()) {
            return false;
        }

        try (FileInputStream input1 = new FileInputStream(archivo1);
             FileInputStream input2 = new FileInputStream(archivo2);
             BufferedInputStream leer1 = new BufferedInputStream(input1);
             BufferedInputStream leer2 = new BufferedInputStream(input2)) {

            int byte1;
            int byte2;

            while ((byte1 = leer1.read()) != -1) {

                byte2 = leer2.read();

                if (byte1 != byte2) {
                    return false;
                }
            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Ejercicio 10
    public void concat(
            String directory1,
            String file1,
            String directory2,
            String file2,
            String directory3,
            String file3) {

        File archivo1 = new File(directory1, file1);
        File archivo2 = new File(directory2, file2);
        File archivo3 = new File(directory3, file3);

        try (FileInputStream input1 = new FileInputStream(archivo1);
             FileInputStream input2 = new FileInputStream(archivo2);
             FileOutputStream output = new FileOutputStream(archivo3)) {

            int byteLeido;

            // Primero copiamos el archivo 1
            while ((byteLeido = input1.read()) != -1) {
                output.write(byteLeido);
            }

            // Después copiamos el archivo 2
            while ((byteLeido = input2.read()) != -1) {
                output.write(byteLeido);
            }

            System.out.println("Archivo concatenado correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ejercicio 11
    public void concatLines(
            String directory1,
            String file1,
            String directory2,
            String file2,
            String directory3,
            String file3) {

        File archivo1 = new File(directory1, file1);
        File archivo2 = new File(directory2, file2);
        File archivo3 = new File(directory3, file3);

        try (FileReader reader1 = new FileReader(archivo1);
             BufferedReader leer1 = new BufferedReader(reader1);

             FileReader reader2 = new FileReader(archivo2);
             BufferedReader leer2 = new BufferedReader(reader2);

             FileWriter writer = new FileWriter(archivo3);
             BufferedWriter escribir = new BufferedWriter(writer)) {

            String linea1;
            String linea2;

            while ((linea1 = leer1.readLine()) != null
                    && (linea2 = leer2.readLine()) != null) {

                escribir.write(linea1 + linea2);
                escribir.newLine();
            }

            System.out.println("Archivo concatenado por líneas correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}