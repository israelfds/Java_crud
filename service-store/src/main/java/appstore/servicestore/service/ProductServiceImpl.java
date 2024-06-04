package appstore.servicestore.service;

import appstore.servicestore.dto.ProductDTO;

import appstore.servicestore.model.Product;
import appstore.servicestore.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public Optional<ProductDTO> create(ProductDTO request) {
        Product product = mapper.map(request, Product.class);
        repository.saveAndFlush(product);
        return Optional.of(mapper.map(product, ProductDTO.class));
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = repository.findAll();
        List<ProductDTO> responses = new ArrayList<>();
        products.forEach(product -> {
            responses.add(mapper.map(product, ProductDTO.class));
        });
        return responses;
    }

    @Override
    public Optional<ProductDTO> getById(long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return Optional.of(mapper.map(product.get(), ProductDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean inactive(long id) {
        Optional<Product> product = repository.findById(id);
        if(product.isPresent()){
            product.get().setAvailable(false);
            return true;
        }
        return false;
    }

}
