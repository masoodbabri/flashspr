class ReportPolicy
  attr_reader :current_user, :report

  def initialize(current_user, report)
    @current_user = current_user
    @report = report
  end

  def index?
    @current_user.admin? || @current_user.user?
  end
end