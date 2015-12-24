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
package VClass;

import Utilities.DataBridge;
import java.awt.image.BufferedImage;

/**
 *
 * @author HERU
 */
public class User extends PersonalInfo implements Cloneable{
    
    private String uname,upass,role;
    
    
    public User(){
        this(null,null,null,null);
    }
    public User(String id,String u,String p,String r){
        this.setID(id);
        this.uname = u;
        this.upass = p;
        this.role = r;
    }
    
    public void setUsername(String u){
        this.uname = u;
    }
    public String getUsername(){
        return uname;
    }
    
    public void setPassword(String p){
        this.upass = p;
    }
    public String getPassword(){
        return upass;
    }
    
    public void setRole(String r){
        this.role = r;
    }
    public String getRole(){
        return role;
    }
    
    public String getUserEntry(){
        return getID()+","+uname+","+upass+","+role;
    }
    
    public java.util.List<String> getInsertBatch(){
        java.util.List<String> tmp = new java.util.ArrayList();
        tmp.add("INSERT INTO "+Manager.USER_TABLE_NAME+ " VALUES('"+getID()+"','"+uname+"','"+upass+"','"+role+"')");
        tmp.add("INSERT INTO "+Manager.PERSONAL_TABLE_NAME+ " VALUES('"+getID()+"','"+getSurname()+"','"+getFirstname()+"','"
                +getMiddlename()+"','"+getBirthdate()+"','"+getGender()+"','"+getCivilStatus()+"','"+getContactNumber()+"','"
                +getEmail()+"','"+getAddress()+"')");
        return tmp;
    }
    
    public String getUpdateBatch(){
        return "UPDATE "+Manager.USER_TABLE_NAME+" SET "+Manager.FIRSTNAME+" ='"+getFirstname()+"',"+Manager.MIDDLENAME+" ='"
                +getMiddlename()+"',"+Manager.SURNAME+" ='"+getSurname()+"',"+Manager.BIRTHDATE+" ='"+getBirthdate()+"',"
                +Manager.GENDER+" ='"+getGender()+"',"+Manager.CIVILSTATUS+" ='"+getCivilStatus()+"',"+Manager.CONTACT+" ='"
                +getContactNumber()+"',"+Manager.ADDRESS+" ='"+getAddress()+"',"+Manager.EMAIL+" ='"+getEmail()+"' WHERE "
                +Manager.ID+" ='"+getID()+"'"; 
    }
    
    public void LoadPersonalInfo(DataBridge DB){
        try{
            java.util.List<String> data = DB.FetchRowData(Manager.PERSONAL_TABLE_NAME, Manager.ID, getID());
            this.setSurname(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.SURNAME)));
            this.setFirstname(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.FIRSTNAME)));
            this.setMiddlename(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.MIDDLENAME)));
            this.setBirthdate(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.BIRTHDATE)));
            this.setGender(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.GENDER)));
            this.setCivilStatus(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.CIVILSTATUS)));
            this.setContactNumber(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.CONTACT)));
            this.setEmail(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.EMAIL)));
            this.setAddress(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.ADDRESS)));
        }catch(Exception er){
            System.out.println(er);
        }
    }
    
    public BufferedImage LoadImage(DataBridge DB){
        try{
            return DB.getBufferedImage(Manager.IMAGE_TABLE_NAME, Manager.IMAGE, Manager.ID, getID());
        }catch(Exception er){
            System.out.println(er);
            return null;
        }
    }
    
}
