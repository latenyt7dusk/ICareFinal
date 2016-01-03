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

/**
 *
 * @author HERU
 */
public class Record {
    
    private String ID,DATE,TIME,COMPLAINT,EXAM,OD,OS,ODVA,OSVA,ODADD,OSADD,CT,SFT,AGT,AC,PD,CASE,DOCTOR,REMARKS;
    
    public void setID(String id){
        this.ID = id;
    }
    public String getID(){
        return this.ID;
    }
    public void setDate(String date){
        this.DATE = date;
    }
    public String getDate(){
        return this.DATE;
    }
    public void setTime(String time){
        this.TIME = time;
    }
    public String getTime(){
        return this.TIME;
    }
    public void setComplaints(String comp){
        this.COMPLAINT = comp;
    }
    public String getComplaints(){
        return this.COMPLAINT;
    }
    public void setExam(String exam){
        this.EXAM = exam;
    }
    public String getExam(){
        return this.EXAM;
    }
    public void setOD(String od){
        this.OD = od;
    }
    public String getOD(){
        return this.OD;
    }
    public void setODVA(String va){
        this.ODVA = va;
    }
    public String getODVA(){
        return this.ODVA;
    }
    public void setODadd(String add){
        this.ODADD = add;
    }
    public String getODadd(){
        return this.ODADD;
    }
    public void setOS(String os){
        this.OS = os;
    }
    public String getOS(){
        return this.OS;
    }
    public void setOSVA(String va){
        this.OSVA = va;
    }
    public String getOSVA(){
        return this.OSVA;
    }
    public void setOSadd(String add){
        this.OSADD = add;
    }
    public String getOSadd(){
        return this.OSADD;
    }
    public void setCT(String ct){
        this.CT = ct;
    }
    public String getCT(){
        return this.CT;
    }
    public void setSFT(String sft){
        this.SFT = sft;
    }
    public String getSFT(){
        return this.SFT;
    }
    public void setAGT(String agt){
        this.AGT = agt;
    }
    public String getAGT(){
        return this.AGT;
    }
    public void setAC(String ac){
        this.AC = ac;
    }
    public String getAC(){
        return this.AC;
    }
    public void setPD(String pd){
        this.PD = pd;
    }
    public String getPD(){
        return this.PD;
    }
    public void setCase(String ca){
        this.CASE = ca;
    }
    public String getCase(){
        return this.CASE;
    }
    public void setDoctor(String doc){
        this.DOCTOR = doc;
    }
    public String getDoctor(){
        return this.DOCTOR;
    }
    public void setRemarks(String rem){
        this.REMARKS =rem;
    }
    public String getRemarks(){
        return this.REMARKS;
    }
}
