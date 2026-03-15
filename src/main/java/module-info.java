module com.example.bolaerestaurant {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bolaerestaurant to javafx.fxml;
    exports com.example.bolaerestaurant;
}