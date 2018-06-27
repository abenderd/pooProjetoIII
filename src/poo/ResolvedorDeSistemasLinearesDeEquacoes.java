package poo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ResolvedorDeSistemasLinearesDeEquacoes {
	private double[][] matriz;
	private boolean resolvido = false;

	public ResolvedorDeSistemasLinearesDeEquacoes(String nomArqDds) throws Exception {
		try {
			@SuppressWarnings("resource")
			BufferedReader arqDds = new BufferedReader(new FileReader(nomArqDds));

			int qtdEquacoes = Integer.parseInt(arqDds.readLine());
			String linha = arqDds.readLine();
			int qtdeColunas = linha.length();
			
			this.matriz = new double[qtdEquacoes][qtdeColunas];

			for (int i = 0; i < qtdEquacoes; i++) {
				linha = arqDds.readLine();

				String unidade1 = linha.replaceAll("\\D", "");
				String[] bla = unidade1.split("");
 
				for (int j = 0; j < qtdeColunas; j++) {

					this.matriz[i][j] = Integer.parseInt(bla[j]);
					System.out.println(this.matriz[i][j] + " ");
				}
			}
		} catch (Exception erro) {
			throw new Exception("[ERRO] Arquivo inexistente ou fora do formato");
		}
		System.out.println((this.matriz.toString()) + " ");
	}

	private void trocaLinhasParaEliminarZerosDaDiagonalPrincipal() throws Exception {
		// trocar linhas ate sumir com zeros da diagonal
		// principal; nao conseguiu? excecao!!!
	}

	private void tornar1ElementoDaDiagonalPrincipal(int pos) {
		// torna 1 o elemento da diagonal principal que
		// está na posicao pos, ou seja, na linha pos e
		// na coluna pos
	}

	private void zeraRestoDaColunaDoElementoDaDiagonalPrincipal(int pos) {
		// zera o resto da coluna do elemento da
		// diagonal principal que está na posicao pos,
		// ou seja, todas as linhas da coluna pos
		// menos a linha pos
	}

	public void resolva() throws Exception {
		trocaLinhasParaEliminarZerosDaDiagonalPrincipal();
		// tornar1ElementoDaDiagonalPrincipal(0);
		// zeraRestoDaColunaDoElementoDaDiagonalPrincipal(0);
		this.resolvido = true;
	}

	public int getQtdEquacoes() {
		return this.matriz.length;
	}

	public double getValorDaVariavel(int i) throws Exception {
		if (!this.resolvido)
			throw new Exception("Tentativa de pegar resultado sem resolver");

		if (i < 0 || i >= this.matriz.length)
			throw new Exception("Tentativa de pegar valor de variavel inexistente");

		return this.matriz[i][this.matriz[i].length - 1];
	}

	@Override
	public String toString() {
		return "ResolvedorDeSistemasLinearesDeEquacoes [matriz=" + Arrays.toString(matriz) + ", resolvido=" + resolvido
				+ "]";
	}

	// fazer os metodos obrigatorios que, neste caso
	// sao: toString, equals, hashCode, clone e
	// construtor de copia

}