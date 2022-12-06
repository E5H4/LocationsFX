package com.example.lab3fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = new AnchorPane();
        AnchorPane root2 = new AnchorPane();
        AnchorPane rootH = new AnchorPane();

        ListView<Location> locList = new ListView<>();
        locList.getItems().add(new Location("Cleveland", 0, 0, true));
        locList.getItems().add(new Location("North Pole", 500, -100, true));
        locList.getItems().add(new Location("Campbell Hill", -50, -50, false));
        locList.getItems().add(new Location("Tokyo", -100, 1000, true));
        locList.getItems().add(new Location("Chicago", -200, 75, true));
        locList.getItems().add(new Location("Erie PA", 150, 0, true));
        locList.getItems().add(new Location("Allegheny National Forest", 300, -75, false));

        Scene locS = new Scene(root, 800, 600);
        Scene addS = new Scene(root2, 800, 600);
        Scene makeHeli = new Scene(rootH, 800, 600);

        Helicopter h = new Helicopter(locList.getItems().get(0), 0, 0, 0);
// start heli scene
        Label hNameLbl = new Label("Helicopter name :");
        Label hFuelLbl = new Label("fuel amount :");
        Label hMPGLbl = new Label("MPG :");

        TextField hNameTF = new TextField();
        TextField hFuelTF = new TextField();
        TextField hMPGTF = new TextField();

        Button hBtn = new Button("create my helicopter!");
        hBtn.setOnAction(actionEvent -> {
            try {
                String hName = hNameTF.getText();
                double hFuel = Double.parseDouble(hFuelTF.getText());
                double hMPG = Double.parseDouble(hMPGTF.getText());

                h.setName(hName);
                h.setFuel(hFuel);
                h.setMPG(hMPG);

//2 methods created in heli
                stage.setScene(locS);
            } catch (Exception e) {
                hBtn.setText("Invalid input!");
            }
        });

        AnchorPane.setLeftAnchor(hNameLbl, 120.0);
        AnchorPane.setTopAnchor(hNameLbl, 80.0);

        AnchorPane.setLeftAnchor(hFuelLbl, 120.0);
        AnchorPane.setTopAnchor(hFuelLbl, 200.0);

        AnchorPane.setLeftAnchor(hNameTF, 250.0);
        AnchorPane.setTopAnchor(hNameTF, 80.0);

        AnchorPane.setLeftAnchor(hFuelTF, 250.0);
        AnchorPane.setTopAnchor(hFuelTF, 200.0);

        AnchorPane.setLeftAnchor(hBtn, 120.0);
        AnchorPane.setTopAnchor(hBtn, 355.0);

        AnchorPane.setLeftAnchor(hMPGLbl, 130.0);
        AnchorPane.setTopAnchor(hMPGLbl, 300.0);

        AnchorPane.setLeftAnchor(hMPGTF, 250.0);
        AnchorPane.setTopAnchor(hMPGTF, 300.0);


        rootH.getChildren().addAll(hNameLbl, hNameTF, hMPGLbl, hMPGTF, hFuelLbl, hFuelTF, hBtn);
        //textfield in children and the anchor panes
//  end heli scene
//list for scene one is in heli scene above^^
        //start scene 1

        AnchorPane.setRightAnchor(locList, 10.0);
        AnchorPane.setTopAnchor(locList, 10.0);

        Label infoLbl = new Label("Fly your helicopter.");
        Button flyBtn = new Button("FLY!");
        flyBtn.setOnAction(actionEvent -> {
            infoLbl.setText(h.flyTo(locList.getSelectionModel().getSelectedItem()));
        });

        Button refuelBtn = new Button("REFUEL");
        refuelBtn.setOnAction(actionEvent -> {
            infoLbl.setText(h.refuel());
        });

        //h.refuel();

        AnchorPane.setLeftAnchor(refuelBtn, 10.0);
        AnchorPane.setBottomAnchor(refuelBtn, 150.0);

        AnchorPane.setRightAnchor(flyBtn, 10.0);
        AnchorPane.setBottomAnchor(flyBtn, 150.0);

        Button addLocation = new Button("Add location");
        addLocation.setOnAction(actionEvent -> {
            stage.setScene(addS);
        });
        Button rmveLocation = new Button("Remove location");
        rmveLocation.setOnAction(actionEvent -> {
            locList.getItems().remove(locList.getSelectionModel().getSelectedIndex());
        });

        AnchorPane.setRightAnchor(addLocation, 10.0);
        AnchorPane.setBottomAnchor(addLocation, 10.0);

        AnchorPane.setRightAnchor(rmveLocation, 140.0);
        AnchorPane.setBottomAnchor(rmveLocation, 10.0);

        AnchorPane.setLeftAnchor(infoLbl, 10.0);
        AnchorPane.setTopAnchor(infoLbl, 10.0);

        root.getChildren().addAll(locList, flyBtn, refuelBtn, infoLbl, addLocation, rmveLocation);

        //end scene 1
        //start scene 2

        Label placeLbl = new Label("place name :");
        Label xLbl = new Label("x coordinate :");
        Label yLbl = new Label("y coordinate :");
        Label gsLbl = new Label("gas station (true/false) :");

        Label statLbl = new Label();

        TextField placeTF = new TextField();
        TextField yTF = new TextField();
        TextField xTF = new TextField();
        TextField gsTF = new TextField();

        Button newlBtn = new Button("add location!");
        newlBtn.setOnAction(actionEvent -> {
            String place;
            double x;
            double y;
            boolean gs;


            try {
                place = placeTF.getText();
                x = Double.parseDouble(xTF.getText());
                y = Double.parseDouble(yTF.getText());
                gs = Boolean.parseBoolean(gsTF.getText());

                locList.getItems().add(new Location(place, x, y, gs));

                stage.setScene(locS);


            } catch (Exception e) {
                statLbl.setText("Check your input.");
            }
        });

        AnchorPane.setTopAnchor(placeLbl, 10.0);
        AnchorPane.setLeftAnchor(placeLbl, 10.0);
        AnchorPane.setTopAnchor(xLbl, 80.0);
        AnchorPane.setLeftAnchor(xLbl, 10.0);
        AnchorPane.setTopAnchor(yLbl, 150.0);
        AnchorPane.setLeftAnchor(yLbl, 10.0);
        AnchorPane.setTopAnchor(gsLbl, 205.0);
        AnchorPane.setLeftAnchor(gsLbl, 10.0);

        AnchorPane.setTopAnchor(placeTF, 10.0);
        AnchorPane.setLeftAnchor(placeTF, 130.0);
        AnchorPane.setTopAnchor(xTF, 80.0);
        AnchorPane.setLeftAnchor(xTF, 130.0);
        AnchorPane.setTopAnchor(yTF, 150.0);
        AnchorPane.setLeftAnchor(yTF, 130.0);
        AnchorPane.setTopAnchor(gsTF, 210.0);
        AnchorPane.setLeftAnchor(gsTF, 130.0);

        AnchorPane.setBottomAnchor(statLbl, 10.0);
        AnchorPane.setLeftAnchor(statLbl, 10.0);

        AnchorPane.setBottomAnchor(newlBtn, 10.0);
        AnchorPane.setRightAnchor(newlBtn, 10.0);

        root2.getChildren().addAll(placeLbl, placeTF, xLbl, xTF, yLbl, yTF, gsLbl, gsTF, statLbl, newlBtn);

//end 2nd scene

        stage.setTitle("helicopter flying fun");
        stage.setScene(makeHeli);
        stage.show();

    }
            public static void main (String[]args){
                launch();
            }
        }
