/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bytecode.magtimus.controller;

import org.bytecode.magtimus.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jose David
 */
@Controller
@RequestMapping("/image")
public class Controlador {
    @Autowired
    private ImagenService service;
    
    @GetMapping("/all")
    public ModelAndView find(Pageable page){
        ModelAndView md = new ModelAndView("index");
        md.addObject("imgs", service.find(page));
        return md;
    }    
    
    @PostMapping("/upload")
    @ResponseBody
    public String ruta_subida(
            @RequestParam("img") MultipartFile file
    ){
        return service.saveImage(file);
    }
    
    @PostMapping("/register")
    @ResponseBody
    public String inser(@RequestParam("titulo")String titulo, @RequestParam("ruta")String ruta) {
        service.guardarImg(titulo, ruta);
        return "/image/all?page=0&size=9";
    }
}
