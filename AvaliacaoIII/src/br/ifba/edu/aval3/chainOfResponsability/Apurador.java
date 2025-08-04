package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public interface Apurador {
	public void setProximo(Apurador regra);
	public Duration apurar(BoletimProva boletim)
			 throws DNFException, AtividadeNaoPermitidaException;
	public Duration getTempo(BoletimProva boletim) throws AtividadeNaoPermitidaException;
}
