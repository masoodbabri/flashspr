FactoryGirl.define do
  factory :staff do
    first_name { Faker::Name.first_name }
    last_name { Faker::Name.last_name }
    title { ['Co-Founder', 'UI Dude', 'Intern', 'Chief'].sample }
    email { Faker::Internet.email }
  end
end