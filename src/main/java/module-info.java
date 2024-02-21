module com.example.wsjavajavafxcourse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wsjavajavafxcourse to javafx.fxml;
    exports com.example.wsjavajavafxcourse;
}