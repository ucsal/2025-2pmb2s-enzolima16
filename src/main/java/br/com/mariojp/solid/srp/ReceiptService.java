package br.com.mariojp.solid.srp;

public class ReceiptService {
	private TaxCalculator taxCalculator = new TaxCalculator();
	private ReceiptFormatter receiptFormatter = new ReceiptFormatter();

	public void ReceiptService(TaxCalculator taxCalculator, ReceiptFormatter receiptFormatter) {
		this.taxCalculator = taxCalculator;
		this.receiptFormatter = receiptFormatter;
	}

	public String generate(Order order) {
		double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
		double tax = TaxCalculator.calculator(subtotal);
		double total = subtotal + tax;
		return receiptFormatter.formatter(order, subtotal, total, tax);
	}
}
