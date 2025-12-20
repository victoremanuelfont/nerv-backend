package com.nerv.nervstore.services;

import com.nerv.nervstore.dto.ProductDTO;
import com.nerv.nervstore.entities.Product;
import com.nerv.nervstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }

    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setStockQuantity(dto.getStockQuantity());

        entity = repository.save(entity);
        return new ProductDTO(entity);
    }



}
