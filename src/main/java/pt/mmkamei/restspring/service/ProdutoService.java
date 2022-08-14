package pt.mmkamei.restspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.mmkamei.restspring.entity.Produto;
import pt.mmkamei.restspring.exception.ProductNullException;
import pt.mmkamei.restspring.exception.ProductPriceException;
import pt.mmkamei.restspring.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired

    private ProdutoRepository repository;

    public Produto save(Produto produto) throws Exception {
        if(produto.getNome() == null || produto.getPreco() == null){
            throw new ProductNullException();
        }
        if(produto.getPreco() < 0){
            throw new ProductPriceException();
        }
        return repository.save(produto);
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

}
