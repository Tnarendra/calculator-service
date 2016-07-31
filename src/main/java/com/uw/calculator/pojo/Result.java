package com.uw.calculator.pojo;

public class Result {

	Integer a;
	Integer b;
	Integer c;
	Integer result;

	public Result(Integer a, Integer b, Integer c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Integer getA() {
		return a;
	}

	public Integer getB() {
		return b;
	}


	public Integer getC() {
		return c;
	}


	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

}
