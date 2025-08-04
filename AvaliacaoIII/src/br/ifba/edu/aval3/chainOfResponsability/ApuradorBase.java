package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public abstract class ApuradorBase implements Apurador{

	protected Apurador proxRegra;

	public ApuradorBase(Apurador proxRegra) {
		super();
		this.proxRegra = proxRegra;
	}
	
	public void setProximo(Apurador regra) {
		this.proxRegra = regra;
	}
	
	public Duration apurar(BoletimProva boletim)
			throws DNFException, AtividadeNaoPermitidaException {
		if(proxRegra != null)
			return this.proxRegra.apurar(boletim);
		return this.getTempo(boletim);
	}
	
	public Duration getTempo(BoletimProva boletim) throws AtividadeNaoPermitidaException {
		return boletim.getTempo(Prisma.CHEGADA);
	}
}
