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
import java.util.Scanner;

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

    public Node<String> getRoot() {
        return root;
    }

    
    
     public boolean recorrerArbol(String direccion) {
        if (direccion.toLowerCase().equals("si")) {
            return recorrerarArbol(this.root.getLeft(), direccion);
        } else {
            return recorrerarArbol(this.root.getRight(), direccion);
        }
    }

    private boolean recorrerarArbol(Node<String> nodo, String direccion) {
        boolean salir = false;
        if (nodo.getRight() == null && nodo.getLeft() == null) {
            //label.setText("Es un " + nodo.getData());
            System.out.println("Es un " + nodo.getData()+"?");
            Scanner d = new Scanner(System.in);
            direccion = d.nextLine();
            if (direccion.toLowerCase().equals("si")) {
                // label.setText("gané");
                System.out.println("gané");
                return true;
            } else if (direccion.equals("no")) {
                // label.setText("perdi");
                System.out.println("perdí");
                return true;
            }
        }

        System.out.println(nodo.getData());
        Scanner d = new Scanner(System.in);
        direccion = d.nextLine();
        if (direccion.toLowerCase().equals("si")) {
            recorrerarArbol(nodo.getLeft(), direccion);
        } else if (direccion.toLowerCase().equals("no")) {
            recorrerarArbol(nodo.getRight(), direccion);
        }

        return salir;
    }

    public  static DecisionTree<String> CargarSalidas() {
        DecisionTree<String> a = new DecisionTree<>();
        List<String> l = new LinkedList<>();
        try (BufferedReader hf = new BufferedReader(new InputStreamReader(new FileInputStream(Constantes.path_archivo), "ISO-8859-1"))) {
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
    
     @Override
    public String toString() {
        return  root.toString();
    }
}


