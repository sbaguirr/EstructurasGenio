/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiffy
 * @param <E>
 */
public class DecisionTree<E> {

    private Node<String> root;

    public DecisionTree() {
        this.root = null;
    }

    public boolean add(Iterator<String> it) {
        this.root = add(it, this.root);
        return true;
    }

    private Node<String> add(Iterator<String> it, Node<String> nodo) {
        if (nodo == null) {
            nodo = new Node<>(it.next());
        }
        if (nodo.getData().startsWith("#R")) {
            return nodo;
        }
        if (nodo.getData().startsWith("#P")) {
            nodo.setLeft(add(it, nodo.getLeft()));
            nodo.setRight(add(it, nodo.getRight()));
        }
        return nodo;
    }

    public static void preOrden(Node<String> nodo, BufferedWriter br) throws IOException {
        if (nodo != null) {
            br.write(nodo.getData());
            br.newLine();
            preOrden(nodo.getLeft(), br);
            preOrden(nodo.getRight(), br);
        }
    }

    public Node<E> searchNode(E data) {
        return searchNode(data, (Node<E>) this.root);
    }

    private Node<E> searchNode(E data, Node<E> p) {
        if (p == null) {
            return null;
        } else if (p.getData().equals(data)) {
            return p;
        }
        Node<E> i = searchNode(data, p.getLeft());
        if (i != null) {
            return i;
        }
       return searchNode(data, p.getLeft());
         
    }

    public Node<String> getRoot() {
        return root;
    }

    public static DecisionTree<String> cargarSalidas() {
        DecisionTree<String> a = new DecisionTree<>();
        List<String> l = new LinkedList<>();
        try (BufferedReader hf = new BufferedReader(new InputStreamReader(new FileInputStream(Constantes.PATH_ARCHIVO), "ISO-8859-1"))) {
            String line;

            while ((line = hf.readLine()) != null) {
                l.add(line);
            }
            ListIterator<String> it = l.listIterator();
            a.add(it);

        } catch (IOException ex) {
             Logger logger = Logger.getLogger("Log"); 
           logger.log(Level.INFO, ex.toString());
        }
        return a;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public static void guardar(DecisionTree<String> arbolito) throws IOException {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(Constantes.PATH_ARCHIVO))) {
            preOrden(arbolito.getRoot(), br);

        } catch (IOException e) {
           Logger logger = Logger.getLogger("Log"); 
           logger.log(Level.INFO, e.toString());
        }

    }
}
