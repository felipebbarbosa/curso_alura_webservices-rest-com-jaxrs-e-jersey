[Curso de Webservices REST com JAX-RS e Jersey](https://www.alura.com.br/curso-online-webservices-rest-com-jaxrs-e-jersey)
Material no [Google Drive](https://drive.google.com/drive/folders/0B64IZUa8-nkHd3ladHBPLXBXU2c)

## Conteúdo Detalhado

### 1. Serviços Web REST e Addressability
- WebServices REST e HTTP
- JAXRS e a implementação Jersey
- Addressability
- Representação x Recurso
- URIs e método GET
- Criando um @Resource
- Produzindo application/xml
- Trazendo a representação de um carrinho
- Usando o Grizzly
- Criando um teste endtoend para produção

### 2. Testes endtoend com JAXRS e Grizzly
- Criando um teste endtoend
- @Before e @After para servidores
- Refatorando nosso código

### 3. Trabalhando com parâmetros
- Lendo parâmetros do Path com @PathParam
- Lendo parâmetros da Query com @QueryParam

### 4.Gerando Json com Gson
- Produzindo Json
- XStream ou Gson

### 5. Criando recursos e o POST
- A criação remota de um recurso
- Enviando representações
- O método POST
- A linha de comando e o curl

### 6. O protocolo HTTP por baixo dos panos
- curl com verbose
- O protocolo HTTP
- O body de uma requisição HTTP: GET x POST
- Headers HTTP

### 7. Status code e a Interface Uniforme
- O erro 500 Internal Server Error
- Status no body ou no status code?
- A resposta 200 Ok
- A resposta 201 Created
- O header Location
- Consumindo application/xml
- curl e os cabeçalhos extras
- Fazendo um POST com a API de cliente do Jersey

### 8. Idempotência
- Requisições e refresh
- Vantagem do GET e da idempotência

### 9. Removendo recursos e subrecursos
- Removendo um recurso
- O verbo DELETE
- curl e DELETE
- DELETE e idempotência

### 10. Utilizando filtros e logging
- Adicionando filtros
- Adicionando logging no cliente

### 11. Atualizando recursos e o PUT
- Atualização de um produto
- Utilizando o verbo PUT
- Atualização parcial de um produto
- PUT e Idempotência

### 12. Interface Uniforme
- PATCH e atualização parcial de recurso
- OPTIONS e outros verbos
- Media types
- A interface uniforme e o HTTP

### 13. Deploy WAR e Servlet Contêiners
- Um web.xml para o Jersey
- Instalando o Tomcat 8
- Gerando um arquivo war
- Contexto de uma aplicação

### 14. Serialização com JAXB
- A serialização padrão
- Anotações do JAXB
- Retornado e recebendo entities no servidor
- Usando entities no cliente