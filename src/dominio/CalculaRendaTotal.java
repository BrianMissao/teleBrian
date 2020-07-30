package dominio;

import dominio.entidades.Assinante;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CalculaRendaTotal {
    public static BigDecimal calcular(List<Assinante> assinantes) {
        return assinantes.stream().map(assinante -> assinante.getPlano().getValor()).reduce(new BigDecimal("0.00"), (x, y) -> x.add(y)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
