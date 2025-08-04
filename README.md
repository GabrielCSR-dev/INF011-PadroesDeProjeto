# INF011-PadroesDeProjeto
Repositório para a matéria de Padrões de Projeto
## Questão 1
Padrão: State  
Justificativa: o padrão State permite ao BoletimProva assumir comportamentos diferentes quando seu estado interno é alterado.  
Participantes:  
- Context: BoletimProva  
- State: State  
- ConcreteStates: PreProva, Largada, Pista, PosProva  
## Questão 2
Padrão: Chain of Responsability  
Justificativa: pois além de permitir que o BoletimProva seja passado por uma série de regras sequencialmente, ele permite adicionar ou retirar regras para apuração do BoletimProva sem alterar as demais.  
Participantes:  
- Handler: Apurador  
- Base Handler: ApuradorBase  
- Concrete Handlers: DefinirPenalizacao, DefinirTempoProva, VerificarPrismasEmOrdem, VerificarRegistroDePrismas, VerificarTempoMaximo  
- Client: AppAvaliacao3  

  
