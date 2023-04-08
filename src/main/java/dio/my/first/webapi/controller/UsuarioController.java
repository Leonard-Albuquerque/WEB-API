package dio.my.first.webapi.controller;

import dio.my.first.webapi.model.Usuario;
import dio.my.first.webapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping("/users")
    public List<Usuario> getUser(){
        return repository.findAll();

    }
    @GetMapping("/users/{username}")
    public Usuario getOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);

    }
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }
    @PostMapping("/users")
    public void post(@RequestBody Usuario usuario){
       repository.save(usuario);
    }

}
