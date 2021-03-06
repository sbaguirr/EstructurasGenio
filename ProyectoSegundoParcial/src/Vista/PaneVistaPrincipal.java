/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Main.Start;
import Modelo.Constantes;
import Modelo.DecisionTree;
import static Modelo.DecisionTree.guardar;
import Modelo.Node;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

/**
 *
 * @author Tiffy
 */
public class PaneVistaPrincipal {

    private BorderPane root;
    private Label preguntas;
    private Button si;
    private Button no;
    private Button playAgain;
    private Button start;
    private Node<String> nodo;
    private DecisionTree arbol;
    private PaneGuardarNuevo pg;

    public PaneVistaPrincipal() {
        pg = new PaneGuardarNuevo();
        root = new BorderPane();
        arbol = DecisionTree.cargarSalidas();
        nodo = arbol.getRoot();
        root.setId("fondoMap");
        inicializarObjetos();
        llamarMetodos();

    }

    public Pane getRoot() {
        return root;
    }

    private void crearSeccionTitulo() {
        HBox hbox = new HBox();
        Label titleLbl = new Label("Bienvenido a genio Politécnico");
        hbox.getChildren().add(titleLbl);
        titleLbl.setFont(new Font("Segoe Print", 30));
        titleLbl.setStyle("-fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setPadding(new Insets(10, 10, 0, 10));
        root.setTop(hbox);
    }

    private void llamarMetodos() {
        crearSeccionTitulo();
        crearSeccionPreguntas();
        seccionAvatar();
        botonesFinal();
        jugar();
        si();
        no();
        playAgain();
    }

    private void inicializarObjetos() {
        preguntas = new Label();
        preguntas.setStyle("-fx-font: 15 Verdana; -fx-background-color: #B0E0E6;");
        preguntas.setPrefSize(250, 50);

        si = new Button("Si");
        si.setStyle("-fx-font: 14 Verdana; -fx-base: #6495ED; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        si.setPrefSize(110, 50);
        no = new Button("No");
        no.setStyle("-fx-font: 14 Verdana; -fx-base: #C71585; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        no.setPrefSize(110, 50);
        deshabilitarBoton();

        start = new Button("Empezar");
        start.setPrefSize(150, 50);

        playAgain = new Button("Jugar de nuevo");
        playAgain.setPrefSize(150, 50);
        playAgain.setStyle("-fx-font: 14 Verdana; -fx-base: #FFD700; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");

        estiloBotones();
    }

    private void estiloBotones() {

        Image imagePlayr = new Image(getClass().getResource(Constantes.PATH_IMAGE+"/play-button.png").toExternalForm());
        ImageView r = new ImageView();
        r.setImage(imagePlayr);
        start.setStyle("-fx-font: 14 Verdana; -fx-base: #48D1CC; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        start.setContentDisplay(ContentDisplay.TOP);
        start.setGraphic(r);

        Image imagePlay = new Image(getClass().getResource(Constantes.PATH_IMAGE+"/replay.png").toExternalForm());
        ImageView w = new ImageView();
        w.setImage(imagePlay);
        playAgain.setContentDisplay(ContentDisplay.TOP);
        playAgain.setGraphic(w);
        playAgain.setDisable(true);
    }

    private void crearSeccionPreguntas() {
        VBox vbox = new VBox();
        HBox h = new HBox();
        h.getChildren().addAll(si, no);
        h.setSpacing(10);
        h.setPadding(new Insets(0, 10, 0, 10));
        vbox.getChildren().addAll(preguntas, h);
        vbox.setPadding(new Insets(150, 100, 0, 0));
        vbox.setSpacing(20);
        root.setRight(vbox);
    }

    private void botonesFinal() {
        HBox j = new HBox();
        j.setPadding(new Insets(40, 70, 60, 70));
        j.setSpacing(20);
        j.setAlignment(Pos.CENTER);
        j.getChildren().addAll(start, playAgain);
        root.setBottom(j);
    }

    private void seccionAvatar() {
        VBox k = new VBox();
        Image image = new Image(getClass().getResourceAsStream(Constantes.PATH_IMAGE+"/excalibur.png"));
        Label myLabel = new Label();
        myLabel.setGraphic(new ImageView(image));
        k.setPadding(new Insets(30, 0, 0, 5));
        k.getChildren().add(myLabel);
        root.setLeft(k);
    }

    private void ventanaProblemasTecnicos() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, estamos teniendo inconvenientes técnicos");
        alert.showAndWait();
    }

    private void dialogoAdvertencia() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de llenar todos los campos");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }

    private void dialogoFin() {
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
        advertencia.setTitle("Gracias por jugar!");
        advertencia.setContentText("Aprendo constantemente, juega de nuevo para adivinar el animal que estas pensando");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }

    private void animalYaExiste() {
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
        advertencia.setTitle(" :(  ");
        advertencia.setContentText("Hey! ya conozco ese animal");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }

    public void si() {
        this.si.setOnAction(e -> {
            try {
                recorrerArbol("si");
            } catch (IOException ex) {
                ventanaProblemasTecnicos();
            }
        });
    }

    public void no() {
        this.no.setOnAction(e -> {
            try {
                recorrerArbol("no");
            } catch (IOException ex) {
                ventanaProblemasTecnicos();
            }
        });

    }

    private boolean recorrerArbol(String direccion) throws IOException {
        boolean salir = false;
        if (nodo.getRight() == null && nodo.getLeft() == null) {
            if (direccion.equals("si")) {
                preguntas.setText("   ¡Gané!");
                deshabilitarBoton();
                deshabilitarBotones();
                return true;
            } else if (direccion.equals("no")) {
                preguntas.setText("   ¡Perdí!");
                deshabilitarBoton();
                this.start.setDisable(true);
                pg = new PaneGuardarNuevo(); 
                Start.SCENE.setRoot(pg.getRoot());
                pg.lastNode.setText(nodo.getData().substring(3));
                pg.save.setOnAction(e -> {
                    if (validar()) {
                        botonGuardar(pg.txtNewAnimal.getText(), pg.txtQuestion.getText(),
                                nodo, pg.botonSI.isSelected(), pg.botonNO.isSelected());
                    } else {
                        dialogoAdvertencia();
                    }
                });
               
                return true;
            }
        }
        if (direccion.equals("si")) {
            nodo = nodo.getLeft();
            preguntas.setText(" " + nodo.getData().substring(2));
        } else if (direccion.equals("no")) {
            nodo = nodo.getRight();
            preguntas.setText(" " + nodo.getData().substring(2));
        }
        return salir;
    }

    private void deshabilitarBotones() {
        start.setDisable(true);
        playAgain.setDisable(false);
    }

    private boolean validar() {
        return !pg.txtNewAnimal.getText().equals("")
                && !pg.txtQuestion.getText().equals("")
                && (pg.grupo.getSelectedToggle() != null);
    }

    private void botonGuardar(String animal, String pregunta, Node<String> nodo, boolean bsi, boolean bno) {
        if (animalNoRepetido(animal)) {
            Node<String> nod = new Node(nodo.getData());
            Node<String> newQuest = new Node("#R " + animal);
            nodo.setData("#P " + pregunta);
            if (bsi) {
                nodo.setLeft(newQuest);
                nodo.setRight(nod);
            } else if (bno) {
                nodo.setLeft(nod);
                nodo.setRight(newQuest);
            }
            guardarArbol(arbol);
            pg.save.setDisable(true);
        } else {
            animalYaExiste();
        }

    }

    private void guardarArbol(DecisionTree arbol) {
        try {
            guardar(arbol);
            dialogoFin();
        } catch (IOException ex) {
            ventanaProblemasTecnicos();
        }
    }

    private boolean animalNoRepetido(String animalNuevo) {
        Node<String> buscar = arbol.searchNode("#R " + animalNuevo);
        return buscar == null;
    }

    public void jugar() {
        this.start.setOnAction(e -> {
            habilitarBoton();
            playAgain.setDisable(true);
            preguntas.setText(" " + nodo.getData().substring(2));
        });
    }

    public void playAgain() {
        this.playAgain.setOnAction(e -> {
            nodo = arbol.getRoot();
            start.setDisable(false);
            habilitarBoton();
            preguntas.setText("");
            deshabilitarBoton();
        });
    }

    private void deshabilitarBoton() {
        this.si.setDisable(true);
        this.no.setDisable(true);
    }

    private void habilitarBoton() {
        this.si.setDisable(false);
        this.no.setDisable(false);
    }

}
