/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulation;

import java.awt.Font;
import javax.swing.JComboBox;

/**
 *
 * @author Ison Mario
 */
public class DropDownBox extends JComboBox{
    Font DropDownBoxFont = StyleConfig.HND_FONTS[4].deriveFont(StyleConfig.BUTTON_TEXT_SIZE);

    DropDownBox(int x, int y, int width, int height){
        this.setBounds(x, y, width, height);
        this.setFont(DropDownBoxFont);
    }
}
