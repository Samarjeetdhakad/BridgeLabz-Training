package com.fundoo.dto.note;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRequestDTO {
	
	@NotBlank(message = "title can no be blank")
	private String title;
	
	@NotBlank(message = " content can not be blank")
	@Size(min = 2 , max = 2000, message = "size in between 2 to 2000")
	private String content;
}
