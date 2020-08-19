package dominio;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;

public class Validador {

    public void validarString(String stringAServalidada) throws ExcecaoDeArgumentoInvalido {
        if (stringAServalidada == null || stringAServalidada.equals("")) {
            throw new ExcecaoDeArgumentoInvalido("String inválida.");
        }
    }

    public void validarBigDecimal(BigDecimal bigDecimalASerValidado) throws ExcecaoDeArgumentoInvalido {
        if (bigDecimalASerValidado == null || bigDecimalASerValidado.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ExcecaoDeArgumentoInvalido("BigDecimal inválido");
        }
    }

    public void validarObjeto(Object objetoAValidar) throws ExcecaoDeArgumentoInvalido {
        if (objetoAValidar == null) {
            throw new ExcecaoDeArgumentoInvalido("Objeto inválido");
        }
    }
}
