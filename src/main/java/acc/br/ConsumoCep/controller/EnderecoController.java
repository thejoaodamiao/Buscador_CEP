package acc.br.ConsumoCep.controller;


import acc.br.ConsumoCep.model.Endereco;
import acc.br.ConsumoCep.services.ViaCepService;
import acc.br.ConsumoCep.repository.EnderecoRepository;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cep")
@CrossOrigin("*")
public class EnderecoController {

    private final ViaCepService service;
    private final EnderecoRepository repository;

    public EnderecoController(ViaCepService service, EnderecoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/{cep}")
    public Endereco getCep(@PathVariable String cep) {
        return service.buscarESalvar(cep);
    }

     @GetMapping
    public List<Endereco> listarTodos() {
        return repository.findAll();
    }


}

