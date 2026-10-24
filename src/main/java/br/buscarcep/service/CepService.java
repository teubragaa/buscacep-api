package br.buscarcep.service;

import br.buscarcep.dto.CepResponse;
import br.buscarcep.model.Cep;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CepService {

    private final RestClient restClient;

    public CepService() {
        this.restClient = RestClient.create();
    }

    public CepResponse buscarCep(String cep) {
        Cep endereco = restClient.get()
                .uri("https://viacep.com.br/ws/{cep}/json/", cep)
                .retrieve()
                .body(Cep.class);

        if (endereco == null || endereco.getLocalidade() == null) {
            throw new RuntimeException("CEP não encontrado.");
        }

        return new CepResponse(
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getLocalidade(),
                endereco.getUf()
        );
    }
}