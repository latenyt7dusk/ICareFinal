/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.imageio.ImageIO;

/**
 *
 * @author Kelvin Nakpil
 */
public class DataBridge {

    private String SOURCE;
    private String USER;
    private String PASS;
    private int TYPE;

    public final static int ODBCJDBC = 0;
    public final static int MYSQL = 1;
    public final static int MSSQL = 2;
    public final static int H2 = 3;

    private final String DEFAULT = "jdbc:h2:tcp://localhost/~/NakSoftwares/DataOptics/database";

    private static final String DRIVER[] = {"sun.jdbc.odbc.JdbcOdbcDriver", "com.mysql.jdbc.Driver",
        "com.microsoft.sqlserver.jdbc.SQLServerDriver", "org.h2.Driver"};

    private Connection CONNECTION;
    private PreparedStatement PREPAREDST;
    private ResultSet RESULTS;

    public DataBridge(Properties p) {
        this(p.getProperty("DATA_SOURCE"), p.getProperty("USER"),
                p.getProperty("PASSWORD"), Integer.parseInt(p.getProperty("TYPE")));
    }

    public DataBridge(String s, String u) {
        this(s, u, u);
    }

    public DataBridge(String s, String u, String p) {
        this(s, u, p, ODBCJDBC);
    }

    public DataBridge(String s, String u, String p, int t) {
        this.SOURCE = s;
        this.USER = u;
        this.PASS = p;
        this.TYPE = t;
        if (TYPE == H2) {
            this.SOURCE = SOURCE + ";CIPHER=AES";
            this.PASS = "dwr2rufd7ezj " + PASS;
        }
    }

    public boolean checkConnection() throws SQLException, ClassNotFoundException {
        try {
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                return true;
            }
            return false;
        } catch (SQLException er) {
            return false;
        } finally {
            this.CONNECTION.close();
            this.CONNECTION = null;
            System.gc();
        }
    }

    public List<List> FetchTableCollection(String TB) throws SQLException {
        try {
            List<List> record = null;
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                this.PREPAREDST = CONNECTION.prepareStatement("SELECT * FROM " + TB);
                this.RESULTS = PREPAREDST.executeQuery();

                record = new ArrayList();
                int column = RESULTS.getMetaData().getColumnCount();
                while (RESULTS.next()) {
                    String tList[] = new String[column];
                    int index = 0;
                    for (int i = 1; i <= column; i++) {
                        tList[index] = RESULTS.getString(i);
                        index++;
                    }
                    record.add(Arrays.asList(tList.clone()));
                }
                return record;
            }
            return record;
        } catch (SQLException | ClassNotFoundException er) {
            return null;
        } finally {
            if (CONNECTION != null) {
                RESULTS.close();
                PREPAREDST.close();
                CONNECTION.close();
                this.CONNECTION = null;
                System.gc();
            }
        }
    }

    public boolean AddData(String TB, List<String> data) throws SQLException {
        try {
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                java.sql.Statement st = CONNECTION.createStatement();

                String ST = "INSERT INTO " + TB + " values('" + data.get(0) + "'";
                for (int i = 1; i < data.size(); i++) {
                    ST = ST.concat(",'" + data.get(i) + "'");
                }
                ST = ST.concat(")");
                st.executeUpdate(ST);
                st.close();
                return true;
            }
            return false;
        } catch (SQLException | ClassNotFoundException er) {
            return false;
        } finally {
            if (CONNECTION != null) {
                CONNECTION.close();
                this.CONNECTION = null;
            }
        }
    }

    public boolean RunScript(String data) throws SQLException {
        try {
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                java.sql.Statement st = CONNECTION.createStatement();
                st.executeUpdate(data);
                st.close();
                return true;
            }
            return false;
        } catch (SQLException | ClassNotFoundException er) {
            System.out.println(er);
            return false;
        } finally {
            if (CONNECTION != null) {
                CONNECTION.close();
                this.CONNECTION = null;
                System.gc();
            }
        }
    }

    public boolean InsertBatchData(List<String> d) throws SQLException {
        try {
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                java.sql.Statement st = CONNECTION.createStatement();
                if (d.size() > 0) {
                    for (String tmp : d) {
                        st.addBatch(tmp);
                    }
                    st.executeBatch();
                    st.close();
                    return true;
                }

            }
            return false;
        } catch (SQLException | ClassNotFoundException er) {
            return false;
        } finally {
            if (CONNECTION != null) {
                CONNECTION.close();
                this.CONNECTION = null;
                System.gc();
            }
        }
    }

    public boolean UpdateData(String TB, List<String> cols, List<String> data1, List<String> data2) throws SQLException {
        try {
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                java.sql.Statement st = CONNECTION.createStatement();

                String ST = "update " + TB + " set " + cols.get(0) + " = '" + data2.get(0) + "'";

                for (int i = 1; i < data2.size(); i++) {
                    ST = ST.concat("," + cols.get(i) + " = '" + data2.get(i) + "'");
                }
                ST = ST.concat(" WHERE " + cols.get(0) + " = '" + data1.get(0) + "'");
                for (int i = 1; i < data1.size(); i++) {
                    ST = ST.concat("AND " + cols.get(i) + " = '" + data1.get(i) + "'");
                }
                st.executeUpdate(ST);
                st.close();
                return true;
            }
            return false;
        } catch (SQLException | ClassNotFoundException er) {
            return false;
        } finally {
            if (CONNECTION != null) {
                CONNECTION.close();
                this.CONNECTION = null;
                System.gc();
            }
        }
    }

    public boolean hasRecord(String TB, String idLb, String val) throws SQLException {
        try {
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                this.PREPAREDST = CONNECTION.prepareStatement("SELECT * FROM " + TB + " WHERE " + idLb + " = '" + val + "'");
                this.RESULTS = PREPAREDST.executeQuery();
                while (RESULTS.next()) {
                    return true;
                }

            }
            return false;
        } catch (ClassNotFoundException | SQLException er) {
            return false;
        } finally {
            if (CONNECTION != null) {
                RESULTS.close();
                PREPAREDST.close();
                CONNECTION.close();
                this.CONNECTION = null;
                System.gc();
            }
        }
    }

    public List<String> FetchRowData(String TB, String id, String val) throws SQLException {
        List<String> Data = null;
        try {
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                this.PREPAREDST = CONNECTION.prepareStatement("SELECT * FROM " + TB + " WHERE " + id + " = '" + val + "'");
                this.RESULTS = PREPAREDST.executeQuery();

                int column = RESULTS.getMetaData().getColumnCount();
                String tList[] = {};
                while (RESULTS.next()) {
                    tList = new String[column];
                    int index = 0;
                    for (int i = 1; i <= column; i++) {
                        tList[index] = RESULTS.getString(i);
                        index++;
                    }
                }
                Data = Arrays.asList(tList);
            }
            return Data;
        } catch (ClassNotFoundException | SQLException er) {
            return Data;
        } finally {
            if (CONNECTION != null) {
                RESULTS.close();
                PREPAREDST.close();
                CONNECTION.close();
                this.CONNECTION = null;
                System.gc();
            }
        }
    }

    public boolean SaveFile(String TB, String ID, File f) throws SQLException {
        try {
            String INSERT_PICTURE = "INSERT INTO " + TB + " VALUES( ?, ?)";
            FileInputStream fis = null;
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                this.PREPAREDST = CONNECTION.prepareStatement(INSERT_PICTURE);
                fis = new FileInputStream(f);
                PREPAREDST.setString(1, ID);
                PREPAREDST.setBinaryStream(2, fis, (int) f.length());
                PREPAREDST.executeUpdate();

            }

            return true;
        } catch (Exception er) {
            System.out.println(er);
            return false;
        } finally {
            if (CONNECTION != null) {
                PREPAREDST.close();
                CONNECTION.close();
                this.CONNECTION = null;
                System.gc();
            }
        }
    }

    public BufferedImage getBufferedImage(String TB, String imgCol, String idLb, String ID) throws SQLException, IOException {
        ByteArrayOutputStream output = null;
        try {
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                this.PREPAREDST = CONNECTION.prepareStatement("SELECT * FROM " + TB + " WHERE " + idLb + " = '" + ID + "'");
                this.RESULTS = PREPAREDST.executeQuery();
                RESULTS.next();
                InputStream stream = RESULTS.getBinaryStream(imgCol);
                output = new ByteArrayOutputStream();
                int a1 = stream.read();
                while (a1 >= 0) {
                    output.write((char) a1);
                    a1 = stream.read();
                }

                ByteArrayInputStream ba = new ByteArrayInputStream(output.toByteArray());
                BufferedImage BI = ImageIO.read(ba);

                return BI;//Toolkit.getDefaultToolkit().createImage(output.toByteArray());

            }
            return null;
        } catch (ClassNotFoundException | SQLException er) {
            return null;
        } finally {
            if (CONNECTION != null) {
                RESULTS.close();
                PREPAREDST.close();
                CONNECTION.close();
                this.CONNECTION = null;
                output.close();
                System.gc();
            }
        }
    }

    public Image getImage(String TB, String imgCol, String idLb, String ID) throws SQLException, IOException {
        ByteArrayOutputStream output = null;
        try {
            if (CONNECTION == null) {
                Class.forName(DRIVER[TYPE]);
                this.CONNECTION = DriverManager.getConnection(SOURCE, USER, PASS);
                this.PREPAREDST = CONNECTION.prepareStatement("SELECT * FROM " + TB + " WHERE " + idLb + " = '" + ID + "'");
                this.RESULTS = PREPAREDST.executeQuery();
                RESULTS.next();
                InputStream stream = RESULTS.getBinaryStream(imgCol);
                output = new ByteArrayOutputStream();
                int a1 = stream.read();
                while (a1 >= 0) {
                    output.write((char) a1);
                    a1 = stream.read();
                }

                return Toolkit.getDefaultToolkit().createImage(output.toByteArray());

            }
            return null;
        } catch (ClassNotFoundException | SQLException er) {
            return null;
        } finally {
            if (CONNECTION != null) {
                RESULTS.close();
                PREPAREDST.close();
                CONNECTION.close();
                this.CONNECTION = null;
                output.close();
                System.gc();
            }
        }
    }

    public File ResizeImageFile(File f, int w1, int h1) {
        try {
            File to = File.createTempFile("tempResImage", ".tmp");
            FileOutputStream tof = new FileOutputStream(to);
            BufferedImage i = ImageIO.read(f);
            BufferedImage ni = resizeImage(i, i.getColorModel().getTransparency(), w1, h1);
            ImageIO.write(ni, "jpg", tof);

            return to;
        } catch (Exception er) {
            System.out.println(er);
            return null;
        }
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }

    
    
    

}
