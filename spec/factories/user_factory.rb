FactoryGirl.define do
  factory :user do
    email { Faker::Internet.email }
    password { 'password123'}
    password_confirmation { 'password123' }
    role { 0 }
  end

  factory :admin, parent: :user do
    role { 1 }
  end
end