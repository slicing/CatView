package com.example.demo.Controller;

import com.example.demo.WiselyMessage;
import com.example.demo.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class WsController {
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WiselyResponse say(WiselyMessage message) throws InterruptedException {
		Thread.sleep(3000);
		return new WiselyResponse("Welcome " + message.getName());
	}
}
