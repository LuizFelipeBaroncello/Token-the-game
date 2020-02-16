Token, the game

Projeto feito para consolidar conhecimento em padrões de projeto e java

Projeto final Luiz Felipe Ribeiro Baroncello;

Nome: Tokens: Uma jornada pelo desconhecido

Descrição: Seria meio que um jogo RPG, no qual o personagem principal (Logan), enfrenta uma serie de criaturas estranhas
para descobrir o paradeiro de seu irmão perdido.


Versao Final:

- Interface Grafica e controle terminados;
- Alterações em jogador;
- Adicionado alguns métodos em fachada;
- Corrigido erro que não fazia com que os inimigos dessem menos experiencia;
- Serialização agora salva inimigos também para que eles continuem dando menos experiencia após o jogo ser salvo e reaberto;
- Adicionado local no mapa (Boss), que seria a ultima batalhado do game, com o mesmo se encerrando após terminar essa batalha;
- Menus no geral melhorados;
- Pequenos bugs concertados;
- Removido controle para testes manuais.



Implementações:
- MVC, facilmente visualizavel através do diagrama;
- Classe abstrata: Personagem, Melhora, SimuladorDeGolpe;
- Padrão de estados: Usado para as localizações e para a experiencia que o inimigo vai dando a cada vez que se ganha dele;
- Fabrica: Usado para a seleção de inimigos baseando-se no local do heroi;
- Fachada: Usada no geral para separar todo o modelo, e subPartes do modelo, por exmplo o gerenciador de melhorias e a fachadaModelo em si;
- Singleton: Usado no controle para melhor utilização na interface Grafica, além de ser utilizado nos inimigos para manter o estado de xp dos mesmos;
- Serialização: Utilizada para salvar a fachada do modelo e os inimigos;