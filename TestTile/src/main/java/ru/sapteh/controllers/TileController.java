package ru.sapteh.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import ru.sapteh.models.Product;

public class TileController {
    @FXML
    private VBox vbox;

    @FXML
    private ImageView imageView;

    @FXML
    private Label labelName;

    @FXML
    private Label labelCost;

    private Product product;

  public void setData(Product product){
      this.product = product;
      labelName.setText(product.getName());
      labelCost.setText(product.getCost());
  }
}
