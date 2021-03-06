class DashboardController < ApplicationController
  after_action :verify_authorized

  def index
    $curUserStaff = Staff.find_by_email(current_user.email)
    @curUser = current_user.email
    @staff = Staff.find_by_email(@curUser)
    @last10Kudos = Kudo.last(5).reverse;
    @sentKudos = Kudo.where(:sender => @curUser)
    authorize :staff, :login_process?
  end
end
