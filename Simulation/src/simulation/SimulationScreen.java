/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static simulation.Main.SC;

/**
 *
 * @author Xander Ison
 */
public class SimulationScreen extends JFrame{
    
    //start button
    Text titleScreenText = new Text("Linear asdadlator", StyleConfig.getWindowCenterWidth(StyleConfig.TITLE_SCREEN_TEXT_WIDTH),  StyleConfig.MAIN_WINDOW_HEIGHT/2 - 40, 500, 30, 20f, 3);
    Text titleScreenSubText = new Text("This experiment simulation project was created by Group 4 ", StyleConfig.getWindowCenterWidth(StyleConfig.TITLE_SCREEN_TEXT_WIDTH),  StyleConfig.MAIN_WINDOW_HEIGHT/2 - 15, 550, 30, 17f, 5);
    
    //simulation elements
    
    DropDownBox MetalSelector = new DropDownBox(SC.METAL_SELECTOR_X, SC.METAL_SELECTOR_Y, SC.METAL_SELECTOR_WIDTH, SC.METAL_SELECTOR_HEIGHT); 
    Metal Metals[] = new Metal[100];
    
    
    SimulationScreen(){
        
        //size settings for this title screen
        this.setSize(StyleConfig.MAIN_WINDOW_WIDTH, StyleConfig.MAIN_WINDOW_HEIGHT);
        this.setTitle("Linear Thermal Expansion Experiment Simulator - Simulation");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        this.add(titleScreenText);
        this.add(titleScreenSubText);
        
        
        UpdateMetalSelector();
        this.add(MetalSelector);
        //set the visibility of the window to true :D
    }
    
    void UpdateMetalSelector(){
        //initialize the metals that we are going to use
        for(int i = 0; i < StyleConfig.DEFAULT_METAL_COUNT; i++){
            Metals[i] = new Metal(StyleConfig.DEFAULT_METAL_NAMES[i], StyleConfig.DEFAULT_METAL_COEFFS[i], StyleConfig.DEFAULT_METAL_COLORS[i]);
        }
        
        for(Metal metal : this.Metals){
            if(metal != null){
                MetalSelector.addItem(metal);
            }
        }
    }
    
}
