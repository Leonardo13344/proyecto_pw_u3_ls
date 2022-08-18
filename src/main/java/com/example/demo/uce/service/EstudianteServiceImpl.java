package com.example.demo.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IEstudianteRepository;
import com.example.demo.uce.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void crear(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.crear(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public Estudiante buscarxId(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}
}
