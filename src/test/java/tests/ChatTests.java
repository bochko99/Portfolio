package tests;

import com.crypterium.cryptApi.pojos.chat.ChatCreateMessageModel;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.MobileTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.crypterium.cryptApi.Auth.auth;

public class ChatTests extends MobileTest {

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
