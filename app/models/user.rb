class User < ApplicationRecord
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable

  enum role: { user: 0, admin: 1 }

  # FIXME: where is this used?
  def set_role
  	role||= :user 
  end
end
