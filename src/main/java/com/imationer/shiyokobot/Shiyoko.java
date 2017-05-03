/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imationer.shiyokobot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author Imationer
 */
public class Shiyoko extends TelegramLongPollingBot {
    
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            
            SendMessage enviar = new SendMessage();
            enviar.setChatId(message.getChatId());
            
            if ("/start".equals(message.getText())) {
                enviar.setText("Thanks for choosing me! I hope to be of use to you, so you can focus on playing!");
            } else if (message.getText().contains("/wscard")) {
                enviar.setText("http://www.heartofthecards.com/code/cardlist.html?card=ws_" + message.getText().substring(8));
            }
            
            try {
                sendMessage(enviar);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
                    
        }
    }
    
    @Override
    public String getBotUsername() {
        return "Shiyoko";
    }
    
    @Override
    public String getBotToken() {
        return "300340152:AAGoUui-X9ml1QZypeZODylyUVMjpnnYzZU";
    }
}
