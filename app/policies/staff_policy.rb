class StaffPolicy
  attr_reader :current_user, :staff

  def initialize(current_user, model)
  	@current_user = current_user
  	@staff = model
  end

  def create?
    @current_user.admin? || @current_user.user?
  end

  def erstaff?
    @current_user.admin?
  end

  def new?
    @current_user.admin? || @current_user.user?
  end

  def edit?
    @current_user.admin? || (@current_user.email == @staff.email)
  end

  def update?
    @current_user.admin? || (@current_user.email == @staff.email)
  end

  def destroy?
    @current_user.admin?
  end

  def login_process?
    Staff.exists?(email: @current_user.email)
  end

  def admin_options?
    @current_user.admin?
  end
end