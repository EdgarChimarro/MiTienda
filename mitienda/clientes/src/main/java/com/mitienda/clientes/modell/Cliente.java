/**
 * 
 */
package com.mitienda.clientes.modell;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

/**
 * @author Edgar Chimarro
 *
 */
@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nombres;

    private String apellidos;

    @Column(nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDateTime fechaRegistro;

    private String genero;

    private String numeroTelefono;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getNombres() {
	return nombres;
    }

    public void setNombres(String nombres) {
	this.nombres = nombres;
    }

    public String getApellidos() {
	return apellidos;
    }

    public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
    }

    public LocalDateTime getFechaRegistro() {
	return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
	this.fechaRegistro = fechaRegistro;
    }

    public String getGenero() {
	return genero;
    }

    public void setGenero(String genero) {
	this.genero = genero;
    }

    public String getNumeroTelefono() {
	return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
	this.numeroTelefono = numeroTelefono;
    }

}
