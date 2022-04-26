/**
 * 
 */
package com.mitienda.clientes.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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

    @NotNull
    @Min(5)
    @Max(50)
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @NotNull
    @Min(2)
    private String nombres;

    @NotNull
    @Min(5)
    @Column(nullable = false)
    private String apellidos;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @NotNull
    @Min(1)
    @Max(30)
    @Column(nullable = false, length = 10)
    private String genero;

    @NotNull
    @Min(5)
    @Column(nullable = false)
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

    public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
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
