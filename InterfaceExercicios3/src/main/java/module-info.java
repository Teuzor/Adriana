module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example to javafx.fxml;
    opens org.example.Imagem2 to javafx.fxml;
    opens org.example.Imagem3 to javafx.fxml;

    exports org.example;
}