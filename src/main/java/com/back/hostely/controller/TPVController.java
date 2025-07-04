package com.back.hostely.controller;

import com.back.hostely.dto.TPVDTO;
import com.back.hostely.dto.UsuarioDTO;
import com.back.hostely.model.TPV;
import com.back.hostely.model.Sede;
import com.back.hostely.model.UsuarioSede;
import com.back.hostely.service.TPVService;
import com.back.hostely.service.UsuarioService;
import com.back.hostely.service.UsuarioSedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tpv")
@CrossOrigin(origins = "*")
public class TPVController {

	@Autowired
	private TPVService tpvService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioSedeService usuarioSedeService;

	@GetMapping("/{tpvId}")
	public TPVDTO obtenerTPV(@PathVariable Long tpvId) {
		TPV tpv = tpvService.obtenerTPVActivo(tpvId)
				.orElseThrow(() -> new RuntimeException("TPV no encontrado o inactivo"));
		return new TPVDTO(tpv);
	}

	@GetMapping("/acceso/{codAcceso}")
	public TPVDTO obtenerTPVCodAcceso(@PathVariable String codAcceso) {
		TPV tpv = tpvService.obtenerTPVCodAcceso(codAcceso)
				.orElseThrow(() -> new RuntimeException("TPV no encontrado o inactivo"));
		return new TPVDTO(tpv);
	}

	@GetMapping("/{tpvId}/empleados")
	public List<UsuarioDTO> obtenerEmpleadosDeSede(@PathVariable Long tpvId) {
		TPV tpv = tpvService.obtenerTPVActivo(tpvId)
				.orElseThrow(() -> new RuntimeException("TPV no encontrado o inactivo"));

		Integer sedeId = tpv.getSede().getId();

		List<Integer> usuarioIds = usuarioSedeService.buscarPorSede(sedeId)
				.stream()
				.map(UsuarioSede::getUsuarioId)
				.collect(Collectors.toList());

		return usuarioService.buscarUsuariosPorIds(usuarioIds)
				.stream()
				.map(UsuarioDTO::new)
				.collect(Collectors.toList());
	}

	@GetMapping("/sede/{sedeId}")
	public TPVDTO obtenerSede(@PathVariable Integer sedeId) {
		Sede sede = new Sede();
		sede.setId(sedeId);

		return tpvService.obtenerSede(sede)
				.map(TPVDTO::new)
				.orElseThrow(
						() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TPV no encontrada para esta sede"));
	}

	@PostMapping
	public TPVDTO crearTPV(@RequestBody TPVDTO dto) {
		TPV tpv = new TPV();
		tpv.setNombre(dto.getNombre());
		tpv.setClaveAcceso(dto.getClaveAcceso());
		tpv.setActiva(dto.getActiva());

		Sede sede = new Sede();
		sede.setId(dto.getSedeId());
		tpv.setSede(sede);

		return new TPVDTO(tpvService.guardar(tpv));
	}

	@PutMapping("/{id}")
	public TPVDTO actualizarTPV(@PathVariable Long id, @RequestBody TPVDTO dto) {
		TPV tpv = tpvService.obtenerTPV(id)
				.orElseThrow(() -> new RuntimeException("TPV no encontrada"));

		tpv.setNombre(dto.getNombre());
		if (dto.getClaveAcceso() != null && !dto.getClaveAcceso().isBlank()) {
			tpv.setClaveAcceso(dto.getClaveAcceso());
		}
		tpv.setActiva(dto.getActiva());

		return new TPVDTO(tpvService.guardar(tpv));
	}

	@DeleteMapping("/{id}")
	public void eliminarTPV(@PathVariable Long id) {
		TPV tpv = tpvService.obtenerTPV(id)
				.orElseThrow(() -> new RuntimeException("TPV no encontrada"));

		tpvService.eliminar(tpv);
	}
}