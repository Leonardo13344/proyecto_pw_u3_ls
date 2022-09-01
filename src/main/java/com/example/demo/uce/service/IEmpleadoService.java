package com.example.demo.uce.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.to.EmpleadoTo;

public interface IEmpleadoService {

	public void crear(Empleado empleado);
	public void actualizar(Empleado empleado);
	public Empleado buscarxId(Integer id);
	public void eliminar(Integer id);
	public List<Empleado> buscarSalario(BigDecimal salario);
	public List<EmpleadoTo> buscarAll();
}
