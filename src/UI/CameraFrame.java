/*
 * Copyright (C) 2016 Late7dusk
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
package UI;

import VComponents.VButton;
import VComponents.VPhotoContainer;
import VComponents.VShadowBorder;
import VComponents.VThemeManager;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Late7dusk
 */
public class CameraFrame extends JDialog {

    private final Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();
    private JPanel container;
    private Webcam camera = null;
    private WebcamPanel cameraPanel;
    private final JPanel controlPanel;
    private VPhotoContainer photoPanel;
    private final JPanel titlePanel;

    private final VButton Close = new VButton() {
        {
            setText("Close");
            addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try{
                        camera.close();
                    }catch(Exception er){
                        
                    }
                    
                    CameraFrame.this.dispose();
                }
            });
        }
    };

    public CameraFrame(Window parent) {
        super((JFrame) parent, true);

        container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
        container.setOpaque(false);
        
        titlePanel = new JPanel();
        titlePanel.setBackground(VThemeManager.ButtonNormal);
        titlePanel.setPreferredSize(new Dimension(0,24));
        
        container.add(titlePanel,BorderLayout.NORTH);
        
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(0, 30));
        
        try {
            camera = Webcam.getDefault();
            camera.setViewSize(WebcamResolution.VGA.getSize());

            cameraPanel = new WebcamPanel(camera);

            cameraPanel.setMirrored(true);
            cameraPanel.setAntialiasingEnabled(true);
            
            cameraPanel.setLayout(new BorderLayout());
            controlPanel.add(Close);
            controlPanel.setOpaque(false);
            cameraPanel.add(controlPanel,BorderLayout.SOUTH);
            container.add(cameraPanel, BorderLayout.CENTER);
            
            
        } catch (Exception er) {
            JPanel tmp = new JPanel();
            tmp.setLayout(new CardLayout());
            tmp.setBackground(VThemeManager.PanelBackgrounds);
            photoPanel = new VPhotoContainer();
            tmp.add(photoPanel);
            container.add(tmp,BorderLayout.CENTER);
            controlPanel.add(Close);        
            container.add(controlPanel, BorderLayout.SOUTH);
        }

        //container.add(title, BorderLayout.NORTH);
        //container.add(body, BorderLayout.CENTER);
        //container.add(boption, BorderLayout.SOUTH);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        getContentPane().setBackground(new Color(0, 0, 0, 0));
        setMinimumSize(new Dimension(500, 500));
        getContentPane().add(container);
        pack();
        setLocation((Dim.width >> 1) - (getWidth() >> 1), (Dim.height >> 1) - (getHeight() >> 1));
        show();
    }

}
