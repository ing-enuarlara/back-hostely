package com.back.hostely.controller;

import com.back.hostely.dto.TaskSeguimientoDTO;
import com.back.hostely.model.Task;
import com.back.hostely.model.TaskSeguimiento;
import com.back.hostely.model.Usuario;
import com.back.hostely.service.TaskService;
import com.back.hostely.service.S3Service;
import com.back.hostely.service.TaskSeguimientoService;
import com.back.hostely.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/seguimientos")
public class TaskSeguimientoController {

    @Autowired
    private TaskSeguimientoService seguimientoService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private S3Service s3Service;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<TaskSeguimientoDTO> agregarComentario(
            @RequestParam Integer taskId,
            @RequestParam Integer usuarioId,
            @RequestParam String descripcion,
            @RequestParam(required = false) MultipartFile adjunto
    ) throws IOException {
        Task task = taskService.buscarPorId(taskId).orElseThrow();
        Usuario usuario = usuarioService.buscarPorId(usuarioId).orElseThrow();

        String rutaAdjunto = null;
        if (adjunto != null && !adjunto.isEmpty()) {
            rutaAdjunto = s3Service.uploadFile(adjunto, "adjuntosTask");
        }

        TaskSeguimiento creado = seguimientoService.guardar(descripcion, rutaAdjunto, task, usuario);
        return ResponseEntity.ok(new TaskSeguimientoDTO(creado));
    }

    @GetMapping("/{taskId}")
    public List<TaskSeguimientoDTO> listarPorTarea(@PathVariable Integer taskId) {
        return seguimientoService.listarPorTask(taskId)
                .stream()
                .map(TaskSeguimientoDTO::new)
                .toList();
    }
}