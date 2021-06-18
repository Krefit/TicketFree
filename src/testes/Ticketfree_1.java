package testes;

import java.util.Scanner;

public class Ticketfree_1 {
	/*
- Variaveis de entrada (CPF, ingresso pe�a, sess�o, area)
- impress�o do ingresso
- impressao Estat�stica de Vendas
- criar estrutura de sele��o pra selecionar a posi��o e tamb�m j� calcular a quantidade e o pre�o do ingresso
- finalizar com a quantidade de ingressos, pre�os e o que mais precisar
	 * */



	/*
	 * ********  Compra Ingresso        ********
	 * ********  Estatistica de vendas  ********
	 * ********  Sair                   ********
	 * 
	 * 
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DECLARA��O DE VARIAVEIS de defini��o do tamanho de cada sess�o do teatro
		int qtdPlateiaA,qtdPlateiaB,qtdFrisa,qtdCamarote,qtdBalcaoNobre;

		qtdPlateiaA = 25;
		qtdPlateiaB = 100;
		qtdFrisa = 5;
		qtdCamarote = 10;
		qtdBalcaoNobre = 50;



		iniciaPrograma(qtdPlateiaA,qtdPlateiaB,qtdFrisa,qtdCamarote,qtdBalcaoNobre);
		for (int i = 0; i < 9; ++i) System.out.println();
		System.out.println("Obrigado!");
	}

	//Inicia o programa
	public static void iniciaPrograma(int qtdPlateiaA, int qtdPlateiaB, int qtdFrisa, int qtdCamarote, int qtdBalcaoNobre) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int menu;
		String matrizPlateiaB[][] = new String[10][10]; //10*10 = 100
		String matrizPlateiaA[][] = new String[5][5];// 5*5 = 25
		String matrizPlateiaFrisa[][] = new String[6][5]; //existem 6 plateias Frisa - cada plateia = uma letra
		String matrizPlateiaCamarote[][] = new String[5][10]; //existem 5 camarotes - cada camarote = uma letra
		String matrizPlateiaBalcNobre[][] = new String[5][10]; //5*10 = 50

		inicializaAssentos(matrizPlateiaA,"A");
		inicializaAssentos(matrizPlateiaB,"B");
		inicializaAssentos(matrizPlateiaCamarote, "CA");
		inicializaAssentos(matrizPlateiaFrisa, "F");
		inicializaAssentos(matrizPlateiaBalcNobre, "BN");

		do { // Executando o DO WHILE para executar pelo menos uma vez o programa
			chamaMenu();
			menu = sc.nextInt();

			if (menu == 1){
				compraIngresso(matrizPlateiaB,matrizPlateiaA,matrizPlateiaFrisa,matrizPlateiaCamarote,matrizPlateiaBalcNobre); //Se escolheu fazer compra, chama fun��o de comprar ingresso
			}else if (menu == 2) {
				estatisticaVendas(matrizPlateiaB,matrizPlateiaA,matrizPlateiaFrisa,matrizPlateiaCamarote,matrizPlateiaBalcNobre); // se escolheu mostrar estatisticas, chama fun��o de estatisticas de venda
			}
		}while (menu < 3); //se escolha for sair, termina o loop e encerra o programa.
	}

	//imprime as estatisticas
	public static void estatisticaVendas(String matrizPlateiaB[][],String matrizPlateiaA[][],String matrizPlateiaFrisa[][],String matrizPlateiaCamarote[][],String matrizPlateiaBalcNobre[][]) {
		// TODO Auto-generated method stub
		//String maisVendidos, menosVendidos;
		int mPBVendidos, mPAVendidos,mPFVendidos, mPCAVendidos, mPBNVendidos;
		System.out.println("Retorna Estatisticas");
		/*		 Qual a pe�a teve mais ingressos vendidos e menos vendidos;
		 � Qual sess�o teve maior e menor ocupa��o de poltronas;
		 � Qual a pe�a/sess�o mais lucrativa e menos lucrativa; 
		 � Lucro m�dio do teatro com todas as �reas por pe�a.
		 */
		//Pe�a com mais ingressos vendidos
		
		mPAVendidos = retornaIngressosVendidos(matrizPlateiaA);
		System.out.println(mPAVendidos+" ingressos vendidos!");

	}
	
	public static int retornaIngressosVendidos(String matriz[][]) {
		int qtdIngressos = 0;
		for (int i = 0; i < matriz.length; i++) {//letras
			for (int j = 0; j < matriz[0].length; j++) {//numero
				if (matriz[i][j] == "X")
				{
					qtdIngressos++;
				}
			}
		}
		return qtdIngressos;
	}
	
	//Faz compra do ingresso
	public static void compraIngresso(String matrizPlateiaB[][],String matrizPlateiaA[][],String matrizPlateiaFrisa[][],String matrizPlateiaCamarote[][],String matrizPlateiaBalcNobre[][]) {
		// TODO Auto-generated method stub
		//cria��o das matrizes

		Scanner sc = new Scanner(System.in);
		int sessao, area, menu;
		float preco=0;
		String cpf;
		System.out.println("**********************************************");
		System.out.println("** Comprando ingresso                       **");
		System.out.println("** Informe o CPF do cliente:                **");
		System.out.println("**********************************************");
		for (int i = 0; i < 7; ++i) System.out.println(); //apenas para "Limpar" a tela
		cpf = sc.next();

		System.out.println("**************************************************");
		System.out.println("** Informe qual a sess�o desejada pelo cliente: **");
		System.out.println("**                 1-Matutino                   **");
		System.out.println("**                 2-Vespertino                 **");
		System.out.println("**                 3-Noturno                    **");
		System.out.println("**************************************************");
		for (int i = 0; i < 5; ++i) System.out.println(); //apenas para "Limpar" a tela
		sessao = sc.nextInt();

		System.out.println("**************************************************");
		System.out.println("** Informe a area que o cliente deseja:         **");
		System.out.println("**                1-Plateia A                   **");
		System.out.println("**                2-Plateia B                   **");
		System.out.println("**                3-Frisa                       **");
		System.out.println("**                4-Camarote                    **");
		System.out.println("**                5-Balc�o Nobre                **");
		System.out.println("**************************************************");
		for (int i = 0; i < 3; ++i) System.out.println(); //apenas para "Limpar" a tela
		area = sc.nextInt();

		String posicao = "";		
		switch (area) {
		case 1: //Plateia A
			preco = 40;
			matrizPlateiaA = escolherAssento(matrizPlateiaA);
			posicao = retornaPosicao(matrizPlateiaA,"A");
			break;
		case 2: //Plateia B
			preco = 60;
			matrizPlateiaB = escolherAssento(matrizPlateiaB);
			posicao = retornaPosicao(matrizPlateiaA,"B");
			break;
		case 3: //Frisa
			preco = 120;
			matrizPlateiaFrisa = escolherAssento(matrizPlateiaFrisa);
			posicao = retornaPosicao(matrizPlateiaA,"F");
			break;
		case 4: //Camarote
			preco = 80;
			matrizPlateiaCamarote = escolherAssento(matrizPlateiaCamarote);
			posicao = retornaPosicao(matrizPlateiaA,"CA");
			break;
		case 5: //Balc�o Nobre
			preco = 250;
			matrizPlateiaBalcNobre = escolherAssento(matrizPlateiaBalcNobre);
			posicao = retornaPosicao(matrizPlateiaA,"BN");
			break;
		default:
			System.out.println("Area n�o existente");
		}


		imprimeIngresso(cpf,sessao,area,preco, posicao);

		System.out.println("** Deseja comprar um novo ingresso? **");
		System.out.println("**       1 - SIM     |  2 - N�O     **");
		menu = sc.nextInt();

		if(menu == 1)
		{
			compraIngresso(matrizPlateiaB,matrizPlateiaA,matrizPlateiaFrisa,matrizPlateiaCamarote,matrizPlateiaBalcNobre);
		}//se n�o, sai da fun��o.
	}

	//Retorna a posi��o que foi compra
	public static String retornaPosicao(String matriz[][], String Nome)
	{
		String posicao = "";
		int contador = 1;
		for (int i = 0; i < matriz.length; i++) {//letras
			for (int j = 0; j < matriz[0].length; j++) {//numero
				if (matriz[i][j] == "X")
				{
					posicao = Nome+contador;
				}
				contador++;
			}
		}

		return posicao;
	}

	//Inicia matriz de assentos
	public static void inicializaAssentos(String matriz[][], String Nome) {
		int contador=1;
		for (int i = 0; i < matriz.length; i++) {//letras
			for (int j = 0; j < matriz[0].length; j++) {//numero
				matriz[i][j] = Nome+contador;
				contador++;
			}
		}
	}

	//Imprime "imagem" da localiza��o dos assentos ou dos assentos dispon�veis
	public static void imprimeMatriz(String matriz[][])
	{
		for (int i = 0; i < matriz.length; i++) {//letras
			for (int j = 0; j < matriz[0].length; j++) {//numero
				System.out.print("["+matriz[i][j]+"]");
			}
			System.out.println();
		}
	}

	//Escolhe assento
	public static  String[][] escolherAssento(String matriz[][]) {
		Scanner sc = new Scanner(System.in);
		String assento;
		//Loop para "Demonstrar cadeiras.
		System.out.println("Escolher assento do cliente:");
		imprimeMatriz(matriz);
		assento = sc.next();		
		for (int i = 0; i < matriz.length; i++) {//letras
			for (int j = 0; j < matriz[0].length; j++) {//numero
				if(matriz[i][j].compareTo(assento) == 0)
				{
					matriz[i][j] = "X";
				}
			}
		}
		System.out.println();
		System.out.println();

		imprimeMatriz(matriz);
		return matriz;

	}

	//Imprime informa��es do ingresso
	public static void imprimeIngresso(String CPF, int Sessao, int Area, float Preco , String posicao)
	{
		System.out.println("**********************************************");
		System.out.println("**                 Ingresso                 **");
		System.out.println("** CPF:"+CPF+"                         **");
		System.out.println("** Sessao: "+Sessao+"          **");
		System.out.println("** Area: "+Area+"              **");
		System.out.println("** Preco: R$"+Preco+"          **");
		System.out.println("** Assento: "+posicao+"          **");
		System.out.println("**********************************************");
	}

	//Imprime tela de menu
	public static void chamaMenu() {
		// TODO Auto-generated method stub
		System.out.println("************** Ticket Free ****************");
		System.out.println("********  1-Compra Ingresso        ********");
		System.out.println("********  2-Estatistica de vendas  ********");
		System.out.println("********  3-Sair                   ********");
		System.out.println("*******************************************");
		for (int i = 0; i < 5; ++i) System.out.println(); //apenas para "Limpar" a tela
	}


}
