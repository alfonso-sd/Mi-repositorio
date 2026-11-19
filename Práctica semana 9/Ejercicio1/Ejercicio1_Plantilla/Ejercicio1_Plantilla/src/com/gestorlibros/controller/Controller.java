package com.gestorlibros.controller;

import java.util.ArrayList;

import com.gestorlibros.model.GestorLibrosModel;
import com.gestorlibros.model.Libro;
import com.gestorlibros.view.View;

public class Controller {

    GestorLibrosModel m;
    View v;

    public Controller(GestorLibrosModel m, View v) {
        this.m = m;
        this.v = v;
        // Inyectamos el controlador en la vista
        v.setC(this);
    }

    public void initApp() {

        // Load data
        int numLibros = m.loadStateOfTheApp();
        if (numLibros > 0) {
            v.showInfoMessage("Se ha importado" + numLibros + "libros");
        } else if (numLibros == 0) {
            v.showInfoMessage("No se han importado libros");
        } else if (numLibros < 0) {
            v.showInfoMessage("Se ha producido un error al importar ls libros");
        }

        // Show Menu
        v.startMenu();

        numLibros = m.saveStateOfTheApp();
        if (numLibros > 0) {
            v.showInfoMessage("Se ha exportado" + numLibros + "libros");
        } else if (numLibros == 0) {
            v.showInfoMessage("No se han exportado libros");
        } else if (numLibros < 0) {
            v.showInfoMessage("Se ha producido un error al exportar ls libros");
        }

        //Save data
    }

    public ArrayList<Libro> getLibros() {
        return m.getLibros();
    }

    public void addLibro(Libro l) {
        m.addLibro(l);
    }

    public void removeLibro(Libro libro) {
        m.removeLibro(libro);
    }

    public void updateLibro(Libro libroAModificar) {
        m.updateLibro(libroAModificar);
    }

    public int exportBooksToCSV() {
        return m.exportBooksToCSV();
    }

    public int exportBooksToJSON() {
        return m.exportBooksToJSON();
    }

    public int importBooksFromJSON() {
        return m.importBooksFromJSON();
    }

    public int importBooksFromCSV() {
        return m.importBooksFromCSV();
    }

    public int importBooksFromXML() {
        return m.importBooksFromXML();
    }

    public int exportBooksToXML() {
        return m.exportBooksToXML();
    }
    
}
