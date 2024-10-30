/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Practica01.demo.dao;

import Practica01.demo.domain.arbol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface arbolDao extends JpaRepository <arbol,Long> {
    
}
