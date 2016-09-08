require 'rails_helper'

RSpec.describe DashboardController, type: :controller do
  describe "GET #index" do
    let(:user) { FactoryGirl.create(:user) }
    before :each do
      sign_in user
    end
    it "renders the index" do
      FactoryGirl.create(:staff, email: user.email)
      get :index
      expect(response).to have_http_status :ok
    end
  end
end
