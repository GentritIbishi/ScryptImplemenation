module com.scrypt.scryptimplemenation {
    requires javafx.fxml;

    requires javafx.controls;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires scrypt;

    exports com.scrypt.scryptimplemenation;
    exports com.scrypt.scryptimplemenation.controller;
    opens com.scrypt.scryptimplemenation to javafx.fxml;
    opens com.scrypt.scryptimplemenation.controller to javafx.fxml;
}
