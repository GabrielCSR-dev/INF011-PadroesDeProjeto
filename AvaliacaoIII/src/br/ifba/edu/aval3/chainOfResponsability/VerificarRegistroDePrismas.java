package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class VerificarRegistroDePrismas extends ApuradorBase{

	public VerificarRegistroDePrismas(Apurador proxRegra) {
		super(proxRegra);
	}
	
	public void setProximo(Apurador regra) {
		super.setProximo(regra);
	}

	public void apurar(BoletimProva boletim)
			throws DNFException, AtividadeNaoPermitidaException {
		List<Integer> ordemPrismas = boletim.getOrdemPrismas();
		
		for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
       		Duration tempo = boletim.getTempo(ordemPrismas.get(iCont));
       		if(ordemPrismas.get(iCont) != Prisma.CHEGADA && tempo == null)
       			throw new DNFException("Atleta não registrou um dos prismas.");
       	}
		
		super.apurar(boletim);
	}
	
}
