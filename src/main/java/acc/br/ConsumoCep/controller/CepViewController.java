package acc.br.ConsumoCep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import acc.br.ConsumoCep.repository.EnderecoRepository;

@Controller
@RequestMapping("/")
class CepViewController {

    private final EnderecoRepository repository;

    public CepViewController(EnderecoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String cepPage() {
        return "cep"; // Renderiza o cep.html
    }

    @GetMapping("/enderecos")
    public String listarEnderecos(Model model) {
        model.addAttribute("enderecos", repository.findAll());
        return "enderecos"; // Renderiza o template enderecos.html
    }
}
