package com.bado.estoque.controller;

import com.bado.estoque.model.Produto;
import com.bado.estoque.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    // =========================
    // LOGIN
    // =========================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> dados) {
        String email = dados.get("email");
        String senha = dados.get("senha");

        if ("admin@email.com".equals(email) && "123".equals(senha)) {
            return ResponseEntity.ok().body("OK");
        }

        return ResponseEntity.status(401).body("Erro");
    }

    // =========================
    // LISTAR TODOS
    // =========================
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    // =========================
    // BUSCAR POR NOME
    // =========================
    @GetMapping("/buscar")
    public List<Produto> buscar(@RequestParam String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    // =========================
    // SALVAR
    // =========================
    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    // =========================
    // ATUALIZAR
    // =========================
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return repository.save(produto);
    }

    // =========================
    // DELETAR
    // =========================
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}