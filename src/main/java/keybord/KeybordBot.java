package keybord;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeybordBot {

  private static InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
  private static InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
  private static InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
  private static InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
  private static InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
  private static InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
  private static InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();


   public  SendMessage inlineKeyboard(SendMessage sendMessage) {

        InlineKeyboardMarkup inlineKeyboardMarkup =new InlineKeyboardMarkup();

        inlineKeyboardButton1.setText("1");
        inlineKeyboardButton1.setCallbackData("1");

        inlineKeyboardButton2.setText("12");
        inlineKeyboardButton2.setCallbackData("12");

        inlineKeyboardButton3.setText("15");
        inlineKeyboardButton3.setCallbackData("15");

        inlineKeyboardButton4.setText("36");
        inlineKeyboardButton4.setCallbackData("36");

        inlineKeyboardButton5.setText("Все в налиичии");
        inlineKeyboardButton5.setCallbackData("give_me_success_key");

        inlineKeyboardButton6.setText("Все конченные");
        inlineKeyboardButton6.setCallbackData("give_me_delete_key");

        inlineKeyboardButton7.setText("Добавить");
        inlineKeyboardButton7.setCallbackData("set_key");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);
        keyboardButtonsRow1.add(inlineKeyboardButton3);
        keyboardButtonsRow1.add(inlineKeyboardButton4);
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(inlineKeyboardButton5);
        keyboardButtonsRow2.add(inlineKeyboardButton6);
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow3.add(inlineKeyboardButton7);

        List<List<InlineKeyboardButton>> rowList= new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return sendMessage;
    }
}
