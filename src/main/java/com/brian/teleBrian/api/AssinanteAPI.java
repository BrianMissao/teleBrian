package com.brian.teleBrian.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.brian.teleBrian.aplicacao.assinantes.AdicionaAssinanteBase;
import com.brian.teleBrian.aplicacao.assinantes.AssinantePessoaFisicaDTO;
import com.brian.teleBrian.aplicacao.assinantes.AssinantePessoaJuridicaDTO;
import com.brian.teleBrian.aplicacao.assinantes.consultaAssinante.ConsultaAssinanteConcreto;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDePlanoInesistente;

@Service
@RestController
@RequestMapping(path = "/assinantes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AssinanteAPI {

    @Autowired
    private AdicionaAssinanteBase adicionaAssinanteBase;

    @Autowired
    private ConsultaAssinanteConcreto consultaAssinanteConcreto;

    @PostMapping("/pessoaFisica")
    public Assinante adicionar(@RequestBody AssinantePessoaFisicaDTO assinantePessoaFisicaDTO)
            throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente {
        return adicionaAssinanteBase.adicionar(assinantePessoaFisicaDTO);
    }

    @PostMapping("/pessoaJuridica")
    public Assinante adicionar(@RequestBody AssinantePessoaJuridicaDTO assinantePessoaJuridicaDTO)
            throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente {
        return adicionaAssinanteBase.adicionar(assinantePessoaJuridicaDTO);
    }

    @GetMapping(consumes = MediaType.ALL_VALUE)
    public Assinante consultarAssinante(@RequestParam String nome) {
        try {
            return consultaAssinanteConcreto.consultar(nome);
        } catch (ExcecaoDeBuscaDeAssinante e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
