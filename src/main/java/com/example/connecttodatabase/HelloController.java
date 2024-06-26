package com.example.connecttodatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.sql.*;

public class HelloController {
    @FXML
    public TableView tableView;

    @FXML
    protected void onHelloButtonClick() throws SQLException {

        Connection conn = null;
        Statement st = null;
        ResultSet rs;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0201");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM postgres.public.medicines");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        ObservableList<Medicines> medicines = FXCollections.observableArrayList();

        Medicines medicines2;

        while (rs.next()) {

            medicines2 = new Medicines();
            medicines2.setIdMedicines(rs.getString("IdMedicines"));
            medicines2.setName(rs.getString("Name"));
            medicines2.setPrice(rs.getDouble("Price"));
            medicines2.setFeatures(rs.getString("Features"));
            medicines2.setCount(rs.getInt("count"));
            System.out.println(medicines2.getIdMedicines());
            medicines.add(medicines2);
        }

        TableView<Medicines> table = new TableView<Medicines>(medicines);
        tableView.setPrefWidth(250);
        tableView.setPrefHeight(200);

        TableColumn<Medicines, String> nameColumn = new TableColumn<Medicines, String>("IdMedicines");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Medicines, String>("IdMedicines"));
        tableView.getColumns().add(nameColumn);

        TableColumn<Medicines, String> loginColumn = new TableColumn<Medicines, String>("Name");
        loginColumn.setCellValueFactory(new PropertyValueFactory<Medicines, String>("Name"));
        tableView.getColumns().add(loginColumn);


        TableColumn<Medicines, Double> priceColumn = new TableColumn<Medicines, Double>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<Medicines, Double>("Price"));
        tableView.getColumns().add(priceColumn);

        TableColumn<Medicines, String> featuresColumn = new TableColumn<Medicines, String>("Features");
        featuresColumn.setCellValueFactory(new PropertyValueFactory<Medicines, String>("Features"));
        tableView.getColumns().add(featuresColumn);

        TableColumn<Medicines, Integer> countColumn = new TableColumn<Medicines, Integer>("Count");
        countColumn.setCellValueFactory(new PropertyValueFactory<Medicines, Integer>("count"));
        tableView.getColumns().add(countColumn);


        tableView.setItems(medicines);

    }
}