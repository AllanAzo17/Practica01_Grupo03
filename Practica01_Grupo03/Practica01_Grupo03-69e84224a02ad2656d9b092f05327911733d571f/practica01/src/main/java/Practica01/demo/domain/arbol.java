/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica01.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="arbol")
public class arbol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="arbol_id")
    private Long arbolId;  
    private String nombreComun;
    private String tipoFlor;
    private String durezaMadera;
    private Double alturaPromedio;
    private String rutaImagen;

    
    private boolean activo;

    public arbol() {
        
        
    }
    public arbol(String arbol, boolean activo) {
        this.nombreComun = arbol;
        this.activo = activo;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
}
