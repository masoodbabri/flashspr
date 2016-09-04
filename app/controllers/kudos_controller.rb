class KudosController < ApplicationController

  after_action only: :create do
    unless @skip_after_action
      url = APP_CONFIG['notification_rest_service_url']
      payload = {'subject' => 'Staff Performance and Recognition Kudo','body' => kudo_params[:message], 'recipent' => @staff.email}
      initheader = { 'Content-Type' => 'application/json' }
      encoded = JSON.generate(payload)
      Thread.new do
        RestClient.post(url, encoded, initheader)
      end
    end
  end

  def create

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
