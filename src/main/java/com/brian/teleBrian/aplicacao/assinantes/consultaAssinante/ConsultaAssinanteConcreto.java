package com.brian.teleBrian.aplicacao.assinantes.consultaAssinante;

import org.springframework.stereotype.Service;

import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

@Service
public class ConsultaAssinanteConcreto implements ConsultaAssinante {

    private AssinanteCrudRepository assinanteCrudRepository;

    public ConsultaAssinanteConcreto(AssinanteCrudRepository assinanteCrudRepository) {
        this.assinanteCrudRepository = assinanteCrudRepository;
    }

    @Override
    public Assinante consultar(String nomeDoAssinanteAConsultar) throws ExcecaoDeBuscaDeAssinante {
        return assinanteCrudRepository.findByNome(nomeDoAssinanteAConsultar).orElseThrow(() -> new ExcecaoDeBuscaDeAssinante("Assinante não encontrado"));
    }
}
