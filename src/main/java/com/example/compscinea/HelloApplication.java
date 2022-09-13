package com.example.compscinea;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Tab tab = new Tab("tab");
        TabContent(tab);

        Tab tab2 = new Tab("tab2");
        charts(tab2);
        Tab tab3 = new Tab("tab3");
        TabPane tabPane = new TabPane(tab, tab2, tab3);
        Scene scene = new Scene(tabPane, 600, 600);
        stage.setTitle("U-Corp Inventory management system");
        stage.setScene(scene);
        stage.show();
    }

    private void charts(Tab tab2) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Bar Chart");
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Bar Chart");
        series1.getData().add(new XYChart.Data("peen",7));
        series1.getData().add(new XYChart.Data("yeen",8));
        series1.getData().add(new XYChart.Data("spleen",9));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Bar Chart 2");
        series2.getData().add(new XYChart.Data("lean",7));
        series2.getData().add(new XYChart.Data("steam",8));
        series2.getData().add(new XYChart.Data("ceam",9));

        bc.getData().addAll(series1, series2);
        tab2.setContent(bc);


    }

    private void TabContent(Tab tab) throws FileNotFoundException {
        Button button = new Button();
        button.setPrefHeight(100);
        button.setPrefWidth(100);
        tab.setContent(button);

        FileInputStream input = new FileInputStream("X:\\My Documents\\compscineafinal\\src\\main\\java\\com\\example\\compscinea\\OIP.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        tab.setContent(imageView);
    }

    public static void main(String[] args) {
        launch();
    }



    }
