/*
 * Copyright (C) 2015 HERU
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package VComponents;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author HERU
 */
public class VPhotoContainer extends JLabel {
    
    public VPhotoContainer() {
        super();
        setForeground(VThemeManager.ButtonForeground);
        setBorder(new LineBorder(VThemeManager.ButtonForeground,1));
        setHorizontalAlignment(JLabel.CENTER);
        setText("No Picture");
    }
    
    public void setPhoto(BufferedImage i){
        setIcon(new ImageIcon(i.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
        if(i != null){
            setText("");
        }else{
            setText("No Picture");
        }
    }
    
}
