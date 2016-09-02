class KudosController < ApplicationController
  def create

    kudo_params[:sender] = current_user.email
    @staff = Staff.find(params[:staff_id])
    @kudo = @staff.kudos.create(
        sender: current_user.email,
        message: kudo_params[:message])

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
