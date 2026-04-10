package corte2.semana1.Ejercicio2SistemaProcesamientoPagos;

public class ValidationChainBuilder {
    public static PaymentValidation build(PaymentValidation... validators) {
        if (validators == null || validators.length == 0) {
            return null;
        }

        for (int i = 0; i < validators.length - 1; i++) {
            validators[i].linkWith(validators[i + 1]);
        }
        return validators[0];
    }
}
