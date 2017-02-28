package br.cefet.eic.java.sorting.junit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeputiesReimbursementsInsertionSort {
	private static final String NOME_ARQUIVO = "C:\\tmp\\dirty_deputies_v2.csv";
	private Double[] valores = null;
	int count = 0;

	@Before
	public void setup() {
		// Executa as configuracoes iniciais
		File file = new File(NOME_ARQUIVO);
		if (file.exists()) {
			try {
				List<Double> lista = new ArrayList<>();
				InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String line = null;
				// int count = 0;
				while ((line = bufferedReader.readLine()) != null) {
					if (count == 0) {
						count++;
						continue;
					}

					String[] registro = line.split(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
					double valor = Double.parseDouble(registro[7]);
					lista.add(valor);
					count++;
				}
				Double[] dummy = new Double[lista.size()];
				dummy = lista.toArray(dummy);
				this.valores = dummy;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.fail("Erro ao ler o arquivo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.fail("Erro ao ler o arquivo");
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				Assert.fail("Erro ao ler valor na linha: " + (count + 1));
			}
		} else {
			Assert.fail("O arquivo de entrada não foi encontrado");
		}
	}

	@Test
	public void insertionSort() {
		long tempoInicio = new Date().getTime();
		for (int i = 0; i < valores.length; i++) {
			double num = valores[i];
			for (int j = i - 1; j >= 0 && valores[j] > num; j--) {
				valores[j + 1] = valores[j];
				valores[j] = num;
			}
		}
		long tempoFim = (new Date().getTime() - tempoInicio) / 1000;
		System.out.println(tempoFim);
	}

}
