/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica01.demo.impl;

import Practica01.demo.dao.arbolDao;
import Practica01.demo.domain.arbol;
import Practica01.demo.Service.arbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class arbolServiceImpl implements arbolService {
    
    @Autowired
    private arbolDao arbolDao;

    @Override
    @Transactional(readOnly = true)
    public List<arbol> getArbol(boolean activo) {
        var lista = arbolDao.findAll();
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public arbol getArbol(arbol arbol) {
        return arbolDao.findById(arbol.getArbolId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    @Transactional
    public void delete(arbol arbol) {
        arbolDao.delete(arbol);
    }
    
}
