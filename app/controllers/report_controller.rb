class ReportController < ApplicationController
  after_action :verify_authorized

  def index
    @allKudos = Kudo.all
    authorize :report, :index?
  end

end
