package airlinemanagementsystem.payment;

public class Payment {

	private String paymentId;
	private String paymentMethod;
	private double amount;
	private PaymentStatus status;
	
	
	public Payment(String paymentId, String paymentMethod, double amount, PaymentStatus status) {
		super();
		this.paymentId = paymentId;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
		this.status = status;
	}
	
	public void proccessPayment() {
		status = PaymentStatus.COMPLETED;
	}
	
	
}
