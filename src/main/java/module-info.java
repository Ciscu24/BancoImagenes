module com.proyectociscu.proyectobancoimagenes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.xml.bind;
    requires java.base;
    requires org.apache.commons.codec;

    opens com.proyectociscu.proyectobancoimagenes.model to java.xml.bind;
    opens com.proyectociscu.proyectobancoimagenes to javafx.fxml;
    exports com.proyectociscu.proyectobancoimagenes;
}