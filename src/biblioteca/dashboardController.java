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
    private TextField addStudents_nombre;

    @FXML
    private TextField addStudents_noControl;

    @FXML
    private TextField addStudents_apellidoMaterno;

    @FXML
    private TextField addStudents_apellidoPaterno;
    
    @FXML
    private ComboBox<?> addStudents_genero;
    
    @FXML
    private ComboBox<?> addStudents_carrera;

    @FXML
    private Button addStudents_clearBtn;

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private Button addStudents_updateBtn;

    @FXML
    private Button addStudents_deleteBtn;

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
    private AnchorPane analysis_FemaleMale;
    
    @FXML
    private LineChart<?, ?> totalFemaleMaleChart;
    
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
            addStudentsListaCarrera();
            addStudentsGenderList();
            addStudentsSearch();
            
            nav_chart.setVisible(false);

        } else if (event.getSource() == dataAnalysis_btn) {
            
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_FemaleMale.setVisible(true);
            daily_charts.setVisible(false);
            weekly_charts.setVisible(false);
            monthly_charts.setVisible(false);

            
            dataAnalysis_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #2c4277, #a4a4cc);");
            home_btn.setStyle("-fx-background-color:transparent");
            addStudents_btn.setStyle("-fx-background-color:transparent");

            DisplayTotalFemaleMaleChart();            
            
            nav_chart.setVisible(true);
            monthly_chart_btn.setStyle("-fx-background-color:transparent");
            weekly_chart_btn.setStyle("-fx-background-color:transparent");
            daily_chart_btn.setStyle("-fx-background-color:transparent");
            
        }
    }
    
    public void navigationChartButton(){
        if(daily_chart_btn.isFocused()){
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            data_form.setVisible(true);
            analysis_FemaleMale.setVisible(false);

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
            analysis_FemaleMale.setVisible(false);
            
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
            analysis_FemaleMale.setVisible(false);
            
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

        String sql = "SELECT COUNT(id) FROM students";

        connect = database.connectDb();

        int countEnrolled = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countEnrolled = result.getInt("COUNT(id)");
            }

            home_totalEnrolled.setText(String.valueOf(countEnrolled));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void homeDisplayFemaleEnrolled() {

        String sql = "SELECT COUNT(id) FROM students WHERE genero = 'Femenino'";

        connect = database.connectDb();

        try {
            int countFemale = 0;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countFemale = result.getInt("COUNT(id)");
            }

            home_totalFemale.setText(String.valueOf(countFemale));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayMaleEnrolled() {

        String sql = "SELECT COUNT(id) FROM students WHERE genero = 'Masculino'";

        connect = database.connectDb();

        try {
            int countMale = 0;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countMale = result.getInt("COUNT(id)");
            }
            home_totalMale.setText(String.valueOf(countMale));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
        public void DisplayDailyChartHome() {
        dailyChartHome.getData().clear();

        String femaleSql = "SELECT fechaEntrada, COUNT(id) FROM students WHERE genero= 'Femenino' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";
        String maleSql = "SELECT fechaEntrada, COUNT(id) FROM students WHERE genero= 'Masculino' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";

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

    
/*  -------- ADD STUDENTS --------*/
    public void addStudentsAdd() {

        String insertData = "INSERT INTO students "
                + "(noControl,nombre,apellidoPaterno,apellidoMaterno,carrera,genero,horaEntrada,fechaEntrada) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;

            if (addStudents_noControl.getText().isEmpty()
                    || addStudents_nombre.getText().isEmpty()
                    || addStudents_apellidoPaterno.getText().isEmpty()
                    || addStudents_apellidoMaterno.getText().isEmpty()
                    || addStudents_carrera.getSelectionModel().getSelectedItem() == null
                    || addStudents_genero.getSelectionModel().getSelectedItem() == null
                    /*|| addStudents_horaEntrada.getValue() == null*/
                    /*|| addStudents_fechaEntrada.getValue() == null*/ ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Llene todos los campos!");
                alert.showAndWait();
            } else {
                // CHECK IF THE STUDENTNUMBER IS ALREADY EXIST
                String checkData = "SELECT noControl FROM students WHERE noControl = '"
                        + addStudents_noControl.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("N° Control " + addStudents_noControl.getText() + " ya existe");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, addStudents_noControl.getText());
                    prepare.setString(2, addStudents_nombre.getText());
                    prepare.setString(3, addStudents_apellidoPaterno.getText());
                    prepare.setString(4, addStudents_apellidoMaterno.getText());
                    prepare.setString(5, (String) addStudents_carrera.getSelectionModel().getSelectedItem());
                    prepare.setString(6, (String) addStudents_genero.getSelectionModel().getSelectedItem());
                    //prepare.setString(7, String.valueOf(addStudents_horaEntrada.getValue()));
                    //prepare.setString(8, String.valueOf(addStudents_fechaEntrada.getValue()));
                    
                    LocalTime horaEntrada = LocalTime.now();
                    Time sqlTime = Time.valueOf(horaEntrada);
                    //java.sql.Time sqlTime = new java.sql.Time(horaEntrada.getTime());
                    prepare.setString(7, String.valueOf(sqlTime));

                    
                    Date fechaEntrada = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(fechaEntrada.getTime());
                    prepare.setString(8, String.valueOf(sqlDate));

                    prepare.executeUpdate();

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
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudentsUpdate() {

        String updateData = "UPDATE students SET "
                + "nombre = '" + addStudents_nombre.getText()
                + "', apellidoPaterno = '" + addStudents_apellidoPaterno.getText()
                + "', apellidoMaterno = '" + addStudents_apellidoMaterno.getText()
                + "', carrera = '" + addStudents_carrera.getSelectionModel().getSelectedItem()
                + "', genero = '" + addStudents_genero.getSelectionModel().getSelectedItem()
                + "' WHERE noControl = '"
                + addStudents_noControl.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (addStudents_noControl.getText().isEmpty()
                    || addStudents_nombre.getText().isEmpty()
                    || addStudents_apellidoPaterno.getText().isEmpty()
                    || addStudents_apellidoMaterno.getText().isEmpty()
                    || addStudents_carrera.getSelectionModel().getSelectedItem() == null
                    || addStudents_genero.getSelectionModel().getSelectedItem() == null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Llene todos los campos!");
                alert.showAndWait();
            } else {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Seguro que quiere modificar los datos del N° Control " + addStudents_noControl.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Modificado exitosamente!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();

                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addStudentsDelete() {

        String deleteData = "DELETE FROM students WHERE noControl = '"
                + addStudents_noControl.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Seguro que quiere eliminar al alumno con el N° Control " + addStudents_noControl.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);                
                
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Eliminado exitosamente!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();
                }else return;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void addStudentsClear() {
        addStudents_noControl.setText("");
        addStudents_nombre.setText("");
        addStudents_apellidoPaterno.setText("");
        addStudents_apellidoMaterno.setText("");
        addStudents_carrera.getSelectionModel().clearSelection();
        addStudents_genero.getSelectionModel().clearSelection();
    }
    
     public void addStudentsSearch() {

        FilteredList<studentData> filter = new FilteredList<>(addStudentsListD, e -> true);

        addStudents_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateStudentData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateStudentData.getNoControl().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getCarrera().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getNombre().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getApellidoPaterno().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getApellidoMaterno().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getGenero().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getHoraEntrada().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getFechaEntrada().toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<studentData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(addStudents_tableView.comparatorProperty());
        addStudents_tableView.setItems(sortList);
     }

    private String[] ListaCarrera = {
        "Ingeniería Indistrial", 
        "Ingeniería en Diseño Indistrial", 
        "Ingeniería en Sistemas Computacionales", 
        "Ingeniería Informática", 
        "Ingeniería en Gestión Empresarial", 
        "Licenciatura en Administración", 
        "Arquitectura"};

    public void addStudentsListaCarrera() {

        List<String> carreraL = new ArrayList<>();

        for (String data : ListaCarrera) {
            carreraL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(carreraL);
        addStudents_carrera.setItems(ObList);

    }

    private String[] genderList = {"Femenino", "Masculino"};

    public void addStudentsGenderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        addStudents_genero.setItems(ObList);
    }
    
    public ObservableList<studentData> addStudentsListData() {

        ObservableList<studentData> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT * FROM students";

        connect = database.connectDb();

        try {
            studentData studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new studentData(result.getInt("noControl"),
                        result.getString("nombre"),
                        result.getString("apellidoPaterno"),
                        result.getString("apellidoMaterno"),
                        result.getString("carrera"),
                        result.getString("genero"),
                        LocalTime.parse(result.getString("horaEntrada")),
                        result.getDate("fechaEntrada"));
                                                
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
        addStudents_col_horaEntrada.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
        addStudents_col_fechaEntrada.setCellValueFactory(new PropertyValueFactory<>("fechaEntrada"));

        addStudents_tableView.setItems(addStudentsListD);
    }
    
    public void addStudentsSelect() {

        studentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
        int num = addStudents_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addStudents_noControl.setText(String.valueOf(studentD.getNoControl()));
        addStudents_nombre.setText(studentD.getNombre());
        addStudents_apellidoPaterno.setText(studentD.getApellidoPaterno());
        addStudents_apellidoMaterno.setText(studentD.getApellidoMaterno());
    }
    
     /*  -------- DATA ANALYSIS --------*/
    
    public void DisplayTotalFemaleMaleChart() {
        totalFemaleMaleChart.getData().clear();

        String femaleSql = "SELECT fechaEntrada, COUNT(id) FROM students WHERE genero = 'Femenino' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";
        String maleSql = "SELECT fechaEntrada, COUNT(id) FROM students WHERE genero = 'Masculino' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";

        connect = database.connectDb();

        try {
            XYChart.Series femaleSeries = new XYChart.Series();
            femaleSeries.setName("Mujeres");

            prepare = connect.prepareStatement(femaleSql);
            result = prepare.executeQuery();

            while (result.next()) {
                femaleSeries.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            totalFemaleMaleChart.getData().add(femaleSeries);

            XYChart.Series maleSeries = new XYChart.Series();
            maleSeries.setName("Hombres");

            prepare = connect.prepareStatement(maleSql);
            result = prepare.executeQuery();

            while (result.next()) {
                maleSeries.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            totalFemaleMaleChart.getData().add(maleSeries);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void DisplayTotalEnrolledChart_daily() {
        totalEnrolledChart_daily.getData().clear();

        String sql = "SELECT fechaEntrada, COUNT(id) FROM students GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";
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

        String sql = "SELECT fechaEntrada, COUNT(id) FROM students WHERE genero = 'Femenino' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";
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

        String sql = "SELECT fechaEntrada, COUNT(id) FROM students WHERE genero = 'Masculino' GROUP BY fechaEntrada ORDER BY TIMESTAMP(fechaEntrada) ASC";
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
        String sql = "SELECT WEEK(fechaEntrada), COUNT(id) FROM students GROUP BY WEEK(fechaEntrada) ORDER BY WEEK(fechaEntrada) ASC LIMIT 5";

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
        String sql = "SELECT WEEK(fechaEntrada), COUNT(id) FROM students WHERE genero = 'Femenino' GROUP BY WEEK(fechaEntrada) ORDER BY WEEK(fechaEntrada) ASC LIMIT 5";

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
        String sql = "SELECT WEEK(fechaEntrada), COUNT(id) FROM students WHERE genero = 'Masculino' GROUP BY WEEK(fechaEntrada) ORDER BY WEEK(fechaEntrada) ASC LIMIT 5";

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
        String sql = "SELECT DATE_FORMAT(fechaEntrada, '%Y-%m'), COUNT(id) FROM students GROUP BY DATE_FORMAT(fechaEntrada, '%Y-%m') ORDER BY DATE_FORMAT(fechaEntrada, '%Y-%m') ASC";
        
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
        String sql = "SELECT DATE_FORMAT(fechaEntrada, '%Y-%m'), COUNT(id) FROM students WHERE genero = 'Femenino' GROUP BY DATE_FORMAT(fechaEntrada, '%Y-%m') ORDER BY DATE_FORMAT(fechaEntrada, '%Y-%m') ASC";

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
        String sql = "SELECT DATE_FORMAT(fechaEntrada, '%Y-%m'), COUNT(id) FROM students WHERE genero = 'Masculino' GROUP BY DATE_FORMAT(fechaEntrada, '%Y-%m') ORDER BY DATE_FORMAT(fechaEntrada, '%Y-%m') ASC";

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

    @Override
    public void initialize(URL location, ResourceBundle resources){
        displayUsername();
        defaultNav();
             
        homeDisplayTotalEnrolledStudents();
        homeDisplayMaleEnrolled();
        homeDisplayFemaleEnrolled();
        DisplayDailyChartHome();
                
        DisplayTotalFemaleMaleChart();            
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
        addStudentsListaCarrera();
        addStudentsGenderList();
        
    }
}
