package com.brian.teleBrian.api;

import com.brian.teleBrian.aplicacao.plano.AdicionaPlano;
import com.brian.teleBrian.aplicacao.plano.PlanoDTO;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(path = "/planos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PlanoAPI {

    @Autowired
    private AdicionaPlano adicionaPlano;

    @PostMapping()
    public Plano adicionar(@RequestBody PlanoDTO planoDTO) throws ExcecaoDeArgumentoInvalido {
        return adicionaPlano.adicionar(planoDTO);
    }
}
