package com.brian.teleBrian.aplicacao.assinantes.removeAssinante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeRemocaoDeAssinante;

@Service
@Transactional
public class RemoveAssinanteImpl implements RemoveAssinante {

    @Autowired
    private AssinanteCrudRepository assinanteCrudRepository;

    public RemoveAssinanteImpl(AssinanteCrudRepository assinanteCrudRepository) {
        this.assinanteCrudRepository = assinanteCrudRepository;
    }

    @Override
    public void remover(Integer idDoAssinante) throws ExcecaoDeRemocaoDeAssinante {
        assinanteCrudRepository.deleteById(idDoAssinante);
    }
}
    