package org.example.bdd.screens;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.example.bdd.models.User;
import org.example.bdd.navigation.Navigation;
import org.example.bdd.services.UsersService;

public class LoginScreen {
    //Elementos del layout
    private GridPane root;

    //Prueba de imagen
    private Image pruebaImg = new Image("señorDeLasTinieblas.png");
    private ImageView prueba = new  ImageView(pruebaImg);

    //Componentes de ventana
    private Label lblUsername = new Label("Username");
    private TextField txtUsername = new TextField();
    private Label lblPassword = new Label("Password");
    private PasswordField txtPassword = new PasswordField();
    private Button btnLogin = new Button("Login");
    private Button btnRegister = new Button("Register");

    //Servicios de ventana
    private UsersService usersServices = new UsersService();

    public LoginScreen() {
        //Edición de imagen
        prueba.setFitWidth(200);
        prueba.setFitHeight(200);
        prueba.setPreserveRatio(true);

        //Edición de ventana
        this.root = new GridPane(); //declarar el GridPane para que funcione.
        root.add(lblUsername,0,0);
        root.add(txtUsername,1,0);
        root.add(lblPassword,0,1);
        root.add(txtPassword,1,1);
        root.add(btnLogin,0,2);
        root.add(btnRegister,0,3);
        root.add(prueba,0,4);

        //Interactividad
        btnLogin.setOnAction(e -> {
            try {
                // Navegación sin usuario.
                // usersServices.loginNotUser(txtUsername.getText(), txtPassword.getText());
                // Navegación con usuario
                User user = usersServices.loginUser(txtUsername.getText(), txtPassword.getText());
                Navigation.navigate(Navigation.Screen.MAIN_SCREEN, user);
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error de conexión");
                alert.setHeaderText(null);
                alert.setContentText(exception.getMessage());
                alert.showAndWait();
            }
        });
        btnRegister.setOnAction(e -> {Navigation.navigate(Navigation.Screen.REGISTER_SCREEN); });
    }

    public GridPane getRoot() { return root; }
}
