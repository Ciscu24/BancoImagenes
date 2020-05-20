package com.proyectociscu.proyectobancoimagenes.controller;

import com.proyectociscu.proyectobancoimagenes.model.Photo;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class IMController implements Initializable {

    @FXML
    private ScrollPane pane;
    @FXML
    private TilePane tile;
    
    public static List<Photo> PhotosIM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(pane!=null && tile!=null){
            pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Horizontal
            pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scroll bar
            pane.setFitToWidth(true);
            pane.setContent(tile);
            tile.setPadding(new Insets(15, 15, 15, 15));
            tile.setHgap(15);
            tile.setVgap(15);
            tile.setAlignment(Pos.CENTER);
            if(PhotosIM != null){
                for (Photo p : PhotosIM) {
                    ImageView imageView;
                    imageView = createImageView(p);
                    tile.getChildren().addAll(imageView);
                }
            }else{
                for (Photo p : AppController.Photos) {
                    ImageView imageView;
                    imageView = createImageView(p);
                    tile.getChildren().addAll(imageView);
                }
            }
            
        }
        
    }

    private ImageView createImageView(String ruta) {
        ImageView imageView = null;
        Image image;
        image = new Image("File:" + ruta, 150, 0, true, true);

        imageView = new ImageView(image);
        imageView.setFitWidth(150);

        return imageView;
    }

    private ImageView createImageView(Photo p) {
        ImageView imageView = null;
        Image image;
        image = new Image("File:" + p.getRuta(), 150, 0, true, true);
        imageView = new ImageView(image);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent mouseEvent) {
                
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    
                    if (mouseEvent.getClickCount() == 2) {
                        ImageView imageView = new ImageView();
                        Image image = new Image("File:"+p.getRuta());
                        imageView.setImage(image);
                        BorderPane borderPane = new BorderPane();
                        imageView.setPreserveRatio(true);
                        imageView.setSmooth(true);
                        imageView.setCache(true);
                        borderPane.setCenter(imageView);
                        borderPane.setStyle("-fx-background-color: #6BA7D6");
                        Label label01 = new Label("Categoria: " + p.getCategoria());
                        label01.setTextFill(Color.web("#FFFFFF"));
                        label01.setPadding(new Insets(15, 15, 15, 15));
                        label01.setStyle("-fx-margin: 10");
                        Label label02 = new Label(p.getDescripcion());
                        label02.setTextFill(Color.web("#FFFFFF"));
                        label02.setPadding(new Insets(15, 15, 15, 15));
                        VBox vbox = new VBox();
                        vbox.setStyle("-fx-background-color: rgba(0,0,0,0.3)");
                        vbox.getChildren().add(label01);
                        vbox.getChildren().add(label02);
                        borderPane.setBottom(vbox);
                        Stage newStage = new Stage();
                        newStage.setTitle(p.getTitulo());
                        Scene scene = new Scene(borderPane, Color.BLACK);
                        newStage.setScene(scene);
                        newStage.show();
                        
                    }
                }
            }
        });
        return imageView;
    }

}
