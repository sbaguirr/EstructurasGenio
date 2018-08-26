/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.DecisionTree;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Tiffy
 */
public class ProyectoSegundoParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
         DecisionTree<String> t= DecisionTree.cargarSalidas();

        System.out.println(t.getRoot());
        Scanner d = new Scanner(System.in);
        String direccion = d.nextLine();
    }

}
