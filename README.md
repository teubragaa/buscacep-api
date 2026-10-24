# RAST API - Consulta de CEP

API REST desenvolvida em Java com Spring Boot para consultar endereços brasileiros por meio do CEP, integrando-se ao serviço externo ViaCEP.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Gradle
- Docker
- ViaCEP API

## Arquitetura

O projeto utiliza arquitetura em camadas para organizar as responsabilidades e facilitar a manutenção do código.

```text
br.buscarcep
├── controller
│   └── CepController.java
├── dto
├── model
├── service
└── BuscarcepApplication.java
```

### Responsabilidades

- **Controller:** recebe as requisições HTTP e retorna as respostas da API.
- **Service:** concentra a lógica de negócio e coordena a consulta de CEP.
- **DTO:** define a estrutura dos dados transferidos pela API.
- **Model:** representa os dados do endereço consultado.

## Endpoint

Consulta um endereço a partir do CEP informado.

| Método | Endpoint |
|---|---|
| GET | `/api/ceps/{cep}` |

### Exemplo de requisição

```http
GET http://localhost:8080/api/ceps/40010000
```

### Exemplo de resposta

```json
{
  "cep": "40010-000",
  "logradouro": "Praça da Sé",
  "complemento": "",
  "bairro": "Sé",
  "localidade": "Salvador",
  "uf": "BA"
}



