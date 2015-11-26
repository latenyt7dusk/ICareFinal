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

import VComponents.VScrollBarUI.VScrollBarStyle;
import VComponents.VScrollBarUI.VScrollTheme;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.geom.GeneralPath;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author HERU
 */
public final class VComboBox extends JComboBox implements VTheme,VScrollTheme {

    private int ThemeAlpha = 255;
    private Color ThemeColor = new Color(51, 153, 255, ThemeAlpha);
    private int SubAlpha = 255;
    private Color SubColor = new Color(35, 35, 35, SubAlpha);
    private Icon VImage = null;
    private boolean ThemeVisible = true;
    private boolean SubVisible = true;
    private final VComboBox myComboBox = this;
    private static Color ScrollBackground;
    private static Color ScrollTrackColor;
    private static Color ScrollThumbNormalColor;
    private static Color ScrollThumbHoverColor;
    private static int ScrollWidth = 10;
    private boolean autocomplete = false;
    
    private static VScrollBarStyle VScrollStyle = VScrollBarStyle.STYLE_ROUNDED;
    
    public VComboBox(Object[] obs) {
        super(obs);
        //AutoCompletion.enable(this);
        setScrollBackground(getBackground());
        setScrollTrackColor(new Color(35, 35, 35));
        setScrollThumbNormalColor(new Color(153, 153, 153));
        setScrollThumbHoverColor(new Color(51, 153, 255));
        setUI(new ComboBox_UI());
        setRenderer(new ItemRenderer());
        //((JLabel) this.getRenderer()).setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4));

        setBorder(javax.swing.BorderFactory.createEmptyBorder());
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                repaint();
            }
        });
    }
    
    public VComboBox() {
        super(new Object[]{"item 1", "item 2", "item 3", "item 4"});
        //AutoCompletion.enable(this);
        setScrollBackground(getBackground());
        setScrollTrackColor(new Color(35, 35, 35));
        setScrollThumbNormalColor(new Color(153, 153, 153));
        setScrollThumbHoverColor(new Color(51, 153, 255));
        setUI(new ComboBox_UI());
        setRenderer(new ItemRenderer());
        //((JLabel) this.getRenderer()).setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4));

        setBorder(javax.swing.BorderFactory.createEmptyBorder());
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                repaint();
            }
        });
    }
    
    public void setAutoCompletion(boolean b){
        this.autocomplete = b;
    }
    public boolean isAutoCompletion(){
        return autocomplete;
    }

    @Override
    public void setScrollWidth(int i) {
        ScrollWidth = i;
        setUI(new ComboBox_UI());
    }

    @Override
    public int getScrollWidth() {
        return ScrollWidth;
    }

    @Override
    public void setScrollTrackColor(Color c) {
        ScrollTrackColor = c;
        setUI(new ComboBox_UI());
    }

    @Override
    public Color getScrollTrackColor() {
        return ScrollTrackColor;
    }

    @Override
    public void setScrollThumbNormalColor(Color c) {
        ScrollThumbNormalColor = c;
        setUI(new ComboBox_UI());
    }

    @Override
    public Color getScrollThumbNormalColor() {
        return ScrollThumbNormalColor;
    }

    @Override
    public void setScrollThumbHoverColor(Color c) {
        ScrollThumbHoverColor = c;
        setUI(new ComboBox_UI());
    }

    @Override
    public Color getScrollThumbHoverColor() {
        return ScrollThumbHoverColor;
    }

    @Override
    public void setVScrollBarStyle(VScrollBarStyle s) {
        VScrollStyle = s;
        setUI(new ComboBox_UI());
    }

    @Override
    public VScrollBarStyle getVScrollBarStyle() {
        return VScrollStyle;
    }

    @Override
    public void setScrollBackground(Color c) {
        ScrollBackground = c;
        setUI(new ComboBox_UI());
    }

    @Override
    public Color getScrollBackground() {
        return ScrollBackground;
    }

    @Override
    public void setVThemeColor(Color c) {
        ThemeColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), ThemeAlpha);
    }

    @Override
    public Color getVThemeColor() {
        return ThemeColor;
    }

    @Override
    public void setVThemeAlpha(int i) {
        ThemeAlpha = ((i > 255 || i < 0) ? 255 : i);
        ThemeColor = new Color(ThemeColor.getRed(), ThemeColor.getGreen(), ThemeColor.getBlue(), ThemeAlpha);
    }

    @Override
    public int getVThemeAlpha() {
        return ThemeAlpha;
    }

    @Override
    public void setVSubColor(Color c) {
        SubColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), SubAlpha);
    }

    @Override
    public Color getVSubColor() {
        return SubColor;
    }

    @Override
    public void setVSubAlpha(int i) {
        SubAlpha = ((i > 255 || i < 0) ? 255 : i);
        SubColor = new Color(SubColor.getRed(), SubColor.getGreen(), SubColor.getBlue(), SubAlpha);
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

    private static class ComboBox_UI extends BasicComboBoxUI {

        public static ComponentUI createUI(JComponent c) {
            return new ComboBox_UI();
        }

        @Override
        protected JButton createArrowButton() {
            JButton button;
            button = new JButton() {
                {
                    setText("");
                    //setFont(new Font("SanSerif", 1, 13));
                    //setMargin(new java.awt.Insets(2, 2, 2, 2));
                    setBorderPainted(false);
                    setContentAreaFilled(false);
                    setHorizontalAlignment(CENTER);
                    setOpaque(false);
                    setBackground(new Color(0, 0, 0, 0));
                    setFocusPainted(false);
                    setBorder(null);
                    setPreferredSize(new Dimension(1, 1));
                }

                @Override
                public int getWidth() {
                    return 0;
                }

            };
            return button;
        }

        @Override
        protected ComboPopup createPopup() {
            BasicComboPopup popup = new BasicComboPopup(comboBox) {

                {
                    //setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    setBorder(javax.swing.BorderFactory.createLineBorder(ScrollBackground));
                    //setBorder(javax.swing.BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(9, 0, 0, 0), new VShadowBorder(false, false, true, false)));
                    setLightWeightPopupEnabled(false);
                    setBackground(new Color(0, 0, 0, 0));
                    

                }

                @Override
                public void setVisible(boolean visible) {
                    if (visible == isVisible()) {
                        return;
                    }
                    super.setVisible(visible);
                    if (visible) {
                        // attempt to set tranparency
                        try {
                            Window w =SwingUtilities.getWindowAncestor(this);
                            //w.setUndecorated(false);
                           w.setOpacity(0.85f);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                    GeneralPath Trg = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);
                    Trg.moveTo(getWidth() - 30, 9);
                    Trg.lineTo(getWidth() - (30 - 6.5), 1);
                    Trg.lineTo(getWidth() - (30 - 13), 9);
                    Trg.lineTo(getWidth() - 30, 9);
                    Trg.closePath();
                    g2d.setColor(ScrollBackground);
                    g2d.fill(Trg);
                }

                @Override
                public JScrollPane createScroller() {
                    return new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER) {

                                {
                                    VScrollBarUI su = new VScrollBarUI();
                                    getVerticalScrollBar().setUI(su.createVerticalScrollBar(ScrollBackground, ScrollTrackColor, ScrollThumbNormalColor, ScrollThumbHoverColor, VScrollStyle.Value()));//VScrollBarUI.SIMPLE_LINE
                                    getVerticalScrollBar().setPreferredSize(new Dimension(ScrollWidth, 0));

                                }
                            };
                }

            };
            return popup;
        }//end of method createPopup
    }//end of inner class myComboUI

    public class ItemRenderer extends JPanel implements ListCellRenderer {

        public JLabel labelItem = new JLabel();

        private ItemRenderer() {
            setLayout(new CardLayout());

            labelItem.setOpaque(true);
            labelItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4));
            
            add(labelItem);
            setBackground(ScrollBackground);

        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            if(value instanceof Object[]){
                Object[] Item = (Object[])value;
                labelItem.setText(Item[0].toString());
                try{
                    labelItem.setIcon(new ImageIcon(getClass().getResource(Item[1].toString())));
                }catch(Exception er){
                    labelItem.setIcon(null);
                }
                labelItem.setIconTextGap(7);
            }else if(value instanceof String){
                String Item = (String) value;
                labelItem.setText(Item);
            }

            //labelItem.setIcon(new ImageIcon(getClass().getResource(Item[1])));
            if (isSelected) {
                labelItem.setBackground(ThemeColor);
                labelItem.setForeground(SubColor);
            } else {
                labelItem.setForeground(myComboBox.getForeground());
                labelItem.setBackground(myComboBox.getBackground());
            }

            return this;
        }

    }

}
