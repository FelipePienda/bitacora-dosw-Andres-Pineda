package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class Main {
    public static void main(String[] args) {
        PaymentProviderRegistry registry = new PaymentProviderRegistry();
        registry.registerProvider("PAYPAL", PayPalAdapter::new);
        registry.registerProvider("STRIPE", StripeAdapter::new);
        registry.registerProvider("CREDIT_CARD", CreditCardAdapter::new);
        registry.registerProvider("BANK_TRANSFER", BankTransferAdapter::new);

        PaymentValidation validationChain = ValidationChainBuilder.build(
                new BalanceValidator(5000),
                new FraudValidator(),
                new TransactionLimitValidator(2000)
        );

        PaymentRequest paypalPayment = new PaymentRequest(
                "cliente@correo.com",
                1200,
                "USD",
                "PAYPAL",
                "cliente@correo.com"
        );
        PaymentProcessor paypalProcessor = new PaymentProcessor(registry.getProvider("PAYPAL"), validationChain);
        paypalProcessor.process(paypalPayment);

        PaymentRequest stripePayment = new PaymentRequest(
                "usuario@ejemplo.com",
                1800,
                "USD",
                "STRIPE",
                "stripe-token-1234"
        );
        PaymentProcessor stripeProcessor = new PaymentProcessor(registry.getProvider("STRIPE"), validationChain);
        stripeProcessor.process(stripePayment);

        PaymentRequest creditCardPayment = new PaymentRequest(
                "tarjeta@cliente.com",
                2200,
                "USD",
                "CREDIT_CARD",
                "4111-1111-1111-1111"
        );
        PaymentProcessor creditCardProcessor = new PaymentProcessor(registry.getProvider("CREDIT_CARD"), validationChain);
        creditCardProcessor.process(creditCardPayment);

        PaymentRequest bankTransferPayment = new PaymentRequest(
                "cliente@banco.com",
                800,
                "USD",
                "BANK_TRANSFER",
                "ES7921000813610123456789"
        );
        PaymentProcessor bankTransferProcessor = new PaymentProcessor(registry.getProvider("BANK_TRANSFER"), validationChain);
        bankTransferProcessor.process(bankTransferPayment);
    }
}
