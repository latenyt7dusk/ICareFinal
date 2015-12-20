/*
 * Copyright (C) 2015 Late7dusk
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
package VClass;

import Utilities.Registry;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Late7dusk
 */
public class Manager {

    private Registry myRegistry;
    public static final String SYSTEM = "SOFTWARE\\NakpilSoftwares\\EyeCare";
    public String SETTINGS_KEY = "Settings";
    
    
    public String LOG_LOGGER;
    public Map<String,String> SETTINGS = new HashMap(){
        {
            put(LOCAL_DB_KEY,"");
            put(SERVER_DB_KEY,"");
            put(LOCAL_BRIDGE_KEY,"");
            put(SERVER_BRIDGE_KEY,"");
            put(LOCAL_USER,"");
            put(SERVER_USER,"");
            put(LOCAL_TYPE_KEY,"");
            put(SERVER_TYPE_KEY,"");
        }
    };
    public static String LOCAL_DB_KEY = "Local";
    public static String SERVER_DB_KEY = "Server";
    public static String LOCAL_BRIDGE_KEY = "LocalBridge";
    public static String SERVER_BRIDGE_KEY = "ServerBridge";
    public static String LOCAL_USER = "LocalUser";
    public static String SERVER_USER = "ServerUser";
    public static String LOCAL_TYPE_KEY = "LocalDatabase";
    public static String SERVER_TYPE_KEY = "ServerDatabase";

    public Manager(Registry reg) {
        myRegistry = reg;
        SETTINGS = Load(SYSTEM+"\\"+SETTINGS_KEY);
        
    }
    

    private Map<String, String> Load(String dbkey) {
        Map<String, String> vals;
        try {
            vals = myRegistry.getREG_BINARY(Registry.HKCU, dbkey);
            return vals;
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void LoadStartup(){
        try{
            
        }catch(Exception er){
            
        }
    }

}
