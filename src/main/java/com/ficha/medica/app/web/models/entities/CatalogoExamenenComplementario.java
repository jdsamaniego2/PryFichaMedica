package com.ficha.medica.app.web.models.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "CASOEMERGENCIA")
public class CatalogoExamenenComplementario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="IDCATALOGOEXAMCOMPL")
    private Integer idCatalogoExamComl;

    @Column(name="NOMBRE")
    @Size(max=55)
    private String Nombre;

    @Column(name="DESCRIPCION")
    @Size(max=55)
    private String Descripcion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @Column(name="NACIMIENTO")
    private Calendar fecha;

    public CatalogoExamenenComplementario() {
        super();
    }

    public CatalogoExamenenComplementario(Integer id) {
        super();
        this.idCatalogoExamComl = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdCatalogoExamComl() {
        return idCatalogoExamComl;
    }

    public void setIdCatalogoExamComl(Integer idCatalogoExamComl) {
        this.idCatalogoExamComl = idCatalogoExamComl;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
}
