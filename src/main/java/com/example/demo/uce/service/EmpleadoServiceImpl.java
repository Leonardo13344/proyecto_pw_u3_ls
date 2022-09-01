package com.example.demo.uce.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IEmpleadoRepository;
import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.to.EmpleadoTo;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	
	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	@Override
	public void crear(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.crear(empleado);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.actualizar(empleado);
	}

	@Override
	public Empleado buscarxId(Integer id) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.empleadoRepository.eliminar(id);
	}

	@Override
	public List<Empleado> buscarSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.buscarSalario(salario);
	}

	@Override
	public List<EmpleadoTo> buscarAll() {
		// TODO Auto-generated method stub
		List<Empleado> lista = this.empleadoRepository.buscarAll();
		List<EmpleadoTo> listTo = lista.stream().map(empl -> this.convertir(empl)).collect(Collectors.toList());
		return listTo;
	}
	
	private EmpleadoTo convertir (Empleado empleado) {
		EmpleadoTo empl = new EmpleadoTo();
		empl.setId(empleado.getId());
		empl.setNombre(empleado.getNombre());
		empl.setApellido(empleado.getApellido());
		empl.setFechaNacimiento(empleado.getFechaNacimiento());
		empl.setFechaNacimiento(empleado.getFechaNacimiento());
		return empl;
	}

	

}
