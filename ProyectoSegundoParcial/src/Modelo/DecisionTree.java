/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Tiffy
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

    public void preOrden() {
        if (!isEmpty()) {
            preOrden(this.root);
        }
    }

    private void preOrden(Node<String> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getData());
            preOrden(nodo.getLeft()); 
            preOrden(nodo.getRight()); 
        }
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    public  DecisionTree<E> CargarSalidas(String filename) throws IOException {
        DecisionTree<E> a = new DecisionTree<>();
        List<String> l = new LinkedList<>();
        try (BufferedReader hf = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"))) {
            String line;

            while ((line = hf.readLine()) != null) {
                l.add(line);
            }
           ListIterator<String> it = l.listIterator();
           a.add(it);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
}


