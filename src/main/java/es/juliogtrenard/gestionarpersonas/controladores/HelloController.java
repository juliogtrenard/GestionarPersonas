package es.juliogtrenard.gestionarpersonas.controladores;

import es.juliogtrenard.gestionarpersonas.modelos.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class HelloController {
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
        String errores = validarEntradas();

        if (!errores.isEmpty()) {
            mostrarAlerta(errores);
            return;
        }

        if (esPersonaRepetida()) {
            mostrarAlerta("Persona repetida");
        } else {
            crearPersona();
        }

        limpiarCampos();
    }

    private void crearPersona() {
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        int edad = Integer.parseInt(txtEdad.getText());

        Persona persona = new Persona(nombre, apellidos, edad);
        listaPersonas.add(persona);

        tvTabla.getItems().add(persona);
    }

    private String validarEntradas() {
        return errores();
    }

    private boolean esPersonaRepetida() {
        for (Persona p : listaPersonas) {
            if (esIgualPersona(p)) {
                return true;
            }
        }
        return false;
    }

    private boolean esIgualPersona(Persona p) {
        return p.getNombre().equalsIgnoreCase(txtNombre.getText().trim()) &&
                p.getApellidos().equalsIgnoreCase(txtApellidos.getText().trim()) &&
                p.getEdad() == Integer.parseInt(txtEdad.getText());
    }

    private void mostrarAlerta(String errores) {
        Alert alerta = new Alert(Alert.AlertType.ERROR, errores);
        alerta.setHeaderText(null);
        alerta.setTitle("Errores en la encuesta:");
        alerta.showAndWait();
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

        if((!txtNombre.getText().matches("[a-zA-Z]+") && !txtNombre.getText().isEmpty()) ||
                (!txtApellidos.getText().matches("[a-zA-Z]+") && !txtApellidos.getText().isEmpty())) {
            errores += "El nombre y/o apellidos no pueden contener números\n";
        }

        return errores;
    }

    private void limpiarCampos() {
        txtApellidos.clear();
        txtEdad.clear();
        txtNombre.clear();
    }

}