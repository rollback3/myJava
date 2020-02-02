package org.cg;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainGolarion {

	public static void main(String[] args) {

		// Initialize Api Context
		ApiContextInitializer.init();

		// TODO Instantiate Telegram Bots API
		TelegramBotsApi botsApi = new TelegramBotsApi();

		// TODO Register our bot
		try {
			botsApi.registerBot(new TrovaInGolarionBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

}
