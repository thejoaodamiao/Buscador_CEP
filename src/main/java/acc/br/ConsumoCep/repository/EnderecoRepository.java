package acc.br.ConsumoCep.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import acc.br.ConsumoCep.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findByCep(String cep);
}