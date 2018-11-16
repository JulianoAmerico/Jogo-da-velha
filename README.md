# Description
Jogo da velha via console.

# Jogo da velha
Jogo da velha que pode ser jogado por dois jogadores via Console. Cada jogador possui uma pontuação registrado no arquivo.

# Como executar?
1. Faça o download dos arquivos JogoDaVelha.jar e execute.bat, e salve-os dentro da pasta JogoDaVelha no diretório C:\\.
2. Abra o arquivo JogoDaVelha e clique no arquivo execute.bat e o jogo é executado no DOS.

# Como jogar?
1. Insira os nomes dos jogadores, após inserir um nome e dê enter, é solicitado o nome do segundo jogador.
2. O tabuleiro do jogo da velha é mostrada na tela, e em seguida é solicitada a jogada do primeiro jogador. Para realizar a jogada é necessário passar a linha e coluna onde será feita a jogada. Exemplo: 0,0. Neste exemplo a jogada é feita na linha 0 e coluna 0.
<strong>Nota:</strong> note que a linha e coluna começa a partir do 0 e não do 1. O tabuleiro tem a matriz de tamanho 3x3.

# Regras
1. O nome do jogador só pode ter o primeiro nome, se houver mais de uma palavra é ignorada.
2. As jogadas deve seguir o padrão: "0,0". Outras jogadas como: "0.0", "0;0" ou "0'0" são ignoradas e dá a vez pro próximo jogador jogar.
3. O tamanho da matriz do tabuleiro é 3x3, então, as jogadas podem ser de 0 - 2. Exemplos: "2,1", "0,2", "1,1", "2,0" etc.

# Pontuação
1. Quando o jogador ganha uma partida é incrementado 1 ponto à sua pontuação. Esta pontuação é armazenada no arquivo pontuação.txt.
2. Todos os jogadores que já ganharam são gravados os nomes, pontuações, data e hora da última pontuação.
3. No inicio do jogo, ao solicitar um nome, é mostrado as pontuações do jogador com o nome inserido, se este jogador tiver pontuações anteriores, e também quando ocorreu sua última pontuação.
