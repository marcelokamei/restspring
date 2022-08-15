package pt.mmkamei.restspring;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pt.mmkamei.restspring.entity.Produto;
import pt.mmkamei.restspring.exception.ProductPriceException;
import pt.mmkamei.restspring.service.ProdutoService;

@SpringBootTest
public class ProdutoTest {

	@Autowired
	private ProdutoService produtoService;

	@Test
	public void vericicaValorNegativoNoProduto() {
		Produto produto = new Produto();

		produto.setNome("Teste");
		produto.setPreco(-10.0);

		assertThrows(ProductPriceException.class, () -> produtoService.save(produto));

	}

}
