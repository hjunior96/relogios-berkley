# Projeto feito por:
- Giovanni Bayerlein de Camargo 31532284
- Hamilton Junior 		31539793
# relogios-berkley

## projeto Rel�gioServidor
O projeto RelogioServidor � composto por 3 componentes:
- IRelogioServidor: � uma interface com a assinatura dos metodos disponiveis para acesso remoto com o objetivo de manipular o relogio.
- IRelogioServidorImpl: � a implementa��o da interface IRelogioServidor, nela s�o feitos os devidos calculos e implementa��es.
- RelogioServidor: � a classe main do servidor, onde o servidor em si � iniciado e algumas instancias da classe IRelogioServidorImpl s�o disponibilizadas para serem acessadas remotamente.


## projeto RelogioClient
O projeto RelogioClient � composto por apenas uma classe principal. Nessa classe � efetivamente criado os relogios e � feito os calculos de m�dia, diferencia entre os relogios e os mesmos s�o ajustados.

# Execu��o
Para executar corretamente o sistema, � necessario que o projeto RelogioServidor seja executado primeiro e ent�o o projeto RelogioClient. Ap�s executado corretamente, ser� exibido no console as informa��es de cada relegio e a cada 10 minutos todo o processo � executado novamente iniciando uma simula��o diferente.