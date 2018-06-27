
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ResolvedorDeSistemasLinearesDeEquacoes {
	private double[][] matriz;
	private boolean resolvido = false;
	public static final int QTD_MAX_ITERACOES = 100;

	public ResolvedorDeSistemasLinearesDeEquacoes(double[][] a) {
		this.matriz = a;
	}

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

				for (double[] row : this.matriz)
					System.out.println("\n" + Arrays.toString(row));
			}
		} catch (Exception erro) {
			throw new Exception("[ERRO] Arquivo inexistente ou fora do formato");
		}
		System.out.println();
	}

	public ResolvedorDeSistemasLinearesDeEquacoes(
			ResolvedorDeSistemasLinearesDeEquacoes resolvedorDeSistemasLinearesDeEquacoes) {
	}

	public void resolva() throws Exception {
		double erro = 1e-15;
		int iteracao = 0;
		int tamanho = this.matriz.length;

		double[] anterior = new double[tamanho];
		double[] aproximacao = new double[tamanho];

		Arrays.fill(aproximacao, 0);
		System.out.println("Iteracoes:");
		while (true) {
			for (int i = 0; i < tamanho; i++) {
				double soma = this.matriz[i][tamanho - 1]; // b_n

				for (int j = 0; j < tamanho; j++)
					if (j != i)
						soma -= this.matriz[i][j] * aproximacao[j];

				aproximacao[i] = 1 / this.matriz[i][i] * soma;
			}

			System.out.print("X[" + iteracao + "] = {");
			for (int i = 0; i < tamanho; i++)
				System.out.print(aproximacao[i] + " ");
			System.out.println("}");

			iteracao++;
			if (iteracao == 1)
				continue;

			boolean pare = true;
			for (int i = 0; i < tamanho && pare; i++)
				if (Math.abs(aproximacao[i] - anterior[i]) > erro)
					pare = false;

			if (pare || iteracao == QTD_MAX_ITERACOES)
				break;
			anterior = (double[]) aproximacao.clone();
		}
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matriz);
		result = prime * result + (resolvido ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResolvedorDeSistemasLinearesDeEquacoes other = (ResolvedorDeSistemasLinearesDeEquacoes) obj;
		if (!Arrays.deepEquals(matriz, other.matriz))
			return false;
		if (resolvido != other.resolvido)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResolvedorDeSistemasLinearesDeEquacoes [matriz=" + Arrays.toString(matriz) + ", resolvido=" + resolvido
				+ "]";
	}

	public Object clone() {
		ResolvedorDeSistemasLinearesDeEquacoes copia = null;

		try {
			copia = new ResolvedorDeSistemasLinearesDeEquacoes(this);
		} catch (Exception e) {
		}

		return copia;
	}
}