package es.juliogtrenard.gestionarpersonas.controladores;

import es.juliogtrenard.gestionarpersonas.modelos.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {

    @FXML
    private Button btnAgregar;

    @FXML
    private TableColumn<Persona, String> tcApellidos;

    @FXML
    private TableColumn<Persona, Integer> tcEdad;

    @FXML
    private TableColumn<Persona, String> tcNombre;

    @FXML
    private TableView<Persona> tvTabla;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private ArrayList<Persona> listaPersonas = new ArrayList<>();

    @FXML
    void agregarPersona(ActionEvent event) {

        limpiarCampos();
    }

    private void limpiarCampos() {
        txtApellidos.clear();
        txtEdad.clear();
        txtNombre.clear();
    }

}