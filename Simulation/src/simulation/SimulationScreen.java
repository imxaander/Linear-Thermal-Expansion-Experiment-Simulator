/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import static simulation.Main.SC;

/**
 *
 * @author Xander Ison
 */
public class SimulationScreen extends JFrame{    
    //simulation elements
    boolean isSimulationRunning = false;
    DropDownBox MetalSelector = new DropDownBox(SC.METAL_SELECTOR_X, SC.METAL_SELECTOR_Y, SC.METAL_SELECTOR_WIDTH, SC.METAL_SELECTOR_HEIGHT); 
    Metal Metals[] = new Metal[100];
    
    //wrapper for textboxes
    Panel inputBoxesPanel = new Panel();
    
    InputBox roomTempInput = new InputBox();
    Text roomTempText = new Text("Room Temp:", 15, 10, 500, 30, 17f, 3);
    
    InputBox steamTempInput = new InputBox();
    Text steamTempText = new Text("Steam Temp:", 15, 42, 500, 30, 17f, 3);
    
    InputBox initialLengthInput = new InputBox();
    Text initialLengthText = new Text("Initial Length:", 300, 10, 500, 30, 17f, 3);
    
    Text finalLengthText = new Text("Final Length:", 650, 40, 500, 30, 17f, 3);
    Text finalLengthValueText = new Text("??", 850 , 40, 500, 30, 17f, 3);

    Text changeInLengthText = new Text("Change in Length:", 650, 10, 500, 30, 17f, 3);
    Text changeInLengthValueText = new Text("??", 850, 10, 500, 30, 17f, 3);

    Button startSimulationButton = new Button("Start Simulation", 0, 0);
    
    //images
    Image baseImage = new Image("assets/Images/base.png");
    Image steamGeneratorImage = new Image("assets/Images/steamgenerator.png");
    Image rulerImage = new Image("assets/Images/ruler.png");
    Image metalRodImage = new Image("assets/Images/metalrod.png");
    Image thermometerImage = new Image("assets/Images/thermometer.png");
    Image steamImage = new Image("assets/Images/steam.gif");
    Text thermometerText = new Text("? °C", 475, 80, 50, 30, 17f, 3);
    Text dialText = new Text("? CM", 80, 180, 340, 30, 17f, 3);
    Text rulerText = new Text("? CM", 430, 340, 100, 30, 17f, 3);

    int screenX = 0;
    int screenY = 0;
    int myX = 0;
    int myY = 0;

    
    SimulationScreen(){
        //size settings for this title screen
        this.setSize(StyleConfig.MAIN_WINDOW_WIDTH, StyleConfig.MAIN_WINDOW_HEIGHT);
        this.setTitle("Linear Thermal Expansion Experiment Simulator - Simulation");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        //inputboxpanel styles
        inputBoxesPanel.setBounds(20, 420, 964, 85);
        inputBoxesPanel.setLayout(null);
        inputBoxesPanel.setBackground(Color.WHITE);
        
        //input bounds
        roomTempInput.setBounds(125, 13, 32, 25);
        roomTempInput.addActionListener(e->UpdateThermometer());
        steamTempInput.setBounds(125, 45, 32, 25);
        initialLengthInput.setBounds(415, 13, 32, 25);
        
        inputBoxesPanel.add(roomTempInput);
        inputBoxesPanel.add(steamTempInput);
        inputBoxesPanel.add(initialLengthInput);
        
        inputBoxesPanel.add(roomTempText);
        inputBoxesPanel.add(steamTempText);
        inputBoxesPanel.add(initialLengthText);
        inputBoxesPanel.add(finalLengthText);
        inputBoxesPanel.add(finalLengthValueText);
        inputBoxesPanel.add(changeInLengthText);
        inputBoxesPanel.add(changeInLengthValueText);
        
        this.add(inputBoxesPanel);
        
        startSimulationButton.setBounds(800, 350, 180, 40);
        startSimulationButton.addActionListener(e->StartSimulation());
        this.add(startSimulationButton);

        MetalSelector.addActionListener(e->UpdateMetalRodColor());
        this.add(MetalSelector);
        
        //images
        baseImage.setBounds(150, 80, 851, 315);
        steamGeneratorImage.setBounds(700, 160,188, 158);
        rulerImage.setBounds(70, 200, 625, 232);
        thermometerImage.setBounds(381, 10, 282, 236);
        metalRodImage.setBounds(80, 20, 514, 20);
        steamImage.setBounds(700, 160, 100, 100);
  
        this.add(metalRodImage);
        this.add(steamGeneratorImage);
        this.add(rulerImage);
        this.add(thermometerImage);
        this.add(baseImage);
        this.add(steamImage);

        this.add(thermometerText);
        this.add(dialText);
        this.add(rulerText);
        
        UpdateMetalSelector();
        UpdateMetalRodColor();
        MetalRodFollowMouse();
        //set the visibility of the window to true :D
    }
    
    void UpdateMetalSelector(){
        //initialize the metals that we are going to use
        for(int i = 0; i < StyleConfig.DEFAULT_METAL_COUNT; i++){
            Metals[i] = new Metal(StyleConfig.DEFAULT_METAL_NAMES[i], StyleConfig.DEFAULT_METAL_COEFFS[i], StyleConfig.DEFAULT_METAL_COLORS[i], StyleConfig.DEFAULT_METAL_IMAGEPATHS[i]);
        }
        
        for(Metal metal : this.Metals){
            if(metal != null){
                MetalSelector.addItem(metal);
            }
        }
    }
    
    void UpdateThermometer(){
        String rightTemp;
        if(isSimulationRunning){
            rightTemp = roomTempInput.getText();

        }else{
            rightTemp = steamTempInput.getText();
        }
        thermometerText.setText(rightTemp + "° C");
    }
   
    //computes for change in length and final length, then update it
    void StartSimulation(){
        if(isSimulationRunning){

            startSimulationButton.setLabel("Start Simulation");
            StopSimulation();
            return;
        }
        
        
        UpdateThermometer();
                 
        //higop 200, 80
        int validOffset = 20;
        System.out.printf("X:%d , Y:%d \n", metalRodImage.getX(), metalRodImage.getY());
        //check metalrod if inside the base
        if(!(metalRodImage.getX() > (178 - validOffset) && metalRodImage.getY() > (201 - validOffset) && metalRodImage.getX() < (178 + validOffset) && metalRodImage.getY() < 201 + validOffset)){
            JOptionPane.showMessageDialog(null, "Please put the metal rod inside the base.");
            return;
        };
        
        if(roomTempInput.getText().length() == 0 || steamTempInput.getText().length() == 0 || initialLengthInput.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Please complete the required fields.");
            return;
        };

        //change in length
        
        //play gif of their gifpath
        float coeff = ((Metal)MetalSelector.getSelectedItem()).coefficient;
        float initialLength = Float.parseFloat(initialLengthInput.getText());
        float steamTemp = Float.parseFloat(steamTempInput.getText());
        float roomTemp = Float.parseFloat(roomTempInput.getText());
        
        float deltaTemp = steamTemp - roomTemp;
        
        float changeInLength = (coeff * 10e-6f) * initialLength * deltaTemp;
        float finalLength  = initialLength + changeInLength;
        
        changeInLengthValueText.setText(String.format("%.04f CM", changeInLength));
        finalLengthValueText.setText(String.format("%.04f CM", finalLength));
        
        rulerText.setText(String.format("%.04f CM", finalLength));
        dialText.setText(String.format("%.04f CM", changeInLength));
        System.out.print("Start");

        startSimulationButton.setLabel("Stop Simulation");
        isSimulationRunning = true;
    }
    
    void UpdateMetalRodColor(){
        metalRodImage.setIcon(new ImageIcon(((Metal)MetalSelector.getSelectedItem()).imagePath));
        metalRodImage.setLocation(80, 20);
    }
    
    void MetalRodFollowMouse(){

        metalRodImage.addMouseListener(new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) {
          screenX = e.getXOnScreen();
          screenY = e.getYOnScreen();

          myX = metalRodImage.getX();
          myY = metalRodImage.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }

      });
      metalRodImage.addMouseMotionListener(new MouseMotionListener() {

        @Override
        public void mouseDragged(MouseEvent e) {
          int deltaX = e.getXOnScreen() - screenX;
          int deltaY = e.getYOnScreen() - screenY;

          metalRodImage.setLocation(myX + deltaX, myY + deltaY);
        }

        @Override
        public void mouseMoved(MouseEvent e) { }

      });
    }
    
    void StopSimulation(){
        System.out.print("Stop");

        UpdateThermometer();
        isSimulationRunning = false;
    }
}
