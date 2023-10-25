package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.CursosImagens;
import com.example.demo.service.CursosImagensService;

@RestController
@RequestMapping("/api/cursosImagens")
@CrossOrigin
public class CursosImagensController {

	@Autowired
    private CursosImagensService cursosImagensService;

    @GetMapping("/")
    public List<CursosImagens> buscarTodos(){
       return cursosImagensService.buscarTodos();
    }

    @PostMapping("/")
    public CursosImagens inserir(@RequestParam("idcursos") Long idcursos, @RequestParam("file") MultipartFile file){
        return cursosImagensService.inserir(idcursos,file);
    }

    @PutMapping("/")
    public CursosImagens alterar(@RequestBody CursosImagens objeto){
        return cursosImagensService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
    	cursosImagensService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
