class ApplicationController < ActionController::Base
  include Pundit
  protect_from_forgery with: :exception
  before_action :authenticate_user!
  rescue_from Pundit::NotAuthorizedError, with: :user_not_authorized

  protected

    def user_not_authorized(exception)
  	  if not_staff_member exception
  	    sign_out current_user
        flash[:alert]='Your authentication is fine, but you are currently not a staff member.  Please contact your administrator and ask to be added/activate as a staff member.'
        redirect_to new_user_session_path
  	  else
  	    flash[:alert] = "User Not Authorized!"
        redirect_to(request.referrer || root_path)
      end
    end

    def not_staff_member(exception)
      policy_name = exception.policy.class.to_s.underscore
      policy_name == 'staff_policy' && exception.query.to_s == "login_process?"
    end

end
