package br.cefet.eic.java.sorting.junit;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeputiesReimbursementsSelectionSort {
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
	public void selectionSort() {
		long tempoInicio = System.currentTimeMillis();
		for (int i = 0; i < valores.length; i++) {
			int menor = i;
			for (int j = i + 1; j < valores.length; j++) {
				if(valores[menor] > valores[j]) {
					menor = j;
				}
			}
			if(i != menor) {
				double temp = valores[menor];
				valores[menor] = valores[i];
				valores[i] = temp;
			}
		}
		long tempoFim = System.currentTimeMillis() - tempoInicio;
		System.out.println(tempoFim);
		System.out.println(valores[0]);
		System.out.println(valores.length);
	}

}
