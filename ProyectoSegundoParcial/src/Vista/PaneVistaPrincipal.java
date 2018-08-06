/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Constantes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Tiffy
 */
public class PaneVistaPrincipal {

    private BorderPane root;
    private Label preguntas;
    private Button si, no, playAgain, start;

    public PaneVistaPrincipal() {
        root = new BorderPane();
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
        titleLbl.setStyle("-fx-text-fill: #F5F5F5;");
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setPadding(new Insets(10, 10, 0, 10));
        root.setTop(hbox);
    }

    private void llamarMetodos() {
        crearSeccionTitulo();
        crearSeccionPreguntas();
        seccionMuñeco();
        botonesFinal();
    }

    private void inicializarObjetos() {
        preguntas = new Label("Es un mamifero?");
        preguntas.setStyle("-fx-font: 15 Verdana; -fx-background-color: #B0E0E6;");
        preguntas.setPrefSize(250, 50);

        si = new Button("Si");
        si.setStyle("-fx-font: 14 Verdana; -fx-base: #6495ED; -fx-text-fill: #F5F5F5;");
        si.setPrefSize(110, 50);
        no = new Button("No");
        no.setStyle("-fx-font: 14 Verdana; -fx-base: #C71585; -fx-text-fill: #F5F5F5;");
        no.setPrefSize(110, 50);
        start = new Button("Empezar");
        start.setPrefSize(150, 50);
        
       
        playAgain = new Button("Jugar de nuevo");
        playAgain.setPrefSize(150, 50);
        playAgain.setStyle("-fx-font: 14 Verdana; -fx-base: #FFD700; -fx-text-fill: #F5F5F5;");
        
        estiloBotones();
    }

    private void estiloBotones() {
        
        Image imagePlayr = new Image(getClass().getResource(Constantes.path_image + "/play-button.png").toExternalForm());
        ImageView r = new ImageView();
        r.setImage(imagePlayr);
        start.setStyle("-fx-font: 14 Verdana; -fx-base: #48D1CC; -fx-text-fill: #F5F5F5;");
        start.setContentDisplay(ContentDisplay.TOP);
        start.setGraphic(r);
        
        Image imagePlay = new Image(getClass().getResource(Constantes.path_image + "/replay.png").toExternalForm());
        ImageView w = new ImageView();
        w.setImage(imagePlay);
        playAgain.setContentDisplay(ContentDisplay.TOP);
        playAgain.setGraphic(w);
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
        j.getChildren().addAll(start, playAgain);
        j.setSpacing(20);
        j.setAlignment(Pos.CENTER);
        root.setBottom(j);
    }

    private void seccionMuñeco() {
        VBox k = new VBox();
        Image image = new Image(getClass().getResourceAsStream(Constantes.path_image + "/excalibur.png"));
        Label myLabel = new Label();
        myLabel.setGraphic(new ImageView(image));
        k.setPadding(new Insets(30, 0, 0, 5));
        k.getChildren().add(myLabel);
        root.setLeft(k);
    }
}
