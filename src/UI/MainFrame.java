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
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HERU
 */
public class MainFrame extends javax.swing.JFrame {

    public static final GraphicsEnvironment GEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public static final Rectangle MaxBounds = GEnvironment.getMaximumWindowBounds().getBounds();
    public static DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    public ImageIcon Paid = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/paid.png")));
    public ImageIcon Balance = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/cash.png")));
    public ImageIcon Canceled = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/canceled.png")));
    public ImageIcon Item_proc = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/item_proc.png")));
    public ImageIcon Item_warn = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/item_warn.png")));
    public ImageIcon Item_ok = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/item_check.png")));
    public ImageIcon Item_claimed = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/item_up.png")));
    public ImageIcon Item_return = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/item_down2.png")));
    public ImageIcon Item_cancel = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/item_x.png")));
    public ImageIcon Item_hold = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/item_hold.png")));
    private ImageIcon tst;
    
    Action delete = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable) e.getSource();
            int modelRow = Integer.valueOf(e.getActionCommand());
            ((DefaultTableModel) table.getModel()).removeRow(modelRow);
        }
    };
    
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/NSoftwares ICO.png")));
        MaximizeUsableBounds();
        System.gc();
        //vPhotoContainer3.Lock(true);
        vTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        PatientInit();
        
        try{
            tst = new ImageIcon(ImageIO.read(new File("C:\\Documents and Settings\\HERU\\My Documents\\My Pictures\\IMG_20150104_112100.jpg")).getScaledInstance(62, 50, Image.SCALE_DEFAULT));
        }catch(Exception er){
            
        }
    }
    
    private void MaximizeUsableBounds() {
        setMaximizedBounds(MaxBounds);
        setExtendedState(MainFrame.MAXIMIZED_BOTH);
    }
    
    private void PatientInit(){
        vTable1.getColumn("Contact").setCellRenderer(centerRenderer);
        vTable1.getColumn("Date").setCellRenderer(centerRenderer);
        vTable1.getColumn("Due").setCellRenderer(centerRenderer);
    } 

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        vButton23 = new VComponents.VButton();
        vShadowedPanel2 = new VComponents.VShadowedPanel();
        vButton9 = new VComponents.VButton();
        vButton24 = new VComponents.VButton();
        vButton25 = new VComponents.VButton();
        vButton26 = new VComponents.VButton();
        vButton28 = new VComponents.VButton();
        vButton29 = new VComponents.VButton();
        vProfileImage1 = new VComponents.VProfileImage();
        vShadowedPanel3 = new VComponents.VShadowedPanel();
        MainSlide = new VComponents.VHolderPanel();
        PatientSlide = new javax.swing.JPanel();
        vScrollPane1 = new VComponents.VScrollPane();
        vTable1 = new VComponents.VTable();
        jLabel1 = new javax.swing.JLabel();
        vButton12 = new VComponents.VButton();
        jSeparator1 = new javax.swing.JSeparator();
        vComboBox1 = new VComponents.VComboBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        vLabel1 = new VComponents.VLabel();
        vLabel2 = new VComponents.VLabel();
        vLabel3 = new VComponents.VLabel();
        jPanel5 = new javax.swing.JPanel();
        vLabel4 = new VComponents.VLabel();
        vLabel6 = new VComponents.VLabel();
        vLabel7 = new VComponents.VLabel();
        jPanel6 = new javax.swing.JPanel();
        vLabel5 = new VComponents.VLabel();
        vLabel8 = new VComponents.VLabel();
        vLabel9 = new VComponents.VLabel();
        vButton13 = new VComponents.VButton();
        vButton14 = new VComponents.VButton();
        vButton15 = new VComponents.VButton();
        vButton16 = new VComponents.VButton();
        vButton17 = new VComponents.VButton();
        vProfileImage2 = new VComponents.VProfileImage();
        UserSlide = new javax.swing.JPanel();
        vScrollPane2 = new VComponents.VScrollPane();
        vTable2 = new VComponents.VTable();
        vLabel10 = new VComponents.VLabel();
        vButton18 = new VComponents.VButton();
        vButton19 = new VComponents.VButton();
        vButton20 = new VComponents.VButton();
        vButton21 = new VComponents.VButton();
        vShadowedPanel4 = new VComponents.VShadowedPanel();
        vButton11 = new VComponents.VButton();
        vButton10 = new VComponents.VButton();
        vButton22 = new VComponents.VButton();
        jLabel2 = new javax.swing.JLabel();
        vButton27 = new VComponents.VButton();

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(VThemeManager.ButtonForeground);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/paid.png"))); // NOI18N
        jLabel5.setText("Settled");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jPanel2.add(jLabel5);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(VThemeManager.ButtonForeground);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/canceled.png"))); // NOI18N
        jLabel12.setText("Canceled");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jPanel2.add(jLabel12);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(VThemeManager.ButtonForeground);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/cash.png"))); // NOI18N
        jLabel6.setText("Unsettled");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jPanel2.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(VThemeManager.ButtonForeground);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/item_check.png"))); // NOI18N
        jLabel7.setText("Available");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jPanel2.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(VThemeManager.ButtonForeground);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/item_warn.png"))); // NOI18N
        jLabel8.setText("Defective");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jPanel2.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(VThemeManager.ButtonForeground);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/item_x.png"))); // NOI18N
        jLabel9.setText("Canceled");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jPanel2.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(VThemeManager.ButtonForeground);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/item_up.png"))); // NOI18N
        jLabel10.setText("Claimed");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jPanel2.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(VThemeManager.ButtonForeground);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/item_down2.png"))); // NOI18N
        jLabel11.setText("Returned");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jPanel2.add(jLabel11);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Home Panel");
        setMaximumSize(new java.awt.Dimension(1024, 726));
        setMinimumSize(new java.awt.Dimension(1024, 726));
        setUndecorated(true);
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        vPanel1.setVImage(new javax.swing.ImageIcon(getClass().getResource("/Background/1.jpg"))); // NOI18N
        vPanel1.setMinimumSize(new java.awt.Dimension(1023, 726));
        vPanel1.setPreferredSize(new java.awt.Dimension(1023, 726));

        vButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/people.png"))); // NOI18N
        vButton1.setText("Patient");
        vButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton1.setIconTextGap(10);
        vButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton1ActionPerformed(evt);
            }
        });

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
        vButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton5ActionPerformed(evt);
            }
        });

        vButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/task.png"))); // NOI18N
        vButton6.setText("Tasks");
        vButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton6.setIconTextGap(10);

        vButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/about.png"))); // NOI18N
        vButton7.setText("About");
        vButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton7.setIconTextGap(10);
        vButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton7ActionPerformed(evt);
            }
        });

        vButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/usage.png"))); // NOI18N
        vButton8.setText("Usage");
        vButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton8.setIconTextGap(10);

        vButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/settings.png"))); // NOI18N
        vButton23.setText("Settings");
        vButton23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton23.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton23.setIconTextGap(10);

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
                    .addComponent(vButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        vButton9.setText("Kelvin G. Nakpil");
        vButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton9ActionPerformed(evt);
            }
        });

        vButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/admin.png"))); // NOI18N

        vButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/task16.png"))); // NOI18N

        vButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/mail.png"))); // NOI18N

        vButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/report16.png"))); // NOI18N

        vButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/save.png"))); // NOI18N

        javax.swing.GroupLayout vProfileImage1Layout = new javax.swing.GroupLayout(vProfileImage1);
        vProfileImage1.setLayout(vProfileImage1Layout);
        vProfileImage1Layout.setHorizontalGroup(
            vProfileImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        vProfileImage1Layout.setVerticalGroup(
            vProfileImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout vShadowedPanel2Layout = new javax.swing.GroupLayout(vShadowedPanel2);
        vShadowedPanel2.setLayout(vShadowedPanel2Layout);
        vShadowedPanel2Layout.setHorizontalGroup(
            vShadowedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vShadowedPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(vShadowedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addGroup(vShadowedPanel2Layout.createSequentialGroup()
                        .addGroup(vShadowedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vProfileImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(vShadowedPanel2Layout.createSequentialGroup()
                                .addComponent(vButton24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vButton25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vButton26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vButton28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vButton29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        vShadowedPanel2Layout.setVerticalGroup(
            vShadowedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vShadowedPanel2Layout.createSequentialGroup()
                .addComponent(vButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vProfileImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(vShadowedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vButton24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vButton25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vButton26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vButton28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vButton29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        vShadowedPanel3.setPreferredSize(new java.awt.Dimension(770, 7));

        PatientSlide.setOpaque(false);

        vTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                " Stat", "Item", "Name", "Contact", "Date", "Due"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        vTable1.setRowHeight(40);
        vTable1.setShowHorizontalLines(false);
        vTable1.setShowVerticalLines(false);
        vTable1.getTableHeader().setReorderingAllowed(false);
        vScrollPane1.setViewportView(vTable1);
        if (vTable1.getColumnModel().getColumnCount() > 0) {
            vTable1.getColumnModel().getColumn(0).setMinWidth(48);
            vTable1.getColumnModel().getColumn(0).setMaxWidth(48);
            vTable1.getColumnModel().getColumn(1).setMinWidth(48);
            vTable1.getColumnModel().getColumn(1).setMaxWidth(48);
            vTable1.getColumnModel().getColumn(3).setMinWidth(150);
            vTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            vTable1.getColumnModel().getColumn(4).setMinWidth(120);
            vTable1.getColumnModel().getColumn(4).setMaxWidth(120);
            vTable1.getColumnModel().getColumn(5).setMinWidth(120);
            vTable1.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        jLabel1.setBackground(VThemeManager.ButtonNormal);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(VThemeManager.ButtonForeground);
        jLabel1.setText("Patient Name");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jLabel1.setOpaque(true);

        vButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/addprofile.png"))); // NOI18N

        jSeparator1.setForeground(VThemeManager.ButtonNormal);

        vComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Recent Month", "Recent Week", "Today", "Un Claimed", "Scheduled" }));
        vComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jPanel4.setOpaque(false);

        vLabel1.setForeground(new java.awt.Color(255, 255, 255));
        vLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/phone.png"))); // NOI18N
        vLabel1.setText("00000000000");

        vLabel2.setForeground(new java.awt.Color(255, 255, 255));
        vLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/present.png"))); // NOI18N
        vLabel2.setText("Oct 24, 2015");

        vLabel3.setForeground(new java.awt.Color(255, 255, 255));
        vLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/symbol.png"))); // NOI18N
        vLabel3.setText("nsoftwares.developer@outlook.com");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        jPanel5.setOpaque(false);

        vLabel4.setForeground(new java.awt.Color(255, 255, 255));
        vLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/day.png"))); // NOI18N
        vLabel4.setText("Jan 8, 2015");

        vLabel6.setForeground(new java.awt.Color(255, 255, 255));
        vLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/rx.png"))); // NOI18N
        vLabel6.setText("Myopic");

        vLabel7.setForeground(new java.awt.Color(255, 255, 255));
        vLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/record.png"))); // NOI18N
        vLabel7.setText("3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(vLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(vLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5);

        jPanel6.setOpaque(false);

        vLabel5.setForeground(new java.awt.Color(255, 255, 255));
        vLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/transaction16.png"))); // NOI18N
        vLabel5.setText("1400");

        vLabel8.setForeground(new java.awt.Color(255, 255, 255));
        vLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/wallet.png"))); // NOI18N
        vLabel8.setText("500");

        vLabel9.setForeground(new java.awt.Color(255, 255, 255));
        vLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/day.png"))); // NOI18N
        vLabel9.setText("Jan 8, 2015");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(vLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(vLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6);

        vButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/shop.png"))); // NOI18N

        vButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/notes.png"))); // NOI18N

        vButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/transaction16.png"))); // NOI18N

        vButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/rx.png"))); // NOI18N

        vButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/admin.png"))); // NOI18N

        javax.swing.GroupLayout vProfileImage2Layout = new javax.swing.GroupLayout(vProfileImage2);
        vProfileImage2.setLayout(vProfileImage2Layout);
        vProfileImage2Layout.setHorizontalGroup(
            vProfileImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        vProfileImage2Layout.setVerticalGroup(
            vProfileImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PatientSlideLayout = new javax.swing.GroupLayout(PatientSlide);
        PatientSlide.setLayout(PatientSlideLayout);
        PatientSlideLayout.setHorizontalGroup(
            PatientSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientSlideLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PatientSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PatientSlideLayout.createSequentialGroup()
                        .addComponent(vProfileImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientSlideLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(vButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(vButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(vButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(vButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(vButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)))
                    .addComponent(jSeparator1)
                    .addGroup(PatientSlideLayout.createSequentialGroup()
                        .addComponent(vComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PatientSlideLayout.setVerticalGroup(
            PatientSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientSlideLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PatientSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PatientSlideLayout.createSequentialGroup()
                        .addGroup(PatientSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vProfileImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PatientSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(vButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        MainSlide.add(PatientSlide, "card2");

        UserSlide.setOpaque(false);

        vTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Image", "Name", "Contact", "Role", "Last Logged"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        vTable2.setRowHeight(50);
        vTable2.setShowHorizontalLines(false);
        vTable2.setShowVerticalLines(false);
        vScrollPane2.setViewportView(vTable2);
        if (vTable2.getColumnModel().getColumnCount() > 0) {
            vTable2.getColumnModel().getColumn(0).setMinWidth(62);
            vTable2.getColumnModel().getColumn(0).setMaxWidth(62);
            vTable2.getColumnModel().getColumn(2).setMinWidth(150);
            vTable2.getColumnModel().getColumn(2).setMaxWidth(150);
            vTable2.getColumnModel().getColumn(3).setMinWidth(100);
            vTable2.getColumnModel().getColumn(3).setMaxWidth(100);
            vTable2.getColumnModel().getColumn(4).setMinWidth(120);
            vTable2.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        vLabel10.setBackground(VThemeManager.ButtonNormal);
        vLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        vLabel10.setForeground(VThemeManager.ButtonForeground);
        vLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/manager_admin.png"))); // NOI18N
        vLabel10.setText("Users");
        vLabel10.setOpaque(true);

        vButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/notes.png"))); // NOI18N

        vButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/remove.png"))); // NOI18N

        vButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/admin.png"))); // NOI18N

        vButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/addprofile.png"))); // NOI18N
        vButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserSlideLayout = new javax.swing.GroupLayout(UserSlide);
        UserSlide.setLayout(UserSlideLayout);
        UserSlideLayout.setHorizontalGroup(
            UserSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserSlideLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(UserSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserSlideLayout.createSequentialGroup()
                        .addComponent(vLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(vButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(vButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(vButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(vButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        UserSlideLayout.setVerticalGroup(
            UserSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserSlideLayout.createSequentialGroup()
                .addGroup(UserSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(vButton20, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(vButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(vScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        MainSlide.add(UserSlide, "card3");

        javax.swing.GroupLayout vShadowedPanel3Layout = new javax.swing.GroupLayout(vShadowedPanel3);
        vShadowedPanel3.setLayout(vShadowedPanel3Layout);
        vShadowedPanel3Layout.setHorizontalGroup(
            vShadowedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainSlide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vShadowedPanel3Layout.setVerticalGroup(
            vShadowedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        vButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/power.png"))); // NOI18N
        vButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton11ActionPerformed(evt);
            }
        });

        vButton10.setText("__");
        vButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton10ActionPerformed(evt);
            }
        });

        vButton22.setText("ICare Optical System");
        vButton22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton22.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        vButton22.setOverpaint(false);

        jLabel2.setBackground(VThemeManager.ButtonNormal);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/NSoftwares.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 4));
        jLabel2.setOpaque(true);

        vButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/search.png"))); // NOI18N
        vButton27.setText("Search");

        javax.swing.GroupLayout vShadowedPanel4Layout = new javax.swing.GroupLayout(vShadowedPanel4);
        vShadowedPanel4.setLayout(vShadowedPanel4Layout);
        vShadowedPanel4Layout.setHorizontalGroup(
            vShadowedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vShadowedPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(vButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vButton27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(vButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        vShadowedPanel4Layout.setVerticalGroup(
            vShadowedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vShadowedPanel4Layout.createSequentialGroup()
                .addGroup(vShadowedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vButton22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void vButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton11ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_vButton11ActionPerformed

    private void vButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton9ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) vTable1.getModel();
        model.setRowCount(0);
        
        
        model.addRow(new Object[]{Paid,Item_proc,"Nakpil, Kelvin Don Othello Gasic","09055550830","Nov 21, 2015","Dec 5, 2015"});
        model.addRow(new Object[]{Balance,Item_hold,"Nakpil, Johanna Mae Beciril","09055550830","Nov 22, 2015","Dec 6, 2015"});
        
        
        
        //VButtonColumn buttonColumn = new VButtonColumn(vTable1, delete, 2);
    }//GEN-LAST:event_vButton9ActionPerformed

    private void vButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton10ActionPerformed
        // TODO add your handling code here:
        setExtendedState(MainFrame.ICONIFIED);
    }//GEN-LAST:event_vButton10ActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
        if(getState() != MainFrame.ICONIFIED){
            MaximizeUsableBounds();
        }
    }//GEN-LAST:event_formWindowStateChanged

    private void vButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton1ActionPerformed
        // TODO add your handling code here:
        MainSlide.showPane(PatientSlide);
    }//GEN-LAST:event_vButton1ActionPerformed

    private void vButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton5ActionPerformed
        // TODO add your handling code here:
        MainSlide.showPane(UserSlide);
    }//GEN-LAST:event_vButton5ActionPerformed

    private void vButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton21ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) vTable2.getModel();
        
        model.setRowCount(0);
        model.addRow(new Object[]{tst,"Nakpil, Kirstein Jonnah Beciril","09055550830","Admin","Dec 2, 2015"});
    }//GEN-LAST:event_vButton21ActionPerformed

    private void vButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton7ActionPerformed
        // TODO add your handling code here:
        dispose();
        Engine.LoginUI.setVisible(true);
    }//GEN-LAST:event_vButton7ActionPerformed

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
    private VComponents.VHolderPanel MainSlide;
    private javax.swing.JPanel PatientSlide;
    private javax.swing.JPanel UserSlide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private VComponents.VButton vButton1;
    private VComponents.VButton vButton10;
    private VComponents.VButton vButton11;
    private VComponents.VButton vButton12;
    private VComponents.VButton vButton13;
    private VComponents.VButton vButton14;
    private VComponents.VButton vButton15;
    private VComponents.VButton vButton16;
    private VComponents.VButton vButton17;
    private VComponents.VButton vButton18;
    private VComponents.VButton vButton19;
    private VComponents.VButton vButton2;
    private VComponents.VButton vButton20;
    private VComponents.VButton vButton21;
    private VComponents.VButton vButton22;
    private VComponents.VButton vButton23;
    private VComponents.VButton vButton24;
    private VComponents.VButton vButton25;
    private VComponents.VButton vButton26;
    private VComponents.VButton vButton27;
    private VComponents.VButton vButton28;
    private VComponents.VButton vButton29;
    private VComponents.VButton vButton3;
    private VComponents.VButton vButton4;
    private VComponents.VButton vButton5;
    private VComponents.VButton vButton6;
    private VComponents.VButton vButton7;
    private VComponents.VButton vButton8;
    private VComponents.VButton vButton9;
    private VComponents.VComboBox vComboBox1;
    private VComponents.VLabel vLabel1;
    private VComponents.VLabel vLabel10;
    private VComponents.VLabel vLabel2;
    private VComponents.VLabel vLabel3;
    private VComponents.VLabel vLabel4;
    private VComponents.VLabel vLabel5;
    private VComponents.VLabel vLabel6;
    private VComponents.VLabel vLabel7;
    private VComponents.VLabel vLabel8;
    private VComponents.VLabel vLabel9;
    private VComponents.VPanel vPanel1;
    private VComponents.VProfileImage vProfileImage1;
    private VComponents.VProfileImage vProfileImage2;
    private VComponents.VScrollPane vScrollPane1;
    private VComponents.VScrollPane vScrollPane2;
    private VComponents.VShadowedPanel vShadowedPanel1;
    private VComponents.VShadowedPanel vShadowedPanel2;
    private VComponents.VShadowedPanel vShadowedPanel3;
    private VComponents.VShadowedPanel vShadowedPanel4;
    private VComponents.VTable vTable1;
    private VComponents.VTable vTable2;
    // End of variables declaration//GEN-END:variables
}
