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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Late7dusk
 */
public class Patient extends PersonalInfo{
    
    public static final String RECORDS = Manager.RECORDS_TABLE_NAME;
    public static final String TRANSACTIONS = Manager.TRANSACTIONS_TABLE_NAME;
    public static final String LOGS = Manager.LOG_TABLE_NAME;
    
    private Map<String,Map<String,Object>> DATA = new HashMap(){
        {
            put(RECORDS,new HashMap<String,Object>());
            put(TRANSACTIONS,new HashMap<String,Object>());
            put(LOGS,new HashMap<String,Object>());
        }
    };
    
    public Patient(){
        this(null,null,null);
    }
    public Patient(String s,String f,String m){
        
    }
}
