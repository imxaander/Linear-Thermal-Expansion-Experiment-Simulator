package simulation;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;

public class Begin extends JFrame {

    JTextField roomTempField, initialLengthField, FinalTempField;
    JComboBox<String> materialBox;

    Begin() {
        // Skibidi toilet amogus
        this.setSize(1000, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel roomTempLabel = new JLabel("Room Temp:");
        roomTempLabel.setBounds(185, 400, 100, 30); 
        this.add(roomTempLabel);
        
        roomTempField = new JTextField();
        roomTempField.setBounds(265, 400, 100, 30);  
        this.add(roomTempField);

        JLabel initialLengthLabel = new JLabel("Initial Length:");
        initialLengthLabel.setBounds(410, 400, 100, 30); 
        this.add(initialLengthLabel);

        initialLengthField = new JTextField();
        initialLengthField.setBounds(500, 400, 100, 30);  
        this.add(initialLengthField);

        JLabel FinalTempLabel = new JLabel("Final Temp:");
        FinalTempLabel.setBounds(640, 400, 150, 30);  
        this.add(FinalTempLabel);

        FinalTempField = new JTextField();
        FinalTempField.setBounds(715, 400, 100, 30);  
        this.add(FinalTempField);
        
        JLabel FinalLengthLabel = new JLabel("Final Length:");
        FinalLengthLabel.setBounds(185, 450, 100, 30);  
        this.add(FinalLengthLabel);
        
        Border border = BorderFactory.createLineBorder(Color.green, 2);
        
        JLabel FinalLengthResult = new JLabel("0.045");
        FinalLengthResult.setBounds(265, 450, 100, 30);  
        this.add(FinalLengthResult);
        FinalLengthResult.setBorder(border);
        FinalLengthResult.setHorizontalAlignment(SwingConstants.CENTER); 
        FinalLengthResult.setOpaque(true);  
        FinalLengthResult.setBackground(Color.WHITE);  

        JLabel DeltaLengthLabel = new JLabel("Delta Length:");
        DeltaLengthLabel.setBounds(410, 450, 100, 30);  
        this.add(DeltaLengthLabel);
        
        JLabel DeltaLengthResult = new JLabel("0.486");
        DeltaLengthResult.setBounds(500, 450, 100, 30);  
        this.add(DeltaLengthResult);

        DeltaLengthResult.setBorder(border);
        DeltaLengthResult.setHorizontalAlignment(SwingConstants.CENTER); 
        DeltaLengthResult.setOpaque(true);  // Allow background color if needed
        DeltaLengthResult.setBackground(Color.WHITE);  
        
        JButton startButton = new JButton("Sigma Button");
        startButton.setBounds(425, 500, 150, 30);  
        this.add(startButton);

        // Make the frame visible
        this.setVisible(true);
        
        String[] materials = {"Gold", "Silver", "Brass", "Copper", "Custom"};
        materialBox = new JComboBox<>(materials);
        materialBox.setBounds(50, 50, 150, 30);  
        this.add(materialBox);

    }
}