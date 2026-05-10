package org.example.bdd.screens;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.bdd.models.CitaTbl;
import org.example.bdd.models.User;
import org.example.bdd.navigation.Navigation;
import org.example.bdd.services.CitasService;

import java.time.LocalDate;

public class MainScreen {
    // Elementos de layout
    private VBox root = new VBox();
    private HBox fila1 = new HBox();
    // Componentes de la ventana
    private Label lblFecha = new Label("Fecha");
    private DatePicker dpFecha = new DatePicker();
    private Button btnBuscar = new Button("Buscar");

    // Añadimos la tabla con las citas
    private TableView<CitaTbl> tblCitas = new TableView<>();


    // Añadimos las columnas de la tabla
    private TableColumn<CitaTbl, String> colFecha = new TableColumn<>("Fecha");
    private TableColumn<CitaTbl, String> colHora = new TableColumn<>("Hora");
    private TableColumn<CitaTbl, String> colCliente = new TableColumn<>("Cliente");
    private TableColumn<CitaTbl, String> colDescripcion = new TableColumn<>("Descripción");

    //Servicios de la ventana
    private CitasService citasService = new CitasService();

    public MainScreen(User user) {
        // Configuramos elementos de layout
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(15);
        fila1.setSpacing(5);

        // Asignamos los componentes al layout correspondiente
        fila1.getChildren().addAll(lblFecha, dpFecha, btnBuscar);
        root.getChildren().addAll(fila1, tblCitas);

        // Asignamos valores por defecto al datepicker
        dpFecha.setValue(LocalDate.now());
        dpFecha.setShowWeekNumbers(false);

        // Asignar las columnas a la tabla
        tblCitas.getColumns().addAll(colFecha, colHora, colCliente, colDescripcion);
        tblCitas.setPrefHeight(400);
        //Acá es siempre lo mismo
        tblCitas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        colFecha.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFecha()));
        colHora.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHora()));
        colCliente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCliente()));
        colDescripcion.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescripcion()));

        //Carga inicial de la tabla
        try {
            tblCitas.getItems().addAll(citasService.getCitasByFecha(String.valueOf(dpFecha.getValue())));
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error al recuperar las citas");
            alert.setHeaderText(null);
            alert.setContentText(exception.getMessage());
            alert.showAndWait();
        }

        //Añadir interactividad a la ventana
        btnBuscar.setOnAction(actionEvent -> {
            try {
                // Añadimos el clear para que no repita los datos, o eliminar patrón singlenton en la conexión.
                tblCitas.getItems().clear();
                tblCitas.getItems().addAll(citasService.getCitasByFecha(String.valueOf(dpFecha.getValue())));
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error al recuperar las citas");
                alert.setHeaderText(null);
                alert.setContentText(exception.getMessage());
                alert.showAndWait();
            }
        });
        // Doble click en una fila de la ventana
        tblCitas.setRowFactory(citaTblTableView -> {
            TableRow<CitaTbl> rowSelected = new TableRow<>();
            rowSelected.setOnMouseClicked(mouseEvent -> {
                if (mouseEvent.getClickCount() == 2 && !rowSelected.isEmpty()) {
                    CitaTbl citaTbl = rowSelected.getItem();
                    Navigation.navigate(Navigation.Screen.EDIT_CITA_SCREEN,user,citaTbl);
                }
            });
            return rowSelected;
        });

    }
    public VBox getRoot() {
        return root;
    }
}