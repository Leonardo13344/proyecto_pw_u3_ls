package com.example.demo.uce.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.websocket.server.PathParam;

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

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestFulController {

	@Autowired
	private IEmpleadoService empleadoService;

	@PostMapping()
	public String crear(@RequestBody Empleado empleado) {
		String mensaje = "Estudiante Insertado Correctamente";
		try {
			this.empleadoService.crear(empleado);
		} catch (Exception e) {
			mensaje = "Error intente mas tarde";
		}

		return mensaje;
	}

	@PutMapping
	public String actualizar(@RequestBody Empleado empleado) {
		this.empleadoService.actualizar(empleado);
		return "Empleado Actualizado";
	}

	@GetMapping(path = "/{idEmpleado}")
	public ResponseEntity<Empleado> buscar(@PathVariable("idEmpleado") Integer idEmpleado) {
		Empleado empl = this.empleadoService.buscarxId(idEmpleado);
		return ResponseEntity.ok(empl);
	}

	@DeleteMapping(path = "/{idEmpleado}")
	public String eliminar(@PathVariable("idEmpleado") Integer idEmpleado) {
		this.empleadoService.eliminar(idEmpleado);
		return "Eliminado Correcto";
	}

	@GetMapping
	public List<Empleado> buscarEmpleadosSalario(@PathParam(value = "sal") BigDecimal salario) {
		return this.empleadoService.buscarSalario(salario);
	}

}
