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

/**
 *
 * @author Late7dusk
 */
public class Log {
    
    private final String logger,description,date,time;
    
    public Log(String log,String desc,String date,String time){
        this(log,desc,date,time,false);
    }
    
    public Log(String log,String desc,String date,String time,boolean save){
        this.date = date;
        this.time = time;
        this.logger = log;
        this.description = desc;
        
        if(save){
            
        }
    }
    
    public String getLogger(){
        return logger;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getTime(){
        return time;
    }
}
