/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulation;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
/**
 *
 * @author Xander Ison
 */
public class Button extends JButton{
    String label; // the button's text
    Font BUTTON_FONT = StyleConfig.HND_FONTS[6].deriveFont(StyleConfig.BUTTON_TEXT_SIZE);
    Button(String text, int x, int y){
        // constructor things
        this.label = text;
        
        // remove default styles
        // this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        
        // our on styles...       
        this.setOpaque(true);
        this.setBackground(StyleConfig.BUTTON_BACKGROUND_COLOR);
        this.setForeground(StyleConfig.BUTTON_TEXT_COLOR);
        //this.setBorder(new RoundedBorder(10));
        
        this.setFont(BUTTON_FONT);
        
        this.setBounds(x, y, StyleConfig.BUTTON_WIDTH, StyleConfig.BUTTON_HEIGHT);
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g.setColor(StyleConfig.BUTTON_BACKGROUND_COLOR);
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        
        g.setColor(StyleConfig.BUTTON_BACKGROUND_COLOR);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        Font f =  BUTTON_FONT;
        if (f != null) {
            FontMetrics fm = getFontMetrics(f);
            g.setColor(StyleConfig.BUTTON_TEXT_COLOR);
            g.setFont(f);
            g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g.drawString(this.getLabel(), getWidth() / 2 - fm.stringWidth(this.getLabel()) / 2, getHeight() / 2 + fm.getMaxDescent());
        }
    }
    
    @Override
    public String getLabel(){
        return this.label;
    }
    
    @Override
    public void setLabel(String text){
       this.label = text;
       repaint();
    }
    
}
