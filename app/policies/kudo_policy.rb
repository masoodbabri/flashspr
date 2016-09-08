class KudoPolicy < ApplicationPolicy
	def destroy?
	  @current_user.admin?	
	end
end