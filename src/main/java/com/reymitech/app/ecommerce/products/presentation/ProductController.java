package com.reymitech.app.ecommerce.products.presentation;

import com.reymitech.app.ecommerce.products.application.usecase.CreateProductUseCase;
import com.reymitech.app.ecommerce.products.application.usecase.FindAllProductsUseCase;
import com.reymitech.app.ecommerce.products.application.usecase.FindByIdUseCase;
import com.reymitech.app.ecommerce.products.domain.dtos.ProductDto;
import com.reymitech.app.ecommerce.products.presentation.request.CreateProductRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ModelMapper modelMapper;
    private final CreateProductUseCase createProductUseCase;
    private final FindAllProductsUseCase findAllProductsUseCase;
    private final FindByIdUseCase findByIdUseCase;

    @GetMapping
    public ResponseEntity<Flux<ProductDto>> getProducts() {
        Flux<ProductDto> products = Flux.fromIterable(findAllProductsUseCase.execute()).map(product -> modelMapper.map(product, ProductDto.class));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ProductDto>> getProductById(@PathVariable final String id) {
        return ResponseEntity.ok(Mono.just(findByIdUseCase.execute(id)).map(product -> modelMapper.map(product, ProductDto.class)));
    }

    @PostMapping("/create")
    public ResponseEntity<Mono<ProductDto>> createProduct(@Valid @RequestBody final CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(Mono.just(createProductUseCase.execute(createProductRequest)).map(product -> modelMapper.map(product, ProductDto.class)));
    }
}
