package org.example.bdd.screens;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.example.bdd.navigation.Navigation;
import org.example.bdd.services.UsersService;

public class RegisterScreen {
    private GridPane root;

    private Label lblUsername = new Label("Username");
    private TextField txtUsername = new TextField();
    private Label lblPassword = new Label("Password");
    private PasswordField txtPassword = new PasswordField();
    private Button btnRegister = new Button("Register");
    private Button btnCancel = new Button("Cancel");

    private UsersService usersService = new UsersService();

    public RegisterScreen() {
        this.root = new GridPane(); //declarar el GridPane para que funcione.
        root.add(lblUsername,0,0);
        root.add(txtUsername,1,0);
        root.add(lblPassword,0,1);
        root.add(txtPassword,1,1);
        root.add(btnRegister,0,2);
        root.add(btnCancel,1,2);


        // Interactividad
        btnRegister.setOnAction(e -> {
            try {
                //usersService.login(txtUsername.getText(),txtPassword.getText());
                Navigation.navigate(Navigation.Screen.LOGIN_SCREEN);
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error de registro");
                alert.setHeaderText(null);
                alert.setContentText(exception.getMessage());
                alert.showAndWait();
            }
        });
        btnCancel.setOnAction(e -> { Navigation.navigate(Navigation.Screen.LOGIN_SCREEN); });
    }

    public GridPane getRoot() { return root; }
}
