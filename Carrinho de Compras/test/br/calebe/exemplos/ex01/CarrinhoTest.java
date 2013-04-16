package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

	private Carrinho carrinho;
        private List<Produto> produtos;

	@Before
	public void criandoCarrinho() {
		carrinho = new Carrinho();
	}

	@Test(expected = CarrinhoVazioExpected.class)
	public void colocandoZeroProduto() throws CarrinhoVazioExpected {
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { null }, new Object[] { menor });
	}

	@Test
	public void colocandoUmProduto() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
	}

	@Test
	public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
	}

	@Test
	public void identidadeDeProdutos() throws CarrinhoVazioExpected {
		Produto original = new Produto("Java em 24 horas", 50.00);
		carrinho.add(original);
		Produto copia = new Produto("Java em 24 horas", 50.00);
		original = carrinho.menorProduto();
		assertArrayEquals(new Object[] { original }, new Object[] { copia });
	}
        
        @Test
	public void ListaTodosOsProdutos() throws CarrinhoVazioExpected {
             	List<String> IsWeInTheTape = new ArrayList<String>();
                Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
                IsWeInTheTape.add(livro.getNome());
		Produto deitel = new Produto("Java: como programar", 150.00);
                carrinho.add(deitel);
                IsWeInTheTape.add(deitel.getNome());
                List<String> IsWeInTheDVD = carrinho.ListaTodosProdutos();
		for(String Nome : IsWeInTheTape){
                    assertTrue(IsWeInTheDVD.contains(Nome));
                }
                //teste
        }
        
        @Test(expected = CarrinhoVazioExpected.class)
	public void RemoverProdutoCarrinho() throws CarrinhoVazioExpected {
               	Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		carrinho.remove(livro);
                Produto menor;
                menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { null }, new Object[] { menor });
	}
        
        @Test
	public void CalculaTotal() throws CarrinhoVazioExpected {
              	double soma;
                soma = 0.0;
                Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
                carrinho.add(deitel);
		soma = carrinho.CalculaTotal();
                System.out.println(soma);
	}

}
