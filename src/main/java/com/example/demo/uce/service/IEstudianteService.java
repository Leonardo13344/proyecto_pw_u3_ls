package com.example.demo.uce.service;

import java.util.List;

import com.example.demo.uce.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	public void crear(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscarxId(Integer id);
	public void eliminar(Integer id);
	public List<Estudiante> buscarCreditos(Integer creditos);

}
