package simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame implements ActionListener{
    private final ImageIcon P6;
    private final JLabel BG;
    private final JButton Begin = new JButton();
    private final JButton Quit = new JButton();

    
    Menu(){
    P6 = new ImageIcon("amog.jpg");
    BG = new JLabel(P6);
    BG.setLayout(null);
    BG.setSize(1000, 562);

    Begin.setText("Simulate");
    Begin.setBounds(410, 200, 150, 25);
    Begin.setFocusable(false);
    Begin.addActionListener(this);
    BG.add(Begin);
    
    Quit.setText("Quit");
    Quit.setBounds(410,250,150,25);
    Quit.setFocusable(false);
    Quit.addActionListener(this);
    BG.add(Quit);
    
    this.setSize(1000, 562);
    this.setTitle("Simulation");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    this.add(BG);
    this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==Begin){
           new Begin();
           dispose();
       }
       if (e.getSource()==Quit){           
           dispose();
       }
    }
}