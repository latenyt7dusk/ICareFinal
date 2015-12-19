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
package Utilities;

import VClass.ClassManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HERU
 */
public class Registry {

    private Runtime runtime;
    private Process process;
    private int result;
    private BufferedReader stream;

    public static String HKCR = "HKEY_CLASSES_ROOT";
    public static String HKCU = "HKEY_CURRENT_USER";
    public static String HKLM = "HKEY_LOCAL_MACHINE";
    public static String HKU = "HKEY_USERS";
    public static String HKCC = "HKEY_CURRENT_CONFIG";

    public static String STRING = "REG_SZ";
    public static String BINARY = "REG_BINARY";

    public static Map<String, String> LOG_DATA;

    public Registry() {
        this.runtime = Runtime.getRuntime();
    }

    public static void main(String args[]) {
        try {
            Registry wr = new Registry();
            new ClassManager(wr);
            //wr.setSubKey(Registry.HKCU, "SOFTWARE\\NakpilSoftwares\\EyeCare\\Data\\Log", Registry.BINARY, "Logger", reverse(StringtoHex("LOGGER")));
            //wr.getSubKeys(Registry.HKCU, "SOFTWARE\\NakpilSoftwares");
            Map<String, String> vals = wr.getREG_BINARY(Registry.HKCU, "SOFTWARE\\NakpilSoftwares\\EyeCare\\Data\\Log");
            Set<String> e = vals.keySet();
            for (String name : e) {
              if (name.equals("Logger")) {
                //JOptionPane.showMessageDialog(null, vals.get(name));
              break;
            }
            }

            //System.out.println(reverse("50616b20796f75206b61"));
            //System.out.println(reverse("49383b79203f24793b38"));
        } catch (Exception ex) {
            Logger.getLogger(Registry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String reverse(String text) {
        char[] x = "9876543210".toCharArray();
        char[] chText = text.toCharArray();
        for (int i = 0; i < chText.length; i++) {
            for (int z = 0; z < x.length; z++) {
                if (chText[i] == x[z]) {
                    chText[i] = x[Character.getNumericValue(chText[i])];
                    break;
                }
            }
        }
        return String.valueOf(chText);
    }

    public static String StringtoHex(String text) {
        byte[] buf = text.getBytes();
        char[] HEX_CHARS = "0123456789abcdef".toCharArray();
        char[] chars = new char[2 * buf.length];
        for (int i = 0; i < buf.length; ++i) {
            chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
            chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
        }
        return new String(chars);
    }

    public String HextoString(String txtInHex) {
        byte[] txtInByte = new byte[txtInHex.length() / 2];
        int j = 0;
        for (int i = 0; i < txtInHex.length(); i += 2) {
            txtInByte[j++] = Byte.parseByte(txtInHex.substring(i, i + 2), 16);
        }
        return new String(txtInByte);
    }

    public boolean newKey(String root, String key) throws IOException {
        try {
            process = runtime.exec("REG ADD " + root + "\\" + key);
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = stream.readLine()) != null) {
                System.out.println(line);
            }
            result = process.waitFor();

            if (result == 0) {
                return true;
            }
            return false;
        } catch (IOException | InterruptedException er) {
            process.destroy();
            return false;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public boolean setSubKey(String root, String key, String type, String name, String val) throws IOException {
        try {
            val = ((type.equalsIgnoreCase("REG_BINARY")) ? val : val.replaceAll(" ", "\" \""));
            System.out.print(val);
            process = runtime.exec("REG ADD " + root + "\\" + key + " /v " + name + " /t " + type + " /d " + val + " /f");
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = stream.readLine()) != null) {
                System.out.println(line);
            }
            result = process.waitFor();

            if (result == 0) {
                return true;
            }
            return false;
        } catch (IOException | InterruptedException er) {
            process.destroy();
            return false;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public List<String> getSubKeys(String root, String key) throws IOException {
        List<String> keys = new ArrayList();
        try {
            process = runtime.exec("REG QUERY " + root + "\\" + key);
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = stream.readLine()) != null) {
                if (line.contains(root + "\\" + key + "\\")) {
                    line = line.replace(root + "\\" + key + "\\", "");
                    keys.add(line);
                }
            }
            result = process.waitFor();
            return keys;

        } catch (IOException | InterruptedException er) {
            process.destroy();
            return keys;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public Map<String, String> getValues(String root, String key) throws IOException {
        Map<String, String> keys = new HashMap();
        try {
            process = runtime.exec("REG QUERY " + root + "\\" + key + " /s");
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = stream.readLine()) != null) {
                if (!line.isEmpty() && !line.contains(root + "\\" + key) && !line.contains("REG.EXE")) {
                    String tmp[] = line.split("[\t]");
                    System.out.println(tmp[0]);
                    tmp[0] = tmp[0].trim();
                    keys.put(tmp[0], tmp[2]);
                }
            }
            result = process.waitFor();
            return keys;

        } catch (IOException | InterruptedException er) {
            process.destroy();
            return keys;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public Map<String, String> getREG_BINARY(String root, String key) throws IOException {
        Map<String, String> keys = new HashMap();
        try {
            process = runtime.exec("REG QUERY " + root + "\\" + key + " /s");
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = stream.readLine()) != null) {
                if (!line.isEmpty() && !line.contains(root + "\\" + key) && !line.contains("REG.EXE")) {
                    String tmp[] = line.trim().split("REG_BINARY");
                    keys.put(tmp[0].trim(), tmp[1].trim());
                }
            }
            result = process.waitFor();
            return keys;

        } catch (IOException | InterruptedException er) {
            process.destroy();
            return keys;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public static class Log {

        public static String LOGGER;

        public static void Load() {
            LOGGER = LOG_DATA.get("Logger");
        }

    }

}
