# Ejercicio 2: Sistema de Procesamiento de Pagos

Este ejercicio implementa un sistema de procesamiento de pagos que integra proveedores externos con interfaces diferentes usando el patrón Adapter. Además, aplica el patrón Chain of Responsibility para ejecutar validaciones configurables antes del pago.

Proveedores incluidos:
- PayPal
- Stripe
- Tarjeta de crédito
- Transferencia bancaria

Validadores incluidos:
- BalanceValidator
- FraudValidator
- TransactionLimitValidator

La clase `PaymentProviderRegistry` permite registrar nuevos proveedores sin cambiar el código del procesador principal.
