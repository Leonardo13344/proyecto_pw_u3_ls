package com.example.demo.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.repository.modelo.Estudiante;
import com.example.demo.uce.service.IEstudianteService;

@RestController
@RequestMapping("/APIMatricula/V1/estudiantes")
public class EstudianteRestFulController {

	@Autowired
	private IEstudianteService estudianteService;
	
	@PostMapping()
	public String crear(@RequestBody Estudiante estudiante) {
		String msg = "Estudiante Insertado Correctamente";
		try {
			this.estudianteService.crear(estudiante);
		} catch (Exception e) {
			// TODO: handle exception
			msg = "Error intente mas tarde";
		}
		return msg;
	}
	
	@PutMapping
	public String actualizar(@RequestBody Estudiante estudiante) {
		this.estudianteService.actualizar(estudiante);
		return "Estudiante Actualizado";
	}
	
	@GetMapping(path = "/{idEstudiante}")
	public ResponseEntity<Estudiante> buscar(@PathVariable("idEstudiante") Integer idEstudiante){
		Estudiante est = this.estudianteService.buscarxId(idEstudiante);
		return ResponseEntity.ok(est);
	}
	
	@DeleteMapping(path = "/{idEstudiante}")
	public String eliminar(@PathVariable("idEstudiante")Integer idEstudiante) {
		this.estudianteService.eliminar(idEstudiante);
		return "Eliminado Correctamente";
	}
}
