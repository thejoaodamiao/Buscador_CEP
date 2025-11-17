package acc.br.ConsumoCep.services;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import acc.br.ConsumoCep.model.Endereco;
import acc.br.ConsumoCep.repository.EnderecoRepository;

@Service
public class ViaCepService {
    private final EnderecoRepository repo;
    private final RestTemplate restTemplate = new RestTemplate();

    public ViaCepService(EnderecoRepository repo) {
        this.repo = repo;
    }

    public Endereco buscarESalvar(String cep) {
        Endereco existente = repo.findByCep(cep);
        if (existente != null) return existente;

        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        Endereco endereco = restTemplate.getForObject(url, Endereco.class);
        if (endereco != null && endereco.getCep() != null) {
            return repo.save(endereco);
        }
        throw new RuntimeException("CEP não encontrado.");
    }
}
