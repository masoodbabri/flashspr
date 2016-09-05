class DashboardController < ApplicationController
  after_action :verify_authorized

  def index
    @curUser = current_user.email
    @staff = Staff.find_by_email(@curUser)
    authorize @staff, :login_process?
  end
end
