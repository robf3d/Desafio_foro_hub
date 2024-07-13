package DesafioForoHub.robf3d.api.controller;

import DesafioForoHub.robf3d.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public ResponseEntity registroTopico(@RequestBody DatosRegistroTopico datosRegistroTopico){
        System.out.println("El topico llega correctamente");
        System.out.println(datosRegistroTopico);
        topicoRepository.save(new Topico(datosRegistroTopico));
        return ResponseEntity.ok("Topico creado correctamente");
    }

    @GetMapping
    public Page<DatosListadoTopicos> listarTopicos(@PageableDefault(size = 10,sort = "fecha",direction = Sort.Direction.DESC) Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
    }
    @GetMapping("/{id}")
    public List<DatosListadoTopicos> topicoDetallado(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        return topicoRepository.findById(id).stream().map(DatosListadoTopicos::new).toList();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getStatus()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

//    @DeleteMapping("/{id}")
//    public void  eliminarTopico(@PathVariable Long id){
//        Topico topico = topicoRepository.getReferenceById(id);
//        topicoRepository.delete(topico);
//    }
}
