class StaffPolicy < ApplicationPolicy
  def create?
    @current_user.admin?
  end

  def erstaff?
    @current_user.admin?
  end

  def new?
    @current_user.admin?
  end

  def edit?
    @current_user.admin? || @current_user.email.eql?(record.try(:email))
  end

  def update?
    @current_user.admin? || @current_user.email.eql?(record.try(:email))
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