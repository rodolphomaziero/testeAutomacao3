Feature: Teste de de calculadora Android

	Scenario: 1 - Teste de Soma
		Given somando 6 com 2
		Then resultado igual a 8

	Scenario: 2 - Teste de Subtração
		Given subtraindo 6 com 2
		Then resultado igual a 4
		
	Scenario: 3 - Teste de Multiplicação
		Given multiplicando 6 com 2
		Then resultado igual a 12

	Scenario: 4 - Teste de Divisão
		Given dividindo 6 com 2
		Then resultado igual a 3	