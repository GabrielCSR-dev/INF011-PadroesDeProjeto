package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class DefinirPenalizacao extends ApuradorBase{


	private Duration tempoProva;
	
	public DefinirPenalizacao(Apurador proxRegra) {
		super(proxRegra);
		this.tempoProva = Duration.ZERO;
	}
	
	public void setProximo(Apurador regra) {
		super.setProximo(regra);
	}

	public void apurar(BoletimProva boletim)
			throws DNFException, AtividadeNaoPermitidaException {
		this.tempoProva = boletim.getTempo(Prisma.CHEGADA);
		if(this.tempoProva == null)
			throw new DNFException("Atleta não registrou chegada");

		this.tempoProva = this.tempoProva.plus(Duration.ofMinutes(boletim.getMinutosAtraso()));
		super.apurar(boletim);
	}
	
	public Duration getTempoProva() {
		return this.tempoProva;
	}
}
