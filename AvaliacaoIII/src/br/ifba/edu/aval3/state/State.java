package br.ifba.edu.aval3.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public abstract class State {
	
	public BoletimProva boletim;
	
	public State(BoletimProva boletim) {
		super();
		this.boletim = boletim;
	}

	public abstract void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException;

	public abstract void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException;
	
	public abstract Long getMinutosAtraso() throws AtividadeNaoPermitidaException;	
	
	public abstract void apresentarPraLargada() throws AtividadeNaoPermitidaException;
	
	public abstract void registrarLargada() throws AtividadeNaoPermitidaException;

	public abstract void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException;
}
