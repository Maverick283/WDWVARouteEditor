/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.omg.CORBA.INITIALIZE;
import sql.Aircraft;

/**
 *
 * @author Eduards
 */
public class ProblematicRoutesTab {

    static void reload() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private final MainUIController father;
    
    ProblematicRoutesTab (MainUIController father){
        this.father = father;
    }
    
    public void refreshButton(){
        ProblematicRoutesTab.reload();
    }
}

