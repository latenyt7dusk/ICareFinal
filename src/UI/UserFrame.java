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

import VClass.User;
import VComponents.VComboBox;
import VComponents.VTextField;
import VComponents.VThemeManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.util.Calendar;

/**
 *
 * @author HERU
 */
public class UserFrame extends javax.swing.JFrame {

    private User cUser;
    private MainFrame cFrame;
    private boolean locked = false;
    int xM;
    int yM;

    /**
     * Creates new form UserFrame
     */
    public UserFrame() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/NSoftwares ICO.png")));
        vComboBox1.removeAllItems();
        vComboBox1.addItem(new Object[]{"Male", "/UI/Icons/male.png"});
        vComboBox1.addItem(new Object[]{"Female", "/UI/Icons/female.png"});
        vComboBox2.removeAllItems();
        vComboBox2.addItem(new Object[]{"User", "/UI/Icons/user_admin.png"});
        vComboBox2.addItem(new Object[]{"Manager", "/UI/Icons/manager_admin.png"});
        vComboBox2.addItem(new Object[]{"Admin", "/UI/Icons/admin.png"});
        vDateChooser1.setAgeField(vTextField5);
    }

    public UserFrame(User user) {
        initComponents();
        this.cUser = user;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/NSoftwares ICO.png")));
        vComboBox1.removeAllItems();
        vComboBox1.addItem(new Object[]{"Male", "/UI/Icons/male.png"});
        vComboBox1.addItem(new Object[]{"Female", "/UI/Icons/female.png"});
        vComboBox2.removeAllItems();
        vComboBox2.addItem(new Object[]{"User", "/UI/Icons/user_admin.png"});
        vComboBox2.addItem(new Object[]{"Manager", "/UI/Icons/manager_admin.png"});
        vComboBox2.addItem(new Object[]{"Admin", "/UI/Icons/admin.png"});
        vDateChooser1.setAgeField(vTextField5);
    }
    
    public UserFrame(MainFrame mf) {
        initComponents();
        this.cFrame = mf;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/NSoftwares ICO.png")));
        vComboBox1.removeAllItems();
        vComboBox1.addItem(new Object[]{"Male", "/UI/Icons/male.png"});
        vComboBox1.addItem(new Object[]{"Female", "/UI/Icons/female.png"});
        vComboBox2.removeAllItems();
        vComboBox2.addItem(new Object[]{"User", "/UI/Icons/user_admin.png"});
        vComboBox2.addItem(new Object[]{"Manager", "/UI/Icons/manager_admin.png"});
        vComboBox2.addItem(new Object[]{"Admin", "/UI/Icons/admin.png"});
        vDateChooser1.setAgeField(vTextField5);
    }
    
    public UserFrame(User user,MainFrame mf) {
        initComponents();
        this.cUser = user;
        this.cFrame = mf;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/Icons/NSoftwares ICO.png")));
        vComboBox1.removeAllItems();
        vComboBox1.addItem(new Object[]{"Male", "/UI/Icons/male.png"});
        vComboBox1.addItem(new Object[]{"Female", "/UI/Icons/female.png"});
        vComboBox2.removeAllItems();
        vComboBox2.addItem(new Object[]{"User", "/UI/Icons/user_admin.png"});
        vComboBox2.addItem(new Object[]{"Manager", "/UI/Icons/manager_admin.png"});
        vComboBox2.addItem(new Object[]{"Admin", "/UI/Icons/admin.png"});
        vDateChooser1.setAgeField(vTextField5);
    }

    public void ClearData() {

        vTextField1.setText("username");
        vPasswordField1.setText("password");
        vComboBox2.setSelectedIndex(0);
        vPhotoContainer2.clearContainer();
        vDateChooser1.setDate(Calendar.getInstance().getTime());
        Component e[] = jPanel1.getComponents();
        for (Component c : e) {
            if (c instanceof VTextField) {
                ((VTextField) c).setText("");
            } else if (c instanceof VComboBox) {
                ((VComboBox) c).setSelectedIndex(0);
            }
        }
    }

    private void Lock(boolean b) {
        this.locked = ((b) ? false : true);
        vTextField1.setEnabled(locked);
        vPasswordField1.setEnabled(locked);
        vComboBox2.setEnabled(locked);
        vPhotoContainer2.Lock(b);
        vDateChooser1.setEnabled(locked);
        Component e[] = jPanel1.getComponents();
        for (Component c : e) {
            if (c instanceof VTextField) {
                ((VTextField) c).setEnabled(locked);
            } else if (c instanceof VComboBox) {
                ((VComboBox) c).setEnabled(locked);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vShadowedPanel1 = new VComponents.VShadowedPanel();
        vButton1 = new VComponents.VButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        vTextField2 = new VComponents.VTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vTextField3 = new VComponents.VTextField();
        jLabel4 = new javax.swing.JLabel();
        vTextField4 = new VComponents.VTextField();
        vDateChooser1 = new VComponents.VDateChooser(vTextField5);
        jLabel6 = new javax.swing.JLabel();
        vTextField5 = new VComponents.VTextField();
        jLabel7 = new javax.swing.JLabel();
        vComboBox1 = new VComponents.VComboBox();
        vComboBox3 = new VComponents.VComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        vTextField6 = new VComponents.VTextField();
        jLabel5 = new javax.swing.JLabel();
        vTextField7 = new VComponents.VTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        vTextField8 = new VComponents.VTextField();
        vButton2 = new VComponents.VButton();
        vTextField1 = new VComponents.VTextField();
        vPasswordField1 = new VComponents.VPasswordField();
        vComboBox2 = new VComponents.VComboBox();
        vPhotoContainer2 = new VComponents.VPhotoContainer();
        vButton4 = new VComponents.VButton();
        vLabel1 = new VComponents.VLabel();
        vLabel2 = new VComponents.VLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New User");
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setUndecorated(true);
        setResizable(false);

        setBackground(new Color(0,0,0,0));
        getContentPane().setBackground(new Color(0,0,0,0));
        vShadowedPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vShadowedPanel1MousePressed(evt);
            }
        });
        vShadowedPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                vShadowedPanel1MouseDragged(evt);
            }
        });

        vButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/power.png"))); // NOI18N
        vButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(VThemeManager.PanelFormBackground);

        jLabel1.setBackground(VThemeManager.HeaderBackground);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(" Personal Information");
        jLabel1.setOpaque(true);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Firstname");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Middlename");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Surname");

        vDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Birth Date");

        vTextField5.setEditable(false);
        vTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vTextField5.setEnabled(false);
        vTextField5.setFocusable(false);
        vTextField5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Age");

        vComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        vComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married", "Separated", "Widdow", "Widdower" }));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Civil Status");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Contact Number");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email Address");

        vButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/save.png"))); // NOI18N
        vButton2.setText("Save");
        vButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vButton2.setIconTextGap(7);
        vButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(vDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                .addComponent(vTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(vTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(vTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, 0)
                                .addComponent(vTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, 0)
                                .addComponent(vTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(vTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(vDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(vTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(vComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(vTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addComponent(vTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(0, 0, 0)
                .addComponent(vTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(vButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        vTextField1.setText("username");

        vPasswordField1.setText("password");

        vComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User", "Manager", "Admin" }));

        vButton4.setText("__");
        vButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton4ActionPerformed(evt);
            }
        });

        vLabel1.setForeground(new java.awt.Color(255, 255, 255));
        vLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/user.png"))); // NOI18N

        vLabel2.setForeground(new java.awt.Color(255, 255, 255));
        vLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icons/lock.png"))); // NOI18N

        javax.swing.GroupLayout vShadowedPanel1Layout = new javax.swing.GroupLayout(vShadowedPanel1);
        vShadowedPanel1.setLayout(vShadowedPanel1Layout);
        vShadowedPanel1Layout.setHorizontalGroup(
            vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vShadowedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(vShadowedPanel1Layout.createSequentialGroup()
                        .addComponent(vPhotoContainer2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vShadowedPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(vButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(vShadowedPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(vLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        vShadowedPanel1Layout.setVerticalGroup(
            vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vShadowedPanel1Layout.createSequentialGroup()
                .addGroup(vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vShadowedPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(vPhotoContainer2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
                    .addGroup(vShadowedPanel1Layout.createSequentialGroup()
                        .addGroup(vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vShadowedPanel1Layout.createSequentialGroup()
                                .addGroup(vShadowedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(vTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(vLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vShadowedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vShadowedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_vButton1ActionPerformed

    private void vButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_vButton2ActionPerformed

    private void vButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton4ActionPerformed
        // TODO add your handling code here:
        setExtendedState(UserFrame.ICONIFIED);
    }//GEN-LAST:event_vButton4ActionPerformed

    private void vShadowedPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vShadowedPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xM, y - yM);
    }//GEN-LAST:event_vShadowedPanel1MouseDragged

    private void vShadowedPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vShadowedPanel1MousePressed
        // TODO add your handling code here:
        xM = evt.getX();
        yM = evt.getY();
    }//GEN-LAST:event_vShadowedPanel1MousePressed

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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private VComponents.VButton vButton1;
    private VComponents.VButton vButton2;
    private VComponents.VButton vButton4;
    private VComponents.VComboBox vComboBox1;
    private VComponents.VComboBox vComboBox2;
    private VComponents.VComboBox vComboBox3;
    private VComponents.VDateChooser vDateChooser1;
    private VComponents.VLabel vLabel1;
    private VComponents.VLabel vLabel2;
    private VComponents.VPasswordField vPasswordField1;
    private VComponents.VPhotoContainer vPhotoContainer2;
    private VComponents.VShadowedPanel vShadowedPanel1;
    private VComponents.VTextField vTextField1;
    private VComponents.VTextField vTextField2;
    private VComponents.VTextField vTextField3;
    private VComponents.VTextField vTextField4;
    private VComponents.VTextField vTextField5;
    private VComponents.VTextField vTextField6;
    private VComponents.VTextField vTextField7;
    private VComponents.VTextField vTextField8;
    // End of variables declaration//GEN-END:variables
}
