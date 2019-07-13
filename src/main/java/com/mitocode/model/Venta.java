package com.mitocode.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	
	@Column(name="fecha", nullable=false)
	private LocalDateTime fecha;		
	
	@ManyToOne
	@JoinColumn(name = "idpersona", nullable = false, foreignKey = @ForeignKey(name = "fk_venta_persona"))
	private Persona idPersona; 
	
	@Column(name="importe",nullable=false)
	private double importe;
}
