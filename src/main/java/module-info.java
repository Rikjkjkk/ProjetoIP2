module br.ufrpe.projetoip2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.ufrpe.projetoip2.gui to javafx.fxml;
    opens br.ufrpe.projetoip2.beans to javafx.base;
    exports br.ufrpe.projetoip2.gui;
}