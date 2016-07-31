package com.naren.calculator.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.naren.calculator.pojo.Result;

@Component
@Path("calculator")
public class CalculatorResource {

	private final Logger logger = LoggerFactory.getLogger(CalculatorResource.class);

	@GET
	@Path("/add/{a}/{b:([0-9]*)}{p:/?}{c:([0-9]*)}")
	@Produces(MediaType.APPLICATION_JSON)
	@Cacheable(value = "addResultCache")
	public Result add(@PathParam("a") Integer a, @PathParam("b") Integer b, @PathParam("c") Integer c) {
		logger.debug("Enter add method: a '{}',  b '{}', c '{}'.", a, b, c);
		Result result = new Result(a, b, c);
		if (c != null) {
			result.setResult(a + b + c);
			return result;
		}
		result.setResult(a + b);
		return result;
	}

	@GET
	@Path("/subtract/{a}/{b:([0-9]*)}{p:/?}{c:([0-9]*)}")
	@Produces(MediaType.APPLICATION_JSON)
	@Cacheable(value = "subtractResultCache")
	public Result subtract(@PathParam("a") Integer a, @PathParam("b") Integer b, @PathParam("c") Integer c) {
		logger.debug("Enter substract method: a '{}',  b '{}', c '{}'.", a, b, c);
		Result result = new Result(a, b, c);
		if (c != null) {
			result.setResult(a - b - c);
			return result;
		}
		result.setResult(a - b);
		return result;
	}

	@GET
	@Path("/multiply/{a}/{b:([0-9]*)}{p:/?}{c:([0-9]*)}")
	@Produces(MediaType.APPLICATION_JSON)
	@Cacheable(value = "multiplyResultCache")
	public Result multiply(@PathParam("a") Integer a, @PathParam("b") Integer b, @PathParam("c") Integer c) {
		logger.debug("Enter add method: a '{}',  b '{}', c '{}'.", a, b, c);
		Result result = new Result(a, b, c);
		if (c != null) {
			result.setResult(a * b * c);
			return result;
		}
		result.setResult(a * b);
		return result;
	}

	@GET
	@Path("/divide/{a}/{b}")
	@Produces(MediaType.APPLICATION_JSON)
	@Cacheable(value = "divideResultCache")
	public Result divide(@PathParam("a") Integer a, @PathParam("b") Integer b) {
		logger.debug("Enter devide method: a '{}',  b '{}'.", a, b);

		Result result = new Result(a, b, null);
		result.setResult(a / b);

		return result;

	}

}
