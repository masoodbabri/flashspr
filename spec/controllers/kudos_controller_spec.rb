require 'rails_helper'

RSpec.describe KudosController, type: :controller do
  let(:staff) { FactoryGirl.create(:staff) }
  let(:valid_attributes) {
    { sender: 'sender', message: 'message' }
  }

  # describe "POST #create" do
  #   context "with valid params" do
  #     it "creates a new Kudo" do
  #       expect {
  #         post :create, params: { kudo: valid_attributes }.merge({ staff_id: staff.id })
  #       }.to change(Kudo, :count).by(1)
  #     end
  #
  #     it "assigns a newly created post as @post" do
  #       post :create, params: { kudo: valid_attributes }
  #       expect(assigns(:post)).to be_a(Kudo)
  #       expect(assigns(:post)).to be_persisted
  #     end
  #
  #     it "redirects to the created post" do
  #       post :create, params: { kudo: valid_attributes}.merge({ staff_id: staff.id } )
  #       expect(response).to redirect_to(Kudo.last)
  #     end
  #   end
  # end
end
