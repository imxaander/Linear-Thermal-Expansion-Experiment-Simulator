/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Xander Ison
 */
public class TitleScreen extends JFrame{
    
    //start button
    private Button startButton = new Button("Start", StyleConfig.getWindowCenterWidth(StyleConfig.BUTTON_WIDTH), StyleConfig.MAIN_WINDOW_HEIGHT - StyleConfig.BUTTON_WIDTH  - 20);

    private Text titleScreenText = new Text("Linear Thermal Expansion Experiment Simulator", StyleConfig.getWindowCenterWidth(StyleConfig.TITLE_SCREEN_TEXT_WIDTH),  StyleConfig.MAIN_WINDOW_HEIGHT/2 - 40, 500, 30, 20f, 3);
    private Text titleScreenSubText = new Text("This experiment simulation project was created by Group 4 ", StyleConfig.getWindowCenterWidth(StyleConfig.TITLE_SCREEN_TEXT_WIDTH),  StyleConfig.MAIN_WINDOW_HEIGHT/2 - 15, 550, 30, 17f, 5);

    TitleScreen(){
        //size settings for this title screen
        this.setSize(StyleConfig.MAIN_WINDOW_WIDTH, StyleConfig.MAIN_WINDOW_HEIGHT);
        this.setTitle("Linear Thermal Expansion Experiment Simulator - Launcher");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        //addition of elements :>      
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { 
                OpenSimulationScreen();
            } 
        });
        
        this.add(startButton);
        this.add(titleScreenText);
        this.add(titleScreenSubText);
    }

    public static void OpenSimulationScreen(){
        System.out.print("asd");
        Main.TS.setVisible(false);
        Main.SS.setVisible(true);
    }
}
