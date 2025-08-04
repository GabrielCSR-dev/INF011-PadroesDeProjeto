package br.ifba.edu.aval3.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class Pista extends State{

	public Pista(BoletimProva boletim) {
		super(boletim);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		this.boletim.passagens.registrarPassagem(prismaID, tempo);	
	}

	@Override
	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		this.boletim.minutoPartidaEfetivo = minutoPartidaEfetivo;
	}

	@Override
	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
		return this.boletim.minutoPartidaEfetivo - this.boletim.minutoPartidaPrevisto;
	}

	@Override
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Fase não permite se apresentar pra largada.");
	}

	@Override
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		this.boletim.setState(this);		
	}

	@Override
	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		this.boletim.setState(new PosProva(this.boletim));
		this.boletim.passagens.registrarPassagem(Prisma.CHEGADA, tempo);
	}

}
