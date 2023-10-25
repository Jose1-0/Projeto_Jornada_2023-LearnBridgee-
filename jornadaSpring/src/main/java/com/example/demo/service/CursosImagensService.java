package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Cursos;
import com.example.demo.entity.CursosImagens;
import com.example.demo.repository.CursosImagensRepository;
import com.example.demo.repository.CursosRepository;



@Service
public class CursosImagensService {

	@Autowired
	private CursosImagensRepository cursosImagensRepository;
	
	@Autowired
	private CursosRepository cursosRepository;
	
	
	public List<CursosImagens> buscarTodos(){
		return cursosImagensRepository.findAll();
	}
	
//	public List<CursosImagens> buscarPorProduto(Long idcursos) {
//        List<CursosImagens> listaProdutoImagens = cursosImagensRepository.findByCursosId(idcursos);
//        
//        for (ProdutoImagens produtoImagens : listaProdutoImagens) {
//            try (InputStream in = new FileInputStream("c:/imagens/"+produtoImagens.getNome())) {
//                produtoImagens.setArquivo(IOUtils.toByteArray(in));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return listaProdutoImagens;
//    }
	
	public CursosImagens inserir(Long idcursos, MultipartFile file) {
		
		Cursos cursos = cursosRepository.findById(idcursos).get();
		CursosImagens cursosImg = new CursosImagens();
		
		try {
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(cursos.getId()) + file.getOriginalFilename();
				Path caminho = Paths
						.get("c:/imagens/" +nomeImagem );
				Files.write(caminho, bytes);
				cursosImg.setNome(nomeImagem);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		cursosImg.setCursos(cursos);
		cursosImg.setDataCriacao(new Date());
		cursosImg= cursosImagensRepository.saveAndFlush(cursosImg);
		return cursosImg;
	}
	
	public CursosImagens alterar(CursosImagens cursosImagens) {
		cursosImagens.setDataAtualizacao(new Date());
		return cursosImagensRepository.saveAndFlush(cursosImagens);
	}
	
	public void excluir(Long id) {
		CursosImagens cursos = cursosImagensRepository.findById(id).get();
		cursosImagensRepository.delete(cursos);
	}
}
