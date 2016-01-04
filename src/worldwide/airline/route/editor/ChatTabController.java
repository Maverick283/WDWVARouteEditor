/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sql.Acarschat;
import sql.Pilots;

/**
 *
 * @author Patrick
 */
public class ChatTabController {

    ListView messageList;
    ArrayList<Acarschat> chatList;
    private final CheckBox showSystemMessagsCheckBox;
    private final MainUIController father;
    private final Button sendButton;
    private final TextField textField;
    private Integer lastMessageID;
    private Timeline timeline;

    public ChatTabController(MainUIController father, TextField textField, Button sendButton, ListView messageList, CheckBox showSystemMessagsCheckBox) {
        this.sendButton = sendButton;
        this.textField = textField;
        this.father = father;
        this.messageList = messageList;
        this.showSystemMessagsCheckBox = showSystemMessagsCheckBox;

        sendButton.setOnAction((ActionEvent event) -> {
            prepareSendMessage();
        });

        textField.setOnAction((ActionEvent event) -> {
            prepareSendMessage();
        });

        BooleanProperty userOnline = new SimpleBooleanProperty(father.getUser() == null);
        sendButton.visibleProperty().bind(userOnline);
        textField.editableProperty().bind(userOnline);

    }

    private void prepareSendMessage() {
        if (father.getUser() == null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            chatList.add(new Acarschat(0, father.getUser().getPilotid(), "System: You cannot send messages if you are not logged on!", "00:00", timestamp));
            refreshChatHistory(new ActionEvent());
        } else if (!textField.getText().isEmpty() && father.getUser() != null) {
            sendMessage(textField.getText());
            textField.setText("");
        }
    }

    void createChatHistory(ArrayList<Acarschat> chatList) {
        showSystemMessagsCheckBox.setSelected(true);
        this.chatList = chatList;
        refreshChatHistory(new ActionEvent());

        lastMessageID = chatList.get(chatList.size() - 1).getId();

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), (ActionEvent actionEvent) -> {
                    checkForNewMessages();
                }),
                new KeyFrame(Duration.seconds(1))
        );
        getTimeline().setCycleCount(Animation.INDEFINITE);
        getTimeline().play();
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

    private void sendMessage(String message) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if (message.contains("\\")) {
            chatList.add(new Acarschat(0, father.getUser().getPilotid(), "System: You cannot include a backslash in your Message!", "00:00", timestamp));
            refreshChatHistory(new ActionEvent());
        } else {
            message = message.replace("'", "\\'");
            Pilots user = father.getUser();
            String userID = String.valueOf(user.getPilotid());
            while (userID.length() < 4) {
                userID = "0" + userID;
            }
            String sql = "INSERT INTO wdwvacom_wdw.acarschat (pilotid, message, `time`, `timestamp`) "
                    + "VALUES (" + user.getPilotid() + ", '[" + time + "]WDW" + userID + " " + user.getFirstname() + " " + user.getLastname() + ": " + message + "', '" + time + "', '" + timestamp + "');";
            try {
                father.con.createStatement().execute(sql);
            } catch (SQLException ex) {
                System.out.println(sql + " could not be executed");
                ex.printStackTrace(System.out);
            }
        }
    }

    private void checkForNewMessages() {
        boolean newMessagesRecieved = false;
        String sql = "select * from acarschat where id > " + lastMessageID + ";";
        try {
            ResultSet rs = father.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int pilotid = rs.getInt("pilotid");
                String message = rs.getString("message");
                String time = rs.getString("time");
                String timestamp = rs.getString("timestamp");

                Acarschat chatMessage = new Acarschat(id, pilotid, message, time, timestamp);
                lastMessageID = id;
                chatList.add(chatMessage);
                newMessagesRecieved = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatTabController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (newMessagesRecieved) {
            refreshChatHistory(new ActionEvent());
        }
    }

    /**
     * @return the timeline
     */
    public Timeline getTimeline() {
        return timeline;
    }

}
