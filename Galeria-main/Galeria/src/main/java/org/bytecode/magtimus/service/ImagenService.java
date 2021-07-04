/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bytecode.magtimus.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import org.bytecode.magtimus.Generar;
import org.bytecode.magtimus.entity.Imagen;
import org.bytecode.magtimus.repository.ImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jose David
 */
@Service
public class ImagenService {
    @Autowired
    private ImagenRepositorio repo;
    
    public List<Imagen> find(Pageable page){
        return repo.findAll(page).getContent();
    }
    
    public String saveImage(MultipartFile file){
        String ruta = "";

        if (!file.isEmpty()){
            byte[] bytes;
            try {
                bytes = file.getBytes();

                String nombre = Generar.code()+file.getOriginalFilename();

                Path path = Paths.get(".//src//main//resources//static//images//"+nombre);

                String tipo = file.getContentType();

                switch(tipo){
                    case "image/png":
                        Files.write(path, bytes);
                        ruta = "/images/"+nombre;
                        break;
                    case "image/jpg":
                        Files.write(path, bytes);
                        ruta = "/images/"+nombre;
                        break;
                    case "image/jpeg":
                        Files.write(path, bytes);
                        ruta = "/images/"+nombre;
                        break;
                    case "image/gif":
                        Files.write(path, bytes);
                        ruta = "/images/"+nombre;
                        break;
                    default:
                        ruta = "";
                        break;
                }
            } catch (IOException ex) {
                ruta = "";
            }
        }
        return ruta;
    }
    
    public void guardarImg(String titulo, String ruta){
        Imagen img = new Imagen();
        img.setRuta(ruta);
        img.setTitulo(titulo);
        img.setFecha(new Date());
        
        repo.save(img);
    }
}
