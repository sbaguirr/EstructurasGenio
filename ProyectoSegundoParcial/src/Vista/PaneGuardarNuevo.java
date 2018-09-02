/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Main.Start;
import Modelo.Constantes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Tiffy
 */
public class PaneGuardarNuevo {

    private BorderPane root;
    protected Button save;
    private Button playAgain;
    protected Label lastNode;
    protected RadioButton botonSI;
    protected RadioButton botonNO;
    protected ToggleGroup grupo;
    protected TextField txtNewAnimal;
    protected TextField txtQuestion;

    public PaneGuardarNuevo() {
        root = new BorderPane();
        root.setId("fondoMap");
        root.setPrefSize(594, 530);
        inicializarObjetos();
        llamarMetodos();

    }

    public Pane getRoot() {
        return root;
    }

    private void crearSeccionTitulo() {
        VBox hbox = new VBox();
        Label titleLbl = new Label("¡Ayúdame a mejorar mi predicción!");
        titleLbl.setFont(new Font("Segoe Print", 22));
        titleLbl.setStyle("-fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        hbox.getChildren().add(titleLbl);
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setPadding(new Insets(20, 20, 20, 20));
        root.setTop(hbox);
    }

    private void llamarMetodos() {
        crearSeccionTitulo();
        crearSeccionPreguntas();
        botonesFinal();
    }

    private void inicializarObjetos() {
        save = new Button("Guardar");
        save.setPrefSize(150, 50);
        save.setStyle("-fx-font: 14 Verdana; -fx-base: #009BFF; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        playAgain = new Button("Jugar de nuevo");
        playAgain.setPrefSize(150, 50);
        playAgain.setStyle("-fx-font: 14 Verdana; -fx-base: #FFD700; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        estiloBotones();
    }

    private void botonesFinal() {
        HBox j = new HBox();
        j.getChildren().addAll(save, playAgain);
        j.setSpacing(20);
        j.setAlignment(Pos.CENTER);
        j.setPadding(new Insets(40, 50, 40, 50));
        root.setBottom(j);
    }

    private Label estiloLabel(Label lbl) {
        lbl.setStyle("-fx-font: 12 Verdana; -fx-base: #48D1CC; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        lbl.setAlignment(Pos.CENTER);
        return lbl;
    }

    private void crearSeccionPreguntas() {
        VBox vbox = new VBox();
        HBox h = new HBox();
        Label labelAnimal = new Label("☆ ¿Qué animal estabas pensando?    ");
        labelAnimal.setStyle("-fx-font: 12 Verdana; -fx-base: #48D1CC; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        labelAnimal.setAlignment(Pos.CENTER);
        txtNewAnimal = new TextField();
        Button b = new Button("Ok");
        txtQuestion = new TextField();
        desactivarObjetos();
        HBox hb = new HBox();
        hb.getChildren().addAll(labelAnimal, txtNewAnimal, b);
        hb.setPadding(new Insets(20, 0, 20, 0));
        hb.setAlignment(Pos.CENTER);

        Label lab = new Label();
        b.setOnAction(e -> {
            if (!txtNewAnimal.getText().equals("")) {
                this.activarObjetos();
                lab.setText(txtNewAnimal.getText());
                estiloLabel(lab);
            }
        });

        VBox vertB = new VBox();
        HBox horiz = new HBox();
        VBox v1 = new VBox();
        Label l1 = new Label("☆ Escribe una pregunta que me permita diferenciar ");
        Label l5 = new Label("entre un(a)");
        Label l2 = new Label(" y");
        lastNode = new Label();
        estiloLabel(l1);
        estiloLabel(l2);
        estiloLabel(l5);
        estiloLabel(lastNode);
        horiz.getChildren().addAll(l5, lab, l2, lastNode);
        horiz.setAlignment(Pos.CENTER);
        horiz.setSpacing(5);
        v1.getChildren().addAll(l1, horiz);
        v1.setAlignment(Pos.CENTER);
        vertB.setPadding(new Insets(15, 45, 10, 45));
        vertB.getChildren().addAll(hb, v1, txtQuestion);

        VBox f = new VBox();

        Label lbl2 = new Label("☆ La respuesta a la pregunta anterior, es si o no?");
        grupo = new ToggleGroup();
        botonSI = new RadioButton("Si");
        botonNO = new RadioButton("No");
        botonSI.setStyle("-fx-font: 12 Verdana; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        botonNO.setStyle("-fx-font: 12 Verdana; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        botonSI.setToggleGroup(grupo);
        botonNO.setToggleGroup(grupo);
        estiloLabel(lbl2);
        h.getChildren().addAll(botonSI, botonNO);
        h.setPadding(new Insets(10, 10, 10, 10));
        h.setSpacing(10);
        h.setAlignment(Pos.CENTER);
        f.getChildren().addAll(lbl2, h);
        f.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(vertB, f);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(20);
        root.setCenter(vbox);
    }

    private void desactivarObjetos() {
        txtQuestion.setDisable(true);
    }

    private void activarObjetos() {
        txtQuestion.setDisable(false);
    }

    private void estiloBotones() {
        Image imagePlayr = new Image(getClass().getResource(Constantes.PATH_IMAGE+"/save.png").toExternalForm());
        ImageView r = new ImageView();
        r.setImage(imagePlayr);
        save.setContentDisplay(ContentDisplay.TOP);
        save.setGraphic(r);

        Image imagePlay = new Image(getClass().getResource(Constantes.PATH_IMAGE+"/replay.png").toExternalForm());
        ImageView w = new ImageView();
        w.setImage(imagePlay);
        playAgain.setContentDisplay(ContentDisplay.TOP);
        playAgain.setGraphic(w);
        playAgain.setOnAction(e -> {
            PaneVistaPrincipal v = new PaneVistaPrincipal();
            Start.SCENE.setRoot(v.getRoot());
        });
    }

}
