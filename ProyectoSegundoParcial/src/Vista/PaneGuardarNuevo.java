/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Main.Start.scene;
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
import javafx.scene.layout.Background;
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
    public Button save, playAgain;
    Label l1, lbl2, lbel3, lastNode; 
    RadioButton botonSI, botonNO;
    ToggleGroup grupo;
    TextField txtNewAnimal, txtQuestion;
    HBox h_msj;

    public PaneGuardarNuevo() {
        root = new BorderPane();
        root.setPrefSize(594, 530);
        BackgroundFill myBF = new BackgroundFill(Color.DARKMAGENTA, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
        //root.setBackground(new Background(myBF));
        root.setId("fondoMap");        
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
        crearSeccionFin();
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
    
    private Label estiloLabel(Label lbl){
        lbl.setStyle("-fx-font: 12 Verdana; -fx-base: #48D1CC; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        lbl.setAlignment(Pos.CENTER);
        //lbl.setPadding(new Insets(10, 10, 10, 10));
        return lbl;
    }

    private void crearSeccionPreguntas() {
        VBox vbox = new VBox();
        HBox h = new HBox();
        Label label_animal = new Label("☆ ¿Qué animal estabas pensando?    ");
        label_animal.setStyle("-fx-font: 12 Verdana; -fx-base: #48D1CC; -fx-text-fill: #F5F5F5; -fx-font-weight: bold;");
        label_animal.setAlignment(Pos.CENTER);
        txtNewAnimal = new TextField();
        Button b = new Button("Ok");
        txtQuestion = new TextField();
        desactivarObjetos();
        HBox hb = new HBox();
        hb.getChildren().addAll(label_animal, txtNewAnimal, b);
        hb.setPadding(new Insets(20, 0, 20, 0));//bordes arriba, derecha, abajo, izquierda
        hb.setAlignment(Pos.CENTER);
        
        Label lab = new Label();
        b.setOnAction(e->{
            if(!txtNewAnimal.getText().equals("")){
                this.activarObjetos();
                lab.setText(txtNewAnimal.getText());
                estiloLabel(lab);
            }
        });
                
        VBox vertB = new VBox();
        HBox horiz = new HBox();
        VBox v1 = new VBox();
        l1 = new Label("☆ Escribe una pregunta que me permita diferenciar ");
        Label l5 = new Label("entre un(a)");
        Label l2 = new Label(" y");
        lastNode = new Label();
        estiloLabel(l1);
        estiloLabel(l2);
        estiloLabel(l5);
        estiloLabel(lastNode);
        horiz.getChildren().addAll(l5,lab,l2,lastNode);
        horiz.setAlignment(Pos.CENTER);
        horiz.setSpacing(5);
        v1.getChildren().addAll(l1,horiz);
        v1.setAlignment(Pos.CENTER);
        vertB.setPadding(new Insets(15, 45, 10, 45));
        vertB.getChildren().addAll(hb,v1,txtQuestion); 
        
        VBox f = new VBox();
        
        lbl2 = new Label("☆ La respuesta a la pregunta anterior, es si o no?");
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
         
        vbox.getChildren().addAll(vertB,f,crearSeccionFin());
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(20);
        root.setCenter(vbox);
    }
    
    private HBox crearSeccionFin(){
        HBox msje = new HBox();
        lbel3 = new Label("Gracias, he aprendido algo nuevo!");
        BackgroundFill myBF = new BackgroundFill(Color.rgb(52, 6, 64), new CornerRadii(5), new Insets(0,0,0,0));
        lbel3.setBackground(new Background(myBF));
        lbel3.setPadding(new Insets(5,5,5,5));
        lbel3.setAlignment(Pos.CENTER);
        msje.getChildren().addAll(lbel3);
        msje.setAlignment(Pos.CENTER);
        estiloLabel(lbel3);
        return msje;
    }
    
    private void desactivarObjetos() {
        txtQuestion.setDisable(true);
    }

    private void activarObjetos() {
        txtQuestion.setDisable(false);
    }
  
    private void estiloBotones() {
        Image imagePlayr = new Image(getClass().getResource(Constantes.path_image + "/save.png").toExternalForm());
        ImageView r = new ImageView();
        r.setImage(imagePlayr);
        save.setContentDisplay(ContentDisplay.TOP);
        save.setGraphic(r);
        
        Image imagePlay = new Image(getClass().getResource(Constantes.path_image + "/replay.png").toExternalForm());
        ImageView w = new ImageView();
        w.setImage(imagePlay);
        playAgain.setContentDisplay(ContentDisplay.TOP);
        playAgain.setGraphic(w);
        playAgain.setOnAction(e->{
            PaneVistaPrincipal v = new PaneVistaPrincipal();
            scene.setRoot(v.getRoot());
        });
    }
}