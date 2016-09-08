class Kudo < ApplicationRecord
  belongs_to :staff
  # belongs_to :award
  has_one :comment
  belongs_to :category
  belongs_to :author, class_name: 'Staff', foreign_key: :author_id

  after_create :create_comment

  # def message=(msg)
  #   @msg = msg
  # end

  # def message
  #   self.comment.try(:body)
  # end

  # def staff_id
  #   recipient.id
  # end

  private

  def create_comment
    Comment.create(body: @msg) unless @msg.blank?
    self.staff.update_attributes(points:  self.staff.points.to_i + 1)
  end
end
