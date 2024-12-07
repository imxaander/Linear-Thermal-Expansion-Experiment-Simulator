/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulation;

import javax.swing.*;
import java.awt.Dimension;
/**
 *
 * @author Ison Mario
 */

public class Text extends JLabel {
    Text(String textContent, int x, int y, int width, int height, float textSize, int fontStyle){
        this.setFont(StyleConfig.HND_FONTS[fontStyle].deriveFont(textSize));
        this.setText(textContent);

        this.setBounds(x, y, width, height);

    }
}
