/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bytecode.magtimus.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Jose David
 */
@Table(name = "imagen")
@Entity
public class Imagen implements Serializable{
    @GeneratedValue
    @Id
    @Column(name = "idimagen")
    private Long idimagen;
    
    @Column(name = "ruta")
    private String ruta;
    
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "fecha")
    @DateTimeFormat
    private Date fecha; 

    public Long getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(Long idimagen) {
        this.idimagen = idimagen;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
