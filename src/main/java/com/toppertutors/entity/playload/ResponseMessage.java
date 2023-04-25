package com.toppertutors.entity.playload;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseMessage {
	String status;
	 String message;
	 Object data;

}
