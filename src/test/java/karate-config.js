function fn() {
	// get system property 'karate.env'
	var env = karate.env;

	// Environment Default
	if (!env) {
		env = 'qa';
	}

	var config = {
		/* -------------------------- PATHS -------------------------- */
		path_user: '/v2/user',
		path_pet: '/v2/pet'
	}

	/* -------------------------- SETTINGS -------------------------- */

	config.ambiente = karate.call('core/environment/config-' + env + '.js');
	config.constants = karate.call('core/constants/constants.js');

	karate.log('karate.env system property was:', env);

	return config;
}
