package dominio;

import dominio.entidades.assinante.Assinante;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CalculaFaturamento {
    public static BigDecimal calcular(List<Assinante> assinantes) {
        return assinantes.stream().map(assinante -> assinante.obterValorDoPlano()).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);
    }
}
