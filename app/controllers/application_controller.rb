class ApplicationController < ActionController::Base
  include Pundit
  protect_from_forgery with: :exception
  before_action :authenticate_user!
  rescue_from Pundit::NotAuthorizedError, with: :user_not_authorized

  protected

  def user_not_authorized
  	flash[:alert] = "User Not Authorized!"
    redirect_to(request.referrer || root_path)
  end
end
