/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Tiffy
 * @param <E>
 */
public class Node<E> {
    private E data;
    private Node<E> left;
    private Node<E> right;
    
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
    
    public Node(E data){
        this.data = data;
        this.left = this.right = null;
    }

    @Override
    public String toString() {
        return data.toString();
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.data);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Node)){
            return false;
        }   
        Node<E> n = (Node<E>)o;
        return (this.data.equals(n.getData()));
    }  
}