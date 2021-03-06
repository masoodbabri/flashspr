# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)
 %w(Teamwork Improvement Delivery Experiment).each do |category|
   Category.create(name: category)
 end

{"Ankle Buster":  10, "Riptide": 25, "Breaker": 50, "Cruncher": 100, "Tidal Wave": 200, "Big Surf": 400}.each do |key, value|
   Badge.create(name: key.to_s, point_level: value)
end


1_000.times do |i|
  Staff.create!(
      first_name: Faker::Name.first_name,
      last_name: Faker::Name.last_name,
      title: Faker::Name.title,
      email: Faker::Internet.user_name + i.to_s +
          "@#{Faker::Internet.domain_name}")
end

Staff.create(
         first_name: 'An',
         last_name: 'Nguyen',
         title: 'Co-Founder',
         email: 'an@innotac.com')

Staff.create(
    first_name: 'David',
    last_name: 'Sachdev',
    title: 'Co-Founder',
    email: 'david@innotac.com')

Staff.create(
    first_name: 'Ayden',
    last_name: 'Nguyen',
    title: 'Intern',
    email: 'feilong601@gmail.com')

Staff.create(
    first_name: 'Nolawi',
    last_name: 'Petros',
    title: 'UI Dude',
    email: 'nolawi.petrso@gmail.com')

Staff.create(
    first_name: 'Amirdash',
    last_name: 'Hasbold',
    title: 'UI Dude',
    email: 'amirdash@yahoo.com')

Staff.create(
    first_name: 'Jonathan',
    last_name: 'Bateman',
    title: 'UI Dude',
    email: 'jonathan@yahoo.com')

Staff.create(
    first_name: 'Big',
    last_name: 'Boss-man',
    title: 'Chief',
    email: 'admin@innotac.com'
  )

User.create(
  email: 'admin@innotac.com',
  password: 'Password1!',
  password_confirmation: 'Password1!',
  created_at: Time.now,
  role: 1
  )