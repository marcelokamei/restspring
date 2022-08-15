package pt.mmkamei.restspring.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.mmkamei.restspring.entity.Pedido;
import pt.mmkamei.restspring.entity.Produto;
import pt.mmkamei.restspring.repository.PedidoRepository;
import pt.mmkamei.restspring.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public Pedido save(Pedido pedido) {
		Set<Produto> produtos = new HashSet<>();

		pedido.setDataPedido(LocalDateTime.now());
		pedido.getProdutos().forEach(produto -> {
			produtos.add(produtoRepository.getById(produto.getId()));
		});
		pedido.setProdutos(produtos);

		return repository.save(pedido);
	}

	public Pedido findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Pedido> findAll() {
		return repository.findAll();
	}
}
