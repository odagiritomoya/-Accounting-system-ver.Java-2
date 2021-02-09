package com.example.demo.result.expenses;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class ExpensesForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//getterがInteger
	private String expensesId;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//TODO 候補付にする可能性あり  //getterがInteger
	private String expensesItem;
	@Pattern(regexp = RegexpPattern.DATE, message = RegexpMessage.DATE)
	private String expensesDate;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//getterがInteger
	private String money;
	//省略可
	private String subject;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	public Integer getExpensesId() {
		return Integer.parseInt(expensesId);
	}
	public void setExpensesId(String expensesId) {
		this.expensesId = expensesId;
	}
	public Integer getExpensesItem() {
		return Integer.parseInt(expensesItem);
	}
	public void setExpensesItem(String expensesItem) {
		this.expensesItem = expensesItem;
	}
	public String getExpensesDate() {
		return expensesDate;
	}
	public void setExpensesDate(String expensesDate) {
		this.expensesDate = expensesDate;
	}
	public Integer getMoney() {
		return Integer.parseInt(money);
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getCompanyAccountId() {
		return companyAccountId;
	}
	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
}