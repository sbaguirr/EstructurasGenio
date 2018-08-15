/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.Constantes;
import Modelo.DecisionTree;
import java.io.IOException;

/**
 *
 * @author Tiffy
 */
public class ProyectoSegundoParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        DecisionTree<String> g = new DecisionTree<>();
         g.CargarSalidas(Constantes.path_archivo).preOrden();
    }
    
}
