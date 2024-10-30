/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Practica01.demo.Service;

import Practica01.demo.domain.arbol;
import java.util.List; 

public interface arbolService {
    
       public List<arbol> getArbol(boolean activo);

    // Se obtiene un Categoria, a partir del id de un categoria
    public arbol getArbol(arbol arbol);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(arbol arbol);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(arbol arbol);
    
}
