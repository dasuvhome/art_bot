import DAO.ConnectionDAO;
import Models.Key;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ArtgetKeyBot extends TelegramLongPollingBot {
    Properties properties = new Properties();
    InputStream input = null;
    ConnectionDAO connectionDAO = null;
    SendMessage message = null;
    String[] sizeKeys = null;
    String[] nameKeys = null;
    Key[] arrayKey= null;
    ArrayList<Key> arrayListKey = null;







    public void onUpdateReceived(Update update) {
        Key key = null;
        connectionDAO = new ConnectionDAO();

        String command = update.getMessage().getText();
        message = new SendMessage();



        switch (command) {
                case "/hello@get_me_key_bot" : {
                message.setText("Привет");
                break;
            }
            case "/1@get_me_key_bot": {
                getOneKey("1", update);
                String nameKey = messCatcher(message, update).getText();
                connectionDAO.updateStatus(nameKey);
                break;
            }
            case "/12@get_me_key_bot": {
                getOneKey("12", update);
                String nameKey = messCatcher(message, update).getText();
                connectionDAO.updateStatus(nameKey);
                break;
            }
            case "/15@get_me_key_bot": {
                getOneKey("15", update);
                String nameKey = messCatcher(message, update).getText();
                connectionDAO.updateStatus(nameKey);
                break;
            }
            case "/36@get_me_key_bot": {
                getOneKey("36", update);
                String nameKey = messCatcher(message, update).getText();
                connectionDAO.updateStatus(nameKey);
                break;
            }
            case "/all_keys@get_me_key_bot": {
                String fullKeyMessage = connectionDAO.sampleKey("y");
                message.setText(fullKeyMessage);
                break;
            }
            case "/all_keys_delete_keys@get_me_key_bot": {
                String fullKeyMessage = connectionDAO.sampleKey("n");
                message.setText(fullKeyMessage);
                break;
            }
            default: {
              sizeKeys =  parseKeys(command, "\\s\\d\\d\\s");
               nameKeys = parseKeys(command, "\\d{10}.");
                     arrayKey = new Key[sizeKeys.length];
                 for (int i = 0; i< sizeKeys.length; i++){
                     arrayKey[i] = new Key(sizeKeys[i], nameKeys[i], "y");
                 }
                 arrayListKey = new ArrayList<>(Arrays.asList(arrayKey));
                boolean writeKey = connectionDAO.insertKey(arrayListKey);
                if (writeKey)
                message.setText("Добавлен ключ в базу данных");
                else message.setText("Я такого ключа не знаю");
                break;

            }
        }


            message.setChatId(update.getMessage().getChatId());



            String chatId = message.getChatId();

        //тут добавляем приватность  наших пользователей, кому отвечает бот
        if (chatId.equals("273426130") || chatId.equals("-551020605")) {
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }

    public String getBotUsername() {
        getProperties();
        return properties.getProperty("name_bot");
    }

    public String getBotToken() {
        getProperties();
        return properties.getProperty("token_bot");
    }

    void getProperties() {
        input = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getOneKey(String sizeKey, Update update) {
        String oneKey = connectionDAO.sampleOneKeyFromTableKey(sizeKey);

            message.setText(oneKey);


    }
    public SendMessage messCatcher(SendMessage sendMessage, Update up){
        SendMessage messageCatcher = sendMessage.setChatId(up.getMessage().getChatId());

        return messageCatcher;
    }
    public String[] parseKeys(String text, String parse){
        String[] matches = Pattern.compile(parse)
                .matcher(text)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        return matches;
    }
}
