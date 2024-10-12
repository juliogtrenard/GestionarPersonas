package es.juliogtrenard.gestionarpersonas.controladores;

import es.juliogtrenard.gestionarpersonas.modelos.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class HelloController {
    int contador = 0;

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
    private ArrayList<Persona> listaPersonas;

    @FXML
    public void initialize() {
        listaPersonas = new ArrayList<>();
    }

    @FXML
    void agregarPersona(ActionEvent event) {
        String errores = errores();

        if(errores.isEmpty()) {
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            Persona persona = new Persona(nombre, apellidos, edad);
            listaPersonas.add(persona);

            tvTabla.getItems().add(persona);
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR, errores);
            alerta.setHeaderText(null);
            alerta.setTitle("Errores en la encuesta:");
            alerta.showAndWait();
        }

        contador++;
        limpiarCampos();
    }

    private String errores() {
        String errores = "";

        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();

        if(nombre.isEmpty()) {
            errores += "Debes introducir tu nombre.\n";
        }

        if(apellidos.isEmpty()) {
            errores += "Debes introducir al menos un apellido.\n";
        }

        try {
            int edad = Integer.parseInt(txtEdad.getText());
        } catch (NumberFormatException e) {
            errores += "El campo 'Edad' debe ser numérico.\n";
        }

        return errores;
    }

    private void limpiarCampos() {
        txtApellidos.clear();
        txtEdad.clear();
        txtNombre.clear();
    }

}