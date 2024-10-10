module es.juliogtrenard.gestionarpersonas {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.juliogtrenard.gestionarpersonas to javafx.fxml;
    exports es.juliogtrenard.gestionarpersonas;
}