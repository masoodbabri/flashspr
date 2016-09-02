class DashboardController < ApplicationController
  def index
    @curUser = current_user.email
    @staff = Staff.find_by_email(@curUser)

  end
end
