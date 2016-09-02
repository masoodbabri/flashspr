# README

##Postgres
Download postgrest enterprise dmg, and install first. Then move to the postgres service
* Set up postgresql on mac:  https://launchschool.com/blog/how-to-install-postgresql-on-a-mac

## NodJS/NPM
* Set up nodejs npm on mac:  https://coolestguidesontheplanet.com/installing-node-js-on-osx-10-10-yosemite/

## Ruby/Rails (use rvm)
* Setup up Ruby and Rails (Rails 5.0.0.1 ruby 2.3.1p112)

## Setting up the application
* createuser --createdb --login -P flashSPR -U postgres
* bundle install
* vi config/datbase.yml
* DO NOT DO - ALREADY in DB MIGRATE: bundle exec rails generate devise:install
* DO NOT DO - ALREADY in DB MIGRATE: bundle exec rails generate devise user
* bundle exec rake db:create
* bundle exec rake db:migrate
* sudo npm install -g bower
* bundle exec rake -T bower
* bundle exec rake bower:install - complained about metadata, but worked
* bundle exec rake db:seed

## Running the application locally
* rails server


