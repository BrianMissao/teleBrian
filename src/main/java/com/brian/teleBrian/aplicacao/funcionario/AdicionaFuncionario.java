package com.brian.teleBrian.aplicacao.funcionario;

import com.brian.teleBrian.dominio.entidades.Funcionario;
import com.brian.teleBrian.dominio.entidades.FuncionarioCrudRepository;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdicionaFuncionario {

    private FuncionarioCrudRepository funcionarioCrudRepository;

    public AdicionaFuncionario(FuncionarioCrudRepository funcionarioCrudRepository) {
        this.funcionarioCrudRepository = funcionarioCrudRepository;
    }

    public Funcionario adicionar(FuncionarioDTO funcionarioDTO) throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(funcionarioDTO.getNome(), funcionarioDTO.getCargo(), funcionarioDTO.getSalario());
        return funcionarioCrudRepository.save(funcionario);
    }
}
