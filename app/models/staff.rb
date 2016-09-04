class Staff < ApplicationRecord
  has_many :kudos, dependent: :destroy
end
