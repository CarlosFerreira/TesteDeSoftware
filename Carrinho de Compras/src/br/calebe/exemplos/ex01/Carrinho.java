package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	private List<Produto> produtos;

	public Carrinho() {
		produtos = new ArrayList<>();
	}

	public void add(Produto produto) {
		produtos.add(produto);
	}
        
        public void remove(Produto produto) {
		produtos.remove(produto);
	}

	public Produto menorProduto() throws CarrinhoVazioExpected {
		if (produtos.size() == 0)
			throw new CarrinhoVazioExpected();
		Produto menor = produtos.get(0);
		for (Produto produto : produtos) {
			if (produto.getPreco() < menor.getPreco())
				menor = produto;
		}
		return menor;
	}
        
        public List<String> ListaTodosProdutos(){
            List<String> IsWe = new ArrayList<String>();
            for (Produto produto : produtos) {
              IsWe.add(produto.getNome());
            }
            return IsWe;
        }
        
        public double CalculaTotal() throws CarrinhoVazioExpected {
                double soma;
                soma = 0.0;
		if (produtos.size() == 0)
			throw new CarrinhoVazioExpected();
		Produto menor = produtos.get(0);
		for (Produto produto : produtos) {
                    soma = soma + produto.getPreco();
		}
		System.out.print(soma);
                return soma;
	}

}
