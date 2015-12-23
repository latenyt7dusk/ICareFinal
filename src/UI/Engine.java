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
package UI;

import Utilities.DataBridge;
import Utilities.Registry;
import VClass.Manager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Late7dusk
 */
public class Engine {

    public static org.h2.tools.Server LocalServer;
    public static Login LoginUI;
    public static MainFrame MainUI = new MainFrame();
    public static Engine ENGINE = new Engine();
    public static Registry REGISTRY = new Registry();
    public static Manager MANAGER = new Manager(REGISTRY);
    public static DataBridge DB;
    

    public static void main(String[] args) {
        try {

            //Set System Look & Feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //Start Database Server
            LocalServer = org.h2.tools.Server.createTcpServer();
            LocalServer.start();
            DB = new DataBridge(MANAGER.SETTINGS.get(Manager.LOCAL_DB_KEY),MANAGER.SETTINGS.get(Manager.LOCAL_USER),MANAGER.SETTINGS.get(Manager.LOCAL_BRIDGE_KEY),Integer.parseInt(MANAGER.SETTINGS.get(Manager.LOCAL_TYPE_KEY)));
            LoadDefaults();
            LoginUI = new Login();
            LoginUI.setVisible(true);
           

        } catch (SQLException er) {

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if(LocalServer != null){
                LocalServer.shutdown();
            }
        }
    }
    
    private static void LoadDefaults(){
        try {
            DB.RunScript(MANAGER.USER_TABLE_DEFAULT);
            DB.RunScript(MANAGER.PERSONAL_TABLE_DEFAULT);
            DB.RunScript(MANAGER.LOG_TABLE_DEFAULT);
            DB.RunScript(MANAGER.IMAGE_TABLE_DEFAULT);
        } catch (SQLException ex) {
            Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
