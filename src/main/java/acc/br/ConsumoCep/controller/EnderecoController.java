package acc.br.ConsumoCep.controller;


import acc.br.ConsumoCep.model.Endereco;
import acc.br.ConsumoCep.services.ViaCepService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cep")
@CrossOrigin("*")
public class EnderecoController {

    private final ViaCepService service;

    public EnderecoController(ViaCepService service) {
        this.service = service;
    }

    @GetMapping("/{cep}")
    public Endereco getCep(@PathVariable String cep) {
        return service.buscarESalvar(cep);
    }
}

@Controller
@RequestMapping("/")
class CepViewController {

    @GetMapping
    public String cepPage(Model model) {
        return "cep"; // Renderiza templates/cep.html
    }
}