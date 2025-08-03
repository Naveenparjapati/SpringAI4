package com.Naveen97.SpringAI1;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;


@Service
public class ChatService {
    
	
	private final ChatModel chatModel;
	
	public ChatService(ChatModel chatModel) {
		// TODO Auto-generated constructor stub
		this.chatModel=chatModel;
	}
	
	public String getResponce(String prompt)
	{
		return chatModel.call(prompt);
		
	}
	
	public AssistantMessage getResponseOptions(String prompt) {
	    ChatResponse response = chatModel.call(
	        new Prompt(
	            prompt,
	            OpenAiChatOptions.builder()
	                .model("gpt-4-o")
	                .temperature(0.4)
	                .build()
	        )
	    );

	    return response.getResult().getOutput();
	}

	
}
