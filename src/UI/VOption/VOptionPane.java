package UI.VOption;

import VComponents.VButton;
import VComponents.VShadowBorder;
import VComponents.VThemeManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VOptionPane {

    public final static int INFO_MESSAGE = 0;
    public final static int QUESTION_MESSAGE = 1;
    public final static int WARNING_MESSAGE = 2;
    public final static int ERROR_MESSAGE = 3;
    public final static int PLAIN_MESSAGE = 4;
    public final static int MASKED_INPUT = 5;

    public final static int NO_SELECTION = -1;
    public final static int SINGLE_SELECTION = 0;
    public final static int MULTI_SELECTION = 1;
    public final static int LIST_SELECTION = 2;

    public final static int OK_OPTION = 0;
    public final static int YES_OPTION = 0;
    public final static int NO_OPTION = 1;
    public final static int CANCEL_OPTION = 2;
    public final static int CUSTOM_OPTION_A = 3;
    public final static int CUSTOM_OPTION_B = 4;

    public final static int OK_CANCEL_OPTION = 3;
    public final static int YES_NO_CANCEL_OPTION = 4;
    public final static int YES_NO_OPTION = 5;
    public final static int CUSTOM_OPTION = 6;
    public final static int CUSTOM_NO_OPTION = 7;
    public final static int CUSTOM_A_B_OPTION = 8;
    public final static int CUSTOM_A_B_CANCEL_OPTION = 9;

    private static JDialog dialog;
    private static String value = "";
    private static List<String> values = new ArrayList();
    private static int INT_RETURN;

    private static final Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();
    private static JPanel container;

    private final static Color BG_Color = VThemeManager.PanelBackgrounds;//VThemeManager.PanelFormBackground;
    private final static Color TT_Color = VThemeManager.ButtonNormal;

    private final static VAction act = new VAction();
    private final static VOptionButton ok = new VOptionButton("Ok");
    private final static VOptionButton cancel = new VOptionButton("Cancel");
    private final static VOptionButton yes = new VOptionButton("Yes");
    private final static VOptionButton no = new VOptionButton("No");
    private static VOptionButton custom = new VOptionButton("Submit");
    private static VOptionButton custom1 = new VOptionButton("Submit");
    private static VTitlebar title = new VTitlebar();
    private static VOptionBody body;
    private static VButtonContainer boption;

    public static void showMessageDialog(String Msg) {
        try {
            Window parent = null;
            dialog = new JDialog((Dialog) parent, true);
            body = new VOptionBody(Msg);
            boption = new VButtonContainer();

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.setBackground(BG_Color);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static void showMessageDialog(Window parent, String Msg) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg);
            boption = new VButtonContainer();

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static void showMessageDialog(Window parent, String Msg, String t) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg);
            title.setText(t);
            boption = new VButtonContainer();

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);
            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static void showMessageDialog(Window parent, String Msg, int icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, icon);
            switch (icon) {
                case WARNING_MESSAGE:
                    title.setText("Warning");
                    break;
                case ERROR_MESSAGE:
                    title.setText("Error");
                    break;
                case QUESTION_MESSAGE:
                    title.setText("Question");
                    break;
                default:
                    title.setText("Info");
                    break;
            }

            boption = new VButtonContainer();

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static void showMessageDialog(Window parent, String Msg, String t, int icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg,icon);
            title.setText(t);
            boption = new VButtonContainer();

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static void showMessageDialog(Window parent, String Msg, String t, Image icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, icon);
            title.setText(t);
            boption = new VButtonContainer();

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static void showListMessageDialog(Window parent, String Msg, String t, Object[] ls, int icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, ls, icon);
            title.setText(t);
            boption = new VButtonContainer();

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static void showListMessageDialog(Window parent, String Msg, String t, Object[] ls, Image icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, ls, icon);
            title.setText(t);
            boption = new VButtonContainer();

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static String showInputDialog(Window parent, String Msg, String t, int icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, new JTextField(), icon);
            title.setText(t);
            boption = new VButtonContainer(OK_CANCEL_OPTION);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);
            dialog.setUndecorated(true);
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
            return value;
        } catch (Exception er) {
            return value;
        }
    }

    public static String showInputDialog(Window parent, String Msg, String t, Image icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, new JTextField(), icon);
            title.setText(t);
            boption = new VButtonContainer(OK_CANCEL_OPTION);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);
            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
            return value;
        } catch (Exception er) {
            return value;
        }
    }

    public static String showMaskedInputDialog(Window parent, String Msg, String t) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, new JPasswordField(), MASKED_INPUT);
            title.setText(t);
            boption = new VButtonContainer(OK_CANCEL_OPTION);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);
            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
            return value;
        } catch (Exception er) {
            return value;
        }
    }

    public static String showMaskedInputDialog(Window parent, String Msg, String t, Image icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, new JPasswordField(), icon);
            title.setText(t);
            boption = new VButtonContainer(OK_CANCEL_OPTION);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);
            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
            return value;
        } catch (Exception er) {
            return value;
        }
    }

    public static void showCustomActionDialog(String Msg, ActionListener al, String btext) {
        try {
            Window parent = null;
            dialog = new JDialog((Dialog) parent, true);
            body = new VOptionBody(Msg);
            custom.setText(btext);
            boption = new VButtonContainer(CUSTOM_OPTION, al);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static int showCustomDialog(Window parent, String Msg, String t, String b1text, String b2text, Image icon, int a) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, icon);
            custom.setText(b1text);
            custom1.setText(b2text);
            title.setText(t);
            boption = new VButtonContainer(a);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
            return INT_RETURN;
        } catch (Exception er) {
            return CANCEL_OPTION;
        }
    }

    public static void showCustomActionDialog(Window parent, String Msg, String t, ActionListener al, String btext, int a) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg);
            title.setText(t);
            custom.setText(btext);
            boption = new VButtonContainer(a, al);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static void showCustomActionDialog(Window parent, String Msg, String t, String ls[], ActionListener al, String btext, int a) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, ls);
            title.setText(t);
            custom.setText(btext);
            boption = new VButtonContainer(a, al);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static void showCustomActionDialog(Window parent, String Msg, String t, String ls[], ActionListener al, String btext, int a, Image icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, ls, icon);
            title.setText(t);
            custom.setText(btext);
            boption = new VButtonContainer(a, al);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
        } catch (Exception er) {
            System.out.println(er);
        }
    }

    public static int showConfirmDialog(Window parent, String Msg, String t, int a) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg);
            title.setText(t);
            boption = new VButtonContainer(a);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
            return INT_RETURN;
        } catch (Exception er) {
            return CANCEL_OPTION;
        }
    }

    public static int showConfirmDialog(Window parent, String Msg, String t, Object e, int a) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, e);
            title.setText(t);
            boption = new VButtonContainer(a);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
            return INT_RETURN;
        } catch (Exception er) {
            return CANCEL_OPTION;
        }
    }

    public static int showConfirmDialog(Window parent, String Msg, String t, Object e, int a, int icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, e, icon);
            title.setText(t);
            boption = new VButtonContainer(a);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
            return INT_RETURN;
        } catch (Exception er) {
            return CANCEL_OPTION;
        }
    }

    public static int showConfirmDialog(Window parent, String Msg, String t, Object e, int a, Image icon) {
        try {
            if (parent instanceof Dialog) {
                dialog = new JDialog((Dialog) parent, true);
            } else {
                dialog = new JDialog((Frame) parent, true);
            }
            body = new VOptionBody(Msg, e, icon);
            title.setText(t);
            boption = new VButtonContainer(a);

            container = new JPanel();
            container.setLayout(new BorderLayout());
            container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 0, 0), new VShadowBorder()));
            container.setOpaque(false);
            container.add(title, BorderLayout.NORTH);
            container.add(body, BorderLayout.CENTER);
            container.add(boption, BorderLayout.SOUTH);

            dialog.setUndecorated(true);
            dialog.setBackground(new Color(0, 0, 0, 0));
            dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
            dialog.setMinimumSize(new Dimension(200, 120));
            dialog.getContentPane().add(container);
            dialog.pack();
            dialog.setLocation((Dim.width >> 1) - (dialog.getWidth() >> 1), (Dim.height >> 1) - (dialog.getHeight() >> 1));
            dialog.show();
            return INT_RETURN;
        } catch (Exception er) {
            return CANCEL_OPTION;
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" VAction Listener ">
    private static class VAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!dialog.isVisible()) {
                return;
            }
            if (e.getSource() == ok) {
                INT_RETURN = OK_OPTION;
                dialog.dispose();
            } else if (e.getSource() == yes) {
                INT_RETURN = YES_OPTION;
                dialog.dispose();
            } else if (e.getSource() == no) {
                INT_RETURN = NO_OPTION;
                dialog.dispose();
            } else if (e.getSource() == custom) {
                INT_RETURN = CUSTOM_OPTION_A;
                dialog.dispose();
            } else if (e.getSource() == custom1) {
                INT_RETURN = CUSTOM_OPTION_B;
                dialog.dispose();
            } else if (e.getSource() == cancel) {
                INT_RETURN = CANCEL_OPTION;
                value = "";
                values.clear();
                dialog.dispose();
            } else if (e.getSource() instanceof JRadioButton) {
                value = e.getActionCommand();
            } else if (e.getSource() instanceof JCheckBox) {
                if (values.contains(((JCheckBox) e.getSource()).getText())) {
                    values.remove(((JCheckBox) e.getSource()).getText());
                } else {
                    values.add(((JCheckBox) e.getSource()).getText());
                }
            }
        }

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" VOption Button ">
    private static class VOptionButton extends VButton {

        private VOptionButton(String l) {
            super(l);
            addActionListener(act);
            setFont(new Font("Tahoma", 1, 11));
            setBorder(new EmptyBorder(2, 14, 2, 14));

        }

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" VTitleBar ">
    private static class VTitlebar extends JLabel {

        private int xMouse;
        private int yMouse;

        {
            setBorder(new EmptyBorder(2, 5, 2, 5));
            setFont(new Font("Tahoma", 1, 11));
            setOpaque(true);
            setBackground(TT_Color);
            setForeground(VThemeManager.ButtonForeground);
            setHorizontalAlignment(JLabel.CENTER);
            setText("Message");
            setMinimumSize(new Dimension(350, 22));

            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    xMouse = evt.getX();
                    yMouse = evt.getY();
                }
            });
            addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                public void mouseDragged(java.awt.event.MouseEvent evt) {
                    int x = evt.getXOnScreen();
                    int y = evt.getYOnScreen();
                    dialog.setLocation(x - xMouse,y - yMouse);
                }
            });

        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" VOptionBody ">
    private static class VOptionBody extends JPanel {

        private JLabel msg = new JLabel() {
            {
                setFont(new Font("Tahoma", 1, 12));
                setForeground(Color.WHITE);
                setIconTextGap(10);
                setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 0, 15));

            }

        };

        private VOptionBody() {
            this("An Error occured!");
        }

        private VOptionBody(String m) {
            this(m, INFO_MESSAGE);
        }

        private VOptionBody(String m, int icon) {
            this(m, null, icon);
        }

        private VOptionBody(String m, Image icon) {
            this(m, null, icon);
        }

        private VOptionBody(String m, Object e) {
            this(m, e, QUESTION_MESSAGE);
        }

        private VOptionBody(String m, Object e, int icon) {
            this(m, e, icon, LIST_SELECTION);
        }
        
        private VOptionBody(String m, Object e, Image icon) {
            this(m, e, icon, NO_SELECTION);
        }

        private VOptionBody(String m, final Object e, int icon, int selection) {
            //setOpaque(false);
            setLayout(new BorderLayout());
            msg.setText(m);
            setBackground(BG_Color);
            if (e != null) {
                if (e instanceof Object[]) {
                    JPanel cont = new JPanel();
                    int count = 0;
                    String opts[] = {};
                    if(selection == LIST_SELECTION){
                        Object[] t = (Object[])e;
                        opts = new String[t.length];
                        count = t.length;
                        for(int i = 0;i < count;i++){
                            opts[i] = t[i].toString();
                        }
                    }else{
                        count = ((String[]) e).length;
                        opts = (String[]) e;
                    }
                    
                    cont.setOpaque(false);
                    cont.setLayout(new GridLayout(count, 0));
                    cont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 30));
                    if (selection == MULTI_SELECTION) {
                        JCheckBox cb[] = new JCheckBox[count];
                        for (int i = 0; i < opts.length; i++) {
                            cb[i] = new JCheckBox(opts[i]);
                            cb[i].addActionListener(act);
                            cb[i].setOpaque(true);
                            cb[i].setBackground(new Color(0, 0, 0, 0));
                            cb[i].setFont(new Font("Tahoma", 0, 11));
                            cb[i].setForeground(Color.WHITE.darker());
                            cb[i].setMaximumSize(new Dimension(120, 22));
                            cb[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 60, 0, 0));
                            cont.add(cb[i]);
                        }
                        add(cont, BorderLayout.CENTER);
                    } else if (selection == SINGLE_SELECTION) {
                        JRadioButton bt[] = new JRadioButton[count];
                        ButtonGroup bg = new ButtonGroup();
                        for (int i = 0; i < opts.length; i++) {
                            bt[i] = new JRadioButton(opts[i], (i == 0));
                            bt[i].addActionListener(act);
                            bt[i].setOpaque(true);
                            bt[i].setBackground(new Color(0, 0, 0, 0));
                            bt[i].setFont(new Font("Tahoma", 0, 11));
                            bt[i].setForeground(Color.WHITE.darker());
                            bt[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 60, 0, 0));
                            bg.add(bt[i]);
                            cont.add(bt[i]);
                        }
                        add(cont, BorderLayout.CENTER);
                    } else {
                        JLabel lbs[] = new JLabel[count];
                        for (int i = 0; i < opts.length; i++) {
                            lbs[i] = new JLabel(opts[i]);
                            lbs[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 60, 0, 0));
                            lbs[i].setBackground(new Color(0, 0, 0, 0));
                            lbs[i].setFont(new Font("Tahoma", 0, 11));
                            lbs[i].setForeground(Color.WHITE.darker());
                            cont.add(lbs[i]);
                        }
                        add(cont, BorderLayout.CENTER);
                    }
                } else if (e instanceof Component) {
                    if (e instanceof JTextField) {
                        JPanel cont = new JPanel();
                        cont.setOpaque(false);
                        cont.setLayout(new CardLayout());
                        cont.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
                        KeyListener kl = new KeyListener() {
                            @Override
                            public void keyReleased(KeyEvent ke) {
                                value = ((JTextField) e).getText();
                            }

                            @Override
                            public void keyTyped(KeyEvent ke) {

                            }

                            @Override
                            public void keyPressed(KeyEvent ke) {
                                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                                    ok.doClick();
                                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                    cancel.doClick();
                                }
                            }

                        };
                        ((JTextField) e).addKeyListener(kl);
                        cont.add(((JTextField) e));
                        add(cont);
                    } else if (e instanceof JPasswordField) {
                        JPanel cont = new JPanel();
                        cont.setOpaque(false);
                        cont.setLayout(new CardLayout());
                        cont.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
                        KeyListener kl = new KeyListener() {
                            @Override
                            public void keyReleased(KeyEvent ke) {
                                value = ((JPasswordField) e).getText();
                            }

                            @Override
                            public void keyTyped(KeyEvent ke) {

                            }

                            @Override
                            public void keyPressed(KeyEvent ke) {
                                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                                    ok.doClick();
                                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                    cancel.doClick();
                                }
                            }

                        };
                        ((JPasswordField) e).addKeyListener(kl);
                        cont.add(((JPasswordField) e));
                        add(cont);
                    } else {
                        add(((Component) e), BorderLayout.CENTER);
                    }

                }
            }

            if (icon == WARNING_MESSAGE) {
                msg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Warning_Icon.png"))));
            } else if (icon == ERROR_MESSAGE) {
                msg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Error_Icon.png"))));
            } else if (icon == QUESTION_MESSAGE) {
                msg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Help_Icon.png"))));
            } else if (icon == MASKED_INPUT) {
                msg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Shield_Icon.png"))));
            } else if (icon == PLAIN_MESSAGE) {
                msg.setIcon(null);
                msg.setHorizontalAlignment(JLabel.CENTER);
            } else {
                msg.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Information_Icon.png"))));
            }
            add(msg, BorderLayout.NORTH);

        }

        private VOptionBody(String m, final Object e, Image icon, int selection) {
            //setOpaque(false);
            setLayout(new BorderLayout());
            setBackground(BG_Color);
            msg.setText(m);
            msg.setIcon(new ImageIcon(icon));
            add(msg, BorderLayout.NORTH);
            if (e != null) {
                if (e instanceof String[]) {
                    JPanel cont = new JPanel();
                    int count = ((String[]) e).length;
                    String opts[] = (String[]) e;
                    cont.setOpaque(false);
                    cont.setLayout(new GridLayout(count, 0));
                    cont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
                    if (selection == MULTI_SELECTION) {
                        JCheckBox cb[] = new JCheckBox[count];
                        for (int i = 0; i < opts.length; i++) {
                            cb[i] = new JCheckBox(opts[i]);
                            cb[i].addActionListener(act);
                            cb[i].setOpaque(true);
                            cb[i].setBackground(new Color(0, 0, 0, 0));
                            cb[i].setFont(new Font("Tahoma", 0, 11));
                            cb[i].setForeground(Color.WHITE.darker());
                            cb[i].setMaximumSize(new Dimension(120, 22));
                            cb[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 60, 0, 0));
                            cont.add(cb[i]);
                        }
                        add(cont, BorderLayout.CENTER);
                    } else if (selection == SINGLE_SELECTION) {
                        JRadioButton bt[] = new JRadioButton[count];
                        ButtonGroup bg = new ButtonGroup();
                        for (int i = 0; i < opts.length; i++) {
                            bt[i] = new JRadioButton(opts[i], (i == 0));
                            bt[i].addActionListener(act);
                            bt[i].setOpaque(true);
                            bt[i].setBackground(new Color(0, 0, 0, 0));
                            bt[i].setFont(new Font("Tahoma", 0, 11));
                            bt[i].setForeground(Color.WHITE.darker());
                            bt[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 60, 0, 0));
                            bg.add(bt[i]);
                            cont.add(bt[i]);
                        }
                        add(cont, BorderLayout.CENTER);
                    } else {
                        JLabel lbs[] = new JLabel[count];
                        for (int i = 0; i < opts.length; i++) {
                            lbs[i] = new JLabel(opts[i]);
                            lbs[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 60, 0, 0));
                            lbs[i].setBackground(new Color(0, 0, 0, 0));
                            lbs[i].setFont(new Font("Tahoma", 0, 11));
                            lbs[i].setForeground(Color.WHITE.darker());
                            cont.add(lbs[i]);
                        }
                        add(cont, BorderLayout.CENTER);
                    }
                } else if (e instanceof Component) {
                    if (e instanceof JTextField) {
                        JPanel cont = new JPanel();
                        cont.setOpaque(false);
                        cont.setLayout(new CardLayout());
                        cont.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
                        KeyListener kl = new KeyListener() {
                            @Override
                            public void keyReleased(KeyEvent ke) {
                                value = ((JTextField) e).getText();
                            }

                            @Override
                            public void keyTyped(KeyEvent ke) {

                            }

                            @Override
                            public void keyPressed(KeyEvent ke) {
                                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                                    ok.doClick();
                                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                    cancel.doClick();
                                }
                            }

                        };
                        ((JTextField) e).addKeyListener(kl);
                        cont.add(((JTextField) e));
                        add(cont);
                    } else if (e instanceof JPasswordField) {
                        JPanel cont = new JPanel();
                        cont.setOpaque(false);
                        cont.setLayout(new CardLayout());
                        cont.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
                        KeyListener kl = new KeyListener() {
                            @Override
                            public void keyReleased(KeyEvent ke) {
                                value = ((JPasswordField) e).getText();
                            }

                            @Override
                            public void keyTyped(KeyEvent ke) {

                            }

                            @Override
                            public void keyPressed(KeyEvent ke) {
                                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                                    ok.doClick();
                                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                    cancel.doClick();
                                }
                            }

                        };
                        ((JPasswordField) e).addKeyListener(kl);
                        cont.add(((JPasswordField) e));
                        add(cont);
                    } else {
                        add(((Component) e), BorderLayout.CENTER);
                    }

                }
            }

        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" VOption Container ">
    private static class VButtonContainer extends JPanel {

        private VButtonContainer() {
            this(OK_OPTION);
        }

        private VButtonContainer(int options) {
            this(options, null);
        }

        private VButtonContainer(int options, ActionListener al) {
            //setOpaque(false);
            setBackground(BG_Color);
            setLayout(new FlowLayout(FlowLayout.CENTER, 9, 12));
            switch (options) {
                default:
                    add(ok);
                    break;
                case OK_CANCEL_OPTION:
                    add(ok);
                    add(cancel);
                    break;
                case YES_NO_OPTION:
                    add(yes);
                    add(no);
                    break;
                case YES_NO_CANCEL_OPTION:
                    add(yes);
                    add(no);
                    add(cancel);
                    break;
                case CUSTOM_OPTION:
                    custom.addActionListener(al);
                    add(custom);
                    add(cancel);
                    break;
                case CUSTOM_NO_OPTION:
                    custom.addActionListener(al);
                    add(custom);
                    add(no);
                    add(cancel);
                    break;
                case CUSTOM_A_B_OPTION:
                    add(custom);
                    add(custom1);
                    break;
                case CUSTOM_A_B_CANCEL_OPTION:
                    add(custom);
                    add(custom1);
                    add(cancel);
                    break;

            }
        }
    }
    //</editor-fold>

}
