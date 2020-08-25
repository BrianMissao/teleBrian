package dominio;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ValidadorDeCamposObrigatorios {
    private List<String> erros = new ArrayList<>();

    public ValidadorDeCamposObrigatorios validarString(String stringAServalidada) throws ExcecaoDeArgumentoInvalido {
        if (stringAServalidada == null || stringAServalidada.equals("")) {
            erros.add("String inválida.");
        }
        return this;
    }

    public ValidadorDeCamposObrigatorios validarBigDecimal(BigDecimal bigDecimalASerValidado) throws ExcecaoDeArgumentoInvalido {
        if (bigDecimalASerValidado == null || bigDecimalASerValidado.compareTo(BigDecimal.ZERO) <= 0) {
            erros.add("BigDecimal inválido");
        }
        return this;
    }

    public ValidadorDeCamposObrigatorios validarObjeto(Object objetoAValidar) throws ExcecaoDeArgumentoInvalido {
        if (objetoAValidar == null) {
            erros.add("Objeto inválido");
        }
        return this;
    }

    public void validar() throws ExcecaoDeArgumentoInvalido {
        if (!erros.isEmpty()) {
            StringBuilder errosConcatenados = new StringBuilder();
            erros.forEach(erro -> errosConcatenados.append(erro + ", "));
            throw new ExcecaoDeArgumentoInvalido(errosConcatenados.toString());
        }
    }
}
