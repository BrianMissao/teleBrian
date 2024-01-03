package com.brian.teleBrian.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brian.teleBrian.aplicacao.funcionario.AdicionaFuncionario;
import com.brian.teleBrian.aplicacao.funcionario.ConsultaFuncionarios;
import com.brian.teleBrian.aplicacao.funcionario.FuncionarioDTO;
import com.brian.teleBrian.dominio.entidades.Funcionario;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

@Service
@RestController
@RequestMapping(path = "/funcionarios", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class FuncionarioApi {

    @Autowired
    private AdicionaFuncionario adicionaFuncionario;

    @Autowired
    private ConsultaFuncionarios consultaFuncionarios;


    @PostMapping()
    public Integer  adicionarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) throws ExcecaoDeArgumentoInvalido {
        return adicionaFuncionario.adicionar(funcionarioDTO).getId();
    }

    @GetMapping()
    public List<Funcionario> consultarFuncionarios() {
        return consultaFuncionarios.consultarTodos();
    }
}
