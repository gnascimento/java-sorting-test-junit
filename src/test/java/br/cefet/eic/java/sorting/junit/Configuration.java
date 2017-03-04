package br.cefet.eic.java.sorting.junit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Configuration {
	private static final String NOME_ARQUIVO = "C:\\tmp\\vgsales.csv";

	public static Double[] carregarValores() throws FileNotFoundException, IOException, NumberFormatException {
		
		// Executa as configuracoes iniciais
		File file = new File(NOME_ARQUIVO);
		if (file.exists()) {

			List<Double> lista = new ArrayList<>();
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = null;
			int count = 0;
			try {
			while ((line = bufferedReader.readLine()) != null) {
				if (count == 0) {
					count++;
					continue;
				}

				String[] registro = line.split(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
				double valor = Double.parseDouble(registro[10]);
				lista.add(valor);
				count++;
			}
			} catch(NumberFormatException ex) {
				throw new NumberFormatException("Erro ao ler valor na linha: " + (count + 1));
			} finally {
				bufferedReader.close();
			}
			Double[] valores = new Double[lista.size()];
			valores = lista.toArray(valores);
			return valores;
		} else {
			throw new FileNotFoundException("O arquivo de entrada não foi encontrado");
		}
	}
}
