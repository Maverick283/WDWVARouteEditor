/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sql.Acarschat;

/**
 *
 * @author Patrick
 */
public class ChatTab {

    ListView messageList;
    ArrayList<Acarschat> chatList;
    private final CheckBox showSystemMessagsCheckBox;

    public ChatTab(ListView messageList, CheckBox showSystemMessagsCheckBox) {
        this.messageList = messageList;
        this.showSystemMessagsCheckBox = showSystemMessagsCheckBox;

    }

    void createChatHistory(ArrayList<Acarschat> chatList) {
        showSystemMessagsCheckBox.setSelected(true);
        this.chatList = chatList;
        refreshChatHistory(new ActionEvent());
    }

    private void updateChatHistory(boolean showSystemMessages) {
        messageList.getItems().clear();
        if (!showSystemMessages) {
            for (Acarschat instance : chatList) {
                String message = instance.getMessage();
                if (!message.contains("Connected!") && !message.contains("Dis-Connected!")) {
                    messageList.getItems().add(generateListEntry(instance));
                }
            }
        } else {
            for (Acarschat instance : chatList) {
                messageList.getItems().add(generateListEntry(instance));
            }
        }
        messageList.scrollTo(messageList.getItems().size());
    }

    void refreshChatHistory(ActionEvent event) {
        updateChatHistory(showSystemMessagsCheckBox.isSelected());
    }

    private Node generateListEntry(Acarschat instance) {
        AnchorPane toReturn = new AnchorPane();
        String message = instance.getMessage();
        message = message.substring(7);
        String name = message.substring(0, message.indexOf(":") + 1);
        message = message.substring(message.indexOf(":") + 1);

        Label time = new Label(instance.getTimestamp());
        Label nameLabel = new Label(name);
        Label messageLabel = new Label(message);
        
        time.setLayoutX(0);
        nameLabel.setLayoutX(120);
        messageLabel.setLayoutX(300);
        
        
        toReturn.getChildren().addAll(time, nameLabel, messageLabel);   
        return toReturn;
    }
}
