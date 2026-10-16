module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example to javafx.fxml;
    opens org.example.Imagem1 to javafx.fxml;
    opens org.example.Imagem2 to javafx.fxml;
    opens org.example.Imagem3 to javafx.fxml;
    opens org.example.Imagem4 to javafx.fxml;

    exports org.example;
}