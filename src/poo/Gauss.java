package poo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gauss {
	public static void main(String[] args) {
		System.out.println("PROGRAMA PARA RESOLVER SISTEMAS DE EQUACOES LINEARES");
		System.out.println("          PELO METODO DE GAUSS-SEIDEL\n\n");

		System.out.println("Digite o caminho do arquivo de dados:");

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		String nomArqDds = null;
		try {
			nomArqDds = teclado.readLine();
		} catch (Exception erro) {
		}

		ResolvedorDeSistemasLinearesDeEquacoes r = null;

		try {
			r = new ResolvedorDeSistemasLinearesDeEquacoes(nomArqDds);

			r.resolva();

			System.out.println("\nOs valores das variaveis sao, respectivamente:");

			for (int i = 0; i < r.getQtdEquacoes(); i++)
				System.out.print(r.getValorDaVariavel(i) + " ");
		} catch (Exception erro) {
			System.err.println(erro.getMessage());
		}

		System.out.println("\n\nOBRIGADO POR USAR ESTE PROGRAMA!\n");
	}
}