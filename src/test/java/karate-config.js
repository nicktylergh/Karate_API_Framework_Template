function fn() {
  var env = karate.env; // pick env from command line or default
  if (!env) {
    env = 'qa';
  }

  var config = {
    env: env,
    // config file references
    filePath: 'file:src/test/resources/config/filePath.json',
    apiServerData: 'file:src/test/resources/config/apiServerData.json',

    // generic credentials (replace with your own in local/private use)
    email: 'user@example.com',
    password: 'P@ssword123!'
  };

  karate.log('Running in environment:', env);
  return config;
}
