package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.medico;
import med.voll.api.medico.medicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private medicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        repository.save(new medico(dados));
            
    }

    @GetMapping
    public List<DadosListagemMedico> listar(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();

    }


}
