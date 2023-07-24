package com.example.EC03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.String;


@Controller
@RequestMapping(path="/")

public class MainController {
    
 @Autowired
  private CategoriaRepository repository;

  @GetMapping(path="/")
  public @ResponseBody String home() {
    return "Diego Ñontol Huiman - A19104002";
  }

  @GetMapping(path="/")
  public @ResponseBody String codigo() {
    return "A19104002";
  }

  @PostMapping(path="/nuevo")
  public @ResponseBody String nuevo (@RequestParam String nombre) {
    Categoria n = new Categoria();
    n.setNombre(nombre);
    repository.save(n);
    return "Categoria Guardado";
  }

  @DeleteMapping(path="/eliminar")
  public @ResponseBody String eliminar(@RequestParam Integer id) {
    Categoria n = new Categoria();
    n.setId(id);
    repository.delete(n);
    return "Categoria Eliminada";
  }

  @GetMapping(path="/listar")
  public @ResponseBody Iterable<Categoria> listar() {
    return repository.findAll();
  }
}
