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

    private Text titleScreenText = new Text("Linear Thermal Expansion Experiment Simulator", StyleConfig.getWindowCenterWidth(StyleConfig.TITLE_SCREEN_TEXT_WIDTH),  StyleConfig.MAIN_WINDOW_HEIGHT/2 - 60, 500, 30, 20f, 3);
    private Text titleScreenSubText1 = new Text("Welcome to our simulation project!", 380,  StyleConfig.MAIN_WINDOW_HEIGHT/2 - 15, 550, 30, 17f, 4);
    private Text titleScreenSubText2 = new Text("This project was created\n by Group 4 to provide users with an interactive experience of conducting a", 180,  300, 800, 30, 17f, 4);
    private Text titleScreenSubText3 = new Text("linear expansion experiment.", 400,  320, 800, 30, 17f, 4);
    
    Image logo = new Image("assets/Images/logo.png");
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
        
        logo.setBounds(462, 90, 100, 100);
        this.add(startButton);
        this.add(titleScreenText);
        this.add(titleScreenSubText1);
        this.add(titleScreenSubText2);
        this.add(titleScreenSubText3);
        this.add(logo);
    }

    public static void OpenSimulationScreen(){
        Main.TS.setVisible(false);
        Main.SS.setVisible(true);
    }
}
