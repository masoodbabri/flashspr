# README

Windows - Setup is painful

Download postgrest enterprise dmg, and install first. Then move to the postgres service
Set up postgresql on mac:  https://launchschool.com/blog/how-to-install-postgresql-on-a-mac
Set up nodejs npm on mac:  https://coolestguidesontheplanet.com/installing-node-js-on-osx-10-10-yosemite/
Setup up Ruby and Rails (Rails 5.0.0.1 ruby 2.3.1p112)

createuser --createdb --login -P flashSPR -U postgres
bundle install
vi config/datbase.yml
bundle exec rails generate devise:install
bundle exec rails generate devise user
bundle exec rake db:create
bundle exec rake db:migrate
bundle exec rake -T bower
bundle exec rake bower:install
bundle exec rake db:seed
