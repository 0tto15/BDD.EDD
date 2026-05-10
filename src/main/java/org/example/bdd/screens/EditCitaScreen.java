package org.example.bdd.screens;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.example.bdd.models.CitaTbl;
import org.example.bdd.models.User;
import org.example.bdd.services.CitasService;

import java.time.LocalDate;

public class EditCitaScreen {
    //Elementos de layout
    private VBox root = new VBox();
    private GridPane grid = new GridPane();
    //Componentes de la ventana
    private Label lblFecha = new Label("Fecha");
    private DatePicker dpFecha = new DatePicker();
    private Label lblHora = new Label("Hora");
    private TextField txtHora = new TextField();
    private Label lblCliente = new Label("Cliente");
    private TextField txtCliente = new TextField();
    private Label lblDescripcion = new Label("Descripcion");
    private TextField txtDescripcion = new TextField();
    private Button btnBorrar = new Button("Borrar");
    private Button btnCancelar = new Button("Cancelar");
    private Button btnGuardar = new Button("Guardar");
    //Servicios de la ventana
    private CitasService citasService = new CitasService();
    //Constructor de la ventana
    //Importante pasarle la cita.
    public EditCitaScreen(User usuario, CitaTbl cita) {
        //Configuramos elementos de layout
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        //Añadimos los componentes
        grid.add(lblFecha, 0, 0);
        grid.add(dpFecha, 1, 0);
        grid.add(lblHora, 0, 1);
        grid.add(txtHora, 1, 1);
        grid.add(lblCliente, 0, 2);
        grid.add(txtCliente, 1, 2);
        grid.add(lblDescripcion, 0, 3);
        grid.add(txtDescripcion, 1, 3);
        grid.add(btnCancelar, 1, 4);
        grid.add(btnBorrar, 2, 4);
        grid.add(btnGuardar, 3, 4);
        root.getChildren().add(grid);
        //Asignamos a cada campo el valor inicial de la cita a editar
        dpFecha.setValue(LocalDate.parse(cita.getFecha()));
        txtHora.setText(cita.getHora());
        txtCliente.setText(cita.getCliente());
        txtDescripcion.setText(cita.getDescripcion());
        //Añadimos la interactividad de la ventana
    }

    //Getter del root
    public VBox getRoot() {
        return root;
    }
}
