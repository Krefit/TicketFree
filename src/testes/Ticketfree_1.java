package testes;

import java.util.Scanner;

public class Ticketfree_1 {

	static int sessao, area, menu, qtdIngressos, contadorPlateiaA, contadorPlateiaB, contadorFrisa, contadorCamarote,
			contadorBalcaoNobre, maiorVenda = 0, menorVenda = 1000;
	static int qtdsessao1, qtdsessao2, qtdsessao3, maiorsessao = 0, menorsessao = 1000, maiorPlateia = 0,
			menorPlateia = 1000;
	static String maiorOcupacao, menorOcupacao, menosIngressos, maisIngressos;

	static String[] nomesSessao = { "matutino", "vespertino", "noturno" };
	static String[] nomesArea = { "plateia A", "plateia B", "frisa", "camarote", "balcão nobre" };
	static double[][] valoresAreaSessao = new double[5][3];

	/*
	 * - Variaveis de entrada (CPF, ingresso peça, sessão, area) - impressão do
	 * ingresso - impressao Estatística de Vendas - criar estrutura de seleção pra
	 * selecionar a posição e também já calcular a quantidade e o preço do ingresso
	 * - finalizar com a quantidade de ingressos, preços e o que mais precisar
	 */
	/*
	 * * Compra Ingresso * * Estatistica de vendas * * Sair *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// DECLARAÇÃO DE VARIAVEIS de definição do tamanho de cada sessão do teatro
		int qtdPlateiaA, qtdPlateiaB, qtdFrisa, qtdCamarote, qtdBalcaoNobre;

		qtdPlateiaA = 25;
		qtdPlateiaB = 100;
		qtdFrisa = 5;
		qtdCamarote = 10;
		qtdBalcaoNobre = 50;

		iniciaPrograma(qtdPlateiaA, qtdPlateiaB, qtdFrisa, qtdCamarote, qtdBalcaoNobre);
		for (int i = 0; i < 9; ++i)
			System.out.println();
		System.out.println("Obrigado!");
	}

	public static void iniciaPrograma(int qtdPlateiaA, int qtdPlateiaB, int qtdFrisa, int qtdCamarote,
			int qtdBalcaoNobre) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int menu;
		String matrizPlateiaB[][] = new String[10][10]; // 10*10 = 100
		String matrizPlateiaA[][] = new String[5][5];// 5*5 = 25
		String matrizPlateiaFrisa[][] = new String[6][5]; // existem 6 plateias Frisa - cada plateia = uma letra
		String matrizPlateiaCamarote[][] = new String[5][10]; // existem 5 camarotes - cada camarote = uma letra
		String matrizPlateiaBalcNobre[][] = new String[5][10]; // 5*10 = 50
		
		//por enquanto a solução é criar mais duas matrizes pra cada plateia, uma matriz pra cada turno

		inicializaAssentos(matrizPlateiaA, "A");
		inicializaAssentos(matrizPlateiaB, "B");
		inicializaAssentos(matrizPlateiaCamarote, "CA");
		inicializaAssentos(matrizPlateiaFrisa, "F");
		inicializaAssentos(matrizPlateiaBalcNobre, "BN");

		do { // Executando o DO WHILE para executar pelo menos uma vez o programa
			chamaMenu();
			menu = sc.nextInt(); //aqui é onde acontece o problema com o menu, ele só funciona se eu colocar exatamente 1, 2 ou 3.
			/*
			 * Solução proposta:
			 * Passo 1: Colocar a variável menu como uma string
			 * Passo 2: No lugar de if, usem switch-case e criem um bloco default, assim vocês vão conseguir filtrar todos os casos possíveis
			 * OBSERVAÇÃO IMPORTANTE: Essa mudança quebra a lógica que vocês estão usando com o do-while, ler comentário abaixo
			 */
			
			/*
			 * Solução para o do-while quebrado:
			 * criem uma variável booleana setada como true, no switch case caso 3, setem a flag para falso, o do-while deverá ser indexado pela variável booleana
			 * 
			 */
			
		
			
			if (menu == 1) {
				compraIngresso(matrizPlateiaB, matrizPlateiaA, matrizPlateiaFrisa, matrizPlateiaCamarote,
						matrizPlateiaBalcNobre); // Se escolheu fazer compra, chama função de comprar ingresso
			} else if (menu == 2) {
				estatisticaVendas(); // se escolheu mostrar estatisticas, chama função de estatisticas de venda
			}
		} while (menu < 3); // se escolha for sair, termina o loop e encerra o programa.
	}

	public static void calcularMaiorSessao() {
		if (qtdsessao1 > maiorsessao) {
			maiorOcupacao = "matutino";
		}
		if (qtdsessao2 > maiorsessao) {
			maiorOcupacao = "vespertino";
		}
		if (qtdsessao3 > maiorsessao) {
			maiorOcupacao = "noturno";
		}
	}

	public static void calcularMenorSessao() {
		if (qtdsessao1 < menorsessao) {
			menorsessao = qtdsessao1;
			menorOcupacao = "matutino";
		}
		if (qtdsessao2 < menorsessao) {
			menorsessao = qtdsessao2;
			menorOcupacao = "vespertino";
		}
		if (qtdsessao3 < menorsessao) {
			menorsessao = qtdsessao3;
			menorOcupacao = "noturno";
		}
	}

	public static void calcularMaiorArea() {
		if (contadorPlateiaA > maiorPlateia) {
			maiorPlateia = contadorPlateiaA;
			maisIngressos = "Plateia A";
		}
		if (contadorPlateiaB > maiorPlateia) {
			maiorPlateia = contadorPlateiaB;
			maisIngressos = "Plateia B";
		}
		if (contadorFrisa < menorPlateia) {
			menorPlateia = contadorFrisa;
			menosIngressos = "Frisa";
		}
		if (contadorCamarote > maiorPlateia) {
			maiorPlateia = contadorCamarote;
			maisIngressos = "Camarote";
		}
		if (contadorBalcaoNobre > maiorPlateia) {
			maiorPlateia = contadorBalcaoNobre;
			maisIngressos = "Balcao Nobre";
		}
	}

	public static void calcularMenorArea() {
		if (contadorPlateiaA < menorPlateia) {
			menorPlateia = contadorPlateiaA;
			menosIngressos = "plateia A";
		}
		if (contadorPlateiaB < menorPlateia) {
			menorPlateia = contadorPlateiaB;
			menosIngressos = "plateia B";
		}
		if (contadorFrisa > maiorPlateia) {
			maiorPlateia = contadorFrisa;
			maisIngressos = "Frisa";
		}
		if (contadorCamarote < menorPlateia) {
			menorPlateia = contadorCamarote;
			menosIngressos = "Camarote";
		}
		if (contadorBalcaoNobre < menorPlateia) {
			menorPlateia = contadorBalcaoNobre;
			menosIngressos = "BalcaoNobre";
		}
	}

	public static double calcularValorArea(String nomeArea) {
		double valor = 0.0;
		if (nomeArea.equalsIgnoreCase("plateia A")) {
			valor = 40 * contadorPlateiaA;
		} else if (nomeArea.equalsIgnoreCase("plateia B")) {
			valor = 60 * contadorPlateiaB;
		} else if (nomeArea.equalsIgnoreCase("camarote")) {
			valor = 80 * contadorCamarote;
		} else if (nomeArea.equalsIgnoreCase("frisa")) {
			valor = 120 * contadorFrisa;
		} else if (nomeArea.equalsIgnoreCase("balcao nobre")) {
			valor = 250 * contadorBalcaoNobre;
		}
		return valor;
	}

	public static String calcularAreaMaisLucrativa() {
		double valorPlateiaA, valorPlateiaB, valorFrisa, valorCamarote, valorBalcaoNobre, lucroMedio;
		valorPlateiaA = calcularValorArea("plateia A");
		valorPlateiaB = calcularValorArea("plateia B");
		valorCamarote = calcularValorArea("camarote");
		valorFrisa = 120 * contadorFrisa;
		valorBalcaoNobre = 250 * contadorBalcaoNobre;
		// IMPLEMENTAR PARA FRISA E BALCAO NOBRE

		double maior = 0;
		if (valorPlateiaA > maior)
			return "plateia A";
		if (valorPlateiaB > maior)
			return "plateia B";
		if (valorCamarote > maior)
			return "camarote";
		// IMPLEMENTAR PARA FRISA E BALCAO NOBRE

		return "nenhuma";
	}

	public static String calcularLucroAreaSessao() {
		double maior = 0;
		double menor = 1000;
		int areaMaior = 0;
		int sessaoMaior = 0;
		int areaMenor = 0;
		int sessaoMenor = 0;

		String nomeMaiorSessao;
		String nomeMenorSessao;
		String nomeMaiorArea;
		String nomeMenorArea;

		for (int i = 0; i < valoresAreaSessao.length; i++) {
			for (int j = 0; j < valoresAreaSessao[i].length; j++) {
				if (valoresAreaSessao[i][j] > maior) {
					maior = valoresAreaSessao[i][j];
					sessaoMaior = i;
					areaMaior = j;
				}
				if (valoresAreaSessao[i][j] < menor) {
					menor = valoresAreaSessao[i][j];
					sessaoMenor = i;
					areaMenor = j;
				}
			}
		}
		nomeMaiorArea = nomesArea[areaMaior];
		nomeMenorArea = nomesArea[areaMenor];
		nomeMaiorSessao = nomesSessao[sessaoMaior];
		nomeMenorSessao = nomesSessao[sessaoMenor];

		String mensagem = String.format("A área e sessão mais lucrativa foram %s %s\n", nomeMaiorArea, nomeMaiorSessao);
		mensagem += String.format("A área e sessão menos lucrativa foram %s %s", nomeMenorArea, nomeMenorSessao);
		return mensagem;
	}

	public static void acrescentarValorAreaSessao(int opcaoArea, int opcaoSessao, double valorIngresso) {
		int i = opcaoSessao - 1;
		int j = opcaoArea - 1;

		valoresAreaSessao[i][j] += valorIngresso;
	}

	public static void estatisticaVendas() {
		if (sessao == 1 || sessao == 2 || sessao == 3) {
			qtdIngressos++;
		}

		/*
		 * lucroMedio = (valorPlateiaA + valorPlateiaB + valorCamarote + valorFrisa +
		 * valorBalcaoNobre) / (25 + 100 + 5 * 6 + 10 * 5 + 50);
		 */

		calcularMaiorArea();
		calcularMenorArea();
		calcularMaiorSessao();
		calcularMenorSessao();

		System.out.println(" ####### ESTATÍSTICA DE VENDA ####### ");
		System.out.println("A Area (Peça) que teve mais ingressos vendidos foi a: " + maisIngressos
				+ " com a quantidade de: " + maiorPlateia + " e a que teve menos foi: " + menosIngressos
				+ " com a quantidade de: " + menorPlateia);
		System.out.println("A Sessao que teve o maior ocupação de poltronas foi: " + maiorOcupacao
				+ " e a que teve a menor foi: " + menorOcupacao);
		System.out.println(calcularLucroAreaSessao());
		// System.out.println("O Lucro médio do teatro com todas as áreas por peça foi
		// R$: " + lucroMedio);
	}

	public static void compraIngresso(String matrizPlateiaB[][], String matrizPlateiaA[][],
			String matrizPlateiaFrisa[][], String matrizPlateiaCamarote[][], String matrizPlateiaBalcNobre[][]) {
		// TODO Auto-generated method stub
		// criação das matrizes

		Scanner sc = new Scanner(System.in);
		float preco = 0;
		String cpf;
		System.out.println("**");
		System.out.println("* Comprando ingresso                       *");
		System.out.println("* Informe o CPF do cliente:                *");
		for (int i = 0; i < 7; ++i)
			System.out.println(); // apenas para "Limpar" a tela
		cpf = sc.next();

		System.out.println("**");
		System.out.println("* Informe qual a sessão desejada pelo cliente: *");
		System.out.println("*                 1-Matutino                   *");
		System.out.println("*                 2-Vespertino                 *");
		System.out.println("*                 3-Noturno                    *");
		for (int i = 0; i < 5; ++i)
			System.out.println(); // apenas para "Limpar" a tela
		sessao = sc.nextInt();  //mesmo problema, se eu escrever "M" ou "Matutino", vai dar erro

		switch (sessao) {
		case 1: // Matutino
			qtdsessao1++;
			break;
		case 2: // Vespertino
			qtdsessao2++;
			break;
		case 3: // Noturno
			qtdsessao3++;
			break;
		default:
			System.err.println("Sessão não existente");
			break;
		}
		//esse switch de área ficaria como um método chamado dentro do switch de sessão, nele vocês passaram como parâmetro uma variável que ia indicar qual o turno foi selecionado e usar ela pra determinar qual matriz deverá ser preenchida
		System.out.println("**");
		System.out.println("* Informe a area que o cliente deseja:         *");
		System.out.println("*                1-Plateia A                   *");
		System.out.println("*                2-Plateia B                   *");
		System.out.println("*                3-Frisa                       *");
		System.out.println("*                4-Camarote                    *");
		System.out.println("*                5-Balcão Nobre                *");
		for (int i = 0; i < 3; ++i)
			System.out.println(); // apenas para "Limpar" a tela
		area = sc.nextInt(); //mesmo problema, se eu escrever "A" ou "Plateia A", vai dar erro

		switch (area) {
		case 1: // Plateia A
			contadorPlateiaA++;
			//contadorPlateiaAMatutino++;
			//contadorPlateiaAVespertino++;
			//contadorPlateiaANoturno++;
			preco = 40;
			matrizPlateiaA = escolherAssento(matrizPlateiaA);
			break;
		case 2: // Plateia B
			contadorPlateiaB++;
			preco = 60;
			matrizPlateiaB = escolherAssento(matrizPlateiaB);
			break;
		case 3: // Frisa
			contadorFrisa++;
			preco = 120;
			matrizPlateiaFrisa = escolherAssento(matrizPlateiaFrisa);
			break;
		case 4: // Camarote
			contadorCamarote++;
			preco = 80;
			matrizPlateiaCamarote = escolherAssento(matrizPlateiaCamarote);
			break;
		case 5: // Balcão Nobre
			contadorBalcaoNobre++;
			preco = 250;
			matrizPlateiaBalcNobre = escolherAssento(matrizPlateiaBalcNobre);
			break;
		default:
			System.out.println("Area não existente");
		}

		acrescentarValorAreaSessao(area, sessao, preco);
		imprimeIngresso(cpf, sessao, area, preco);

		System.out.println("* Deseja comprar um novo ingresso? *");
		System.out.println("*       1 - SIM     |  2 - NÃO     *");
		menu = sc.nextInt();

		if (menu == 1) {
			compraIngresso(matrizPlateiaB, matrizPlateiaA, matrizPlateiaFrisa, matrizPlateiaCamarote,
					matrizPlateiaBalcNobre);
		} // se não, sai da função.
	}

	public static void inicializaAssentos(String matriz[][], String Nome) {
		int contador = 1;
		for (int i = 0; i < matriz.length; i++) {// letras
			for (int j = 0; j < matriz[0].length; j++) {// numero
				matriz[i][j] = Nome + contador;
				contador++;
			}
		}
	}

	public static void imprimeMatriz(String matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {// letras
			for (int j = 0; j < matriz[0].length; j++) {// numero
				System.out.print("[" + matriz[i][j] + "]");
			}
			System.out.println();
		}
	}

	public static String[][] escolherAssento(String matriz[][]) {
		Scanner sc = new Scanner(System.in);
		String assento;
		// Loop para "Demonstrar cadeiras.
		System.out.println("Escolher assento do cliente:");
		imprimeMatriz(matriz);
		assento = sc.next();
		for (int i = 0; i < matriz.length; i++) {// letras
			for (int j = 0; j < matriz[0].length; j++) {// numero
				if (matriz[i][j].compareTo(assento) == 0) {
					matriz[i][j] = "X";
				}
			}
		}
		System.out.println();
		System.out.println();

		imprimeMatriz(matriz);
		return matriz;
	}

	public static void imprimeIngresso(String CPF, int Sessao, int Area, float preco) {
		System.out.println("**");
		System.out.println("*                 Ingresso                 *");
		System.out.println("* CPF:" + CPF + "                         *");
		System.out.println("* Sessao: " + Sessao + "          *");
		System.out.println("* Area: " + Area + "              *");
		System.out.println("* Preco: R$" + preco + "          *");
		// System.out.println("* Assento: "+posicao+" *");
		System.out.println("**");
	}

	public static void chamaMenu() {
		// TODO Auto-generated method stub
		System.out.println("* Ticket Free ***");
		System.out.println("*  1-Compra Ingresso        *");
		System.out.println("*  2-Estatistica de vendas  *");
		System.out.println("*  3-Sair                   *");
		System.out.println("***");
		for (int i = 0; i < 5; ++i)
			System.out.println(); // apenas para "Limpar" a tela
	}

}