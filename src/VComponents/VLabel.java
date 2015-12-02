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

import Utilities.ImageUtils;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author HERU
 */
public class VLabel extends JLabel{
    
    public VLabel(){
        setFont(getFont().deriveFont(Font.BOLD));
    }
    
    @Override
    public void setIcon(Icon ii) {
        if(ii != null){
            super.setIcon(new ImageIcon(ImageUtils.Colorize(ii, getForeground())));
        }else{
            super.setIcon(null);
        }
    }
    
}
