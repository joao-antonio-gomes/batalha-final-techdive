import enums.ArmasEnum;
import enums.ClassesEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BatalhaFinal {
    private static Scanner scanner = new Scanner(System.in);

    public BatalhaFinal() {

    }

    public static void pressioneEnterParaContinuar() {
        System.out.println();
        System.out.println("Pressione ENTER para continuar...");
        System.out.println();
        scanner.nextLine();
    }

    public static void imprimeLinha() {
        System.out.println("-----------------------------------------------------");
    }

    public static void pulaLinha() {
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Seja bem vindo(a) à BATALHA FINAL!");
        System.out.println("Qual o seu nome?");
        String nome = scanner.nextLine();

        pulaLinha();

        System.out.println("Qual o seu sexo?");
        for (SexoEnum sexo : SexoEnum.values()) {
            System.out.println(sexo.getId() + " - " + sexo.getDescricao());
        }
        int sexo = scanner.nextInt();
        SexoEnum sexoEscolhido = SexoEnum.getSexo(sexo);

        pulaLinha();

        System.out.println("Qual a classe do seu personagem?");
        for (ClassesEnum classe : ClassesEnum.values()) {
            System.out.println(classe.getId() + " - " + classe.getDescricao());
        }
        int classe = scanner.nextInt();
        ClassesEnum classeEscolhida = ClassesEnum.getClasse(classe);

        pulaLinha();

        System.out.println("Qual sua arma?");
        ArrayList<ArmasEnum> armas = ArmasEnum.getArmasByClasse(classeEscolhida);
        for (ArmasEnum arma : armas) {
            System.out.println(arma.getId() + " - " + arma.getNome());
        }
        int arma = scanner.nextInt();
        ArmasEnum armaEscolhida = ArmasEnum.getArma(arma);

        pulaLinha();

        Jogador jogador = null;
        try {
            switch (classeEscolhida) {
                case GUERREIRO:
                    jogador = new Guerreiro(nome, sexoEscolhido, armaEscolhida);
                    break;
                case ARQUEIRO:
                    jogador = new Arqueiro(nome, sexoEscolhido, armaEscolhida);
                    break;
                case MAGO:
                    jogador = new Mago(nome, sexoEscolhido, armaEscolhida);
                    break;
                case PALADINO:
                    jogador = new Paladino(nome, sexoEscolhido, armaEscolhida);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            scanner.nextLine();
            pressioneEnterParaContinuar();

            BatalhaFinal.main(args);
        }

        System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo,\n"
                + "e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.\n"
                + "Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");

        scanner.nextLine();
        pressioneEnterParaContinuar();

        System.out.println("Memórias do caminho percorrido para chegar até aqui invadem sua mente.\n"
                + "Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno.\n"
                + "Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas.\n"
                + "Você está a um passo de encerrar para sempre esse mal.");

        pressioneEnterParaContinuar();

        System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");

        pulaLinha();

        System.out.println("Qual sua motivação?");
        for (MotivacoesEnum motivacao : MotivacoesEnum.values()) {
            System.out.println(motivacao.getId() + " - " + motivacao.getNome());
        }
        int motivacao = scanner.nextInt();
        MotivacoesEnum motivacaoEscolhida = MotivacoesEnum.getMotivacao(motivacao);
        jogador.setMotivacao(motivacaoEscolhida);

        scanner.nextLine();
        pulaLinha();

        if (motivacaoEscolhida == MotivacoesEnum.VINGANCA) {
            System.out.println("Imagens daquela noite trágica invadem sua mente.\n"
                    + "Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes,\n"
                    + "mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram.\n"
                    + "Elas são o combustível que te fizeram chegar até aqui.\n"
                    + "E você sabe que não irá desistir até ter vingado a morte\n"
                    + "daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo.\n"
                    + "O maldito líder finalmente pagará por tanto mal causado na vida de tantos\n"
                    + "(e principalmente na sua).");
        } else {
            System.out.println("Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos,\n"
                    + "bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas,\n"
                    + "taberneiros se recusando a cobrar por suas bebedeiras e comilanças.\n"
                    + "Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas,\n"
                    + "depois de destruir o vilão que tanto assombrou a paz de todos.\n"
                    + "Porém, você sabe que ainda falta o último ato dessa história.\n"
                    + "Você se concentra na missão.\n"
                    + "A glória o aguarda, mas não antes da última batalha.");
        }

        pressioneEnterParaContinuar();

        System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas,\n"
                + "suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.\n"
                + "Você avança pelo portal.");

        pressioneEnterParaContinuar();

        System.out.println("A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas.\n"
                + "À sua frente, só é possível perceber que você se encontra em um corredor extenso.\n"
                + "Você só pode ir à frente, ou desistir.");

        pulaLinha();

        System.out.println("Qual sua ação?");
        System.out.println("1 - Ir à frente");
        System.out.println("2 - Desistir");
        int acao = scanner.nextInt();

        pulaLinha();

        if (acao == 2) {
            System.out.println("O medo invade o seu coração e você sente que ainda não está à altura do desafio.\n"
                    + "Você se volta para a noite lá fora, e corre em direção à segurança.");
            System.exit(0);
        }

        System.out.println("Você caminha, atento a todos os seus sentidos, por vários metros,\n"
                + "até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha,\n"
                + "vindo de dentro de uma porta aberta.");

        scanner.nextLine();
        pressioneEnterParaContinuar();

        System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
                + "e pondera sobre como passar pela porta.");

        pressioneEnterParaContinuar();

        System.out.println("Como você deseja avançar?");
        System.out.println("1 - Andando cuidadosamente");
        System.out.println("2 - Correndo");
        System.out.println("3 - Saltando");
        acao = scanner.nextInt();

        pulaLinha();

        if (acao == 3) {
            System.out.println("Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
        } else if (acao == 2) {
            System.out.println("Você respira fundo e desata a correr em direção à sala.\n"
                    + "Quando passa pela porta, sente que pisou em uma pedra solta,\n"
                    + "mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.\n"
                    + "Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você,\n"
                    + "e quando se vira, vê várias flechas no chão.\n"
                    + "Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,\n"
                    + "mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
        } else {
            System.out.println("Você toma cuidado e vai caminhando vagarosamente em direção à luz.\n"
                    + "Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.\n"
                    + "Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor.\n"
                    + "Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");

            Armadilha armadilha = new Armadilha();
            System.out.println();
            armadilha.atacar(jogador);
        }

        scanner.nextLine();
        pressioneEnterParaContinuar();

        System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
                + "Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas.\n"
                + "A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler,\n"
                + "mas reconhece como sendo a língua antiga utilizada pelo inimigo.\n"
                + "Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas,\n"
                + "e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais,\n"
                + "antes de conseguir enfrentar o líder.");

        pressioneEnterParaContinuar();

        System.out.println("Você se dirige para a porta à direita.");

        pressioneEnterParaContinuar();

        System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                + "Ao entrar, você se depara com uma sala espaçosa,\n"
                + "com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas.\n"
                + "Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados\n"
                + "utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n"
                + "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás.\n"
                + "Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo.\n"
                + "Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate.\n"
                + "Ele avança em sua direção.");

        pressioneEnterParaContinuar();

        imprimeLinha();
        Armeiro armeiro = new Armeiro();
        new Combate(jogador, armeiro).combate();

        scanner.nextLine();
        pressioneEnterParaContinuar();

        System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados.\n"
                + "Olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");

        pressioneEnterParaContinuar();

        System.out.println("Você deseja pegar as armaduras novas?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        acao = scanner.nextInt();

        pulaLinha();

        if (acao == 1) {
            System.out.println("Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas,\n"
                    + "que estavam danificadas, pelas peças de armaduras existentes na sala.\n"
                    + "De armadura nova, você se sente mais protegido para os desafios à sua frente.");
            int pontosDeDefesa = jogador.getPontosDeDefesa();
            pontosDeDefesa += 5;
            jogador.setPontosDeDefesa(pontosDeDefesa);
        } else {
            System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
        }

        scanner.nextLine();
        pressioneEnterParaContinuar();

        System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo.\n"
                + "Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

        pressioneEnterParaContinuar();

        System.out.println("Você retorna à sala anterior e se dirige à porta da esquerda.\n"
                + "Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                + "Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,\n"
                + "existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas,\n"
                + "e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes,\n"
                + "criando poções utilizadas pelos soldados para aterrorizar a região.");

        pressioneEnterParaContinuar();

        System.out.println("No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo.\n"
                + "Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.");

        pressioneEnterParaContinuar();

        Alquimista alquimista = new Alquimista();
        new Combate(jogador, alquimista).combate();

        scanner.nextLine();
        pressioneEnterParaContinuar();

        System.out.println("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo.\n"
                + "Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado,\n"
                + "pega a garrafa e pondera se deve beber um gole.");

        pressioneEnterParaContinuar();

        System.out.println("Você deseja beber um gole da poção?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        acao = scanner.nextInt();

        pulaLinha();

        if (acao == 1) {
            System.out.println("Você se sente revigorado para seguir adiante!");
            jogador.setPontosDeVida(jogador.getPontosDeVidaMaximo());
        } else {
            System.out.println("Você fica receoso de beber algo produzido pelo inimigo.");
        }

        scanner.nextLine();
        pressioneEnterParaContinuar();

        System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa,\n"
                + "e sabe que aquela chave abre a outra fechadura da porta do líder inimigo.\n"
                + "Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.");

        pressioneEnterParaContinuar();

        System.out.println("De volta à sala das portas, você se dirige à porta final.\n"
                + "Coloca as chaves nas fechaduras, e a porta se abre.\n"
                + "Seu coração acelera, memórias de toda a sua vida passam pela sua mente,\n"
                + "e você percebe que está muito próximo do seu objetivo final.\n"
                + "Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.");

        pressioneEnterParaContinuar();

        System.out.println("Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.");

        pressioneEnterParaContinuar();

        System.out.println("Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.");

        pressioneEnterParaContinuar();

        System.out.println("Você deseja atacar ou esperar?");
        System.out.println("1 - Atacar");
        System.out.println("2 - Esperar");
        acao = scanner.nextInt();

        pulaLinha();

        Lider lider = new Lider();
        if (acao == 1) {
            new Combate(jogador, lider, jogador).combate();
        } else {
            new Combate(jogador, lider, lider).combate();
        }

        System.out.println("Você conseguiu!");

        scanner.nextLine();
        pressioneEnterParaContinuar();

        if (motivacaoEscolhida == MotivacoesEnum.VINGANCA) {
            System.out.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
        } else {
            System.out.println("O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
        }

        pressioneEnterParaContinuar();

        System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta,\n"
                + "e todos vocês saem em direção à noite, retornando à cidade.\n"
                + "Seu dever está cumprido.");
    }
}
