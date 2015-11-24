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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

/**
 *
 * @author HERU
 */
public class VButton extends JButton {

    private boolean visi = true;
    private boolean hov = false;

    public VButton() {
        setOpaque(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setFocusable(false);
        setForeground(VThemeManager.ButtonForeground);
        setBackground(new Color(0, 0, 0, 0));

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hov = true;
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hov = false;
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hov = false;
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hov = true;
            }
        });

    }

    public void setButtonVisible(boolean b) {
        this.visi = b;
    }

    public boolean isButtonVisible() {
        return visi;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (visi) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setColor(VThemeManager.ButtonNormal);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            if (hov) {
                g2d.setColor(VThemeManager.ButtonHighlight);
                g2d.fillRect(getWidth() - 5, 0, getWidth(), getHeight());
            }
        }
        super.paintComponent(g);

    }

}
