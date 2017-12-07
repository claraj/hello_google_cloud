Create cloud platform project, enable billing, enable cloud sql administration API

Create cloud SQL instance; mine is called movies

https://cloud.google.com/sql/docs/mysql/quickstart


Make user to access the database and note their password.


Google Cloud Platform Console, click (shell) terminal icon

`gcloud sql connect movies --user=root`


Use socketfactory

which needs credentials...
https://developers.google.com/identity/protocols/application-default-credentials

Generate in shell

gcloud auth application-default login

cat the file created and copy into your local credential store; there is a link to that file when the app crashes because of bad credentials

` cat /tmp/tmp.someRandomNumbers/application_default_credentials.json `

Create a file in your project application_default_credentials.json

Set environment variable GOOGLE_APPLICATION_CREDENTIALS pointing to this file e.g. src/main/java/resources/applicarion_default_credentials.json

Also set environment variable to read your DB password 
