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
package UI;

import VComponents.VThemeManager;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author HERU
 */
public class MainFrame extends javax.swing.JFrame {

    public static final GraphicsEnvironment GEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public static final Rectangle MaxBounds = GEnvironment.getMaximumWindowBounds().getBounds();
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/NSoftwares ICO.png")));
        MaximizeUsableBounds();
        System.gc();
    }
    
    private void MaximizeUsableBounds() {
        setMaximizedBounds(MaxBounds);
        setExtendedState(MainFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vPanel1 = new VComponents.VPanel();
        vShadowedPanel1 = new VComponents.VShadowedPanel();
        vButton1 = new VComponents.VButton();
        vButton2 = new VComponents.VButton();
        vButton3 = new VComponents.VButton();
        vButton4 = new VComponents.VButton();
        vButton5 = new VComponents.VButton();
        vButton6 = new VComponents.VButton();
        vButton7 = new VComponents.VButton();
        vButton8 = new VComponents.VButton();
        vButton10 = new VComponents.VButton();
        vShadowedPanel2 = new VComponents.VShadowedPanel();
        vPhotoContainer1 = new VComponents.VPhotoContainer();
        vButton9 = new VComponents.VButton();
        vShadowedPanel3 = new VComponents.VShadowedPanel();
        vHolderPanel1 = new VComponents.VHolderPanel();
        jPanel3 = new javax.swing.JPanel();
        vScrollPane1 = new VComponents.VScrollPane();
        vTable2 = new VComponents.VTable();
        vComboBox1 = new VComponents.VComboBox();
        jPanel2 = new javax.swing.JPanel();
        vShadowedPanel4 = new VComponents.VShadowedPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Home Panel");
        setMaximumSize(new java.awt.Dimension(1024, 726));
        setMinimumSize(new java.awt.Dimension(1024, 726));
        setPreferredSize(new java.awt.Dimension(1023, 726));
        setResizable(false);

        vPanel1.setVImage(new javax.swing.ImageIcon(getClass().getResource("/Background/1.jpg"))); // NOI18N
        vPanel1.setMinimumSize(new java.awt.Dimension(1023, 726));
        vPanel1.setPreferredSize(new java.awt.Dimension(1023, 726));

        vButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/people.png"))); // NOI18N
        vButton1.setText("Patient");
        vButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton1.setIconTextGap(10);

        vButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/stock.png"))); // NOI18N
        vButton2.setText("Inventory");
        vButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton2.setIconTextGap(10);

        vButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/transaction.png"))); // NOI18N
        vButton3.setText("Transaction");
        vButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton3.setIconTextGap(10);

        vButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/report.png"))); // NOI18N
        vButton4.setText("Reports");
        vButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton4.setIconTextGap(10);

        vButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/users.png"))); // NOI18N
        vButton5.setText("Users");
        vButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton5.setIconTextGap(10);

        vButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/settings.png"))); // NOI18N
        vButton6.setText("Settings");
        vButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton6.setIconTextGap(10);

        vButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/about.png"))); // NOI18N
        vButton7.setText("About");
        vButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton7.setIconTextGap(10);

        vButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/usage.png"))); // NOI18N
        vButton8.setText("Usage");
        vButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton8.setIconTextGap(10);

        vButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/logout.png"))); // NOI18N
        vButton10.setText("Logout");
        vButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton10.setIconTextGap(10);

        javax.swing.GroupLayout vShadowedPanel1Layout = new javax.swing.GroupLayout(vShadowedPanel1);
        vShadowedPanel1.setLayout(vShadowedPanel1Layout);
        vShadowedPanel1Layout.setHorizontalGroup(
            vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vShadowedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(vButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        vShadowedPanel1Layout.setVerticalGroup(
            vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vShadowedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(vButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(vButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        vButton9.setText("Name");

        javax.swing.GroupLayout vShadowedPanel2Layout = new javax.swing.GroupLayout(vShadowedPanel2);
        vShadowedPanel2.setLayout(vShadowedPanel2Layout);
        vShadowedPanel2Layout.setHorizontalGroup(
            vShadowedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vShadowedPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(vShadowedPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vPhotoContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vShadowedPanel2Layout.setVerticalGroup(
            vShadowedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vShadowedPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(vPhotoContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        vShadowedPanel3.setPreferredSize(new java.awt.Dimension(770, 7));

        jPanel3.setOpaque(false);

        vTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        vScrollPane1.setViewportView(vTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(vComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(vComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addComponent(vScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        vHolderPanel1.add(jPanel3, "card2");

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        vHolderPanel1.add(jPanel2, "card3");

        javax.swing.GroupLayout vShadowedPanel3Layout = new javax.swing.GroupLayout(vShadowedPanel3);
        vShadowedPanel3.setLayout(vShadowedPanel3Layout);
        vShadowedPanel3Layout.setHorizontalGroup(
            vShadowedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vHolderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vShadowedPanel3Layout.setVerticalGroup(
            vShadowedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vShadowedPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vHolderPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout vShadowedPanel4Layout = new javax.swing.GroupLayout(vShadowedPanel4);
        vShadowedPanel4.setLayout(vShadowedPanel4Layout);
        vShadowedPanel4Layout.setHorizontalGroup(
            vShadowedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vShadowedPanel4Layout.setVerticalGroup(
            vShadowedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout vPanel1Layout = new javax.swing.GroupLayout(vPanel1);
        vPanel1.setLayout(vPanel1Layout);
        vPanel1Layout.setHorizontalGroup(
            vPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vShadowedPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(vPanel1Layout.createSequentialGroup()
                        .addGroup(vPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vShadowedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vShadowedPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(vShadowedPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)))
                .addContainerGap())
        );
        vPanel1Layout.setVerticalGroup(
            vPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vShadowedPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vPanel1Layout.createSequentialGroup()
                        .addComponent(vShadowedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vShadowedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(vShadowedPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(vPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private VComponents.VButton vButton1;
    private VComponents.VButton vButton10;
    private VComponents.VButton vButton2;
    private VComponents.VButton vButton3;
    private VComponents.VButton vButton4;
    private VComponents.VButton vButton5;
    private VComponents.VButton vButton6;
    private VComponents.VButton vButton7;
    private VComponents.VButton vButton8;
    private VComponents.VButton vButton9;
    private VComponents.VComboBox vComboBox1;
    private VComponents.VHolderPanel vHolderPanel1;
    private VComponents.VPanel vPanel1;
    private VComponents.VPhotoContainer vPhotoContainer1;
    private VComponents.VScrollPane vScrollPane1;
    private VComponents.VShadowedPanel vShadowedPanel1;
    private VComponents.VShadowedPanel vShadowedPanel2;
    private VComponents.VShadowedPanel vShadowedPanel3;
    private VComponents.VShadowedPanel vShadowedPanel4;
    private VComponents.VTable vTable2;
    // End of variables declaration//GEN-END:variables
}
