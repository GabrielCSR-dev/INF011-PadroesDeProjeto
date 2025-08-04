package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class DefinirTempoProva extends ApuradorBase{

	public DefinirTempoProva(Apurador proxRegra) {
		super(proxRegra);
	}
	
	public void setProximo(Apurador regra) {
		super.setProximo(regra);
	}

	public Duration apurar(BoletimProva boletim)
			throws DNFException, AtividadeNaoPermitidaException {
		
		Duration tempoProva = boletim.getTempo(Prisma.CHEGADA);
    	if(tempoProva == null)
    		throw new DNFException("Atleta não registrou chegada");

    	return super.apurar(boletim);
	}
	
}
