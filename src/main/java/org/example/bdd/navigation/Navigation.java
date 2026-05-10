package org.example.bdd.navigation;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.bdd.models.CitaTbl;
import org.example.bdd.models.User;
import org.example.bdd.screens.EditCitaScreen;
import org.example.bdd.screens.LoginScreen;
import org.example.bdd.screens.MainScreen;
import org.example.bdd.screens.RegisterScreen;

/**
 * A tener en cuenta:
 * Esto usualmente siempre es lo mismo, se agregó la opción de añadir un enum a la screen. (tengo que preguntar por qué)
 */

public class Navigation {
    public enum Screen {
        LOGIN_SCREEN,
        REGISTER_SCREEN,
        MAIN_SCREEN,
        EDIT_CITA_SCREEN
    }
    public static Stage stage = new Stage();

    // Navegación sin usuario.
    public static void navigate (Screen screen) {
        switch (screen) {
            case LOGIN_SCREEN -> {
                LoginScreen loginScreen = new LoginScreen();
                Scene loginScene = new Scene(loginScreen.getRoot(), 300,300);
                stage.setTitle("Login");
                stage.setScene(loginScene);
                stage.show();
            }
            case REGISTER_SCREEN -> {
                RegisterScreen registerScreen = new RegisterScreen();
                Scene registerScene = new Scene(registerScreen.getRoot(), 300,300);
                stage.setTitle("Register");
                stage.setScene(registerScene);
                stage.show();
            }
        }
    }
    // Navegación con usuario
    public static void navigate(Screen screen, User user){
        switch (screen){
            case MAIN_SCREEN -> {
                MainScreen mainScreen = new MainScreen(user);
                Scene mainScene = new Scene(mainScreen.getRoot(), 400, 400);
                stage.setTitle("Ventana principal");
                stage.setScene(mainScene);
                stage.show();
            }
        }
    }
    public static void navigate(Screen screen, User user, CitaTbl cita){
        switch (screen){
            case EDIT_CITA_SCREEN -> {
                EditCitaScreen editCitaScreen = new EditCitaScreen(user, cita);
                Scene editCitaScene = new Scene(editCitaScreen.getRoot(), 800, 600);
                stage.setTitle("Editar Cita");
                stage.setScene(editCitaScene);
                stage.show();
            }
        }
    }
}
