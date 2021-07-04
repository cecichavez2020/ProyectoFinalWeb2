/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bytecode.magtimus.repository;

import java.io.Serializable;
import org.bytecode.magtimus.entity.Imagen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose David
 */
@Repository
public interface ImagenRepositorio extends PagingAndSortingRepository<Imagen, Serializable>{
    
    @Query("select i from Imagen i order by i.fecha desc")
    public abstract Page<Imagen> findAll(Pageable page);
    
}
