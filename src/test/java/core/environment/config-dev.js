function environmentQA() {

	var ambiente = {
		url : 'https://devpetstore.swagger.io'
	};


	// Feature API Ejemplo
	ambiente.flujoX = {
		user : {
			numero_celular : '+54911773622662',
			dni : '714666242',
			password : '116699'
		},
		cards : {
			visa_debit_card_token : '4123660000000016',
			visa_credit_card : '4540760039904452',
			visa_debit_card : '4517656612965467',
			master_credit_card : '5505688277915366',
			master_debit_card : '5142850888531006',
			amex_credit_card : '371593210999043',
			cabal_credit_card : '6042011000007025'
		}
	}

	return ambiente;
}