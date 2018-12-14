package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pojos.chat.ChatCreateMessageModel;
import utils.EndPoints;

import java.text.SimpleDateFormat;
import java.util.Date;

import static core.Auth.auth;

public class ChatTests {

    @Test
    @DisplayName(EndPoints.chat_messages + " GET")
    public void testGetChatMessages() {
        auth().get(EndPoints.chat_messages);
    }

    @Test
    @DisplayName(EndPoints.chat_messages + " POST")
    public void testPostChatMessages() {
        String message = "Test " + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
        auth()
                .body(new ChatCreateMessageModel().setMessage(message))
                .post(EndPoints.chat_messages);
    }


}
