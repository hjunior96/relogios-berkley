# Projeto feito por:
- Giovanni Bayerlein de Camargo 31532284
- Hamilton Junior 		31539793
# relogios-berkley

## projeto RelógioServidor
O projeto RelogioServidor é composto por 3 componentes:
- IRelogioServidor: É uma interface com a assinatura dos metodos disponiveis para acesso remoto com o objetivo de manipular o relogio.
- IRelogioServidorImpl: É a implementação da interface IRelogioServidor, nela são feitos os devidos calculos e implementações.
- RelogioServidor: É a classe main do servidor, onde o servidor em si é iniciado e algumas instancias da classe IRelogioServidorImpl são disponibilizadas para serem acessadas remotamente.


## projeto RelogioClient
O projeto RelogioClient é composto por apenas uma classe principal. Nessa classe é efetivamente criado os relogios e é feito os calculos de média, diferencia entre os relogios e os mesmos são ajustados.

# Execução
Para executar corretamente o sistema, é necessario que o projeto RelogioServidor seja executado primeiro e então o projeto RelogioClient. Após executado corretamente, será exibido no console as informações de cada relegio e a cada 10 minutos todo o processo é executado novamente iniciando uma simulação diferente.