package br.ifba.edu.aval3.chainOfResponsability;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public abstract class ApuradorBase implements Apurador{

	protected Apurador proxRegra;

	public ApuradorBase(Apurador proxRegra) {
		super();
		this.proxRegra = proxRegra;
	}
	
	public void setProximo(Apurador regra) {
		this.proxRegra = regra;
	}
	
	public void apurar(BoletimProva boletim)
			throws DNFException, AtividadeNaoPermitidaException {
		if(proxRegra != null)
			this.proxRegra.apurar(boletim);
	}
}
