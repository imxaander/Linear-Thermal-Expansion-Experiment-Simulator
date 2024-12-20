/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulation;

import java.awt.*;

/**
 *
 * @author Ison Mario
 */
public class Metal {
    public String name;
    public Float coefficient;
    public Color color;
    public String imagePath;
    Metal(String name, float coeff, Color color, String imagePath){
        this.name = name;
        this.coefficient = coeff;
        this.color = color;
        this.imagePath = imagePath;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
