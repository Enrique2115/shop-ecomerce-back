package com.reymitech.app.ecommerce.client.presentation;

import com.reymitech.app.ecommerce.client.application.usecase.CreateClientUseCase;
import com.reymitech.app.ecommerce.client.application.usecase.FindAllClientsUseCase;
import com.reymitech.app.ecommerce.client.application.usecase.FindByClientIdUseCase;
import com.reymitech.app.ecommerce.client.domain.dtos.ClientDto;
import com.reymitech.app.ecommerce.client.presentation.request.CreateClientRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final FindAllClientsUseCase findAllClientsUseCase;
    private final FindByClientIdUseCase findByClientIdUseCase;
    private final CreateClientUseCase createClientUseCase;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Flux<ClientDto>> getClients() {
        return ResponseEntity.ok(Flux.fromIterable(findAllClientsUseCase.execute()).map(client -> modelMapper.map(client, ClientDto.class)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ClientDto>> getClientById(@PathVariable final String id) {
        return ResponseEntity.ok(Mono.just(findByClientIdUseCase.execute(id)).map(client -> modelMapper.map(client, ClientDto.class)));
    }

    @PostMapping("/create")
    public ResponseEntity<Mono<ClientDto>> createClient(@Valid @RequestBody final CreateClientRequest clientRequest) {
        return ResponseEntity.ok(Mono.just(createClientUseCase.execute(clientRequest)).map(client -> modelMapper.map(client, ClientDto.class)));
    }
}
