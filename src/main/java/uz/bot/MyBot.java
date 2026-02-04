package uz.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Java-testbot";
    }

    @Override
    public String getBotToken() {
        return "8599762784:AAF9pXWI-7dMQ_TZPKls7btpTndf2Ki9KKQ";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            String response = "Tushunmadim 🤔";

            if (text.equals("/start")){
                response = "Salom! Men Smart Java Botman \uD83E\uDD16";
            }
            else if (text.equals("/help")){
                response = """
                    Men quyidagilarni qila olaman:
                    /start - botni boshlash
                    /help  - yordam
                    vaqt   - hozirgi vaqt
                    """;
            }
            else if (text.equals("salom")){
                response = "Salom 😄 Qalaysan?";
            }
            else if (text.equals("vaqt")){
                response = "⏰ Hozirgi vaqt: " + java.time.LocalTime.now();
            }

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(response);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
