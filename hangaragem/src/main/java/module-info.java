module org.sahthan.sahthan_v1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires jakarta.cdi;

    // APPLICATION (entry point)
    exports org.sahthan.sahthan_v1.application;
    opens org.sahthan.sahthan_v1.application to javafx.fxml;

    // BASE
    exports org.sahthan.sahthan_v1;

    // CONTROLLERS
    exports org.sahthan.sahthan_v1.controller;
    opens org.sahthan.sahthan_v1.controller to javafx.fxml;

    exports org.sahthan.sahthan_v1.controller.usuario;
    opens org.sahthan.sahthan_v1.controller.usuario to javafx.fxml;

    exports org.sahthan.sahthan_v1.controller.aeronave;
    opens org.sahthan.sahthan_v1.controller.aeronave to javafx.fxml;

    exports org.sahthan.sahthan_v1.controller.hangar;
    opens org.sahthan.sahthan_v1.controller.hangar to javafx.fxml;

    exports org.sahthan.sahthan_v1.controller.localidade;
    opens org.sahthan.sahthan_v1.controller.localidade to javafx.fxml;

    exports org.sahthan.sahthan_v1.controller.locacao;
    opens org.sahthan.sahthan_v1.controller.locacao to javafx.fxml;

    // MODEL (Hibernate + JavaFX reflection)
    opens org.sahthan.sahthan_v1.model to
        javafx.base,
        javafx.fxml,
        org.hibernate.orm.core,
        jakarta.persistence;
}