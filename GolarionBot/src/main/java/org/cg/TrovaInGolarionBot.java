package org.cg;

import java.io.IOException;
import org.cg.GolarionScraper.GolarionTalenti;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TrovaInGolarionBot extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {

		if (update.hasMessage() && update.getMessage().hasText()) {
			// Set variables
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();

			String answer=null;
			if (message_text.equals("/start")) {
				SendMessage message = new SendMessage() // Create a message object object
						.setChatId(chat_id).setText(message_text);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else 
/*				if (message_text.equals("/findtalento")) {
				SendMessage message = new SendMessage();// Create a message object object
					message.setChatId(chat_id).setText("Dimmi che talento vuoi cercare");
				
				try {						 
							message.setChatId(chat_id)
								.setText(GolarionTalenti.getTalento(message_text));
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						execute(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
			}
*/
			
			try {
				answer = GolarionTalenti.getTalento(message_text);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			SendMessage message = new SendMessage() // Create a message object object
					.setChatId(chat_id).setText(answer);
			try {
				execute(message); // Sending our message object to user
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}


		}

	}

	public String getBotUsername() {
		return "trovaInGolarioBot";
	}

	@Override
	public String getBotToken() {
		return "900908628:AAG0dEgeaBYz77_JdVDt0V2WXVV3x38qCvw";
	}

}
