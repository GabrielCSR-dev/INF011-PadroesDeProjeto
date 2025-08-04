package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class VerificarTempoMaximo extends ApuradorBase{

	private Duration tempoMaximo;
	
	public VerificarTempoMaximo(Apurador proxRegra, Duration tempoMaximo) {
		super(proxRegra);
		this.tempoMaximo = tempoMaximo;
	}
	
	public void setProximo(Apurador regra) {
		super.setProximo(regra);
	}

	public void apurar(BoletimProva boletim)
			throws DNFException, AtividadeNaoPermitidaException {
		Duration tempoProva = boletim.getTempo(Prisma.CHEGADA);
		if(tempoProva.compareTo(this.tempoMaximo)>0)
			throw new DNFException("O atleta finalizou a prova, após o tempo limite");

		super.apurar(boletim);
	}
	
}
