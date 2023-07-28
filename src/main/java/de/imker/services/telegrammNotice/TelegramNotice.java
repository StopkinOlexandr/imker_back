package de.imker.services.telegrammNotice;

import okhttp3.*;

import java.io.IOException;

public class TelegramNotice {
  public static void sendTelegramNotice(String message) {

    String botToken = "6300117312:AAFuAe05tNIO58jo1Z1cGwjU54vQG888Cm0";
    String chatId = "-1001767992658";

    OkHttpClient client = new OkHttpClient();
    String urlString = "https://api.telegram.org/bot" + botToken + "/sendMessage";

    RequestBody requestBody = new FormBody.Builder()
        .add("chat_id", chatId)
        .add("text", message)
        .build();

    Request request = new Request.Builder()
        .url(urlString)
        .post(requestBody)
        .build();

    try {
      Response response = client.newCall(request).execute();
      String responseBody = response.body().string();

      System.out.println("Ответ сервера: " + responseBody);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

