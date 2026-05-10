module org.example.bdd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires org.postgresql.jdbc;
    requires javafx.graphics;
    requires javafx.base;


    opens org.example.bdd to javafx.fxml;
    exports org.example.bdd;
}