class Kudo < ApplicationRecord
  belongs_to :staff
  has_many :award
end
