# Padrões de projeto

Este projeto visa ilustrar a implementação dos padrões de projetos SINGLETON, STRATEGY E FACADE

## PADRÃO SINGLETON

Em um projeto Spring Boot sempre que usamos o  `@Autowired` ou `@Bean` estamos utilizando o padrão Singleton 

O padrão Singleton é um padrão de design que garante que uma classe tenha apenas uma única instância e fornece um ponto global de acesso a essa instância. Ele é útil em várias situações, como:

1. **Controle de Recursos**: Quando você precisa controlar o acesso a um recurso compartilhado, como um banco de dados ou uma conexão de rede, o Singleton pode ajudar a garantir que apenas uma instância do recurso seja utilizada.

2. **Gerenciamento de Estado Global**: Se você precisa de um objeto que mantenha um estado global (como configurações de aplicativo), o Singleton pode ser uma boa escolha.

3. **Facilidade de Acesso**: Quando você quer garantir que um objeto específico seja facilmente acessível em toda a aplicação, sem precisar passar referências dele entre várias classes.

### Quando Utilizar

- **Quando há necessidade de uma única instância**: Se a lógica da sua aplicação exige que apenas uma instância de uma classe exista, como em sistemas de log ou configurações de aplicativo.

- **Quando a criação de instâncias adicionais não faz sentido**: Se criar múltiplas instâncias da classe pode causar problemas, como inconsistências de dados.

- **Em aplicações com alta concorrência**: O Singleton pode ser usado para garantir que o estado compartilhado não seja corrompido.

### Cuidados

- **Testabilidade**: Singleton pode dificultar testes, já que ele introduce um estado global. Isso pode ser mitigado usando injeção de dependência.

- **Concorrência**: É preciso garantir que o acesso à instância única seja thread-safe, especialmente em ambientes de múltiplas threads.

Em resumo, o padrão Singleton é uma ferramenta poderosa, mas deve ser usado com cautela e em situações apropriadas.


<hr>

## Padrão Strategy

Em um projeto Spring Boot sempre que implementamos uma interface  `@Repository` ou `@Service` estamos utilizando o padrão Strategy

O padrão Strategy é um padrão de design comportamental que permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. O padrão permite que o algoritmo varie independentemente dos clientes que o utilizam. 

### Para que Serve

1. **Encapsulamento de Algoritmos**: O padrão permite encapsular diferentes algoritmos em classes separadas, facilitando a manutenção e a extensão do código.

2. **Intercambiabilidade**: Você pode mudar o algoritmo que está sendo usado em tempo de execução, sem alterar o código do cliente que utiliza esse algoritmo.

3. **Flexibilidade e Reutilização**: O padrão promove o uso de algoritmos de forma flexível e reutilizável, ajudando a evitar duplicação de código.

4. **Separação de Responsabilidades**: Permite separar a lógica de seleção do algoritmo da lógica de uso, seguindo o princípio de responsabilidade única.

### Quando Utilizar

- **Quando você tem múltiplas variantes de um algoritmo**: Se o seu código precisa de diferentes algoritmos que realizam uma tarefa semelhante (por exemplo, diferentes estratégias de ordenação ou cálculo de impostos), o padrão Strategy é uma boa escolha.

- **Quando você precisa de flexibilidade para mudar algoritmos em tempo de execução**: Se a lógica de seleção do algoritmo pode mudar em função do estado do aplicativo ou de preferências do usuário, o Strategy permite essa flexibilidade.

- **Quando você quer evitar condicionais complexos**: Se você está usando muitos `if` ou `switch` para escolher entre diferentes algoritmos, pode ser mais limpo e organizado usar o padrão Strategy.

- **Quando você quer aumentar a extensibilidade do seu código**: O padrão permite adicionar novos algoritmos sem alterar o código existente, apenas criando novas classes que implementam a interface do Strategy.
  
  

### Considerações Finais

O padrão Strategy é útil para tornar seu código mais limpo e gerenciável, especialmente quando lidamos com comportamentos que podem mudar. É uma ótima maneira de promover a reutilização de código e seguir os princípios SOLID, especialmente o Princípio de Substituição de Liskov e o Princípio da Responsabilidade Única.



<hr>

## PADRÃO FACADE

Quando utilizamos recusos externo como de API do ViaCEP implmentada neste projeto para consumir um endereço baseado no cep através interface, estamos utilizando o padrão **Facade**

O padrão Facade é um padrão de design estrutural que fornece uma interface simplificada para um sistema complexo, escondendo suas complexidades internas. Ele facilita a interação com subsistemas ou um conjunto de classes, tornando o uso mais intuitivo e acessível.

### Para que Serve

1. **Simplificação da Interface**: O padrão oferece uma interface mais fácil de usar, reduzindo a complexidade para o usuário final.

2. **Desacoplamento**: Ele ajuda a desacoplar o código cliente dos detalhes do sistema complexo, permitindo que você altere a implementação interna sem afetar o código que a utiliza.

3. **Facilita a Manutenção**: Ao centralizar a lógica de interação em um único ponto, torna-se mais fácil modificar e manter o sistema.

4. **Melhoria da Legibilidade**: O uso de uma fachada torna o código mais legível e compreensível, uma vez que oculta detalhes de implementação que não são relevantes para o cliente.

### Quando Utilizar

- **Quando você tem um sistema complexo**: Se um sistema é composto por várias classes ou subsistemas interconectados que tornam o uso complicado, a implementação de uma fachada pode simplificar a interação.

- **Quando você quer desacoplar o código cliente do sistema**: Se você precisa esconder a complexidade de um subsistema para que mudanças internas não afetem o código cliente, o padrão Facade é apropriado.

- **Quando você quer fornecer uma interface única**: Se existem várias maneiras de interagir com um conjunto de funcionalidades, mas você deseja fornecer uma única interface simplificada, a fachada pode ser uma boa solução.

- **Ao integrar com sistemas externos**: Ao trabalhar com bibliotecas ou APIs externas que têm interfaces complexas, uma fachada pode ajudar a encapsular a complexidade e fornecer um uso mais direto.

### Considerações Finais

O padrão Facade é uma ótima escolha para simplificar interações com sistemas complexos e promover um design de código mais limpo e organizado. Ele não altera as classes existentes, mas proporciona uma maneira de trabalhar com elas de forma mais eficiente, facilitando a manutenção e a legibilidade do código.
