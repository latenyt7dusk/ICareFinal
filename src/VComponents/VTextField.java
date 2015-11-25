/*
 * Copyright (C) 2015 late7dusk
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

import Utilities.Colorizer;
import Utilities.ImageUtils;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JTextField;

/**
 *
 * @author HERU
 */
public class VTextField extends JTextField {

    private String Value;
    private boolean hasError = false;
    private Icon ico = null;
    private Color IconFG = Color.BLACK;
    private boolean ibgVisible = false;

    public VTextField() {

        setBackground(VThemeManager.TextBackground);
        setForeground(VThemeManager.TextForeground);
        putClientProperty("HasError", Boolean.FALSE);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4));

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                selectAll();
            }
        });
    }

    public void setHasError(boolean b) {
        this.hasError = b;
        repaint();
    }

    public boolean HasError() {
        return hasError;
    }

    public void setValue(String i) {
        this.Value = i;
    }

    public String getValue() {
        return Value;
    }

    public void setLabelIcon(Icon i) {
        this.ico = i;
        repaint();
    }

    public Icon getLabelIcon() {
        return ico;
    }

    public void setIconBackgroundVisible(boolean b) {
        this.ibgVisible = b;
    }

    public boolean isIconBackgroundVisible() {
        return ibgVisible;
    }

    public void setIconForeground(Color c) {
        this.IconFG = c;
    }

    public Color getIconForeground() {
        return IconFG;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setColor(getBackground());

        if (hasError == true) {
            g2d.setColor(Color.RED.brighter());
            GeneralPath p = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 5);
            p.moveTo(getWidth() - 10, getHeight() - 1);
            p.lineTo(getWidth() - 1, getHeight() - 1);
            p.lineTo(getWidth() - 1, getHeight() - 11);
            p.lineTo(getWidth() - 10, getHeight() - 1);
            p.closePath();
            g2d.fill(p);
        }

        if (ico != null) {
            BufferedImage image = ImageUtils.Convert(ico);
            if (ibgVisible) {
                g2d.setColor(getBackground().darker());
                g2d.fillRect(1, 1, 24, getHeight() - 2);
                if (!IconFG.equals(Color.BLACK)) {
                    Colorizer.doRGB(IconFG, image);
                }
            }
            setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 27, 1, 4));
            g2d.drawImage(image, 5, 4, null);
        }
        
    }

}
