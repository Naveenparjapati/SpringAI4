package com.Naveen97.SpringAI1;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImagService {
       
	private final OpenAiImageModel openAiImageModel;

	public ImagService(OpenAiImageModel openAiImageModel) {
		this.openAiImageModel = openAiImageModel;
	}
	
	public ImageResponse genrateIMg(String prompt)
	{
		ImageResponse imageResponse = openAiImageModel.call(
				
				 new ImagePrompt(prompt,
						    OpenAiImageOptions.builder()
						    .model("dall-e-2")
						        .quality("hd")
						        .N(4)
						        .height(1024)
						        .width(1024).build())

				);
				return imageResponse;
	}
}
