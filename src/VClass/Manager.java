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

import Utilities.DataBridge;
import Utilities.Registry;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Late7dusk
 */
public class Manager {

    private Registry myRegistry;
    public static final String DEFAULT_DATE_FORMAT = "MMM dd, yyyy";
    public static final String SYSTEM = "SOFTWARE\\NakpilSoftwares\\EyeCare";
    public String SETTINGS_KEY = "Settings";
    
    //User
    public static final Map<String,Integer> USER_TABLE_MAP = new HashMap(){
        {
            put(ID,0);
            put(USERNAME,1);
            put(PASSWORD,2);
            put(ROLE,3);
        }  
    };
    public static final String USER_TABLE_NAME = "Users";
    public static final String USERNAME = "Username";//1
    public static final String PASSWORD = "Password";//2
    public static final String ROLE = "Role";//3
    public final String USER_TABLE_DEFAULT = "CREATE TABLE IF NOT EXISTS "+USER_TABLE_NAME+" ("+ID+" VARCHAR(255),"
            +USERNAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(255),"+ROLE+" VARCHAR(255))";
    
    public boolean saveNewUser(User e,DataBridge DB){
        try{
            DB.InsertBatchData(e.getBatch());
            return true;
        }catch(Exception er){
            return false;
        }
    }
    
    public List<User> getUsers(DataBridge DB){
        java.util.List<User> tmp = new java.util.ArrayList();
        try{
            java.util.List<List> coll = DB.FetchTableCollection(USER_TABLE_NAME);
            for(List<String> e:coll){
                String id = e.get(USER_TABLE_MAP.get(ID));
                String user = e.get(USER_TABLE_MAP.get(USERNAME));
                String pass = e.get(USER_TABLE_MAP.get(PASSWORD));
                String role = e.get(USER_TABLE_MAP.get(ROLE));
                tmp.add(new User(id,user,pass,role));
            }
            return tmp;
        }catch(Exception er){
            return tmp;
        }
    }
    
    
    
    //Personal Info
    public static final Map<String,Integer> PERSONAL_TABLE_MAP = new HashMap(){
        {
            put(ID,0);
            put(SURNAME,1);
            put(FIRSTNAME,2);
            put(MIDDLENAME,3);
            put(BIRTHDATE,4);
            put(GENDER,5);
            put(CIVILSTATUS,6);
            put(CONTACT,7);
            put(EMAIL,8);
            put(ADDRESS,9);
        }  
    };
    public static final String PERSONAL_TABLE_NAME = "Profiles";
    public static final String ID = "ID";//0
    public static final String SURNAME = "Surname";//1
    public static final String FIRSTNAME = "Firstname";//2
    public static final String MIDDLENAME = "Middlename";//3
    public static final String BIRTHDATE = "Birthdate";//4
    public static final String GENDER = "Gender";//5
    public static final String CIVILSTATUS = "Civilstatus";//6
    public static final String CONTACT = "Contact";//7
    public static final String EMAIL = "Email";//8
    public static final String ADDRESS = "Address";//9
    public final String PERSONAL_TABLE_DEFAULT = "CREATE TABLE IF NOT EXISTS "+PERSONAL_TABLE_NAME+" ("+ID+" VARCHAR(255),"+SURNAME
            +" VARCHAR(255),"+FIRSTNAME+" VARCHAR(255),"+MIDDLENAME+" VARCHAR(255),"+BIRTHDATE+" VARCHAR(255),"+GENDER+" VARCHAR(255),"
            +CIVILSTATUS+" VARCHAR(255),"+CONTACT+" VARCHAR(255),"+EMAIL+" VARCHAR(255),"+ADDRESS+" VARCHAR(255))";
    
    //Logger
    public static final Map<String,String> LOG_TABLE_MAP = new HashMap(){
        {
            put(ID,0);
            put(LOGGER,1);
            put(DESCRIPTION,2);
            put(TYPE,3);
            put(DATE,4);
            put(TIME,5);
        }
    };
    public static final String LOG_TABLE_NAME = "Logs";
    public static final String LOGGER = "Logger";//1
    public static final String DESCRIPTION = "Description";//2
    public static final String TYPE = "Type";//3
    public static final String DATE = "Date";//4
    public static final String TIME = "Time";//5
    public final String LOG_TABLE_DEFAULT = "CREATE TABLE IF NOT EXISTS "+LOG_TABLE_NAME+" ("+ID+" VARCHAR(255),"+DESCRIPTION+
            " VARCHAR(255),"+LOGGER+" VARCHAR(255),"+TYPE+" VARCHAR(255),"+DATE+" VARCHAR(255),"+TIME+" VARCHAR(255))";
    
    //Image
    public static final Map<String,Integer> IMAGE_TABLE_MAP = new HashMap(){
        {
            put(ID,0);
            put(DATA,1);
        }  
    };
    public static final String IMAGE_TABLE_NAME = "Image";
    public static final String DATA = "Data";
    public final String IMAGE_TABLE_DEFAULT = "CREATE TABLE IF NOT EXISTS "+IMAGE_TABLE_NAME+" ("+ID+" VARCHAR(255),IMAGE BLOB)";
    
    
    public Map<String,String> SETTINGS = new HashMap(){
        {
            put(LOCAL_DB_KEY,"jdbc:h2:tcp://localhost/~/NakpilSoftwares/EyeCare/database");
            put(SERVER_DB_KEY,"");
            put(LOCAL_BRIDGE_KEY,"root");
            put(SERVER_BRIDGE_KEY,"");
            put(LOCAL_USER,"root");
            put(SERVER_USER,"");
            put(LOCAL_TYPE_KEY,"3");
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
    
    //<editor-fold defaultstate="collapsed" desc=" UUID Code Block">  
    public static String getNewID(String head) {
        try {
            Calendar cal = new GregorianCalendar();
            String temp[] = cal.getTime().toString().split("[: ]");
            return head + cal.get(Calendar.YEAR) + (cal.get(Calendar.MONTH)+1) + "" + cal.get(Calendar.DAY_OF_MONTH) + temp[3] + temp[4] + temp[5];
        } catch (Exception er) {
            return null;
        }
    }
    //</editor-fold>
    
}
