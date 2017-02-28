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
		System.out.println(" ----------- ");
		for(Double num : this.valores) {
			System.out.println(num);
		}
	}
	
	public void quickSort(int esquerda, int direita) {
		int esq = esquerda;
		int dir = direita;
		double pivo = this.valores[(esq + dir) / 2];
		double troca;
		while (esq <= dir) {
			while (this.valores[esq] < pivo) {
				esq = esq + 1;
			}
			while (this.valores[dir] > pivo) {
				dir = dir - 1;
			}
			if (esq <= dir) {
				troca = this.valores[esq];
				this.valores[esq] = this.valores[dir];
				this.valores[dir] = troca;
				esq++;
				dir--;
			}
		}
		if (dir > esquerda)
			quickSort(esquerda, dir);
		if (esq < direita)
			quickSort(esq, direita);
	}

}
