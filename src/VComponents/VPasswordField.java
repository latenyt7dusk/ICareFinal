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
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JPasswordField;

/**
 *
 * @author HERU
 */
public class VPasswordField extends JPasswordField implements VTheme {

    private int ThemeAlpha = 255;
    private Color ThemeColor = new Color(51, 153, 255, ThemeAlpha);
    private int SubAlpha = 255;
    private Color SubColor = new Color(35, 35, 35, SubAlpha);
    private Icon VImage = null;
    private Color VIconColor = null;
    private boolean ThemeVisible = true;
    private boolean SubVisible = true;
    private String Value;
    private boolean hasError = false;

    public VPasswordField() {

        setBackground(VThemeManager.TextBackground);
        setForeground(VThemeManager.TextForeground);
        putClientProperty("HasError", Boolean.FALSE);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                repaint();
            }
        });
    }

    public void setHasError(boolean b) {
        this.hasError = b;
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

    public void setVIconColor(Color col) {
        this.VIconColor = col;
    }

    public Color getVIconColor() {
        return VIconColor;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setColor(getBackground());
        if (VImage != null) {
            BufferedImage image = ImageUtils.Convert(VImage);
            if (VIconColor != null) {
                Colorizer.doRGB(VIconColor, image);
            }
            if (ThemeVisible == true) {
                g2d.setColor(ThemeColor);
                g2d.fillRect(0, 0, getHeight(), getHeight());
            }
            g2d.drawImage(image.getScaledInstance(getHeight(), getHeight() - 4, Image.SCALE_SMOOTH), 0, 2, null);
            setBorder(javax.swing.BorderFactory.createEmptyBorder(1, getHeight() + 4, 1, 2));
        } else {
            setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4));
        }
        if (hasError == true) {
            g2d.setColor(Color.RED.darker());
            GeneralPath p = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 5);
            p.moveTo(getWidth() - 10, getHeight());
            p.lineTo(getWidth(), getHeight());
            p.lineTo(getWidth(), getHeight() - 10);
            p.lineTo(getWidth() - 10, getHeight());
            p.closePath();
            g2d.fill(p);
        }
    }

    @Override
    public void setVThemeColor(Color c) {
        this.ThemeColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), ThemeAlpha);
    }

    @Override
    public Color getVThemeColor() {
        return ThemeColor;
    }

    @Override
    public void setVThemeAlpha(int i) {
        this.ThemeAlpha = ((i > 255 || i < 0) ? 255 : i);
        this.ThemeColor = new Color(ThemeColor.getRed(), ThemeColor.getGreen(), ThemeColor.getBlue(), ThemeAlpha);
    }

    @Override
    public int getVThemeAlpha() {
        return ThemeAlpha;
    }

    @Override
    public void setVSubColor(Color c) {
        this.SubColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), SubAlpha);
    }

    @Override
    public Color getVSubColor() {
        return SubColor;
    }

    @Override
    public void setVSubAlpha(int i) {
        this.SubAlpha = ((i > 255 || i < 0) ? 255 : i);
        this.SubColor = new Color(SubColor.getRed(), SubColor.getGreen(), SubColor.getBlue(), SubAlpha);
    }

    @Override
    public int getVSubAlpha() {
        return SubAlpha;
    }

    @Override
    public void setVImage(Icon i) {
        this.VImage = i;
    }

    @Override
    public Icon getVImage() {
        return VImage;
    }

    @Override
    public void setVThemeVisible(boolean b) {
        this.ThemeVisible = b;
    }

    @Override
    public boolean isVThemeVisible() {
        return ThemeVisible;
    }

    @Override
    public void setVSubVisible(boolean b) {
        this.SubVisible = b;
    }

    @Override
    public boolean isVSubVisible() {
        return SubVisible;
    }

}
