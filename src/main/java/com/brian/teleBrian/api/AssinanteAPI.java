package com.brian.teleBrian.api;


import com.brian.teleBrian.aplicacao.assinantes.AdicionaAssinanteBase;
import com.brian.teleBrian.aplicacao.assinantes.AssinanteDTO;
import com.brian.teleBrian.aplicacao.assinantes.consultaAssinante.ConsultaAssinante;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDePlanoInesistente;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping(path = "/assinantes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AssinanteAPI {

    private final AdicionaAssinanteBase adicionaAssinanteBase;
    private final ConsultaAssinante consultaAssinante;

    public AssinanteAPI(AdicionaAssinanteBase adicionaAssinanteBase, ConsultaAssinante consultaAssinante) {
        this.adicionaAssinanteBase = adicionaAssinanteBase;
        this.consultaAssinante = consultaAssinante;
    }

    @PostMapping()
    public Assinante adicionar(@RequestBody AssinanteDTO assinanteDTO)
            throws ExcecaoDePlanoInesistente, ExcecaoDeArgumentoInvalido {
        return adicionaAssinanteBase.adicionar(assinanteDTO);
    }

    @GetMapping()
    public Assinante consultar(@RequestParam String nome) throws ExcecaoDeBuscaDeAssinante {
        return consultaAssinante.consultar(nome);
    }
}
