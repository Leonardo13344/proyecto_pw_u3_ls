package com.example.demo.uce.controller;

import java.math.BigDecimal;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestFulController {

	@Autowired
	private IEmpleadoService empleadoService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public String crear(@RequestBody Empleado empleado) {
		String mensaje = "Estudiante Insertado Correctamente";
		try {
			this.empleadoService.crear(empleado);
		} catch (Exception e) {
			
			mensaje = "Error intente mas tarde";
			throw new RuntimeException();
		}
		return mensaje;
	}

	@PutMapping
	public String actualizar(@RequestBody Empleado empleado) {
		this.empleadoService.actualizar(empleado);
		return "Empleado Actualizado";
	}

	@GetMapping(path = "/{idEmpleado}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Empleado> buscar(@PathVariable("idEmpleado") Integer idEmpleado) {
		Empleado empl = this.empleadoService.buscarxId(idEmpleado);
		return ResponseEntity.ok(empl);
	}
	
	@GetMapping(path = "/status/{idEmpleado}")
	public ResponseEntity<Empleado> buscarStatus(@PathVariable("idEmpleado") Integer idEmpleado) {
		Empleado empl = this.empleadoService.buscarxId(idEmpleado);
		//return ResponseEntity.status(HttpStatus.OK).body(empl);
		return ResponseEntity.status(227).body(empl);
	}
	
	@GetMapping(path = "/headers/{idEmpleado}")
	public ResponseEntity<Empleado> buscarHeaders(@PathVariable("idEmpleado") Integer idEmpleado) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("detalleMensaje", "Estas bien pero envia el apellido adicional");
		headers.add("solicitud", "Recuerda consumirme mañana");
		headers.add("valor", "1");
		Empleado empl = this.empleadoService.buscarxId(idEmpleado);
		
		//return ResponseEntity.ok(empl);
		return new ResponseEntity<>(empl, headers, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{idEmpleado}")
	public String eliminar(@PathVariable("idEmpleado") Integer idEmpleado) {
		this.empleadoService.eliminar(idEmpleado);
		return "Eliminado Correcto";
	}

	@GetMapping
	public List<Empleado> buscarEmpleadosSalario(@RequestParam(value = "salario") BigDecimal salario,
			@RequestParam(value = "provincia") String provincia) {
		System.out.println(provincia);
		return this.empleadoService.buscarSalario(salario);
	}

	/*
	 * @GetMapping public List<Empleado> buscarEmpleadosSalario(@PathParam(value =
	 * "salario") BigDecimal salario) { return
	 * this.empleadoService.buscarSalario(salario); }
	 */

}
