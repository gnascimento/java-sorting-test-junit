package br.cefet.eic.java.sorting.junit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeputiesReimbursementsQuickSort {
	private Double[] valores = null;
	
	private int numExecucoes = 0;
	
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
	public void test() {
		long tempoInicio = new Date().getTime();
		quickSort(0, valores.length - 1);
		long tempoFim = (new Date().getTime() - tempoInicio) / 1000;
		System.out.println(tempoFim);
		System.out.println(valores[0]);
		System.out.println(valores.length);
	}
	
	private void quickSort(int inicio, int fim) {
		if(inicio < fim) {
			int posicaoPivo = particiona(0, valores.length - 1);
			quickSort(inicio, posicaoPivo -1);
			quickSort(posicaoPivo + 1, fim);
		}
	}
	
	private int particiona(int inicio, int fim) {
		int esq = inicio;
		int dir = fim;
		double pivo = this.valores[inicio];
		while(esq < dir) {
			while(this.valores[esq] <= pivo)
				esq++;
			while(this.valores[dir] > pivo)
				dir--;
			if(esq < dir) {
				double aux = this.valores[esq];
				this.valores[esq] = this.valores[dir];
				this.valores[dir] = aux;
			}
		}
		this.valores[inicio] = this.valores[dir];
		this.valores[fim] = pivo;
		return dir;
	}

}
