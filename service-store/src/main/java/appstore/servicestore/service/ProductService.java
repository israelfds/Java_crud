package appstore.servicestore.service;

import appstore.servicestore.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDTO> create(ProductDTO request);

    List<ProductDTO> getAll();

    Optional<ProductDTO> getById(long id); // Corrigido para retornar Optional<ProductDTO>

    boolean inactive(long id);
}
