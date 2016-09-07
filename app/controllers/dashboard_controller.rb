class DashboardController < ApplicationController
  after_action :verify_authorized

  def index
    $curUserStaff = Staff.find_by_email(current_user.email)
    @curUser = current_user.email
    @staff = Staff.find_by_email(@curUser)
    @last10Kudos = Kudo.last(5).reverse;
    @sentKudos = Kudo.where(:sender => @curUser)

    if !@staff.nil?
      authorize @staff, :login_process?
    else
      sign_out current_user
      skip_authorization
      flash[:alert]='Your authentication is fine, but you are currently not a staff member.  Please contact your administrator and ask to be added/activate as a staff member.'
      redirect_to new_user_session_path
    end

  end
end
