package com.ibm.orderentry;

public class OrderRequest {

	private String _id;
	private long orderId;
	private String orderType;
	private String orderAction;
	private String amount;
	private String fundId;
	private String fundName;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderAction() {
		return orderAction;
	}
	public void setOrderAction(String orderAction) {
		this.orderAction = orderAction;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getFundId() {
		return fundId;
	}
	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	
	public OrderRequest() {}
	
	public OrderRequest(
			String orderType,
	String orderAction,
	String amount,
	String fundId,
	String fundName
	) {
		this.orderType = orderType;
		this.orderAction = orderAction;
		this.amount = amount;
		this.fundId = fundId;
		this.fundName = fundName;
	}
}
