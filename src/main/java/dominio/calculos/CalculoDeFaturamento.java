package dominio.calculos;

import dominio.entidades.assinante.Assinante;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CalculoDeFaturamento implements Calculos {
    private List<Assinante> assinantes;

    public CalculoDeFaturamento(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public BigDecimal calcular() {
        return assinantes.stream().map(assinante -> assinante.obterValorDoPlano()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
