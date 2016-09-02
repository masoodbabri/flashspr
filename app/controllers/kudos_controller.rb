class KudosController < ApplicationController
  def create
    @staff = Staff.find(params[:staff_id])
    @kudo = @staff.kudos.create(kudo_params)

    redirect_to staff_path(@staff)
  end

  def destroy
    @staff = Staff.find(params[:staff_id])
    @kudo = @staff.kudos.find(params[:id])
    @kudo.destroy
    redirect_to staff_path(@staff)
  end

  private
  def kudo_params
    params.require(:kudo).permit(:sender, :message)
  end
end
