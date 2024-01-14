module poo.proyectopoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens poo.proyectopoo to javafx.fxml;
    exports poo.proyectopoo;
}
