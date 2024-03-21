package biblioteca;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
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
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.control.Alert.AlertType;


import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
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
    private Button reportePDF_btnGeneral;

    @FXML
    private Button reportePDF_btnDia;

    @FXML
    private Button reportePDF_btnMes;

    @FXML
    private Button reportePDF_btnAnual;

    @FXML
    private Button reportePDF_btnTrimestral;

    @FXML
    private Button reportePDF_btnSemestral;

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

        String femaleSql = """
                           SELECT 
                               CASE 
                                   WHEN HOUR(h.horaEntrada) BETWEEN 7 AND 8 THEN '08:00 - 09:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 8 AND 9 THEN '09:00 - 10:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 9 AND 10 THEN '10:00 - 11:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 10 AND 11 THEN '11:00 - 12:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 11 AND 12 THEN '12:00 - 13:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 12 AND 13 THEN '13:00 - 14:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 13 AND 14 THEN '14:00 - 15:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 14 AND 15 THEN '15:00 - 16:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 15 AND 16 THEN '16:00 - 17:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 16 AND 17 THEN '17:00 - 18:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 17 AND 18 THEN '18:00 - 19:00'
                                   WHEN HOUR(h.horaEntrada) BETWEEN 18 AND 19 THEN '19:00 - 20:00'
                               END AS hora,
                               SUM(CASE WHEN a.genero = 'F' THEN 1 ELSE 0 END)
                           FROM 
                               historial h
                           JOIN 
                               Alumnos a ON h.noControl = a.noControl
                           WHERE 
                               DATE(h.fechaEntrada) = ?
                               AND TIME(h.horaEntrada) BETWEEN '08:00:00' AND '20:00:00'
                           GROUP BY 
                               hora;""";
        String maleSql = """
                         SELECT 
                             CASE 
                                 WHEN HOUR(h.horaEntrada) BETWEEN 7 AND 8 THEN '08:00 - 09:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 8 AND 9 THEN '09:00 - 10:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 9 AND 10 THEN '10:00 - 11:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 10 AND 11 THEN '11:00 - 12:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 11 AND 12 THEN '12:00 - 13:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 12 AND 13 THEN '13:00 - 14:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 13 AND 14 THEN '14:00 - 15:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 14 AND 15 THEN '15:00 - 16:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 15 AND 16 THEN '16:00 - 17:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 16 AND 17 THEN '17:00 - 18:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 17 AND 18 THEN '18:00 - 19:00'
                                 WHEN HOUR(h.horaEntrada) BETWEEN 18 AND 19 THEN '19:00 - 20:00'
                             END AS hora,
                             SUM(CASE WHEN a.genero = 'M' THEN 1 ELSE 0 END)
                         FROM 
                             historial h
                         JOIN 
                             Alumnos a ON h.noControl = a.noControl
                         WHERE 
                             DATE(h.fechaEntrada) = ?
                             AND TIME(h.horaEntrada) BETWEEN '08:00:00' AND '20:00:00'
                         GROUP BY 
                             hora;""";

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

        // Utilizando la función QUARTER() y YEAR() para agrupar por trimestre y año
        String sql = "SELECT YEAR(fechaEntrada), QUARTER(fechaEntrada), COUNT(*) " +
                     "FROM historial " +
                     "GROUP BY YEAR(fechaEntrada), QUARTER(fechaEntrada) " +
                     "ORDER BY YEAR(fechaEntrada) DESC, QUARTER(fechaEntrada) DESC " +
                     "LIMIT 4";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();

            while (result.next()) {
                // Puedes personalizar la presentación del trimestre según tus necesidades
                String trimestre = "Trimestre " + result.getString(2) + " " +  result.getString(1);
                chart.getData().add(new XYChart.Data<>(trimestre, result.getInt(3)));
            }

            totalEnrolledChart_quarter.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayFemaleEnrolledChart_quarter() {
        totalFemaleChart_quarter.getData().clear();

        // Utilizando la función QUARTER() y YEAR() para agrupar por trimestre y año
        String sql = "SELECT YEAR(h.fechaEntrada), QUARTER(h.fechaEntrada), COUNT(*) " +
                     "FROM historial h JOIN alumnos a ON h.noControl = a.noControl " +
                     "WHERE a.genero = 'F' " +
                     "GROUP BY YEAR(h.fechaEntrada), QUARTER(h.fechaEntrada) " +
                     "ORDER BY YEAR(h.fechaEntrada) DESC, QUARTER(h.fechaEntrada) DESC " +
                     "LIMIT 4";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Mujeres");

            while (result.next()) {
                // Puedes personalizar la presentación del trimestre y año según tus necesidades
                String trimestre = "Trimestre " + result.getString(2) + " " +  result.getString(1);
                chart.getData().add(new XYChart.Data<>(trimestre, result.getInt(3)));
            }

            totalFemaleChart_quarter.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayEnrolledMaleChart_quarter() {
        totalMaleChart_quarter.getData().clear();
        
            // Utilizando la función QUARTER() y YEAR() para agrupar por trimestre y año
            String sql = "SELECT YEAR(h.fechaEntrada), QUARTER(h.fechaEntrada), COUNT(*) " +
                         "FROM historial h JOIN alumnos a ON h.noControl = a.noControl " +
                         "WHERE a.genero = 'M' " +
                         "GROUP BY YEAR(h.fechaEntrada), QUARTER(h.fechaEntrada) " +
                         "ORDER BY YEAR(h.fechaEntrada) DESC, QUARTER(h.fechaEntrada) DESC " +
                         "LIMIT 4";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Hombres");

            while (result.next()) {
                // Puedes personalizar la presentación del trimestre y año según tus necesidades
                String trimestre = "Trimestre " + result.getString(2) + " " +  result.getString(1);
                chart.getData().add(new XYChart.Data<>(trimestre, result.getInt(3)));
            }

            totalMaleChart_quarter.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayTotalEnrolledChart_semestre() {
        totalEnrolledChart_semestre.getData().clear();

        // Utilizando la función MONTH() y expresiones CASE para calcular el semestre
        String sql = "SELECT CONCAT('Semestre ', CASE WHEN MONTH(fechaEntrada) <= 6 THEN 'A' ELSE 'B' END, ' ', YEAR(fechaEntrada)) AS Semestre, COUNT(*) FROM historial GROUP BY Semestre DESC LIMIT 2";

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
        String sql = "SELECT CONCAT('Semestre ', CASE WHEN QUARTER(fechaEntrada) <= 2 THEN 'A' ELSE 'B' END, ' ', YEAR(fechaEntrada)), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F' GROUP BY YEAR(fechaEntrada), QUARTER(fechaEntrada) ORDER BY YEAR(fechaEntrada) DESC, QUARTER(fechaEntrada) DESC LIMIT 4";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Mujeres");

            while (result.next()) {
                // Puedes personalizar la presentación del semestre según tus necesidades
                String semestre = result.getString(1);
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
        String sql = "SELECT CONCAT('Semestre ', CASE WHEN QUARTER(fechaEntrada) <= 2 THEN 'A' ELSE 'B' END, ' ', YEAR(fechaEntrada)), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M' GROUP BY YEAR(fechaEntrada), QUARTER(fechaEntrada) ORDER BY YEAR(fechaEntrada) DESC, QUARTER(fechaEntrada) DESC LIMIT 4";

        try (Connection connect = database.connectDb(); PreparedStatement prepare = connect.prepareStatement(sql); ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Hombres");

            while (result.next()) {
                // Puedes personalizar la presentación del semestre según tus necesidades
                String semestre = result.getString(1);
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
public class HeaderFooter extends PdfPageEventHelper {
    private String imagePath;
    private float marginLeft;
    private float marginTop;
    private int numLineas;

    public HeaderFooter(String imagePath, float marginLeft, float marginTop, int numLineas) {
        this.imagePath = imagePath;
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.numLineas = numLineas;
    }

    
    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        try {
            // Agregar saltos de línea
            for (int i = 0; i < numLineas; i++) {
                document.add(new Paragraph("\n"));
            }

            // Cargar la imagen
            Image image = Image.getInstance(getClass().getResource(imagePath));
            image.scaleToFit(200, 100); // Ancho // Altura
            image.setAbsolutePosition(document.left() + marginLeft, document.top() - marginTop - image.getScaledHeight());

            // Agregar la imagen al contenido del documento
            PdfContentByte canvas = writer.getDirectContent();
            canvas.addImage(image);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}

    public void reporteGeneral_PDF() throws IOException {
        Document documento = new Document();
        documento.setMargins(0, 0, 20, 20); // Establecer márgenes izq, der, arr, ab
        
        try{
            String ruta = System.getProperty("user.home");
            float marginLeft = 20f;
            float marginTop = 10f;
            int numLineas = 3; // Cantidad de saltos de línea a agregar

            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Lista de Registro General.pdf"));

            // Agregar el encabezado a cada página
            String imagePath = "/reporte/educacionTec.png";
            HeaderFooter event = new HeaderFooter(imagePath, marginLeft, marginTop, numLineas);
            writer.setPageEvent(event);

            documento.open();
   
            // Agregar el título
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Paragraph title = new Paragraph("Instituto Tecnológico de Chihuahua II\n", titleFont);
            title.setAlignment(Element.ALIGN_CENTER); // Alineación central del título
            documento.add(title);

            Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Paragraph subTitle = new Paragraph("Centro de Información\n", subTitleFont);
            subTitle.setAlignment(Element.ALIGN_CENTER); // Alineación central del subtítulo
            documento.add(subTitle);

            // Nuevo párrafo para "Reporte anual" con letra más pequeña
            Font generalReportFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Paragraph generalReport = new Paragraph("Reporte General\n\n", generalReportFont);
            generalReport.setAlignment(Element.ALIGN_CENTER);
            documento.add(generalReport);

            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10); // Puedes ajustar el tamaño del texto aquí

            PdfPTable tabla = new PdfPTable(8);
            tabla.getDefaultCell().setMinimumHeight(20); // Establecer altura mínima de celda
            
            // Establecer el ancho de la tabla al 90% del ancho de la página
            tabla.setWidthPercentage(90);

            // Establecer los anchos de las columnas (en porcentaje)
            float[] columnWidths = {10f, 15f, 13f, 13f, 16f, 10f, 10f, 10f};
            tabla.setWidths(columnWidths);

            tabla.addCell(new PdfPCell(new Phrase("No Control", font)));
            tabla.addCell(new PdfPCell(new Phrase("Nombre", font)));
            tabla.addCell(new PdfPCell(new Phrase("Apellido Paterno", font)));
            tabla.addCell(new PdfPCell(new Phrase("Apellido Materno", font)));
            tabla.addCell(new PdfPCell(new Phrase("Carrera", font)));
            tabla.addCell(new PdfPCell(new Phrase("Género", font)));
            tabla.addCell(new PdfPCell(new Phrase("Fecha de Entrada", font)));
            tabla.addCell(new PdfPCell(new Phrase("Hora de Entrada", font)));
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
                        
                        // Condición para mostrar "Femenino" o "Masculino" en lugar de "F" o "M"
                        String genero = result.getString(8);
                        if (genero.equals("F")) {
                            tabla.addCell(new PdfPCell(new Phrase("Femenino", dataFont)));
                        } else if (genero.equals("M")) {
                            tabla.addCell(new PdfPCell(new Phrase("Masculino", dataFont)));
                        } else {
                            // Manejar otro caso si es necesario
                            tabla.addCell(new PdfPCell(new Phrase(genero, dataFont)));
                        }

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
                    alert.setContentText("Reporte general creado.");
                    alert.showAndWait();
        } catch (DocumentException | FileNotFoundException e){
        }
    }    
        
    public void reporteAnual_PDF() {
        Document documentoAnual = new Document();
        documentoAnual.setMargins(0, 0, 20, 20); // Establecer márgenes izq, der, arr, ab

        try{
            String ruta = System.getProperty("user.home");
            float marginLeft = 20f;
            float marginTop = 10f;
            int numLineas = 3; // Cantidad de saltos de línea a agregar

            PdfWriter writer = PdfWriter.getInstance(documentoAnual, new FileOutputStream(ruta + "/Desktop/Lista de Registro Anual.pdf"));

            // Agregar el encabezado a cada página
            String imagePath = "/reporte/educacionTec.png";
            HeaderFooter event = new HeaderFooter(imagePath, marginLeft, marginTop, numLineas);
            writer.setPageEvent(event);
        
            documentoAnual.open();
            
            // Agregar el título
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Paragraph title = new Paragraph("Instituto Tecnológico de Chihuahua II\n", titleFont);
            title.setAlignment(Element.ALIGN_CENTER); // Alineación central del título
            documentoAnual.add(title);

            Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Paragraph subTitle = new Paragraph("Centro de Información\n", subTitleFont);
            subTitle.setAlignment(Element.ALIGN_CENTER); // Alineación central del subtítulo
            documentoAnual.add(subTitle);

            // Nuevo párrafo para "Reporte anual" con letra más pequeña
            Font annualReportFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Paragraph annualReport = new Paragraph("Reporte Anual\n\n", annualReportFont);
            annualReport.setAlignment(Element.ALIGN_CENTER);
            documentoAnual.add(annualReport);

            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10); // Puedes ajustar el tamaño del texto aquí

            PdfPTable tabla = new PdfPTable(8);
            tabla.getDefaultCell().setMinimumHeight(20); // Establecer altura mínima de celda
            
            // Establecer el ancho de la tabla al 90% del ancho de la página
            tabla.setWidthPercentage(90);

            // Establecer los anchos de las columnas (en porcentaje)
            float[] columnWidths = {10f, 15f, 13f, 13f, 16f, 10f, 10f, 10f};
            tabla.setWidths(columnWidths);

            tabla.addCell(new PdfPCell(new Phrase("No Control", font)));
            tabla.addCell(new PdfPCell(new Phrase("Nombre", font)));
            tabla.addCell(new PdfPCell(new Phrase("Apellido Paterno", font)));
            tabla.addCell(new PdfPCell(new Phrase("Apellido Materno", font)));
            tabla.addCell(new PdfPCell(new Phrase("Carrera", font)));
            tabla.addCell(new PdfPCell(new Phrase("Género", font)));
            tabla.addCell(new PdfPCell(new Phrase("Fecha de Entrada", font)));
            tabla.addCell(new PdfPCell(new Phrase("Hora de Entrada", font)));
            try {
                connect = database.connectDb();

            String sql = "SELECT historial.noControl, historial.fechaEntrada, historial.horaEntrada, alumnos.nombre, alumnos.apellidoPaterno, alumnos.apellidoMaterno, alumnos.carrera, alumnos.genero "
                    + "FROM historial "
                    + "JOIN alumnos ON historial.noControl = alumnos.noControl "
                    + "WHERE YEAR(historial.fechaEntrada) = YEAR(CURDATE()) " // Filtrar por el año actual
                    + "ORDER BY historial.fechaEntrada ASC, historial.horaEntrada ASC";

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
                        
                        // Condición para mostrar "Femenino" o "Masculino" en lugar de "F" o "M"
                        String genero = result.getString(8);
                        if (genero.equals("F")) {
                            tabla.addCell(new PdfPCell(new Phrase("Femenino", dataFont)));
                        } else if (genero.equals("M")) {
                            tabla.addCell(new PdfPCell(new Phrase("Masculino", dataFont)));
                        } else {
                            // Manejar otro caso si es necesario
                            tabla.addCell(new PdfPCell(new Phrase(genero, dataFont)));
                        }

                        tabla.addCell(new PdfPCell(new Phrase(result.getString(2), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(3), dataFont)));
                } while (result.next());
                    documentoAnual.add(tabla);
                }
            } catch (DocumentException | SQLException e){
            }
            documentoAnual.close();

            Alert alert = new Alert(AlertType.INFORMATION);

                    alert.setTitle("biblioTec Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Reporte anual creado.");
                    alert.showAndWait();
        } catch (DocumentException | FileNotFoundException e){
        }
    }    

    public void reporteDiario_PDF() {
        Document documentoDiario = new Document();
        documentoDiario.setMargins(0, 0, 20, 20); // Establecer márgenes izq, der, arr, ab
        
        try{
            String ruta = System.getProperty("user.home");
            float marginLeft = 20f;
            float marginTop = 10f;
            int numLineas = 3; // Cantidad de saltos de línea a agregar

            PdfWriter writer = PdfWriter.getInstance(documentoDiario, new FileOutputStream(ruta + "/Desktop/Lista de Registro Diario.pdf"));

            // Agregar el encabezado a cada página
            String imagePath = "/reporte/educacionTec.png";
            HeaderFooter event = new HeaderFooter(imagePath, marginLeft, marginTop, numLineas);
            writer.setPageEvent(event);

            documentoDiario.open();
            
            // Agregar el título
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Paragraph title = new Paragraph("Instituto Tecnológico de Chihuahua II\n", titleFont);
            title.setAlignment(Element.ALIGN_CENTER); // Alineación central del título
            documentoDiario.add(title);

            Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Paragraph subTitle = new Paragraph("Centro de Información\n", subTitleFont);
            subTitle.setAlignment(Element.ALIGN_CENTER); // Alineación central del subtítulo
            documentoDiario.add(subTitle);

            // Nuevo párrafo para "Reporte anual" con letra más pequeña
            Font generalReportFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Paragraph generalReport = new Paragraph("Reporte Diario\n\n", generalReportFont);
            generalReport.setAlignment(Element.ALIGN_CENTER);
            documentoDiario.add(generalReport);

            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10); // Puedes ajustar el tamaño del texto aquí

            PdfPTable tabla = new PdfPTable(8);
            tabla.getDefaultCell().setMinimumHeight(20); // Establecer altura mínima de celda
            
            // Establecer el ancho de la tabla al 90% del ancho de la página
            tabla.setWidthPercentage(90);

            // Establecer los anchos de las columnas (en porcentaje)
            float[] columnWidths = {10f, 15f, 13f, 13f, 16f, 10f, 10f, 10f};
            tabla.setWidths(columnWidths);

            tabla.addCell(new PdfPCell(new Phrase("No Control", font)));
            tabla.addCell(new PdfPCell(new Phrase("Nombre", font)));
            tabla.addCell(new PdfPCell(new Phrase("Apellido Paterno", font)));
            tabla.addCell(new PdfPCell(new Phrase("Apellido Materno", font)));
            tabla.addCell(new PdfPCell(new Phrase("Carrera", font)));
            tabla.addCell(new PdfPCell(new Phrase("Género", font)));
            tabla.addCell(new PdfPCell(new Phrase("Fecha de Entrada", font)));
            tabla.addCell(new PdfPCell(new Phrase("Hora de Entrada", font)));
            try {
                connect = database.connectDb();

                String sql = "SELECT historial.noControl, historial.fechaEntrada, historial.horaEntrada, alumnos.nombre, alumnos.apellidoPaterno, alumnos.apellidoMaterno, alumnos.carrera, alumnos.genero "
                    + "FROM historial "
                    + "JOIN alumnos ON historial.noControl = alumnos.noControl "
                    + "WHERE DATE(historial.fechaEntrada) = CURRENT_DATE() " // Filtrar por la fecha actual
                    + "ORDER BY historial.fechaEntrada ASC, historial.horaEntrada ASC";

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
                        
                        // Condición para mostrar "Femenino" o "Masculino" en lugar de "F" o "M"
                        String genero = result.getString(8);
                        if (genero.equals("F")) {
                            tabla.addCell(new PdfPCell(new Phrase("Femenino", dataFont)));
                        } else if (genero.equals("M")) {
                            tabla.addCell(new PdfPCell(new Phrase("Masculino", dataFont)));
                        } else {
                            // Manejar otro caso si es necesario
                            tabla.addCell(new PdfPCell(new Phrase(genero, dataFont)));
                        }

                        tabla.addCell(new PdfPCell(new Phrase(result.getString(2), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(3), dataFont)));
                } while (result.next());
                    documentoDiario.add(tabla);
                }
            } catch (DocumentException | SQLException e){
            }
            documentoDiario.close();

            Alert alert = new Alert(AlertType.INFORMATION);

                    alert.setTitle("biblioTec Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Reporte diario creado.");
                    alert.showAndWait();
        } catch (DocumentException | FileNotFoundException e){
        }
    }    

    public void reporteMensual_PDF() {
        Document documentoMensual = new Document();
        documentoMensual.setMargins(0, 0, 20, 20); // Establecer márgenes izq, der, arr, ab
        
        try{
            String ruta = System.getProperty("user.home");
            float marginLeft = 20f;
            float marginTop = 10f;
            int numLineas = 3; // Cantidad de saltos de línea a agregar

            PdfWriter writer = PdfWriter.getInstance(documentoMensual, new FileOutputStream(ruta + "/Desktop/Lista de Registro Mensual.pdf"));

            // Agregar el encabezado a cada página
            String imagePath = "/reporte/educacionTec.png";
            HeaderFooter event = new HeaderFooter(imagePath, marginLeft, marginTop, numLineas);
            writer.setPageEvent(event);

            documentoMensual.open();
            
            // Agregar el título
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Paragraph title = new Paragraph("Instituto Tecnológico de Chihuahua II\n", titleFont);
            title.setAlignment(Element.ALIGN_CENTER); // Alineación central del título
            documentoMensual.add(title);

            Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Paragraph subTitle = new Paragraph("Centro de Información\n", subTitleFont);
            subTitle.setAlignment(Element.ALIGN_CENTER); // Alineación central del subtítulo
            documentoMensual.add(subTitle);

            // Nuevo párrafo para "Reporte anual" con letra más pequeña
            Font generalReportFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Paragraph generalReport = new Paragraph("Reporte Mensual\n\n", generalReportFont);
            generalReport.setAlignment(Element.ALIGN_CENTER);
            documentoMensual.add(generalReport);

            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10); // Puedes ajustar el tamaño del texto aquí

            PdfPTable tabla = new PdfPTable(8);
            tabla.getDefaultCell().setMinimumHeight(20); // Establecer altura mínima de celda
            
            // Establecer el ancho de la tabla al 90% del ancho de la página
            tabla.setWidthPercentage(90);

            // Establecer los anchos de las columnas (en porcentaje)
            float[] columnWidths = {10f, 15f, 13f, 13f, 16f, 10f, 10f, 10f};
            tabla.setWidths(columnWidths);

            tabla.addCell(new PdfPCell(new Phrase("No Control", font)));
            tabla.addCell(new PdfPCell(new Phrase("Nombre", font)));
            tabla.addCell(new PdfPCell(new Phrase("Apellido Paterno", font)));
            tabla.addCell(new PdfPCell(new Phrase("Apellido Materno", font)));
            tabla.addCell(new PdfPCell(new Phrase("Carrera", font)));
            tabla.addCell(new PdfPCell(new Phrase("Género", font)));
            tabla.addCell(new PdfPCell(new Phrase("Fecha de Entrada", font)));
            tabla.addCell(new PdfPCell(new Phrase("Hora de Entrada", font)));
            try {
                connect = database.connectDb();

                String sql = "SELECT historial.noControl, historial.fechaEntrada, historial.horaEntrada, alumnos.nombre, alumnos.apellidoPaterno, alumnos.apellidoMaterno, alumnos.carrera, alumnos.genero "
                    + "FROM historial "
                    + "JOIN alumnos ON historial.noControl = alumnos.noControl "
                    + "WHERE MONTH(historial.fechaEntrada) = MONTH(CURRENT_DATE()) " // Filtrar por el mes actual
                    + "AND YEAR(historial.fechaEntrada) = YEAR(CURRENT_DATE()) " // Asegurar que sea del año actual
                    + "ORDER BY historial.fechaEntrada ASC, historial.horaEntrada ASC";

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
                        
                        // Condición para mostrar "Femenino" o "Masculino" en lugar de "F" o "M"
                        String genero = result.getString(8);
                        if (genero.equals("F")) {
                            tabla.addCell(new PdfPCell(new Phrase("Femenino", dataFont)));
                        } else if (genero.equals("M")) {
                            tabla.addCell(new PdfPCell(new Phrase("Masculino", dataFont)));
                        } else {
                            // Manejar otro caso si es necesario
                            tabla.addCell(new PdfPCell(new Phrase(genero, dataFont)));
                        }

                        tabla.addCell(new PdfPCell(new Phrase(result.getString(2), dataFont)));
                        tabla.addCell(new PdfPCell(new Phrase(result.getString(3), dataFont)));
                } while (result.next());
                    documentoMensual.add(tabla);
                }
            } catch (DocumentException | SQLException e){
            }
            documentoMensual.close();

            Alert alert = new Alert(AlertType.INFORMATION);

                    alert.setTitle("biblioTec Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Reporte mensual creado.");
                    alert.showAndWait();
        } catch (DocumentException | FileNotFoundException e){
        }
    }    
  
    Document documentoTrimestral;
    public void reporteTrimestral_PDF() {
        documentoTrimestral = new Document();
        documentoTrimestral.setMargins(0, 0, 20, 20);

        try{
            String ruta = System.getProperty("user.home");
            float marginLeft = 20f;
            float marginTop = 10f;
            int numLineas = 3; // Cantidad de saltos de línea a agregar

            PdfWriter writer = PdfWriter.getInstance(documentoTrimestral, new FileOutputStream(ruta + "/Desktop/Lista de Registro Trimestral.pdf"));

            // Agregar el encabezado a cada página
            String imagePath = "/reporte/educacionTec.png";
            HeaderFooter event = new HeaderFooter(imagePath, marginLeft, marginTop, numLineas);
            writer.setPageEvent(event);

            documentoTrimestral.open();

            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Font annualReportFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

            addTitle(documentoTrimestral, titleFont, "Instituto Tecnológico de Chihuahua II");
            addTitle(documentoTrimestral, subTitleFont, "Centro de Información");
            addTitle(documentoTrimestral, annualReportFont, "Reporte Trimestral");

            // Tabla para enero a marzo
            addSubtitle(documentoTrimestral, annualReportFont, "Afluencia Enero-Marzo\n\n", Element.ALIGN_LEFT, 20f);
            PdfPTable tablaEneroMarzo = createTable(annualReportFont);
            addDataToTable(tablaEneroMarzo, "WHERE MONTH(historial.fechaEntrada) BETWEEN 1 AND 3");
            documentoTrimestral.add(tablaEneroMarzo);

            // Añade un párrafo en blanco para crear un espacio
            documentoTrimestral.add(new Paragraph("\n"));

            // Llama al método para obtener el total de alumnos de enero a marzo
            int totalAlumnosEneroMarzo = obtenerTotalAlumnosTrimestre(1, 3);
            // Muestra el total de alumnos para enero a marzo
            addTitle(documentoTrimestral, annualReportFont, "Total de Alumnos (Enero-Marzo): " + totalAlumnosEneroMarzo + "\n\n");

            // Tabla para abril a junio
            addSubtitle(documentoTrimestral, annualReportFont, "Afluencia Abril-Junio\n\n", Element.ALIGN_LEFT, 20f);
            PdfPTable tablaAbrilJunio = createTable(annualReportFont);
            addDataToTable(tablaAbrilJunio, "WHERE MONTH(historial.fechaEntrada) BETWEEN 4 AND 6");
            documentoTrimestral.add(tablaAbrilJunio);

            // Añade un párrafo en blanco para crear un espacio
            documentoTrimestral.add(new Paragraph("\n"));

            // Llama al método para obtener el total de alumnos de abril a junio
            int totalAlumnosAbrilJunio = obtenerTotalAlumnosTrimestre(4, 6);
            // Muestra el total de alumnos para abril a junio
            addTitle(documentoTrimestral, annualReportFont, "Total de Alumnos (Abril-Junio): " + totalAlumnosAbrilJunio + "\n\n");

            // Tabla para julio a septiembre
            addSubtitle(documentoTrimestral, annualReportFont, "Afluencia Julio-Septiembre\n\n", Element.ALIGN_LEFT, 20f);
            PdfPTable tablaJulioSeptiembre = createTable(annualReportFont);
            addDataToTable(tablaJulioSeptiembre, "WHERE MONTH(historial.fechaEntrada) BETWEEN 7 AND 9");
            documentoTrimestral.add(tablaJulioSeptiembre);

            // Añade un párrafo en blanco para crear un espacio
            documentoTrimestral.add(new Paragraph("\n"));

            // Llama al método para obtener el total de alumnos de julio a septiembre
            int totalAlumnosJulioSeptiembre = obtenerTotalAlumnosTrimestre(7, 9);
            // Muestra el total de alumnos para julio a septiembre
            addTitle(documentoTrimestral, annualReportFont, "Total de Alumnos (Julio-Septiembre): " + totalAlumnosJulioSeptiembre + "\n\n");

            // Tabla para octubre a diciembre
            addSubtitle(documentoTrimestral, annualReportFont, "Afluencia Octubre-Diciembre\n\n", Element.ALIGN_LEFT, 20f);
            PdfPTable tablaOctubreDiciembre = createTable(annualReportFont);
            addDataToTable(tablaOctubreDiciembre, "WHERE MONTH(historial.fechaEntrada) BETWEEN 10 AND 12");
            documentoTrimestral.add(tablaOctubreDiciembre);

            // Añade un párrafo en blanco para crear un espacio
            documentoTrimestral.add(new Paragraph("\n"));

            // Llama al método para obtener el total de alumnos de octubre a diciembre
            int totalAlumnosOctubreDiciembre = obtenerTotalAlumnosTrimestre(10, 12);
            // Muestra el total de alumnos para octubre a diciembre
            addTitle(documentoTrimestral, annualReportFont, "Total de Alumnos (Octubre-Diciembre): " + totalAlumnosOctubreDiciembre + "\n\n");

            // Agrega un párrafo en blanco para crear un espacio antes del PieChart
            documentoTrimestral.add(new Paragraph("\n"));

            documentoTrimestral.close();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("biblioTec Message");
            alert.setHeaderText(null);
            alert.setContentText("Reporte trimestral creado.");
            alert.showAndWait();

        } catch (DocumentException | FileNotFoundException | SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    private int obtenerTotalAlumnosTrimestre(int mesInicio, int mesFin) throws SQLException {
        connect = database.connectDb();

        String sql = "SELECT COUNT(*) AS TotalAlumnos FROM historial " +
                     "WHERE MONTH(historial.fechaEntrada) BETWEEN ? AND ? " +
                     "AND YEAR(historial.fechaEntrada) = YEAR(CURDATE())";

        prepare = connect.prepareStatement(sql);
        prepare.setInt(1, mesInicio);
        prepare.setInt(2, mesFin);
        result = prepare.executeQuery();

        int totalAlumnos = 0;

        if (result.next()) {
            totalAlumnos = result.getInt("TotalAlumnos");
        }

        connect.close();

        return totalAlumnos;
    }    
    
    Document documentoSemestral;
    public void reporteSemestral_PDF() {
        documentoSemestral = new Document();
        documentoSemestral.setMargins(0, 0, 20, 20);

        try{
            String ruta = System.getProperty("user.home");
            float marginLeft = 20f;
            float marginTop = 10f;
            int numLineas = 3; // Cantidad de saltos de línea a agregar

            PdfWriter writer = PdfWriter.getInstance(documentoSemestral, new FileOutputStream(ruta + "/Desktop/Lista de Registro Semestral.pdf"));

            // Agregar el encabezado a cada página
            String imagePath = "/reporte/educacionTec.png";
            HeaderFooter event = new HeaderFooter(imagePath, marginLeft, marginTop, numLineas);
            writer.setPageEvent(event);

            documentoSemestral.open();

            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Font subTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Font annualReportFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

            addTitle(documentoSemestral, titleFont, "Instituto Tecnológico de Chihuahua II");
            addTitle(documentoSemestral, subTitleFont, "Centro de Información");
            addTitle(documentoSemestral, annualReportFont, "Reporte Semestral");
                   
            // Tabla para enero a junio
            addSubtitle(documentoSemestral, annualReportFont, "Afluencia Enero-Junio\n\n", Element.ALIGN_LEFT, 20f);
            PdfPTable tablaEneroJunio = createTable(annualReportFont);
            addDataToTable(tablaEneroJunio, "WHERE MONTH(historial.fechaEntrada) BETWEEN 1 AND 6");            
            documentoSemestral.add(tablaEneroJunio);

            // Añade un párrafo en blanco para crear un espacio
            documentoSemestral.add(new Paragraph("\n"));

            // Llama al método para obtener el total de alumnos de enero a junio
        int totalAlumnosEneroJunio = obtenerTotalAlumnosEneroJunio();
        // Muestra el total de alumnos para enero a junio
        addTitle(documentoSemestral, annualReportFont, "Total de Alumnos (Enero-Junio): " + totalAlumnosEneroJunio + "\n\n");

            // Nueva página para la tabla de agosto a diciembre
            //documentoSemestral.newPage();

            // Tabla para agosto a diciembre
            addSubtitle(documentoSemestral, annualReportFont, "Afluencia Agosto-Diciembre\n\n", Element.ALIGN_LEFT, 20f);
            PdfPTable tablaAgostoDiciembre = createTable(annualReportFont);
            addDataToTable(tablaAgostoDiciembre, "WHERE MONTH(historial.fechaEntrada) BETWEEN 8 AND 12");
            documentoSemestral.add(tablaAgostoDiciembre);

            // Añade un párrafo en blanco para crear un espacio
            documentoSemestral.add(new Paragraph("\n"));

            // Llama al método para obtener el total de alumnos de agosto a diciembre
        int totalAlumnosAgostoDiciembre = obtenerTotalAlumnosAgostoDiciembre();
        // Muestra el total de alumnos para agosto a diciembre
        addTitle(documentoSemestral, annualReportFont, "Total de Alumnos (Agosto-Diciembre): " + totalAlumnosAgostoDiciembre);
            
        // Agrega un párrafo en blanco para crear un espacio antes del PieChart
        documentoSemestral.add(new Paragraph("\n"));
        
        documentoSemestral.close();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("biblioTec Message");
            alert.setHeaderText(null);
            alert.setContentText("Reporte semestral creado.");
            alert.showAndWait();

        } catch (DocumentException | FileNotFoundException | SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    // Método para agregar títulos al documento
    private void addTitle(Document document, Font font, String title) throws DocumentException {
        Paragraph paragraph = new Paragraph(title, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        
    }

    // Método para agregar subtitulos al documento
    private void addSubtitle(Document document, Font font, String title, int alignment, float indentationLeft) throws DocumentException {
        Paragraph paragraph = new Paragraph(title, font);
        paragraph.setAlignment(alignment);
        paragraph.setIndentationLeft(indentationLeft); // Establecer el relleno izquierdo
        document.add(paragraph);
        
    }

    private PdfPTable createTable(Font font) throws DocumentException {
        PdfPTable tabla = new PdfPTable(3);
        tabla.getDefaultCell().setMinimumHeight(20);
        tabla.setWidthPercentage(90);

        float[] columnWidths = {30f, 30f, 30f};
        tabla.setWidths(columnWidths);

        tabla.addCell(new PdfPCell(new Phrase("Mes", font)));
        tabla.addCell(new PdfPCell(new Phrase("Hombres", font)));
        tabla.addCell(new PdfPCell(new Phrase("Mujeres", font)));

        return tabla;
    }
    
    private int obtenerTotalAlumnosEneroJunio() throws SQLException {
        connect = database.connectDb();

        String sql = "SELECT COUNT(*) AS TotalAlumnos FROM historial " +
                     "WHERE MONTH(historial.fechaEntrada) BETWEEN 1 AND 6 " +
                     "AND YEAR(historial.fechaEntrada) = YEAR(CURDATE())";

        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        int totalAlumnos = 0;

        if (result.next()) {
            totalAlumnos = result.getInt("TotalAlumnos");
        }

        connect.close();

        return totalAlumnos;
    }
    
    private int obtenerTotalAlumnosAgostoDiciembre() throws SQLException {
        connect = database.connectDb();

        String sql = "SELECT COUNT(*) AS TotalAlumnos FROM historial " +
                     "WHERE MONTH(historial.fechaEntrada) BETWEEN 8 AND 12 " +
                     "AND YEAR(historial.fechaEntrada) = YEAR(CURDATE())";

        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        int totalAlumnos = 0;

        if (result.next()) {
            totalAlumnos = result.getInt("TotalAlumnos");
        }

        connect.close();

        return totalAlumnos;
    }    

    private void addDataToTable(PdfPTable tabla, String condition) throws SQLException, DocumentException {
        try {
            connect = database.connectDb();

            String sql = "SELECT MONTHNAME(historial.fechaEntrada) AS Mes, " +
                         "SUM(CASE WHEN alumnos.genero = 'M' THEN 1 ELSE 0 END) AS Hombres, " +
                         "SUM(CASE WHEN alumnos.genero = 'F' THEN 1 ELSE 0 END) AS Mujeres " +
                         "FROM historial " +
                         "JOIN alumnos ON historial.noControl = alumnos.noControl " +
                         condition +
                         " AND YEAR(historial.fechaEntrada) = YEAR(CURDATE()) " +
                         "GROUP BY MONTH(historial.fechaEntrada) " +
                         "ORDER BY MONTH(historial.fechaEntrada) ASC";

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Font dataFont = new Font(Font.FontFamily.TIMES_ROMAN, 8);

            int totalHombres = 0;
            int totalMujeres = 0;

            while (result.next()) {
                tabla.addCell(new PdfPCell(new Phrase(result.getString("Mes"), dataFont)));
                int hombres = result.getInt("Hombres");
                int mujeres = result.getInt("Mujeres");
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(hombres), dataFont)));
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(mujeres), dataFont)));

                // Acumula el total de hombres y mujeres
                totalHombres += hombres;
                totalMujeres += mujeres;
            }

            // Agrega una fila adicional con el total
            tabla.addCell(new PdfPCell(new Phrase("Total", dataFont)));
            tabla.addCell(new PdfPCell(new Phrase(String.valueOf(totalHombres), dataFont)));
            tabla.addCell(new PdfPCell(new Phrase(String.valueOf(totalMujeres), dataFont)));


            // Crea un conjunto de datos para el gráfico PieChart
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Hombres", totalHombres);
            dataset.setValue("Mujeres", totalMujeres);


            // Crea el gráfico PieChart
            JFreeChart chart = ChartFactory.createPieChart(
                    "\n",
                    dataset,
                    true,
                    true,
                    false
            );

            // Personaliza los colores de las secciones del gráfico
            PiePlot plot = (PiePlot) chart.getPlot();
            
            //plot.setBackgroundPaint(Color.WHITE);
            plot.setSectionPaint("Hombres", new Color(82, 132, 178)); // Color azul #5284b2
            plot.setSectionPaint("Mujeres", new Color(226, 192, 193)); // Color rosa #e2c0c1

            // Ajusta el tamaño del gráfico
            chart.setBackgroundPaint(null);
            
            // Crea un panel para mostrar el gráfico
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setMaximumDrawWidth(800);
            chartPanel.setMaximumDrawHeight(300);
            
            // Convierte el ChartPanel a una imagen
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ChartUtilities.writeChartAsPNG(byteArrayOutputStream, chart, 800, 300);
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] imageData = byteArrayOutputStream.toByteArray();

            // Crea una imagen desde los datos de la imagen
            Image chartImage = null;
            try {
                chartImage = Image.getInstance(imageData);
            } catch (BadElementException | IOException e) {
                e.printStackTrace();
            }

            // Añade la imagen a la celda del documento
            PdfPCell chartCell = new PdfPCell(chartImage, true);
            chartCell.setColspan(3);
            chartCell.setBorder(0); // Sin bordes
            tabla.addCell(chartCell);        
        } finally {
            if (connect != null) {
                connect.close();
            }
        }
    }
    

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
