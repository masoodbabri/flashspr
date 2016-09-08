class Kudo < ApplicationRecord
  belongs_to :staff
  # belongs_to :award
  has_one :comment
  belongs_to :category
  belongs_to :author, class_name: 'Staff', foreign_key: :author_id

  after_commit :create_coment, on: :create

  def message=(msg)
    @msg = msg
  end

  def message
    self.comment.try(:body)
  end

  def sender
    author.email
  end

  def staff_id
    recipient.id
  end

  private

  def create_comment
    p "after create"
    p msg
    self.comments.create(body: @msg) unless msg.blank?
  end
end
