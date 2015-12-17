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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HERU
 */
public class WindowsRegistry {
    
    private Runtime runtime;
    private Process process;
    private int result;
    private BufferedReader stream;
    
    public static String HKCR = "HKEY_CLASSES_ROOT";
    public static String HKCU = "HKEY_CURRENT_USER";
    public static String HKLM = "HKEY_LOCAL_MACHINE";
    public static String HKU = "HKEY_USERS";
    public static String HKCC = "HKEY_CURRENT_CONFIG";
    
    public WindowsRegistry(){
        runtime = Runtime.getRuntime();
    }
    
    public static void main(String args[]){
        try {
            WindowsRegistry wr = new WindowsRegistry();
            //wr.setSubKey(WindowsRegistry.HKCU,"SOFTWARE\\NakpilSoftwares\\ICare","REG_EXPAND_SZ","InstallDate","%USERPROFILE%\\Potang ina mo gaga ka\\tae");
            //wr.getSubKeys(WindowsRegistry.HKCU,"SOFTWARE\\NakpilSoftwares");
            JOptionPane.showMessageDialog(null, wr.getValues(WindowsRegistry.HKCU,"SOFTWARE\\NakpilSoftwares\\ICare"));
        } catch (IOException ex) {
            Logger.getLogger(WindowsRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean newKey(String root,String key) throws IOException{
        try{
            process = runtime.exec("REG ADD "+root+"\\"+key);
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = stream.readLine()) != null){
                System.out.println(line);
            }
            result = process.waitFor();
            
            if(result == 0){
                return true;
            }
            return false;
        }catch(IOException | InterruptedException er){
            process.destroy();
            return false;
        }finally{
            if(stream != null){
                stream.close();
            }
        }
    }
    
    public boolean setSubKey(String root,String key,String type,String name,String val) throws IOException{
        try{
            val = val.replaceAll(" ", "\" \"");
            System.out.print(val);
            process = runtime.exec("REG ADD "+root+"\\"+key+" /v "+name+" /t "+type+" /d "+val+" /f");
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = stream.readLine()) != null){
                System.out.println(line);
            }
            result = process.waitFor();
            
            if(result == 0){
                return true;
            }
            return false;
        }catch(IOException | InterruptedException er){
            process.destroy();
            return false;
        }finally{
            if(stream != null){
                stream.close();
            }
        }
    }
    
    
    public List<String> getSubKeys(String root,String key) throws IOException{
        List<String> keys = new ArrayList();
        try{
            process = runtime.exec("REG QUERY "+root+"\\"+key);
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            while((line = stream.readLine()) != null){
                if(line.contains(root+"\\"+key+"\\")){
                    line = line.replace(root+"\\"+key+"\\", "");
                    keys.add(line);
                }
            }
            result = process.waitFor();
            return keys;       
            
        }catch(IOException | InterruptedException er){
            process.destroy();
            return keys;
        }finally{
            if(stream != null){
                stream.close();
            }
        }
    }
    
    public Map<String,String> getValues(String root,String key) throws IOException{
        Map<String,String> keys = new HashMap();
        try{
            process = runtime.exec("REG QUERY "+root+"\\"+key+" /s");
            stream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            while((line = stream.readLine()) != null){
                    //keys.add(line);
            }
            result = process.waitFor();
            return keys;       
            
        }catch(IOException | InterruptedException er){
            process.destroy();
            return keys;
        }finally{
            if(stream != null){
                stream.close();
            }
        }
    }
    
    public String parseVariable(String var,char en){
        try{
            char chars[] = var.toCharArray();
            int enclose = 0;
            String tmp = "";
            boolean read = false;
            for(int i = 0;i < chars.length;i++){
                if(chars[i] == en){
                    read = true;
                    enclose++;
                }
                if(read){
                    tmp = tmp.concat(String.valueOf(chars[i]));
                    System.out.println(tmp);
                }
                if(enclose == 2){
                    break;
                }
            }
            System.out.println("end");
            return tmp;
        }catch(Exception er){
            er.printStackTrace();
            return "";
        }
    }
   
    
}
