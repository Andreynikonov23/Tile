package ru.sapteh.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Product;
import ru.sapteh.service.ProductService;

import java.io.IOException;

public class MainController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Product, Integer> dao = new ProductService(factory);
    ObservableList<Product> observableList = FXCollections.observableArrayList();

    @FXML
    private BorderPane borderPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TilePane tilePane;

    @FXML
    void initialize() throws IOException {
        observableList.addAll(dao.findByAll());
        FlowPane flowPane;
        for (Product product : observableList){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tile.fxml"));
            flowPane = loader.load();
            TileController tileController = new TileController();
            tileController.setData(product);
            tilePane.getChildren().add(flowPane);
        }
    }
}
