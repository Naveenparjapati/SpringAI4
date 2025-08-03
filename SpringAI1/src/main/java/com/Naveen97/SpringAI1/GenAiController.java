package com.Naveen97.SpringAI1;

import java.util.List;

import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class GenAiController {

	private final ChatService chatService;
	
	private final ImagService imagService;
	
	
	
	public GenAiController(ChatService chatService, ImagService imagService) {
		this.chatService=chatService;
		this.imagService = imagService;
	}

	@GetMapping("/askai1")
	public String getResponce1(@RequestParam  String prompt)
	{
		return chatService.getResponce(prompt);
	}
	
	
	@GetMapping("/askai2")
	public String getResponce2(@RequestParam  String prompt)
	{
		return chatService.getResponce(prompt);
	}
	
	
//	@GetMapping("/askai3")
//	public void genrateImages(HttpServletResponse response,@RequestParam  String prompt)
//	{
//		ImageResponse imageResponse= imagService.genrateIMg(prompt);
//		String imagUrl=imageResponse.getResult().getOutput().getUrl();
//		 try {
//			response.sendRedirect(imagUrl);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@GetMapping("generate-image")
	public List<String> generateImages(HttpServletResponse response, @RequestParam String prompt) {
	    ImageResponse imageResponse = imagService.genrateIMg(prompt);

	    // Streams to get urls from ImageResponse
	    List<String> imageUrls = imageResponse.getResults().stream()
	        .map(result -> result.getOutput().getUrl())
	        .toList();

	    return  imageUrls;
	}

	

	
}