package br.ifba.edu.aval3.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class PosProva extends State{

	public PosProva(BoletimProva boletim) {
		super(boletim);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Não pode registrar prisma");		
	}

	@Override
	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Não pode registrar tempo de partida");
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
		throw new AtividadeNaoPermitidaException("Fase não permite largar.");		
	}

	@Override
	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		this.boletim.setState(this);
	}

}
