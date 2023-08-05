package com.mvc.common.controller;

public class ViewResolver {
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {	// viewName = /board/getBoardList이면 prefix = /WEB-INF , suffix = .jsp
		return prefix + viewName + suffix;
	}
}
