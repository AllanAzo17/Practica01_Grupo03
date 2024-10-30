/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica01.demo.controller;


import Practica01.demo.domain.arbol;
import Practica01.demo.Service.arbolService;
import Practica01.demo.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/arbol")



public class arbolController {
    
    @Autowired
    arbolService arbolService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var arbol = arbolService.getArbol(false);
        model.addAttribute("arboles", arbol);
        model.addAttribute("totalarboles", arbol.size());
        return "/arbol/listado";
    }
    @GetMapping("/nuevo")
    public String arbolNuevo(arbol arbol) {
        return "/arbol/modifica";
    }
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String arbolGuardar(arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(imagenFile, "arbol" ,arbol.getArbolId()));
        }
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }
    

    @GetMapping("/eliminar/{arbolId}")
     public String arbolEliminar(arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{arbolId}")
    public String arbolModificar(arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }   
    
}
