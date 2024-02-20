/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package biblioteca;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private Button dataAnalysis_btn;
    
    @FXML
    private AnchorPane nav_chart;
    
    @FXML
    private Button daily_chart_btn;
    
    @FXML
    private Button weekly_chart_btn;
    
    @FXML
    private Button monthly_chart_btn;
    
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
    private AnchorPane daily_charts;

    @FXML
    private BarChart<?, ?> totalEnrolledChart_daily; 

    @FXML
    private LineChart<?, ?> totalFemaleChart_daily;
    
    @FXML
    private LineChart<?, ?> totalMaleChart_daily;
    
    @FXML
    private AnchorPane weekly_charts;
    
    @FXML
    private BarChart<?, ?> totalEnrolledChart_weekly; 

    @FXML
    private LineChart<?, ?> totalFemaleChart_weekly;
    
    @FXML
    private LineChart<?, ?> totalMaleChart_weekly;
    
    @FXML
    private AnchorPane monthly_charts;
    
    @FXML
    private BarChart<?, ?> totalEnrolledChart_monthly; 

    @FXML
    private LineChart<?, ?> totalFemaleChart_monthly;
    
    @FXML
    private LineChart<?, ?> totalMaleChart_monthly;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    /*  -------- HEADER --------*/
    public void close(){
        
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

    public void minimize(){
        Stage stage = (Stage)main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    
    public void maximize(){
        Stage stage = (Stage)main_form.getScene().getWindow();
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

    public void displayUsername(){
        username.setText(getData.username);
    }
    
    public void defaultNav(){
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
        addStudents_btn.setStyle("-fx-background-color:transparent");
        dataAnalysis_btn.setStyle("-fx-background-color:transparent");
    }
        
    public void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            addStudents_form.setVisible(false);
            data_form.setVisible(false);


            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            dataAnalysis_btn.setStyle("-fx-background-color:transparent");

            homeDisplayTotalEnrolledStudents();
            homeDisplayMaleEnrolled();
            homeDisplayFemaleEnrolled();
            DisplayDailyChartHome();


            nav_chart.setVisible(false);


        } else if (event.getSource() == addStudents_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(true);
            data_form.setVisible(false);


            addStudents_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            home_btn.setStyle("-fx-background-color:transparent");
            dataAnalysis_btn.setStyle("-fx-background-color:transparent");

            
//            TO BECOME UPDATED ONCE YOU CLICK THE ADD STUDENTS BUTTON ON NAV
            addStudentsShowListData();

            nav_chart.setVisible(false);

        } else if (event.getSource() == dataAnalysis_btn) {
            
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_Careers.setVisible(true);
            daily_charts.setVisible(false);
            weekly_charts.setVisible(false);
            monthly_charts.setVisible(false);
            analysisCareers_pieChart.setVisible(true);
            SetFalsePieChartsCareersFM();
            legendFemaleMale.setVisible(false);
            
            dataAnalysis_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            home_btn.setStyle("-fx-background-color:transparent");
            addStudents_btn.setStyle("-fx-background-color:transparent");

            DisplayCareersPieChart();            
            
            nav_chart.setVisible(true);
            monthly_chart_btn.setStyle("-fx-background-color:transparent");
            weekly_chart_btn.setStyle("-fx-background-color:transparent");
            daily_chart_btn.setStyle("-fx-background-color:transparent");
            
            DisplayStyleButtonsCareers();
            DisplayLabelsTotalCareers();
        }
    }
    
    public void navigationChartButton(){
        if(daily_chart_btn.isFocused()){
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_Careers.setVisible(false);

            DisplayEnrolledMaleChart_daily();
            DisplayFemaleEnrolledChart_daily();
            DisplayTotalEnrolledChart_daily();
            
            nav_chart.setVisible(true);            

            daily_charts.setVisible(true);
            weekly_charts.setVisible(false);
            monthly_charts.setVisible(false);
            
           daily_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            weekly_chart_btn.setStyle("-fx-background-color:transparent");
            monthly_chart_btn.setStyle("-fx-background-color:transparent");
        
         
        }else if(weekly_chart_btn.isFocused()){
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_Careers.setVisible(false);
            
            DisplayEnrolledMaleChart_weekly();
            DisplayFemaleEnrolledChart_weekly();
            DisplayTotalEnrolledChart_weekly();
            
            nav_chart.setVisible(true);            

            daily_charts.setVisible(false);
            weekly_charts.setVisible(true);
            monthly_charts.setVisible(false);
            
            weekly_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            daily_chart_btn.setStyle("-fx-background-color:transparent");
            monthly_chart_btn.setStyle("-fx-background-color:transparent");
        
        
        }else if(monthly_chart_btn.isFocused()){
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_Careers.setVisible(false);
            
            DisplayEnrolledMaleChart_monthly();
            DisplayFemaleEnrolledChart_monthly();
            DisplayTotalEnrolledChart_monthly();
            
            nav_chart.setVisible(true);            

            daily_charts.setVisible(false);
            weekly_charts.setVisible(false);
            monthly_charts.setVisible(true);
            
            monthly_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            weekly_chart_btn.setStyle("-fx-background-color:transparent");
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
       
        String femaleSql = "SELECT fechaEntrada, COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";
        String maleSql = "SELECT fechaEntrada, COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";

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

        String sql = "SELECT historial.noControl, historial.fechaEntrada, historial.horaEntrada, alumnos.nombre, alumnos.apellidoPaterno, alumnos.apellidoMaterno, alumnos.carrera, alumnos.genero " +
                     "FROM historial " +
                     "JOIN alumnos ON historial.noControl = alumnos.noControl ORDER BY historial.fechaEntrada, historial.horaEntrada";

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

     private String agregarPrefijo(String numeroControl) {
         
        char prefijo = numeroControl.charAt(0);
        switch (prefijo) {
            case 'C':
                return "B" + numeroControl;
            case 'B':
                return "M" + numeroControl;
            case 'M':
                return "D" + numeroControl;
            default:
                return "C" + numeroControl;
        }
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

        // Mostrar un mensaje de éxito
        System.out.println("¡Agregado exitosamente!");
    }
    
     public void verificarInsercion(String numeroControl) {
        try {
            // Verificar si el número de control existe en la base de datos
            String checkData = "SELECT noControl FROM alumnos WHERE noControl = ?";
            PreparedStatement checkStatement = connect.prepareStatement(checkData);
            checkStatement.setString(1, numeroControl);
            ResultSet result = checkStatement.executeQuery();

            if (!result.next()) { // Si el número de control no se encuentra en la base de datos
                if (numeroControl.length() == 9) { // Si ya hemos añadido sufijos
                    // Mostrar mensaje de advertencia y limpiar campos
                    System.out.println("El número de control no se encuentra en la base de datos.");
                    return;
                } else {
                    // Intentar con el siguiente prefijo
                    String nuevoNumeroControl = agregarPrefijo(numeroControl);
                    verificarInsercion(nuevoNumeroControl);
                }
            } else {
                // Si el número de control se encuentra en la base de datos, proceder con la inserción
                insertarDatos(numeroControl);
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción SQL que pueda ocurrir
            e.printStackTrace();
            // Mostrar un mensaje de error
            System.out.println("Se produjo un error al intentar agregar el estudiante.");
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
                
                if(numeroControl.length() > 8){ //Verifica si lo ingresado es mayor a 8 caracteres
                
                    numeroControl = numeroControl.substring(numeroControl.length() - 8);
                    // Asignar el número de control al campo de texto
                    addStudents_noControl.setText(numeroControl);
                    
                }
                
                verificarInsercion(numeroControl);   
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Agregado exitosamente!");
                alert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                // TO CLEAR THE FIELDS
                    addStudentsClear();
                
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("¡Hola, mundo!");
       
        }
        
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
                + carrera +"' GROUP BY genero;";
        
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

        String sql = "SELECT fechaEntrada, COUNT(*) FROM historial GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";
        //String sql = "SELECT fechaEntrada, COUNT(id) FROM students GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC LIMIT 5";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            totalEnrolledChart_daily.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void DisplayFemaleEnrolledChart_daily() {
        totalFemaleChart_daily.getData().clear();

        String sql = "SELECT fechaEntrada, COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";
        //String sql = "SELECT fechaEntrada, COUNT(id) FROM students WHERE genero = 'Femenino' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC LIMIT 5";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();
            chart.setName("Mujeres");

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            totalFemaleChart_daily.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayEnrolledMaleChart_daily() {

        totalMaleChart_daily.getData().clear();

        String sql = "SELECT fechaEntrada, COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";
        //String sql = "SELECT fechaEntrada, COUNT(id) FROM students WHERE genero = 'Masculino' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC LIMIT 5";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();
            chart.setName("Hombres");

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            totalMaleChart_daily.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void DisplayTotalEnrolledChart_weekly() {
        totalEnrolledChart_weekly.getData().clear();

        // Utilizando la función WEEK() para agrupar por semana
        String sql = "SELECT WEEK(fechaEntrada), COUNT(*) FROM historial GROUP BY WEEK(fechaEntrada) ORDER BY WEEK(fechaEntrada) ASC LIMIT 5";

        try (Connection connect = database.connectDb();
             PreparedStatement prepare = connect.prepareStatement(sql);
             ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();

            while (result.next()) {
                // Puedes personalizar la presentación de la semana según tus necesidades
                String semana = "Semana " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(semana, result.getInt(2)));
            }

            totalEnrolledChart_weekly.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void DisplayFemaleEnrolledChart_weekly() {
        totalFemaleChart_weekly.getData().clear();

        // Utilizando la función WEEK() para agrupar por semana
        String sql = "SELECT WEEK(fechaEntrada), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F' GROUP BY WEEK(fechaEntrada) ORDER BY WEEK(fechaEntrada) ASC LIMIT 5";

        try (Connection connect = database.connectDb();
             PreparedStatement prepare = connect.prepareStatement(sql);
             ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Mujeres");

            while (result.next()) {
                // Puedes personalizar la presentación de la semana según tus necesidades
                String semana = "Semana " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(semana, result.getInt(2)));
            }

            totalFemaleChart_weekly.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayEnrolledMaleChart_weekly() {
        totalMaleChart_weekly.getData().clear();
        // Utilizando la función WEEK() para agrupar por semana
        String sql = "SELECT WEEK(fechaEntrada), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M' GROUP BY WEEK(fechaEntrada) ORDER BY WEEK(fechaEntrada) ASC LIMIT 5";

        try (Connection connect = database.connectDb();
             PreparedStatement prepare = connect.prepareStatement(sql);
             ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Hombres");

            while (result.next()) {
                // Puedes personalizar la presentación de la semana según tus necesidades
                String semana = "Semana " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(semana, result.getInt(2)));
            }

            totalMaleChart_weekly.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void DisplayTotalEnrolledChart_monthly() {
        totalEnrolledChart_monthly.getData().clear();

        // Utilizando la función MONTH() para agrupar por mes
        String sql = "SELECT DATE_FORMAT(fechaEntrada, '%Y-%m'), COUNT(*) FROM historial GROUP BY DATE_FORMAT(fechaEntrada, '%Y-%m') ORDER BY DATE_FORMAT(fechaEntrada, '%Y-%m') ASC";

        try (Connection connect = database.connectDb();
             PreparedStatement prepare = connect.prepareStatement(sql);
             ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();

            while (result.next()) {
                // Puedes personalizar la presentación del mes según tus necesidades
                String mes = "Mes " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(mes, result.getInt(2)));
            }

            totalEnrolledChart_monthly.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayFemaleEnrolledChart_monthly() {
        totalFemaleChart_monthly.getData().clear();

        // Utilizando la función MONTH() para agrupar por mes
        String sql = "SELECT DATE_FORMAT(fechaEntrada, '%Y-%m'), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'F' GROUP BY DATE_FORMAT(fechaEntrada, '%Y-%m') ORDER BY DATE_FORMAT(fechaEntrada, '%Y-%m') ASC";

        try (Connection connect = database.connectDb();
             PreparedStatement prepare = connect.prepareStatement(sql);
             ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Mujeres");

            while (result.next()) {
                // Puedes personalizar la presentación del mes según tus necesidades
                String mes = "Mes " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(mes, result.getInt(2)));
            }

            totalFemaleChart_monthly.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DisplayEnrolledMaleChart_monthly() {
        totalMaleChart_monthly.getData().clear();

        // Utilizando la función MONTH() para agrupar por mes
        String sql = "SELECT DATE_FORMAT(fechaEntrada, '%Y-%m'), COUNT(*) FROM historial h JOIN alumnos a ON h.noControl = a.noControl WHERE a.genero = 'M' GROUP BY DATE_FORMAT(fechaEntrada, '%Y-%m') ORDER BY DATE_FORMAT(fechaEntrada, '%Y-%m') ASC";

        try (Connection connect = database.connectDb();
             PreparedStatement prepare = connect.prepareStatement(sql);
             ResultSet result = prepare.executeQuery()) {

            XYChart.Series chart = new XYChart.Series();
            chart.setName("Hombres");

            while (result.next()) {
                // Puedes personalizar la presentación del mes según tus necesidades
                String mes = "Mes " + result.getString(1);
                chart.getData().add(new XYChart.Data<>(mes, result.getInt(2)));
            }

            totalMaleChart_monthly.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Función para aparecer las graficas individuales de cada carrera
    public void navigationCarrersChartButton(){
        if(IDIN_chart_btn.isFocused()){
            SetFalsePieChartsCareersFM();
            idinPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA EN DISEÑO INDUSTRIAL", totalFemaleMaleIDIN_chart);
            
            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);
            
            DisplayStyleButtonsCareers();
            IDIN_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #0D111B, #364774);");
         
        } else if(ADM_chart_btn.isFocused()){
            SetFalsePieChartsCareersFM();
            admPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("LICENCIATURA EN ADMINISTRACION", totalFemaleMaleADM_chart);
            
            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);
            
            DisplayStyleButtonsCareers();
            ADM_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #23164C, #4B30A3);");
            
        } else if(ISC_chart_btn.isFocused()){
            SetFalsePieChartsCareersFM();
            iscPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA EN SISTEMAS COMPUTACIONALES", totalFemaleMaleISC_chart);
            
            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);
            
            DisplayStyleButtonsCareers();
            ISC_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2A435B, #5284B2);");
            
        } else if(IINF_chart_btn.isFocused()){
            SetFalsePieChartsCareersFM();
            iinfPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA INFORMATICA", totalFemaleMaleIINF_chart);
            
            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);
            
            DisplayStyleButtonsCareers();
            IINF_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #092615, #1F7C46);");
            
        } else if(IIND_chart_btn.isFocused()){
            SetFalsePieChartsCareersFM();
            iindPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA INDUSTRIAL", totalFemaleMaleIIND_chart);
            
            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);
            
            DisplayStyleButtonsCareers();
            IIND_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #847C24, #DCCE3C);");
            
        } else if(IGE_chart_btn.isFocused()){
            SetFalsePieChartsCareersFM();
            igePieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("INGENIERIA EN GESTION EMPRESARIAL", totalFemaleMaleIGE_chart);
            
            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);
            
            DisplayStyleButtonsCareers();
            IGE_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #7A3E25, #D1693E);");
            
        } else if(ARQ_chart_btn.isFocused()){
            SetFalsePieChartsCareersFM();
            arquiPieChart_AP.setVisible(true);

            DisplayCareersFemaleMalePieChart("ARQUITECTURA", totalFemaleMaleARQ_chart);
            
            analysisCareers_pieChart.setVisible(false);
            legendFemaleMale.setVisible(true);
            
            DisplayStyleButtonsCareers();
            ARQ_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #401312, #972D2A);");
            
        }
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        displayUsername();
        defaultNav();
             
        homeDisplayTotalEnrolledStudents();
        homeDisplayMaleEnrolled();
        homeDisplayFemaleEnrolled();
        DisplayDailyChartHome();
                
        DisplayCareersPieChart();            
        DisplayEnrolledMaleChart_daily();
        DisplayFemaleEnrolledChart_daily();
        DisplayTotalEnrolledChart_daily();
        DisplayEnrolledMaleChart_weekly();
        DisplayFemaleEnrolledChart_weekly();
        DisplayTotalEnrolledChart_weekly();
        DisplayEnrolledMaleChart_monthly();
        DisplayFemaleEnrolledChart_monthly();
        DisplayTotalEnrolledChart_monthly();
        // To show inmediately when we proceed to dashboard application form
        addStudentsShowListData();
        

    }
    
    //ESTILOS DE LOS BOTONES DE LAS CARRERAS
    public void IDINButtonStyle(){
        IDIN_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #364774, #607CC8);");
    }
    
    public void ADMButtonStyle(){
        ADM_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #4B30A3, #6D74E5);");
    }
    
    public void ISCButtonStyle(){
        ISC_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #5284B2, #96DEFA);");
    }
    
    public void IINFButtonStyle(){
        IINF_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #1F7C46, #33D577);");
    }
    
    public void IINDButtonStyle(){
        IIND_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #DCCE3C, #FFF45D);");
    }
    
    public void IGEButtonStyle(){
        IGE_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #D1693E, #FF933E);");
    }
    
    public void ARQButtonStyle(){
        ARQ_chart_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #972D2A, #FF4A47);");
    }
    
    public void DisplayStyleButtonsCareers(){
        IDINButtonStyle();
        ADMButtonStyle();
        ISCButtonStyle();
        IINFButtonStyle();
        IINDButtonStyle();
        IGEButtonStyle();
        ARQButtonStyle();
    }
    
    //Función para desplegar en cada etiqueta correspondiente cuantos alumnos ingresaron por carrera
    public void DisplayLabelsTotalCareers(){
        DisplayTotalByCareer("INGENIERIA EN DISEÑO INDUSTRIAL", totalIDIN);
        DisplayTotalByCareer("INGENIERIA INDUSTRIAL", totalIIND);
        DisplayTotalByCareer("INGENIERIA EN SISTEMAS COMPUTACIONALES", totalISC);
        DisplayTotalByCareer("INGENIERIA INFORMATICA", totalIINF);
        DisplayTotalByCareer("LICENCIATURA EN ADMINISTRACION", totalADM);
        DisplayTotalByCareer("INGENIERIA EN GESTION EMPRESARIAL", totalIGE);
        DisplayTotalByCareer("ARQUITECTURA", totalARQ);
    }
    
    public void SetFalsePieChartsCareersFM(){
        idinPieChart_AP.setVisible(false);
        admPieChart_AP.setVisible(false);
        iscPieChart_AP.setVisible(false);
        iinfPieChart_AP.setVisible(false);
        iindPieChart_AP.setVisible(false);
        igePieChart_AP.setVisible(false);
        arquiPieChart_AP.setVisible(false);
    }
}
