package com.brian.teleBrian.api;

import com.brian.teleBrian.aplicacao.assinantes.AdicionaAssinanteBase;
import com.brian.teleBrian.aplicacao.assinantes.AssinantePessoaFisicaDTO;
import com.brian.teleBrian.aplicacao.assinantes.AssinantePessoaJuridicaDTO;
import com.brian.teleBrian.aplicacao.assinantes.consultaAssinante.ConsultaAssinanteConcreto;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDePlanoInesistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping(path = "/assinantes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AssinanteAPI {

    @Autowired
    private AdicionaAssinanteBase adicionaAssinanteBase;

    @Autowired
    private ConsultaAssinanteConcreto consultaAssinanteConcreto;

    @PostMapping("/pessoaFisica")
    public Assinante adicionar(@RequestBody AssinantePessoaFisicaDTO assinantePessoaFisicaDTO) throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente {
        return adicionaAssinanteBase.adicionar(assinantePessoaFisicaDTO);
    }

    @PostMapping("/pessoaJuridica")
    public Assinante adicionar(@RequestBody AssinantePessoaJuridicaDTO assinantePessoaJuridicaDTO) throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente {
        return adicionaAssinanteBase.adicionar(assinantePessoaJuridicaDTO);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Assinante consultar(@RequestParam String nome) throws ExcecaoDeBuscaDeAssinante {
        return consultaAssinanteConcreto.consultar(nome);
    }

}
