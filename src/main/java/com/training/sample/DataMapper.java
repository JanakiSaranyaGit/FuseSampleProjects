package com.training.sample;

import org.apache.camel.Exchange;

public class DataMapper {

	public void process(Exchange exchange) throws InvalidInputException
	{
		RequestData inputData= exchange.getIn().getBody(RequestData.class);
		boolean valid=validate(inputData);
		frameSuccessResponse(exchange,inputData,valid);
		
	}
	
	boolean validate(RequestData inputData) throws InvalidInputException
	{
		if(inputData.getName()!=null && inputData.getAge()!=null)
		{
			return true ;
		}
		else
		{
			throw new InvalidInputException("Invalid Input");
		}
	}
	
	void frameSuccessResponse(Exchange exchange,RequestData inputData,boolean valid)
	{
		ResponseData response=new ResponseData();
		response.setName(inputData.getName());
		response.setAge(inputData.getAge());
		response.setReturnCode(Boolean.valueOf(valid).toString());
		response.setMsg("success");
		exchange.getIn().setBody(response, ResponseData.class);
	}
	void frameInvalidInputErrorResponse(Exchange exchange,RequestData inputData)
	{
		ResponseData response=new ResponseData();
		response.setName(inputData.getName());
		response.setAge(inputData.getAge());
		response.setReturnCode(Boolean.valueOf(false).toString());
		response.setMsg("InvalidInputError");
		exchange.getIn().setBody(response, ResponseData.class);
	}
	void frameGenericErrorResponse(Exchange exchange,RequestData inputData)
	{
		ResponseData response=new ResponseData();
		response.setName(inputData.getName());
		response.setAge(inputData.getAge());
		response.setReturnCode(Boolean.valueOf(false).toString());
		response.setMsg("Generic Error");
		exchange.getIn().setBody(response, ResponseData.class);
	}
	void sendResponse(Exchange exchange,ResponseData response)
	{
		response.setCompletionStatus("completed");
		exchange.getIn().setBody(response, ResponseData.class);
	}
	
}
