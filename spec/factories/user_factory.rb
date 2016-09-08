FactoryGirl.define do
  factory :user do
    email { Faker::Internet.email }
    role { 0 }
  end

  factory :admin, parent: :user do
    role { 1 }
  end
end