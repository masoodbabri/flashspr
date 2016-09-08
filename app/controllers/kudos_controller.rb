class KudosController < ApplicationController
  after_action :verify_authorized, only: [ :destroy ]
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
    @staff.kudos.create(sender: current_user.email,
                        staff_id: params[:staff_id],
                        message: kudo_params[:message],
                        category_id: kudo_params[:category_id])

    redirect_to root_path
  end

  def destroy
    @staff = Staff.find(params[:staff_id])
    kudo = @staff.kudos.find(params[:id])
    authorize kudo
    kudo.destroy
    redirect_to staff_path(@staff)
  end

  def report
  end

  private

  def kudo_params
    params.require(:kudo).permit(:sender, :message, :category_id)
  end
end
