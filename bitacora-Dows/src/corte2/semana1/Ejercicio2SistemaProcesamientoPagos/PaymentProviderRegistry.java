package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentProviderRegistry {
    private final Map<String, Supplier<PaymentProvider>> providers = new HashMap<>();

    public void registerProvider(String name, Supplier<PaymentProvider> supplier) {
        providers.put(name.toUpperCase(), supplier);
    }

    public PaymentProvider getProvider(String name) {
        Supplier<PaymentProvider> supplier = providers.get(name.toUpperCase());
        if (supplier == null) {
            throw new IllegalArgumentException("Proveedor de pago no registrado: " + name);
        }
        return supplier.get();
    }
}
