function fn() {
	var env = karate.env;
	var file_path = 'file:src/test/resources/config/FilePath.json';
	var apiServerData = 'file:src/test/resources/config/ApiServerData.json';

	env = 'qa'


	if (!env) {
		env = 'qa'
	}

	var config = {
		env: env,
		file_path: file_path,
		apiServerData: apiServerData,
		email: 'nick.tyler@ecoatm.com',
		password: 'Test123456!'
	}

	return config;
}