# README

Windows - Setup is painful

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

## Postgres Install on RHEL 6
* rpm -Uvh http://yum.postgresql.org/9.5/redhat/rhel-6-x86_64/pgdg-redhat95-9.5-2.noarch.rpm
* yum install postgresql95-server postgresql95
* yum install postgresql95 postgresql95-server postgresql95-libs postgresql95-contrib postgresql95-devel
* service postgresql-9.5 initdb 
* service postgresql-9.5 start
* chkconfig postgresql-9.5 on
* ssu - postgres
* psql -U postgres
* Need to update the authentication model: 
* http://stackoverflow.com/questions/18664074/getting-error-peer-authentication-failed-for-user-postgres-when-trying-to-ge
* http://stackoverflow.com/questions/33951528/fatal-peer-authentication-failed-for-user-rails
* File in this version: vi /var/lib/pgsql/9.5/data/pg_hba.conf
* Restart: 
* The createuser command doesn't create the DB as it is supposed to - make sure to use quotes for UPPERCASE - CREATE DATABASE "flashSPR"

## Node Install on RHEL 6
* curl --silent --location https://rpm.nodesource.com/setup_4.x | bash -
* yum install -y nodejs
