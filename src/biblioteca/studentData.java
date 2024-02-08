/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.sql.Date;
import java.time.LocalTime;

/**
 *
 * @author bombo
 */
/*public class studentData {
    private String noControl;
    private LocalTime horaEntrada;
    private Date fechaEntrada;

    // MAKE SURE THAT SAME DATATYPE THAT YOU WILL PUT THERE 
    public studentData(String noControl, Date fechaEntrada, LocalTime horaEntrada) {
        this.noControl = noControl;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
    }
    
    public String getNoControl() {
        return noControl;
    }
    
    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }
}*/

    public class studentData {
    private String noControl;
    private Date fechaEntrada;
    private LocalTime horaEntrada;
    
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String carrera;
    private String genero;


    // MAKE SURE THAT SAME DATATYPE THAT YOU WILL PUT THERE 
    public studentData(String noControl, String nombre, String apellidoPaterno, String apellidoMaterno, String carrera, String genero, Date fechaEntrada, LocalTime horaEntrada) {
        this.noControl = noControl;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.carrera = carrera;
        this.genero = genero;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
    }
    
    public String getNoControl() {
        return noControl;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getGenero() {
        return genero;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }
    
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }


}
