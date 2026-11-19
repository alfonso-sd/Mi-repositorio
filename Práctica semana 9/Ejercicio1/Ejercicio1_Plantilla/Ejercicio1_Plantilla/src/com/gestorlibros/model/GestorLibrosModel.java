package com.gestorlibros.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import es.usal.progiii.tools.Rutas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GestorLibrosModel {

    ArrayList<Libro> libros;

    Path pathToXML = Paths.get(System.getProperty("user.home"), "Desktop", "libros.xml");
    Path pathToJSON = Paths.get(System.getProperty("user.home"), "Desktop", "libros.json");
    Path pathToCSV = Paths.get(System.getProperty("user.home"), "Desktop", "libros.csv");
    Path pathToBinary = Paths.get(System.getProperty("user.home"), "Desktop", "libros.bin");

    public GestorLibrosModel() {
        libros = new ArrayList<Libro>();
    }

    public void addLibro(Libro l) {
        libros.add(l);
    }

    public void removeLibro(Libro l) {
        libros.remove(l);
    }

    public void updateLibro(Libro l) {
        libros.set(libros.indexOf(l), l);
    }

    public ArrayList<Libro> getLibros() {
        return new ArrayList<Libro>(this.libros);
    }

    public int exportBooksToCSV() {
        ArrayList<String> lineas = new ArrayList<>();

        for(Libro l: libros) {
            String libroEnFormatoLinea = l.asDelimitedString(","); //algo falla
            lineas.add(libroEnFormatoLinea);
        }

        try {
            Files.write(pathToCSV, lineas, StandardCharsets.UTF_8);
            return libros.size();
        } catch (IOException e) {
            return -1;
        }
    }

    public int importBooksFromCSV() {
        try {
            List<String> lineas = Files.readAllLines(pathToCSV, StandardCharsets.UTF_8);

            int contadorLibros = 0;

            for(String linea : lineas) {
                Libro l = Libro.fromDelimitedString(linea, ","); //algo falla
                if(l != null) {
                    //Comprobar que no existe un libro
                    //Criterio de no importar libros que ya esten en la coleccion (el arraylist de libros)
                    if(!libros.contains(l)) {
                        libros.add(l);
                        contadorLibros++;
                    }   
                }
            }

            return contadorLibros;

        } catch(IOException e) {
            return -1;
        }

    }

    public int exportBooksToJSON() {
        Gson gson = new Gson();
        String json = gson.toJson(libros);

        try {
            Files.write(pathToJSON, json.getBytes(StandardCharsets.UTF_8));
            return libros.size();
        } catch(IOException e) {
            return -1;
        }
    }

    public int importBooksFromJSON() {
       Gson gson = new Gson();
       String json; //String con el json que vamos a importar del archivo
       try {
        json = new String(Files.readAllBytes(pathToJSON), StandardCharsets.UTF_8);
        Type tipoList = new TypeToken<ArrayList<Libro>>() {}.getType();

        ArrayList<Libro> librosImportados = gson.fromJson(json, tipoList);

        int contadorLibrosImportados = 0;
        for(Libro l: librosImportados) {
            if(!libros.contains(l)) {
                libros.add(l);
                contadorLibrosImportados++;
            }
        }
        return contadorLibrosImportados;

       } catch(IOException e) {
        return -1;
       }
    }

    public int importBooksFromXML() {
          XmlMapper xmlMapper = new XmlMapper();
          String xml;
          try {
            xml = new String(Files.readAllBytes(pathToXML),StandardCharsets.UTF_8);
            List<Libro> librosImportados = xmlMapper.readValue(
                xml,
                xmlMapper.getTypeFactory().constructCollectionType(
                List.class,
                Libro.class)
            );

            int numLibrosImportados = 0;
            for(Libro l: librosImportados) {
            if(!libros.contains(l)) {
                libros.add(l);
                numLibrosImportados++;
            }
        }
        return numLibrosImportados;
          } catch(IOException e) {
            return -1;
          }
    }

    public int exportBooksToXML() {
        XmlMapper xmlMapper = new XmlMapper();
        String xml;
        try {
            xml = xmlMapper.writeValueAsString(libros);
            Files.write(pathToXML, xml.getBytes(StandardCharsets.UTF_8));
            return libros.size();
        } catch(IOException e) {
            return -1;
        }
    }

    public int saveStateOfTheApp(){
        try{
        FileOutputStream fileOutputStream = new FileOutputStream(pathToBinary.toFile());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(libros);
        objectOutputStream.close();
        return libros.size();
        } catch(IOException e) {
            return -1;
        }
        
    }

    public int loadStateOfTheApp(){
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToBinary.toFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            libros = (ArrayList<Libro>) objectInputStream.readObject();
            objectInputStream.close();
            return libros.size();
        } catch(IOException e) { //Poniendo solo Exception valdría pero no sabríamos que tipo de excepcion es
            return -1;
        } catch(ClassNotFoundException e) {
            return -1;
        }
    }



}
