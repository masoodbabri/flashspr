class ReportController < ApplicationController

  def index
    @allKudos = Kudo.all

  end

end
