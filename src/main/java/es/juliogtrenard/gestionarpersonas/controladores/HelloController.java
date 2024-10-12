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

        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String edadInput = txtEdad.getText().trim();

        if (nombre.isEmpty()) {
            errores += "Debes introducir tu nombre.\n";
        } else if (!nombre.matches("^[A-Za-záéíóúÁÉÍÓÚÑñ\\s]+$")) {
            errores += "El nombre no puede contener números.\n";
        }

        if (apellidos.isEmpty()) {
            errores += "Debes introducir al menos un apellido.\n";
        } else if (!apellidos.matches("^[A-Za-záéíóúÁÉÍÓÚÑñ\\s]+$")) {
            errores += "Los apellidos no pueden contener números.\n";
        }

        int edad;
        try {
            edad = Integer.parseInt(edadInput);
        } catch (NumberFormatException e) {
            return errores + "El campo 'Edad' debe ser numérico.\n";
        }

        if (edad < 1 || edad > 100) {
            errores += "Introduce una edad válida (1-100).\n";
        }

        return errores;
    }

    private void limpiarCampos() {
        txtApellidos.clear();
        txtEdad.clear();
        txtNombre.clear();
    }

}