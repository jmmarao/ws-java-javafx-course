package com.example.wsjavajavafxcourse.controller;

import com.example.wsjavajavafxcourse.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PersonController implements Initializable {

    @FXML
    private ComboBox<Person> cbPerson;

    @FXML
    private Button btListAll;

    private ObservableList<Person> observableList;

    @FXML
    public void onCbPersonAction() {
        Person selectedPerson = cbPerson.getSelectionModel().getSelectedItem();
        System.out.println(selectedPerson);
    }

    @FXML
    public void onBtListAll() {
        for (Person person : cbPerson.getItems()) {
            System.out.println(person);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> mockList = new ArrayList<>();
        mockList.add(new Person(1, "Doctor Strange", "strange@marvel.com"));
        mockList.add(new Person(2, "Black Panther", "panther@marvel.com"));
        mockList.add(new Person(3, "Scarlet Witch", "scarlet@marvel.com"));

        observableList = FXCollections.observableArrayList(mockList);
        cbPerson.setItems(observableList);

        Callback<ListView<Person>, ListCell<Person>> factory = personListView -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };

        cbPerson.setCellFactory(factory);
        cbPerson.setButtonCell(factory.call(null));
    }
}
