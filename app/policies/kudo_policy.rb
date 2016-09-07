class KudoPolicy
	attr_reader :current_user, :kudo

	def initialize(current_user, model)
	  @current_user = current_user
	  @kudo = model
	end

	def destroy?
	  @current_user.admin?	
	end
end