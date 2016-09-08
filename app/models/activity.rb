class Activity < ApplicationRecord
  has_one :comment
  belongs_to :category
  belongs_to :author, class_name: 'Staff', foreign_key: :author_id
  belongs_to :recipient, class_name: 'Staff', foreign_key: :recipient_id
end
