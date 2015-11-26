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

import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author HERU
 */
public class VPhotoContainer extends JLabel {

    private boolean changeable = true;
    private File img;
    private int size = 300;
    private boolean lock = false;

    private JFileChooser chooser = new JFileChooser() {
        {
            FileNameExtensionFilter jpg = new FileNameExtensionFilter("JPEG File", "jpg");
            FileNameExtensionFilter png = new FileNameExtensionFilter("PNG File", "png");
            addChoosableFileFilter(jpg);
            addChoosableFileFilter(png);
            setFileFilter(jpg);
            setAcceptAllFileFilterUsed(false);
            setApproveButtonText("Select");
        }
    };

    public VPhotoContainer() {
        super();
        setForeground(VThemeManager.ButtonForeground);
        setBorder(new LineBorder(VThemeManager.ButtonForeground, 1));
        setHorizontalAlignment(JLabel.CENTER);
        setText("No Picture");
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (lock != true) {
                    int con = chooser.showDialog(null, "Select Image");
                    if (con == JFileChooser.APPROVE_OPTION) {
                        img = chooser.getSelectedFile();
                        try {
                            if (Files.size(img.toPath()) / 1000 > size) {
                                JOptionPane.showMessageDialog(null, "File Size too Large (" + size + "Kb Limit).");
                            } else {
                                setPhoto(ImageIO.read(img));
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(VPhotoContainer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        img = null;
                    }
                }
            }
        });

    }

    public void clearContainer() {
        setIcon(null);
        setText("No Picture");
        img = null;
    }

    public void setPhoto(BufferedImage i) {
        setIcon(new ImageIcon(i.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
        if (i != null) {
            setText("");
        } else {
            setText("No Picture");
        }
    }

    public void setChangeAble(boolean b) {
        this.changeable = b;
    }

    public boolean isChangeAble() {
        return changeable;
    }

    public void setSizeLimit(int i) {
        this.size = i;
    }

    public int getSizeLimit() {
        return size;
    }
    
    public void Lock(boolean b){
        this.lock = ((b)? false:true);
        if(b){
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }else{
            setCursor(Cursor.getDefaultCursor());
        }
    }
    
    

}
