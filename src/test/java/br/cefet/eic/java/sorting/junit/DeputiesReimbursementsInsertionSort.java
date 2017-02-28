package br.cefet.eic.java.sorting.junit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeputiesReimbursementsInsertionSort {
	private Double[] valores = null;

	@Before
	public void setup() {
		try {
			this.valores = Configuration.carregarValores();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Arquivo não encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Erro ao ler o arquivo");
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
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
		System.out.println(valores[0]);
		System.out.println(valores.length);
	}

}
