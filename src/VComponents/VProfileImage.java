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
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;

/**
 *
 * @author HERU
 */
public class VProfileImage extends javax.swing.JPanel{
    
    private Icon img = null;
    
    public VProfileImage(){
        setOpaque(false);
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        try {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            Ellipse2D circ = new Ellipse2D.Float();
            circ.setFrame(9, 9, getWidth()-18, getHeight()-18);
            g2d.clip(circ);
            if(img != null){
                g2d.drawImage(ImageUtils.Convert(img).getScaledInstance(getWidth()-18, getHeight()-18, Image.SCALE_SMOOTH), 9, 9, null);
            }else{
                Image ig  = ImageIO.read(getClass().getResource("/UI/Icons/noimage.png")).getScaledInstance(getWidth()-18, getHeight()-18, Image.SCALE_SMOOTH);//Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/noimage.png"));
                g2d.drawImage(ig, 9, 9, null);
            }
            
            g2d.draw(circ);
            g2d.setClip(null);
            
            g2d.setStroke(new BasicStroke(4,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER));
            g2d.setColor(VThemeManager.ButtonForeground);
            g2d.drawOval(8, 8, getWidth()-16, getHeight()-16);
            
            g2d.setStroke(new BasicStroke(1,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER));
            g2d.setColor(VThemeManager.ButtonForeground);
            g2d.drawOval(2, 2, getWidth()-4, getHeight()-4);
        } catch (IOException ex) {
            Logger.getLogger(VProfileImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
