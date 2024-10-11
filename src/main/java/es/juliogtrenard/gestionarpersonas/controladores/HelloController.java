package es.juliogtrenard.gestionarpersonas.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button btnAgregar;

    @FXML
    private TableColumn<?, ?> tcApellidos;

    @FXML
    private TableColumn<?, ?> tcEdad;

    @FXML
    private TableColumn<?, ?> tcNombre;

    @FXML
    private TableView<?> tvTabla;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    void agregarPersona(ActionEvent event) {

    }

}