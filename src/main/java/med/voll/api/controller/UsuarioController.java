package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.DadosAutenticacao;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody @Valid DadosAutenticacao dados) {
        UserDetails usuarioExistente = usuarioRepository.findByLogin(dados.login());
        if (usuarioExistente != null) {
            return ResponseEntity.badRequest().body("Login já existe.");
        }

        // Codifica a senha antes de salvar
        String senhaCodificada = passwordEncoder.encode(dados.senha());

        // Cria e salva o novo usuário
        Usuario usuario = new Usuario();
        usuario.setLogin(dados.login());
        usuario.setSenha(senhaCodificada);
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuário criado com sucesso.");
    }
}
