/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package biblioteca;

import com.itextpdf.text.BadElementException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.sql.Time;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.control.Alert.AlertType;


import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * FXML Controller class
 *
 * @author bombo
 */
public class dashboardController implements Initializable {

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private Label home_totalFemale;

    @FXML
    private Label home_totalMale;

    @FXML
    private TextField addStudents_noControl;

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private Button addStudents_btn;

    @FXML
    private TableView<studentData> addStudents_tableView;

    @FXML
    private TableColumn<studentData, String> addStudents_col_noControl;

    @FXML
    private TableColumn<studentData, String> addStudents_col_nombre;

    @FXML
    private TableColumn<studentData, String> addStudents_col_apellidoPaterno;

    @FXML
    private TableColumn<studentData, String> addStudents_col_apellidoMaterno;

    @FXML
    private TableColumn<studentData, String> addStudents_col_carrera;

    @FXML
    private TableColumn<studentData, String> addStudents_col_genero;

    @FXML
    private TableColumn<studentData, LocalTime> addStudents_col_horaEntrada;

    @FXML
    private TableColumn<studentData, Date> addStudents_col_fechaEntrada;

    @FXML
    private AnchorPane addStudents_form;

    @FXML
    private TextField addStudents_search;

    @FXML
    private Button close;

    @FXML
    private Button home_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private Label username;

    @FXML
    private AnchorPane data_form;

    @FXML
    private AnchorPane reporte_form;

    @FXML
    private Button dataAnalysis_btn;

    @FXML
    private Button addReporte_btn;

    @FXML
    private AnchorPane nav_chart;

    @FXML
    private Button daily_chart_btn;

    @FXML
    private Button quarter_chart_btn;

    @FXML
    private Button semestre_chart_btn;

    @FXML
    private BarChart<?, ?> dailyChartHome;

    @FXML
    private Label totalIDIN;

    @FXML
    private Label totalADM;

    @FXML
    private Label totalISC;

    @FXML
    private Label totalIINF;

    @FXML
    private Label totalIIND;

    @FXML
    private Label totalIGE;

    @FXML
    private Label totalARQ;

    @FXML
    private AnchorPane analysis_Careers;

    @FXML
    private AnchorPane careers_buttons;

    @FXML
    private AnchorPane analysisCareers_pieChart;

    @FXML
    private AnchorPane idinPieChart_AP;

    @FXML
    private AnchorPane admPieChart_AP;

    @FXML
    private AnchorPane iscPieChart_AP;

    @FXML
    private AnchorPane iinfPieChart_AP;

    @FXML
    private AnchorPane iindPieChart_AP;

    @FXML
    private AnchorPane igePieChart_AP;

    @FXML
    private AnchorPane arquiPieChart_AP;

    @FXML
    private AnchorPane legendFemaleMale;

    @FXML
    private PieChart analisisPorCarreras_chart;

    @FXML
    private PieChart totalFemaleMaleIDIN_chart;

    @FXML
    private PieChart totalFemaleMaleADM_chart;

    @FXML
    private PieChart totalFemaleMaleISC_chart;

    @FXML
    private PieChart totalFemaleMaleIINF_chart;

    @FXML
    private PieChart totalFemaleMaleIIND_chart;

    @FXML
    private PieChart totalFemaleMaleIGE_chart;

    @FXML
    private PieChart totalFemaleMaleARQ_chart;

    @FXML
    private Button IDIN_chart_btn;

    @FXML
    private Button ADM_chart_btn;

    @FXML
    private Button ISC_chart_btn;

    @FXML
    private Button IINF_chart_btn;

    @FXML
    private Button IIND_chart_btn;

    @FXML
    private Button IGE_chart_btn;

    @FXML
    private Button ARQ_chart_btn;

    @FXML
    private Button reportePDF_btn;

    @FXML
    private AnchorPane daily_charts;

    @FXML
    private BarChart<?, ?> totalEnrolledChart_daily;

    @FXML
    private AnchorPane quarter_charts;

    @FXML
    private BarChart<?, ?> totalEnrolledChart_quarter;

    @FXML
    private LineChart<?, ?> totalFemaleChart_quarter;

    @FXML
    private LineChart<?, ?> totalMaleChart_quarter;

    @FXML
    private AnchorPane semestre_charts;

    @FXML
    private BarChart<?, ?> totalEnrolledChart_semestre;

    @FXML
    private LineChart<?, ?> totalFemaleChart_semestre;

    @FXML
    private LineChart<?, ?> totalMaleChart_semestre;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    int n = 0; //variable de control 

    /*  -------- HEADER --------*/
    public void close() {

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Si cierra la ventana cierra sesión, ¿está bien?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                //HIDE YOUR DASHBOARD FORM
                logout.getScene().getWindow().hide();

                System.exit(0);

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void maximize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setMaximized(true);

    }

    /*  -------- NAV --------*/
    private double x = 0;
    private double y = 0;

    public void logout() {

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("¿Está seguro que quiere cerrar sesión?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                //HIDE YOUR DASHBOARD FORM
                logout.getScene().getWindow().hide();

                //LINK YOUR LOGIN FORM 
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(0.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayUsername() {
        username.setText(getData.username);
    }

    public void defaultNav() {
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
        addStudents_btn.setStyle("-fx-background-color:transparent");
        dataAnalysis_btn.setStyle("-fx-background-color:transparent");
        dataAnalysis_btn.setStyle("-fx-background-color:transparent");
        addReporte_btn.setStyle("-fx-background-color:transparent");
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            addStudents_form.setVisible(false);
            data_form.setVisible(false);
            reporte_form.setVisible(false);

            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            dataAnalysis_btn.setStyle("-fx-background-color:transparent");
            addReporte_btn.setStyle("-fx-background-color:transparent");

            homeDisplayTotalEnrolledStudents();
            homeDisplayMaleEnrolled();
            homeDisplayFemaleEnrolled();
            DisplayDailyChartHome();

            nav_chart.setVisible(false);

        } else if (event.getSource() == addStudents_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(true);
            data_form.setVisible(false);
            reporte_form.setVisible(false);

            addStudents_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            home_btn.setStyle("-fx-background-color:transparent");
            dataAnalysis_btn.setStyle("-fx-background-color:transparent");
            addReporte_btn.setStyle("-fx-background-color:transparent");
            addStudents_noControl.requestFocus();

//            TO BECOME UPDATED ONCE YOU CLICK THE ADD STUDENTS BUTTON ON NAV
            addStudentsShowListData();

            nav_chart.setVisible(false);

        } else if (event.getSource() == dataAnalysis_btn) {

            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_Careers.setVisible(true);
            daily_charts.setVisible(false);
            quarter_charts.setVisible(false);
            semestre_charts.setVisible(false);
            analysisCareers_pieChart.setVisible(true);
            SetFalsePieChartsCareersFM();
            legendFemaleMale.setVisible(false);
            reporte_form.setVisible(false);

            dataAnalysis_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            home_btn.setStyle("-fx-background-color:transparent");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            addReporte_btn.setStyle("-fx-background-color:transparent");

            DisplayCareersPieChart();

            nav_chart.setVisible(true);
            semestre_chart_btn.setStyle("-fx-background-color:transparent");
            quarter_chart_btn.setStyle("-fx-background-color:transparent");
            daily_chart_btn.setStyle("-fx-background-color:transparent");

            DisplayStyleButtonsCareers();
            DisplayLabelsTotalCareers();
        } else if (event.getSource() == addReporte_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(false);
            reporte_form.setVisible(true);

            addReporte_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            home_btn.setStyle("-fx-background-color:transparent");
            dataAnalysis_btn.setStyle("-fx-background-color:transparent");
            addStudents_btn.setStyle("-fx-background-color:transparent");

            nav_chart.setVisible(false);
        }
    }

    public void navigationChartButton() {
        if (daily_chart_btn.isFocused()) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_Careers.setVisible(false);
            reporte_form.setVisible(false);

            DisplayTotalEnrolledChart_daily();

            nav_chart.setVisible(true);

            daily_charts.setVisible(true);
            quarter_charts.setVisible(false);
            semestre_charts.setVisible(false);

            daily_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            quarter_chart_btn.setStyle("-fx-background-color:transparent");
            semestre_chart_btn.setStyle("-fx-background-color:transparent");

        } else if (quarter_chart_btn.isFocused()) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_Careers.setVisible(false);
            reporte_form.setVisible(false);

            DisplayEnrolledMaleChart_quarter();
            DisplayFemaleEnrolledChart_quarter();
            DisplayTotalEnrolledChart_quarter();

            nav_chart.setVisible(true);

            daily_charts.setVisible(false);
            quarter_charts.setVisible(true);
            semestre_charts.setVisible(false);

            quarter_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            daily_chart_btn.setStyle("-fx-background-color:transparent");
            semestre_chart_btn.setStyle("-fx-background-color:transparent");

        } else if (semestre_chart_btn.isFocused()) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_Careers.setVisible(false);
            reporte_form.setVisible(false);

            DisplayEnrolledMaleChart_semestre();
            DisplayFemaleEnrolledChart_semestre();
            DisplayTotalEnrolledChart_semestre();

            nav_chart.setVisible(true);

            daily_charts.setVisible(false);
            quarter_charts.setVisible(false);
            semestre_charts.setVisible(true);

            semestre_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            quarter_chart_btn.setStyle("-fx-background-color:transparent");
            daily_chart_btn.setStyle("-fx-background-color:transparent");

        }

    }

    /*  -------- HOME --------*/
    public void homeDisplayTotalEnrolledStudents() {

        String sql = "SELECT COUNT(*) FROM historial";

        connect = database.connectDb();

        int countEnrolled = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countEnrolled = result.getInt("COUNT(*)");
            }

            home_totalEnrolled.setText(String.valueOf(countEnrolled));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayFemaleEnrolled() {

        String sql = "SELECT COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F'";

        connect = database.connectDb();

        try {
            int countFemale = 0;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countFemale = result.getInt("COUNT(*)");
            }

            home_totalFemale.setText(String.valueOf(countFemale));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayMaleEnrolled() {

        String sql = "SELECT COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M'";

        connect = database.connectDb();

        try {
            int countMale = 0;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countMale = result.getInt("COUNT(*)");
            }
            home_totalMale.setText(String.valueOf(countMale));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void DisplayDailyChartHome() {
        dailyChartHome.getData().clear();

        String femaleSql = "SELECT fechaEntrada, COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) DESC LIMIT 5";
        String maleSql = "SELECT fechaEntrada, COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) DESC LIMIT 5";

        connect = database.connectDb();

        try {
            XYChart.Series femaleSeries = new XYChart.Series();
            femaleSeries.setName("Mujeres");

            prepare = connect.prepareStatement(femaleSql);
            result = prepare.executeQuery();

            while (result.next()) {
                femaleSeries.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            dailyChartHome.getData().add(femaleSeries);

            XYChart.Series maleSeries = new XYChart.Series();
            maleSeries.setName("Hombres");

            prepare = connect.prepareStatement(maleSql);
            result = prepare.executeQuery();

            while (result.next()) {
                maleSeries.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            dailyChartHome.getData().add(maleSeries);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*  -------- ALUMNOS --------*/
    public ObservableList<studentData> addStudentsListData() {
        ObservableList<studentData> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT historial.noControl, historial.fechaEntrada, historial.horaEntrada, alumnos.nombre, alumnos.apellidoPaterno, alumnos.apellidoMaterno, alumnos.carrera, alumnos.genero "
                + "FROM historial "
                + "JOIN alumnos ON historial.noControl = alumnos.noControl ORDER BY historial.fechaEntrada DESC, historial.horaEntrada DESC";

        connect = database.connectDb();

        try {
            studentData studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new studentData(result.getString("noControl"),
                        result.getString("nombre"),
                        result.getString("apellidoPaterno"),
                        result.getString("apellidoMaterno"),
                        result.getString("carrera"),
                        result.getString("genero"),
                        result.getDate("fechaEntrada"),
                        LocalTime.parse(result.getString("horaEntrada")));

                listStudents.add(studentD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }

    private ObservableList<studentData> addStudentsListD;

    public void addStudentsShowListData() {
        addStudentsListD = addStudentsListData();

        addStudents_col_noControl.setCellValueFactory(new PropertyValueFactory<>("noControl"));
        addStudents_col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        addStudents_col_apellidoPaterno.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        addStudents_col_apellidoMaterno.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
        addStudents_col_carrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        addStudents_col_genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        addStudents_col_fechaEntrada.setCellValueFactory(new PropertyValueFactory<>("fechaEntrada"));
        addStudents_col_horaEntrada.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));

        addStudents_tableView.setItems(addStudentsListD);
    }

    public void addStudentsSelect() {

        studentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
        int num = addStudents_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addStudents_noControl.setText(String.valueOf(studentD.getNoControl()));
    }

    public void addStudentsClear() {
        addStudents_noControl.setText("");
    }

    /* -----    Metodos recursivos para agregar estudiante a registro -----*/
    private String agregarPrefijo(String numeroControl, int n) {
        String prefijo = null;
        switch (n) {
            case 1:
                prefijo = "C";
                break;
            case 2:
                prefijo = "B";
                break;
            case 3:
                prefijo = "M";
                break;
            case 4:
                prefijo = "D";
                break;
        }
        return prefijo + numeroControl;
    }

    private void insertarDatos(String numeroControl) throws SQLException {
        // Preparar la consulta para insertar los datos
        String insertData = "INSERT INTO historial (noControl, fechaEntrada, horaEntrada) VALUES (?, ?, ?)";
        PreparedStatement prepare = connect.prepareStatement(insertData);
        prepare.setString(1, numeroControl);

        Date fechaEntrada = new Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(fechaEntrada.getTime());
        prepare.setString(2, String.valueOf(sqlDate));

        Time horaEntrada = new Time(System.currentTimeMillis());
        prepare.setString(3, String.valueOf(horaEntrada));

        // Ejecutar la consulta de inserción
        prepare.executeUpdate();
        /*
        // Mostrar un mensaje de éxito
        //System.out.println("¡Agregado exitosamente!");
         */
    }

    public void verificarInsercion(String numeroControl) {
        // Verificar si el noControl ya fue agregado previamente
        if (!codigoRepetido(numeroControl)) {
            try {
                // Verificar si el número de control existe en la base de datos
                String checkData = "SELECT noControl FROM alumnos WHERE noControl = ?";
                PreparedStatement checkStatement = connect.prepareStatement(checkData);
                checkStatement.setString(1, numeroControl);
                ResultSet resultado = checkStatement.executeQuery();

                if (!resultado.next()) { // Si el número de control no se encuentra en la base de datos
                    if (n < 4) { // Verificar si n es menor que 4
                        n++;
                        if (numeroControl.length() > 8) { // Si el num control tiene más de 8 caracteres
                            //Toma solo los últimos 8
                            numeroControl = numeroControl.substring(numeroControl.length() - 8);
                            String nuevoNumeroControl = agregarPrefijo(numeroControl, n);
                            verificarInsercion(nuevoNumeroControl);
                        } else {
                            // Intentar con el siguiente prefijo
                            String nuevoNumeroControl = agregarPrefijo(numeroControl, n);
                            verificarInsercion(nuevoNumeroControl);
                        }
                    } else {
                        // Si n llega a 4, detener la recursión
                    }
                } else {
                    // Si el número de control se encuentra en la base de datos, proceder con la inserción
                    insertarDatos(numeroControl);
                    n = 0;
                }
            } catch (SQLException e) {
                // Manejar cualquier excepción SQL que pueda ocurrir
                e.printStackTrace();
                //System.out.println("Se produjo un error al intentar agregar el estudiante.");
            }

        } else {
            //System.out.println("El código de barras ya fue escaneado previamente.");
            addStudentsClear();
            addStudents_noControl.requestFocus();
        }
    }

    /* ------------------METODO PARA AGREGAR AL REGISTRO ---------------- */
    public void addStudentsAdd() {

        String numeroControl = "";

        try {
            Alert alert;
            numeroControl = addStudents_noControl.getText();

            if (numeroControl.isEmpty()) { //Verifica si el campo de texto addStudents_noControl está vacío.
                //se crea y muestra un cuadro de diálogo de error
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("No se ha ingresado num Control");
                alert.showAndWait();

            } else { //Si entra aqui, entonces si hay algo dentro del campo de texto

                if (numeroControl.length() > 8) { //Verifica si lo ingresado es mayor a 8 caracteres

                    numeroControl = numeroControl.substring(numeroControl.length() - 8);
                    // Asignar el número de control al campo de texto
                    addStudents_noControl.setText(numeroControl);

                }
                
                verificarInsercion(numeroControl);
                // TO UPDATE THE TABLEVIEW
                addStudentsShowListData();
                // TO CLEAR THE FIELDS
                addStudentsClear();
                addStudents_noControl.requestFocus();               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    //Método para llamar a la función addStudentsAdd cuando se presione la tecla enter
    public void txtFieldAddStudentKeyReleased(KeyEvent event){
        if(event.getCode() == event.getCode().ENTER){
            addStudentsAdd();
        }
    }
    
    //Método para ver si el mismo numero de control está repetido
    public boolean codigoRepetido(String noControl) {
        try {
            // Consultar el último código de barras agregado a la base de datos
            String sql = "SELECT noControl FROM historial ORDER BY id DESC LIMIT 1";
            connect = database.connectDb();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                String ultimoCodigo = result.getString("noControl");
                return noControl.equals(ultimoCodigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }

    /*  -------- DATA ANALYSIS --------*/
    //Función para desplegar la gráfica de pastel de todas las carreras
    public void DisplayCareersPieChart() {
        analisisPorCarreras_chart.getData().clear();

        String carreraSql = "SELECT a.carrera, COUNT(*) FROM alumnos a JOIN historial h ON a.noControl = h.noControl "
                + "WHERE a.carrera NOT IN ('DOCTORADO EN CIENCIAS DE LA INGENIERIA', 'MAESTRIA EN SISTEMAS COMPUTACIONALES', "
                + "'MAESTRIA EN INGENIERIA INDUSTRIAL') GROUP BY a.carrera ORDER BY CASE a.carrera "
                + "WHEN 'INGENIERIA EN DISEÑO INDUSTRIAL' THEN 1 WHEN 'INGENIERIA INDUSTRIAL' THEN 2 WHEN 'ARQUITECTURA' "
                + "THEN 3 WHEN 'INGENIERIA EN GESTION EMPRESARIAL' THEN 4 WHEN 'INGENIERIA INFORMATICA' THEN 5 "
                + "WHEN 'LICENCIATURA EN ADMINISTRACION' THEN 6 WHEN 'INGENIERIA EN SISTEMAS COMPUTACIONALES' THEN 7 END;";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(carreraSql);
            result = prepare.executeQuery();

            while (result.next()) {
                PieChart.Data data = new PieChart.Data(result.getString(2), result.getInt(2));
                analisisPorCarreras_chart.getData().add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Funcion para desplegar cuantas mujeres y hombres ingresaron de cada carrera
    public void DisplayCareersFemaleMalePieChart(String carrera, PieChart grafico) {
        grafico.getData().clear();

        String Sql = "SELECT genero, COUNT(*) FROM alumnos a JOIN historial h ON a.noControl = h.noControl WHERE a.carrera = '"
                + carrera + "' GROUP BY genero;";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(Sql);
            result = prepare.executeQuery();

            while (result.next()) {
                PieChart.Data data = new PieChart.Data(result.getString(2), result.getInt(2));
                grafico.getData().add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Funcion para desplegar cuantas mujeres y hombres ingresaron de cada carrera
    public void DisplayTotalByCareer(String carrera, Label etiqueta) {
        String sql = "SELECT COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl "
                + "WHERE a.carrera = '" + carrera + "';";

        connect = database.connectDb();

        try {
            int count = 0;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                count = result.getInt("COUNT(*)");
            }

            etiqueta.setText(String.valueOf(count));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayTotalEnrolledChart_daily() {
        totalEnrolledChart_daily.getData().clear();

    String femaleSql = "SELECT fechaEntrada, COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F' AND DATE(fechaEntrada) = ? GROUP BY fechaEntrada ORDER BY fechaEntrada DESC LIMIT 5";
    String maleSql = "SELECT fechaEntrada, COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M' AND DATE(fechaEntrada) = ? GROUP BY fechaEntrada ORDER BY fechaEntrada DESC LIMIT 5";

    connect = database.connectDb();

    try {
        XYChart.Series femaleSeries = new XYChart.Series();
        femaleSeries.setName("Mujeres");

        prepare = connect.prepareStatement(femaleSql);
        prepare.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
        result = prepare.executeQuery();

        while (result.next()) {
            femaleSeries.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
        }

        totalEnrolledChart_daily.getData().add(femaleSeries);

        XYChart.Series maleSeries = new XYChart.Series();
        maleSeries.setName("Hombres");

        prepare = connect.prepareStatement(maleSql);
        prepare.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
        result = prepare.executeQuery();

        while (result.next()) {
            maleSeries.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
        }

        totalEnrolledChart_daily.getData().add(maleSeries);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public void DisplayTotalEnrolledChart_quarter() {
        totalEnrolledChart_quarter.getData().clear();

        // Utilizando la función QUARTER() para agrupar por trimestre
        String sql = "SELECT QUARTER(fechaEntrada), COUNT(*) FROM historial GROUP BY QUARTER(fechaEntrada) ORDER BY QUARTER(fechaEntrada) DESC";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();

            while (result.next()) {
                // Puedes personalizar la presentación del trimestre según tus necesidades
                String trimestre = "Trimestre " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(trimestre, result.getInt(2)));
            }

            totalEnrolledChart_quarter.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayFemaleEnrolledChart_quarter() {
        totalFemaleChart_quarter.getData().clear();

        // Utilizando la función QUARTER() para agrupar por trimestre
        String sql = "SELECT QUARTER(fechaEntrada), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F' GROUP BY QUARTER(fechaEntrada) ORDER BY QUARTER(fechaEntrada) DESC LIMIT 5";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Mujeres");

            while (result.next()) {
                // Puedes personalizar la presentación del trimestre según tus necesidades
                String trimestre = "Trimestre " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(trimestre, result.getInt(2)));
            }

            totalFemaleChart_quarter.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayEnrolledMaleChart_quarter() {
        totalMaleChart_quarter.getData().clear();
        // Utilizando la función QUARTER() para agrupar por trimestre
        String sql = "SELECT QUARTER(fechaEntrada), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M' GROUP BY QUARTER(fechaEntrada) ORDER BY QUARTER(fechaEntrada) DESC LIMIT 5";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Hombres");

            while (result.next()) {
                // Puedes personalizar la presentación del trimestre según tus necesidades
                String trimestre = "Trimestre " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(trimestre, result.getInt(2)));
            }

            totalMaleChart_quarter.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayTotalEnrolledChart_semestre() {
        totalEnrolledChart_semestre.getData().clear();

        // Utilizando la función MONTH() y expresiones CASE para calcular el semestre
        String sql = "SELECT CASE WHEN MONTH(fechaEntrada) <= 6 THEN '1er Semestre' ELSE '2do Semestre' END AS Semestre, COUNT(*) FROM historial GROUP BY Semestre DESC";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();

            while (result.next()) {
                // Puedes personalizar la presentación del semestre según tus necesidades
                String semestre = result.getString(1);
                chart.getData().add(new XYChart.Data<>(semestre, result.getInt(2)));
            }

            totalEnrolledChart_semestre.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayFemaleEnrolledChart_semestre() {
        totalFemaleChart_semestre.getData().clear();

        // Utilizando la función QUARTER() y YEAR() para agrupar por semestre
        String sql = "SELECT CONCAT(YEAR(fechaEntrada), '-S', QUARTER(fechaEntrada)), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F' GROUP BY YEAR(fechaEntrada), QUARTER(fechaEntrada) ORDER BY YEAR(fechaEntrada) DESC, QUARTER(fechaEntrada) DESC";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Mujeres");

            while (result.next()) {
                // Puedes personalizar la presentación del semestre según tus necesidades
                String semestre = "Semestre " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(semestre, result.getInt(2)));
            }

            totalFemaleChart_semestre.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayEnrolledMaleChart_semestre() {
        totalMaleChart_semestre.getData().clear();

        // Utilizando la función QUARTER() y YEAR() para agrupar por semestre
        String sql = "SELECT CONCAT(YEAR(fechaEntrada), '-S', QUARTER(fechaEntrada)), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M' GROUP BY YEAR(fechaEntrada), QUARTER(fechaEntrada) ORDER BY YEAR(fechaEntrada) DESC, QUARTER(fechaEntrada) DESC";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Hombres");

            while (result.next()) {
                // Puedes personalizar la presentación del semestre según tus necesidades
                String semestre = "Semestre " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(semestre, result.getInt(2)));
            }

            totalMaleChart_semestre.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Función para aparecer las graficas individuales de cada carrera
    public void navigationCarrersChartButton() {
        if (IDIN_chart_btn.isFocused()) {
            SetFalsePieChartsCareersFM();
            idinPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA EN DISEÑO INDUSTRIAL", totalFemaleMaleIDIN_chart);

            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);

            DisplayStyleButtonsCareers();
            IDIN_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #0D111B, #364774);");

        } else if (ADM_chart_btn.isFocused()) {
            SetFalsePieChartsCareersFM();
            admPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("LICENCIATURA EN ADMINISTRACION", totalFemaleMaleADM_chart);

            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);

            DisplayStyleButtonsCareers();
            ADM_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #23164C, #4B30A3);");

        } else if (ISC_chart_btn.isFocused()) {
            SetFalsePieChartsCareersFM();
            iscPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA EN SISTEMAS COMPUTACIONALES", totalFemaleMaleISC_chart);

            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);

            DisplayStyleButtonsCareers();
            ISC_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2A435B, #5284B2);");

        } else if (IINF_chart_btn.isFocused()) {
            SetFalsePieChartsCareersFM();
            iinfPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA INFORMATICA", totalFemaleMaleIINF_chart);

            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);

            DisplayStyleButtonsCareers();
            IINF_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #092615, #1F7C46);");

        } else if (IIND_chart_btn.isFocused()) {
            SetFalsePieChartsCareersFM();
            iindPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA INDUSTRIAL", totalFemaleMaleIIND_chart);

            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);

            DisplayStyleButtonsCareers();
            IIND_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #847C24, #DCCE3C);");

        } else if (IGE_chart_btn.isFocused()) {
            SetFalsePieChartsCareersFM();
            igePieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA EN GESTION EMPRESARIAL", totalFemaleMaleIGE_chart);

            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);

            DisplayStyleButtonsCareers();
            IGE_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #7A3E25, #D1693E);");

        } else if (ARQ_chart_btn.isFocused()) {
            SetFalsePieChartsCareersFM();
            arquiPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("ARQUITECTURA", totalFemaleMaleARQ_chart);

            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);

            DisplayStyleButtonsCareers();
            ARQ_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #401312, #972D2A);");

        }

    }

    /*  -------- GENERAR REPORTES --------*/
    public void reportePDF() {
        Document documento = new Document();
        documento.setMargins(0, 20, 0, 0); // Establecer márgenes a cero
        
        try{
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReportePrueba.pdf"));
            documento.open();
            
            // Agregar el título
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Paragraph title = new Paragraph("Instituto Tecnológico de Chihuahua II\n", titleFont);
            title.setAlignment(Element.ALIGN_CENTER); // Alineación central del título
            documento.add(title);

            Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Paragraph subTitle = new Paragraph("Centro de Información\n\n", subTitleFont);
            subTitle.setAlignment(Element.ALIGN_CENTER); // Alineación central del subtítulo
            documento.add(subTitle);

            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 8); // Puedes ajustar el tamaño del texto aquí

            PdfPTable tabla = new PdfPTable(8);
            tabla.getDefaultCell().setMinimumHeight(10); // Establecer altura mínima de celda

            tabla.addCell(new PdfPCell(new Phrase("noControl", font)));
            tabla.addCell(new PdfPCell(new Phrase("nombre", font)));
            tabla.addCell(new PdfPCell(new Phrase("apellidoPaterno", font)));
            tabla.addCell(new PdfPCell(new Phrase("apellidoMaterno", font)));
            tabla.addCell(new PdfPCell(new Phrase("carrera", font)));
            tabla.addCell(new PdfPCell(new Phrase("genero", font)));
            tabla.addCell(new PdfPCell(new Phrase("fechaEntrada", font)));
            tabla.addCell(new PdfPCell(new Phrase("horaEntrada", font)));
            try {
                connect = database.connectDb();

                String sql = "SELECT historial.noControl, historial.fechaEntrada, historial.horaEntrada, alumnos.nombre, alumnos.apellidoPaterno, alumnos.apellidoMaterno, alumnos.carrera, alumnos.genero "
                    + "FROM historial "
                    + "JOIN alumnos ON historial.noControl = alumnos.noControl ORDER BY historial.fechaEntrada ASC, historial.horaEntrada ASC";

                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                if (result.next()) {
                    Font dataFont = new Font(Font.FontFamily.TIMES_ROMAN, 8); // Tamaño de fuente más pequeño para los datos

                    do {
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(1), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(4), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(5), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(6), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(7), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(8), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(2), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(3), dataFont)));
                    } while (result.next());
                    documento.add(tabla);
                }
            } catch (DocumentException | SQLException e){
            }
            documento.close();

            Alert alert = new Alert(AlertType.INFORMATION);

                    alert.setTitle("biblioTec Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Reporte creado.");
                    alert.showAndWait();
        } catch (DocumentException | FileNotFoundException e){
        }
    }    
    
    
/*
        public void reportePDF() throws BadElementException, IOException, SQLException {
    Document documento = new Document();

    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReportePrueba.pdf"));
        documento.open();

        //Agregar una imagen al documento
        String rutaImagen = "C:\\Users\\bombo\\Desktop\\BiblioTec\\src\\reporte\\header.png"; // Reemplaza con la ruta de tu imagen
        Image imagen = Image.getInstance(rutaImagen);
        imagen.scaleAbsolute(500f, 70f);
        imagen.setAlignment(Element.ALIGN_TOP); // Alinea la imagen en la parte superior
        documento.add(imagen);

        //Crear un párrafo con el texto deseado
        Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Paragraph header = new Paragraph("\n\n\n\n Instituto Tecnológico de Chihuahua II \n\n", font);
        header.setAlignment(Element.ALIGN_RIGHT); // Alinea la imagen en la parte inferior
        //Agregar el párrafo al documento
        documento.add(header);

        Paragraph alumno = new Paragraph("CENTRO DE INFORMACIÓN \n\n", font);
        alumno.setAlignment(Element.ALIGN_CENTER); // Alinea la imagen en la parte inferior
        documento.add(alumno);
        
            connect = database.connectDb();

        // Consulta SQL para obtener el total de entradas por mes y género
        String sql = "SELECT DATE_FORMAT(h.fechaEntrada, '%Y-%m-%d') as mes, a.genero, COUNT(*) as total " +
                          "FROM historial h " +
                          "JOIN alumnos a ON h.noControl = a.noControl " +
                          "GROUP BY mes, a.genero";


            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

        // Crear la tabla en el documento PDF
        PdfPTable tabla = new PdfPTable(3); // 3 columnas: mes, mujeres, hombres
        tabla.setWidthPercentage(100);

        // Encabezados de la tabla
        tabla.addCell("Mes");
        tabla.addCell("Mujeres");
        tabla.addCell("Hombres");

        // Llenar la tabla con los resultados de la consulta
        while (result.next()) {
            String mes = result.getString("mes");
            String genero = result.getString("genero");
            int total = result.getInt("total");

            // Agregar los datos a la tabla
            PdfPCell cellMes = new PdfPCell(new Phrase(String.valueOf(mes)));
            PdfPCell cellMujeres = new PdfPCell(new Phrase(genero.equals("F") ? String.valueOf(total) : ""));
            PdfPCell cellHombres = new PdfPCell(new Phrase(genero.equals("M") ? String.valueOf(total) : ""));

            tabla.addCell(cellMes);
            tabla.addCell(cellMujeres);
            tabla.addCell(cellHombres);
        }

        // Cerrar la conexión a la base de datos
        connect.close();

        // Agregar la tabla al documento
        documento.add(tabla);

        
        //Agregar otra imagen al final del documento
        String rutaImagenAbajo = "C:\\Users\\bombo\\Desktop\\BiblioTec\\src\\reporte\\footer.png"; // Reemplaza con la ruta de tu imagen inferior
        Image imagenAbajo = Image.getInstance(rutaImagenAbajo);
        imagenAbajo.scaleAbsolute(500f, 80f);
        imagenAbajo.setAlignment(Element.ALIGN_BOTTOM); // Alinea la imagen en la parte inferior
        documento.add(imagenAbajo);

        documento.close();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("biblioTec Message");
        alert.setHeaderText(null);
        alert.setContentText("Reporte creado.");
        alert.showAndWait();
    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace(); // Manejar excepciones adecuadamente en tu aplicación
    }
}
 */       
// Agregar esta clase interna para manejar eventos de página
/*    private static class HeaderFooterEvent extends PdfPageEventHelper {
        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            // Agregar aquí el contenido del encabezado en cada página
            // Puedes ajustar la posición y el contenido según tus necesidades
            // Ejemplo:
            PdfPTable headerTable = new PdfPTable(1);
            headerTable.addCell("Encabezado");
            try {
                document.add(headerTable);
            } catch (DocumentException ex) {
            }
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            // Agregar aquí el contenido del pie de página en cada página
            // Puedes ajustar la posición y el contenido según tus necesidades
            // Ejemplo:
            PdfPTable footerTable = new PdfPTable(1);
            footerTable.addCell("Pie de página");
            try {
                document.add(footerTable);
            } catch (DocumentException ex) {
            }
        }
    }

    public void reportePDF() throws BadElementException, IOException {
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReportePrueba.pdf"));

            // Agregar el evento para el encabezado y el pie de página
            HeaderFooterEvent event = new HeaderFooterEvent();
            writer.setPageEvent(event);

            documento.open();

        //Crear un párrafo con el texto deseado
        Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Paragraph header = new Paragraph("\n\n\n\n Instituto Tecnológico de Chihuahua II \n\n", font);
        header.setAlignment(Element.ALIGN_RIGHT); // Alinea la imagen en la parte inferior
        //Agregar el párrafo al documento
        documento.add(header);

            documento.close();

            // Resto de tu código...
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace(); // Manejar excepciones adecuadamente en tu aplicación
        }
    }
    
*/    
/*    public void reportePDF() throws BadElementException, IOException {
    Document documento = new Document();

    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReportePrueba.pdf"));
        documento.open();

        //Agregar una imagen al documento
        String rutaImagen = "C:\\Users\\bombo\\Desktop\\BiblioTec\\src\\reporte\\header.png"; // Reemplaza con la ruta de tu imagen
        Image imagen = Image.getInstance(rutaImagen);
        imagen.scaleAbsolute(500f, 70f);
        imagen.setAlignment(Element.ALIGN_TOP); // Alinea la imagen en la parte superior
        documento.add(imagen);

        //Crear un párrafo con el texto deseado
        Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Paragraph header = new Paragraph("\n\n\n\n Instituto Tecnológico de Chihuahua II \n\n", font);
        header.setAlignment(Element.ALIGN_RIGHT); // Alinea la imagen en la parte inferior
        //Agregar el párrafo al documento
        documento.add(header);

        Paragraph alumno = new Paragraph("CENTRO DE INFORMACIÓN \n\n", font);
        alumno.setAlignment(Element.ALIGN_CENTER); // Alinea la imagen en la parte inferior
        documento.add(alumno);
        
        
                        
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("noControl");
        tabla.addCell("fechaEntrada");
        tabla.addCell("horaEntrada");

        try {
            connect = database.connectDb();

            String sql = "select * from historial";

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                do {
                    tabla.addCell(result.getString(2));
                    tabla.addCell(result.getString(3));
                    tabla.addCell(result.getString(4));

                } while (result.next());

                // Agregar la tabla al documento
                documento.add(tabla);
            }
        } catch (DocumentException | SQLException e) {
            e.printStackTrace(); // Manejar excepciones adecuadamente en tu aplicación
        }

        //Agregar otra imagen al final del documento
        String rutaImagenAbajo = "C:\\Users\\bombo\\Desktop\\BiblioTec\\src\\reporte\\footer.png"; // Reemplaza con la ruta de tu imagen inferior
        Image imagenAbajo = Image.getInstance(rutaImagenAbajo);
        imagenAbajo.scaleAbsolute(500f, 80f);
        imagenAbajo.setAlignment(Element.ALIGN_BOTTOM); // Alinea la imagen en la parte inferior
        documento.add(imagenAbajo);

        documento.close();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("biblioTec Message");
        alert.setHeaderText(null);
        alert.setContentText("Reporte creado.");
        alert.showAndWait();
    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace(); // Manejar excepciones adecuadamente en tu aplicación
    }
}
*/
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        defaultNav();

        homeDisplayTotalEnrolledStudents();
        homeDisplayMaleEnrolled();
        homeDisplayFemaleEnrolled();
        DisplayDailyChartHome();

        DisplayCareersPieChart();
        DisplayTotalEnrolledChart_daily();
        DisplayEnrolledMaleChart_quarter();
        DisplayFemaleEnrolledChart_quarter();
        DisplayTotalEnrolledChart_quarter();
        DisplayEnrolledMaleChart_semestre();
        DisplayFemaleEnrolledChart_semestre();
        DisplayTotalEnrolledChart_semestre();
        // To show inmediately when we proceed to dashboard application form
        addStudentsShowListData();

    }

    //ESTILOS DE LOS BOTONES DE LAS CARRERAS
    public void IDINButtonStyle() {
        IDIN_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #364774, #607CC8);");
    }

    public void ADMButtonStyle() {
        ADM_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4B30A3, #6D74E5);");
    }

    public void ISCButtonStyle() {
        ISC_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #5284B2, #96DEFA);");
    }

    public void IINFButtonStyle() {
        IINF_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #1F7C46, #33D577);");
    }

    public void IINDButtonStyle() {
        IIND_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #DCCE3C, #FFF45D);");
    }

    public void IGEButtonStyle() {
        IGE_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #D1693E, #FF933E);");
    }

    public void ARQButtonStyle() {
        ARQ_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #972D2A, #FF4A47);");
    }

    public void DisplayStyleButtonsCareers() {
        IDINButtonStyle();
        ADMButtonStyle();
        ISCButtonStyle();
        IINFButtonStyle();
        IINDButtonStyle();
        IGEButtonStyle();
        ARQButtonStyle();
    }

    //Función para desplegar en cada etiqueta correspondiente cuantos alumnos ingresaron por carrera
    public void DisplayLabelsTotalCareers() {
        DisplayTotalByCareer("INGENIERIA EN DISEÑO INDUSTRIAL", totalIDIN);
        DisplayTotalByCareer("INGENIERIA INDUSTRIAL", totalIIND);
        DisplayTotalByCareer("INGENIERIA EN SISTEMAS COMPUTACIONALES", totalISC);
        DisplayTotalByCareer("INGENIERIA INFORMATICA", totalIINF);
        DisplayTotalByCareer("LICENCIATURA EN ADMINISTRACION", totalADM);
        DisplayTotalByCareer("INGENIERIA EN GESTION EMPRESARIAL", totalIGE);
        DisplayTotalByCareer("ARQUITECTURA", totalARQ);
    }

    public void SetFalsePieChartsCareersFM() {
        idinPieChart_AP.setVisible(false);
        admPieChart_AP.setVisible(false);
        iscPieChart_AP.setVisible(false);
        iinfPieChart_AP.setVisible(false);
        iindPieChart_AP.setVisible(false);
        igePieChart_AP.setVisible(false);
        arquiPieChart_AP.setVisible(false);
    }
}
