package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.dto.UsuarioDTO;
import br.com.fujideia.iesp.tecback.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Slf4j
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        log.info("Chamando listarTodos no UsuarioController");
        List<UsuarioDTO> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no UsuarioController com id: {}", id);
        Optional<UsuarioDTO> usuario = usuarioService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        log.info("Chamando criarUsuario no UsuarioController com dados: {}", usuarioDTO);
        UsuarioDTO usuarioCriado = usuarioService.criarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        log.info("Chamando atualizarUsuario no UsuarioController com id: {} e dados: {}", id, usuarioDTO);
        Optional<UsuarioDTO> usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioDTO);
        return usuarioAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        log.info("Chamando deletarUsuario no UsuarioController com id: {}", id);
        boolean deletado = usuarioService.deletarUsuario(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
