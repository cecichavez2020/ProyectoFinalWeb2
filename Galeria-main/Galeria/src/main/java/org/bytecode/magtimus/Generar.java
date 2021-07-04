/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bytecode.magtimus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Jose David
 */
public class Generar {
    
    
    public static String code(){
        return new SimpleDateFormat("ddMyyyhhmmss").format(new Date())+new Random().nextLong();
    }
    
}
