function environmentQA() {

	var ambiente = {
		url : 'https://petstore.swagger.io'
	};


	// Feature API Ejemplo
	ambiente.flujoX = {
		user : {
			numero_celular : '+5491177361162',
			dni : '71452242',
			password : '115599'
		},
		cards : {
			visa_debit_card_token : '4123220000000016',
			visa_credit_card : '4540750039904452',
			visa_debit_card : '4517650612965467',
			master_credit_card : '5505688230915366',
			master_debit_card : '5142850020531006',
			amex_credit_card : '371593210378043',
			cabal_credit_card : '6042011000007025'
		}
	}

	return ambiente;
}